package gov.nia.nrs.utils;


import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;


public class CommonUtils {
    
    private static final Logger logger = Logger.getLogger(CommonUtils.class);

    /**
     * key table
     */
    private static char[] keyTable = {'H', 'y', 'W', 'e', 'b', '-', '2', '0', '1', '5', ':', 'F', 'i', 'r', 'M'};

    /**
     * 將 c3p0密碼字串進行加密
     *
     * @param c3p0Pwd 明碼c3p0字串
     * @return 加密字串
     *
     */
    public static String encryptFtpPwdStr(String c3p0Pwd) {
        if (c3p0Pwd == null || c3p0Pwd.isEmpty()) {
            return "";
        }
        char[] cFtpPwd = c3p0Pwd.toCharArray();
        int keyTableLen = keyTable.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cFtpPwd.length; i++) {
            int idx = i % keyTableLen;
            sb.append(cFtpPwd[i] ^= keyTable[idx]);
        }
        return StringUtil.hexString(sb.toString().getBytes());
    }

    /**
     * 將 c3p0密碼字串進行解密
     *
     * @param enc3p0Pwd
     * @return 解密字串
     */
    public static String decryptFtpPwdStr(String enc3p0Pwd) {
        if (enc3p0Pwd == null || enc3p0Pwd.isEmpty()) {
            return "";
        }
        int keyTableLen = keyTable.length;
        String decStr = org.apache.commons.codec.binary.StringUtils.newStringUsAscii(StringUtil.hex2byte(enc3p0Pwd.toString()));
        StringBuilder sb = new StringBuilder();
        char[] decFtpPwd = decStr.toCharArray();
        for (int i = 0; i < decFtpPwd.length; i++) {
            int idx = i % keyTableLen;
            sb.append(decFtpPwd[i] ^= keyTable[idx]);
        }
        return sb.toString();
    }

    public static String hashDigest(String acount,String password){
			MessageDigest sha = null;
			String digest = null;
			try {
				 String input = acount+password;
				 sha =  MessageDigest.getInstance("SHA-256");
				 sha.update(input.getBytes());
				 digest = toHexString(sha.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return digest.substring(0, 32);
	}

    public static String hashDigestLength20(String acount,String password){

        return hashDigest( acount, password).substring(0, 20); //UserDef Password長度為20
    }

    public static String toHexString(byte[] bytes) {
			StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < bytes.length; i++){
				String hex = Integer.toHexString(0xFF & bytes[i]);
				if (hex.length() == 1){
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
	}

    /**
     * 判斷bean內的屬性是否皆為空值
     * @param bean
     * @return
     */
    public static boolean isEmpty(Object bean)
	{
		if (bean == null)
			return true;

		for (Field f : bean.getClass().getDeclaredFields())
		{
			try
			{
				f.setAccessible(true);
				Object value = f.get(bean);
				if (value != null)
				{
					if (value instanceof String)
					{
						if (String.valueOf(value).trim().length() != 0)
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
			}
			catch (Exception e)
			{
				logger.warn("isEmpty error", e);
			}
		}
		return true;
	}

    public static void main(String[] args) throws Exception {
        String[] pd = {"jdbc:log4jdbc:jtds:sybase://168.201.4.80:5000/CNHKMO", "jdbc:log4jdbc:jtds:sybase://168.201.4.80:5000/NIAIMM", "apfirmo","apcloud","cdio"};
        for (int i = 0; i < pd.length; i++) {
            System.out.println("password = " + pd[i]);
            String encyprt = encryptFtpPwdStr(pd[i]);
            System.out.print("encrypt  = " + encyprt);
            System.out.println(",decrypt  = " + decryptFtpPwdStr(encyprt));
        }
    }
}
