package gov.nia.nrs.utils;

public class DecryptUtils
{
	/** key table */
	private static char[] keyTable = { 'H', 'y', 'W', 'e', 'b', 'C', '3', 'p', '0', 'P', 'w', 'd' };

	/**
	 * converts a byte array to hex string (suitable for dumps and ASCII packaging of Binary fields
	 * @param b - byte array
	 * @return String representation
	 */
	public static String hexString(byte[] b)
	{
		StringBuffer d = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++)
		{
			char hi = Character.forDigit((b[i] >> 4) & 0x0F, 16);
			char lo = Character.forDigit(b[i] & 0x0F, 16);
			d.append(Character.toUpperCase(hi));
			d.append(Character.toUpperCase(lo));
		}
		return d.toString();
	}

	/**
	 * 將 c3p0密碼字串進行加密
	 * @param c3p0Pwd 明碼c3p0字串
	 * @return 加密字串
	 *
	 */
	public static String encryptFtpPwdStr(String c3p0Pwd)
	{
		if (c3p0Pwd == null || c3p0Pwd.isEmpty())
		{
			return "";
		}
		char[] cFtpPwd = c3p0Pwd.toCharArray();
		int keyTableLen = keyTable.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cFtpPwd.length; i++)
		{
			int idx = i % keyTableLen;
			sb.append(cFtpPwd[i] ^= keyTable[idx]);
		}
		return hexString(sb.toString().getBytes());
	}

	/**
	 * @param b source byte array
	 * @param offset starting offset
	 * @param len number of bytes in destination (processes len*2)
	 * @return byte[len]
	 */
	public static byte[] hex2byte(byte[] b, int offset, int len)
	{
		byte[] d = new byte[len];
		for (int i = 0; i < len * 2; i++)
		{
			int shift = i % 2 == 1 ? 0 : 4;
			d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
		}
		return d;
	}

	/**
	 * Convert hex String to byte[]. ex."12345678" to byte[]={0x12,0x34,0x56,0x78}
	 * @param s source string (with Hex representation)
	 * @return byte array
	 */
	public static byte[] hex2byte(String s)
	{
		return hex2byte(s.getBytes(), 0, s.length() >> 1);
	}

	/**
	 * 將 c3p0密碼字串進行解密
	 * @param enc3p0Pwd
	 * @return 解密字串
	 */
	public static String decryptFtpPwdStr(String enc3p0Pwd)
	{
		if (enc3p0Pwd == null || enc3p0Pwd.isEmpty())
		{
			return "";
		}
		int keyTableLen = keyTable.length;
		String decStr = org.apache.commons.codec.binary.StringUtils
				.newStringUsAscii(hex2byte(enc3p0Pwd.toString()));
		StringBuilder sb = new StringBuilder();
		char[] decFtpPwd = decStr.toCharArray();
		for (int i = 0; i < decFtpPwd.length; i++)
		{
			int idx = i % keyTableLen;
			sb.append(decFtpPwd[i] ^= keyTable[idx]);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception
	{
		String[] pd = { "apcloud", "apncpo" };
		for (int i = 0; i < pd.length; i++)
		{
			System.out.println("password = " + pd[i]);
			String encyprt = encryptFtpPwdStr(pd[i]);
			System.out.print("encrypt  = " + encyprt);
			System.out.println(",decrypt  = " + decryptFtpPwdStr(encyprt));
		}
	}
}
