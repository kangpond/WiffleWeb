/*
 * $Id: StringUtil.java 46724 2014-12-16 10:21:21Z 96003 $ Copyright 2011 Hyweb Technology Corporation. All Rights Reserved.
 */
package gov.nia.nrs.utils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author SamSon
 *
 */
@Component
public class CommonUtils
{
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static final String NameIndex_name0 = "name0";
	public static final String NameIndex_name1 = "name1";
	public static final String NameIndex_name2 = "name2";

	public static String getClientIp(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		if ("0:0:0:0:0:0:0:1".equals(ip))
		{
			ip = "127.0.0.1";//ipv6 to ipv4
		}
		return ip;
	}

	/**
	 * pad character to the left of the string
	 *
	 * @param s - original string
	 * @param len - desired len of string after padded
	 * @param c - padding char
	 * @return padded string
	 */
	public static String padLeft(String s, int len, char c)
	{
		if (s.length() > len)
		{
			return s;
		}

		String sTrim = s.trim();
		StringBuffer d = new StringBuffer(len);
		int fill = len - sTrim.length();
		while (fill-- > 0)
		{
			d.append(c);
		}
		d.append(sTrim);
		return d.toString();
	}

	/**
	 * pad character to the right of the string
	 *
	 * @param s - original string
	 * @param len - desired len of string after padded
	 * @param c - padding char
	 * @return padded string
	 */
	public static String padRight(String s, int len, char c)
	{
		StringBuffer d = new StringBuffer(s);
		while (d.length() < len)
		{
			d.append(c);
		}
		return d.toString();
	}

	/**
	 * Unpad from left. In case the string to be returned is empty, the result is c
	 *
	 * @param s - original string
	 * @param c - padding char
	 * @return unPadded string.
	 */
	public static String unPadLeft(String s, char c)
	{
		if ((s.trim().length() == 0) && (c == ' '))
		{
			return Character.toString(c);
		}
		else if ((s.trim().length() == 0))
		{
			return s;
		}
		String sTrim = s.trim();
		int fill = 0, end = sTrim.length();
		while ((fill < end) && (sTrim.charAt(fill) == c))
		{
			fill++;
		}
		return (fill < end) ? sTrim.substring(fill, end) : sTrim.substring(fill - 1, end);
	}

	/**
	 * Unpad from right. In case the string to be returned is empty, the result is c
	 *
	 * @param s - original string
	 * @param c - padding char
	 * @return unPadded string.
	 */
	public static String unPadRight(String s, char c)
	{
		if ((s.trim().length() == 0) && (c == ' '))
		{
			return Character.toString(c);
		}
		else if ((s.trim().length() == 0))
		{
			return s;
		}
		String sTrim = s.trim();
		int end = sTrim.length();
		while ((0 < end) && (sTrim.charAt(end - 1) == c))
		{
			end--;
		}
		return (0 < end) ? sTrim.substring(0, end) : sTrim.substring(0, 1);
	}

	/**
	 * converts a byte array to hex string (suitable for dumps and ASCII packaging of Binary fields
	 *
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
	 *
	 * @param s source string (with Hex representation)
	 * @return byte array
	 */
	public static byte[] hex2byte(String s)
	{
		return hex2byte(s.getBytes(), 0, s.length() >> 1);
	}

	/**
	 * check the string has '0' character
	 *
	 * @param s input string
	 * @return true if the string is zero-filled ( '0' char filled )
	 */
	public static boolean isZero(String s)
	{
		int i = 0, len = s.length();
		while (i < len && (s.charAt(i) == '0'))
		{
			i++;
		}
		return (i >= len);
	}

	/**
	 * check the string is null or empty string
	 *
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s)
	{
		return (s == null) || (s.trim().length() == 0);
	}

	/**
	 * 檢查傳進來的字串是否為數值型態的字串
	 *
	 * @param fldValue - value
	 * @return is Numeric
	 */
	public static boolean isNumeric(String fldValue)
	{
		boolean ret = true;

		if ((fldValue == null) || (fldValue.equals("")))
		{
			ret = false;

			return ret;
		}

		for (int i = 0; i < fldValue.length(); i++)
		{
			if (!Character.isDigit(fldValue.charAt(i)))
			{
				ret = false;

				break;
			}
		}

		return ret;
	}

	/**
	 * 檢查傳進來的字串是否為數值+空白 型態的字串
	 *
	 * @param fldValue - value
	 * @return is Numeric Space
	 */
	public static boolean isNumericSpace(String fldValue)
	{
		boolean ret = true;

		if ((fldValue == null) || (fldValue.equals("")))
		{
			ret = false;

			return ret;
		}

		char ch = 0;

		for (int i = 0; i < fldValue.length(); i++)
		{
			ch = fldValue.charAt(i);

			if (!Character.isDigit(ch) && (ch != ' '))
			{
				ret = false;

				break;
			}
		}

		return ret;
	}

	/**
	 * Return true if the string is alphanum.
	 *
	 * @param s input string
	 * @return true if the string is alphanum.
	 */
	public static boolean isAlphaNumeric(String s)
	{
		int i = 0, len = s.length();
		while (i < len && (Character.isLetterOrDigit(s.charAt(i))))
		{
			i++;
		}
		return (i >= len);
	}

	public static boolean isEngName(String s)
	{
		int i = 0, len = s.length();
		while (i < len && (Character.isLetter(s.charAt(i)) || s.charAt(i) == ' '))
		{
			i++;
		}
		return (i >= len);
	}

	public static boolean isChnName(String s)
	{
		// 先簡單判斷是否有雙位元組字元
		return s.getBytes().length != s.length();
	}

	/**
	 * Parses the int. 0 will be return while any exception
	 *
	 * @param intStr the int str
	 * @return the int
	 */
	public static int parseInt(String intStr)
	{
		return parseInt(intStr, 0);
	}

	/**
	 * Parses the int.
	 *
	 * @param intStr the int str
	 * @param defValue the def value will return while any Exception
	 * @return the int
	 */
	public static int parseInt(String intStr, int defValue)
	{
		int ret = defValue;
		if (intStr == null)
		{
			return ret;
		}
		if (!CommonUtils.isNumeric(intStr))
		{
			return ret;
		}
		try
		{
			ret = Integer.parseInt(intStr);
		}
		catch (Exception e)
		{
			logger.warn("exception when parse int", e);
		}
		return ret;
	}

	public static long parseLong(String intStr)
	{
		return parseLong(intStr, 0);
	}

	public static long parseLong(String intStr, long defValue)
	{
		long ret = defValue;
		if (intStr == null)
		{
			return ret;
		}
		if (!CommonUtils.isNumeric(intStr))
		{
			return ret;
		}
		try
		{
			ret = Long.parseLong(intStr);
		}
		catch (Exception e)
		{
			logger.warn("exception when parse long", e);
		}
		return ret;
	}

	public static double parseDouble(String intStr)
	{
		return parseDouble(intStr, 0);
	}

	public static double parseDouble(String intStr, double defValue)
	{
		double ret = defValue;
		if (intStr == null)
		{
			return ret;
		}

		try
		{
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < intStr.length(); i++)
			{
				char ch = intStr.charAt(i);
				if (Character.isDigit(ch) || ch == '.')
				{
					sb.append(ch);
				}
			}
			ret = Double.parseDouble(sb.toString());
		}
		catch (Exception e)
		{
			logger.warn("exception when parse double", e);
		}
		return ret;
	}

	/**
	 * Filter date.過濾輸入日期非數字
	 *
	 * @param fldValue the fld value
	 * @return the string
	 */
	public static String filterDate(String fldValue)
	{
		String ret = fldValue;
		if (fldValue == null)
		{
			return ret;
		}

		return ret.replaceAll("[^0-9]", "");
	}

	public static String chkNull2empty(String str)
	{
		if (str == null)
		{
			return "";
		}
		else
		{
			return str.trim();
		}
	}

	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 *
	 * @param cs the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 * @author B00-96003-2269
	 * @since 2014/7/25 下午2:48:07
	 */
	public static boolean isEmptyOrBlank(String str)
	{
		return isEmpty(str) || StringUtils.isBlank(str);
	}

	/**
	 *
	 * 將中文切割成各自獨立的List(0~n代表1~n的字,ex:陳王李,0:陳,1:王,李:2)
	 *
	 * @param chineseName 中文姓名
	 * @return List<String> 中文字清單
	 * @author Brian Su
	 */
	public static List<String> getChineseNameList(String chineseName)
	{
		List<String> resultList = new ArrayList<String>();
		for (int off = 0; off < chineseName.length();)
		{
			int codePoint = chineseName.codePointAt(off);
			String result = new StringBuffer().appendCodePoint(codePoint).toString();
			off += Character.charCount(codePoint);
			resultList.add(result);
		}
		return resultList;
	}

	/**
	 *
	 * 以單獨中文字的List取出Name0
	 *
	 * @param chineseStringList 單獨中文字的List
	 * @return String Name0的字串(預設為空字串)
	 */
	public static String getName0ByStringList(List<String> chineseStringList)
	{
		String result = "";
		int intLength = chineseStringList.size();
		for (int i = intLength - 1; i >= 3; i--)
		{
			String item = chineseStringList.get(i);
			result += item;
		}
		return result;
	}

	/**
	 * 產生中文姓名Map(name0,name1,name2的Map) 例 : 一個字 -> name0="",name1="",name2="安" 例 : 兩個字 -> name0="",name1="",name2="李丹" 例 : 三個字 ->
	 * name0="",name1="王",name2="李丹" 例 : 三個字以上 -> name0="陳",name1="王",name2="李丹"
	 *
	 * @param chineseName 中文姓名
	 * @return HashMap<String,String> name0,name1,name2的Map
	 * @author <a href="mailto:brian.su@hyweb.com.tw">Brian Su</a>
	 */
	public static HashMap<String, String> getNameMap(String chineseName)
	{
		HashMap<String, String> resultMap = new HashMap<String, String>();
		List<String> nameList = CommonUtils.getChineseNameList(chineseName);
		// 反轉List順序(ex : 王李丹 變成 丹李王,所以可以由index=0開始取)
		Collections.reverse(nameList);
		int len = nameList.size();
		String name0 = "";
		String name1 = "";
		String name2 = "";
		if (len > 3)
		{
			// 產生name0
			int intLength = nameList.size();
			for (int i = intLength - 1; i >= 3; i--)
			{
				String item = nameList.get(i);
				name0 += item;
			}
			name1 = nameList.get(2);
			name2 = nameList.get(1) + nameList.get(0);
		}
		else if (len == 3)
		{
			name1 = nameList.get(2);
			name2 = nameList.get(1) + nameList.get(0);
		}
		else if (len == 2)
		{
			name2 = nameList.get(1) + nameList.get(0);
		}
		else if (len == 1)
		{
			name2 = nameList.get(0);
		}
		resultMap.put(CommonUtils.NameIndex_name0, name0);
		resultMap.put(CommonUtils.NameIndex_name1, name1);
		resultMap.put(CommonUtils.NameIndex_name2, name2);
		return resultMap;
	}

	/**
	 * 英文姓名去非英數字->轉大寫->小至大排序
	 *
	 * @return String of Sorted English Words
	 */
	public static String sortEnglishWords(String strEngWords)
	{
		String StrRet = "";

		if (StringUtils.isNotBlank(strEngWords))
		{
			String tmpStr = strEngWords.replaceAll("[\\W\\s_]", "");
			char[] SortEngName = tmpStr.trim().toUpperCase().toCharArray();
			Arrays.sort(SortEngName);
			StrRet = String.valueOf(SortEngName).trim();
		}
		return StrRet;
	}

	/**
	 * 判斷該字串是否為英文姓名(含數字空白)
	 *
	 * @param String
	 * @return true if it is EnglishName
	 * @author Allen
	 * @since 2013/03/27
	 */
	public static boolean isEnglishName(String str)
	{
		int spaceCnt = 0;
		int engNameCnt = 0;
		if (StringUtils.isNotBlank(str))
		{
			try
			{
				// 計算全型空白個數
				byte[] dataFilter = { (byte) 0xE3, (byte) 0x80, (byte) 0x80 };
				for (int i = 0; i < str.length(); i++)
				{
					byte[] strByte = (String.valueOf(str.charAt(i))).getBytes("UTF-8");
					boolean bWholeSpace = true;
					for (int j = 0, k = 0; j < strByte.length && k < dataFilter.length; j++, k++)
					{
						if (dataFilter[k] != strByte[j])
						{
							bWholeSpace = false;
							break;
						}
					}
					if (bWholeSpace)
					{
						spaceCnt++;
					}
				}
			}
			catch (Exception e)
			{
				logger.error("Cant trim SPACE!", e);
			}

			// 計算空白字元個數
			spaceCnt += str.replaceAll("[\\S_]", "").length();
			// 計算純英文+數字字元個數
			engNameCnt = str.replaceAll("[\\W\\s_]", "").length();
			// 判斷是否為英文字
			if (str.length() == (engNameCnt + spaceCnt))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 判斷並決定該收件號字串補碼規則，當 <br>
	 * A. 輸入之收件號長度為1~11時，規則如下: <br>
	 * 　1. 開頭數字為1: 後補足0至總長12碼 <br>
	 * 　2. 開頭數字為2~9: 前補1個0，後補足0至總長12碼 <br>
	 * 　3. 開頭數字為其他: 後補足0至總長12碼 <br>
	 * B. 當輸入之收件號長度不為1~12時，直接回傳輸入之收件號。
	 *
	 * @param receiveNo 收件號
	 * @return packed receiveNo 補碼之收件號
	 * @author Allen
	 * @since 2013/05/30
	 * @since 2013/06/26 -- 修正收件號字串補碼規則，Step.A from 1~11 to 1~12
	 */
	public static String packReceiveNo(String receiveNo)
	{
		if (StringUtils.isBlank(receiveNo))
		{
			return receiveNo;
		}

		StringBuilder sb = new StringBuilder();
		int recvNoLen = receiveNo.length();

		if (recvNoLen >= 1 && recvNoLen <= 11)
		{
			String header = receiveNo.substring(0, 1);
			if (isNumeric(header))
			{
				int iHeader = Integer.parseInt(header);

				if (iHeader == 1)
				{
					// 1. 開頭數字為1: 後補足0至總長12碼
					sb.append(receiveNo);
					for (int i = 0; i < (12 - recvNoLen); i++)
					{
						sb.append("0");
					}
				}
				else if (iHeader >= 2 && iHeader <= 9)
				{
					// 2. 開頭數字為2~9: 前補1個0，後補足0至總長12碼
					sb.append("0");
					sb.append(receiveNo);
					for (int i = 0; i < (12 - recvNoLen - 1); i++)
					{
						sb.append("0");
					}
				}
				else
				{
					// 3. 開頭數字為其他: 後補足0至總長12碼
					sb.append(receiveNo);
					for (int i = 0; i < (12 - recvNoLen); i++)
					{
						sb.append("0");
					}
				}

			}
			else
			{
				// 3. 開頭數字為其他: 後補足0至總長12碼
				sb.append(receiveNo);
				for (int i = 0; i < (12 - recvNoLen); i++)
				{
					sb.append("0");
				}
			}
		}
		else
		{
			sb.append(receiveNo);
		}

		return sb.toString();
	}

	/**
	 * 將英文或數字轉成半形
	 *
	 * @param source 來源字串
	 * @param include 是否包含標點符號
	 * @return String
	 */
	public static String convertToHalfStr(String source, boolean include)
	{
		if (null == source)
		{
			return null;
		}
		char[] charArray = source.toCharArray();
		if (include)
		{
			// 65281~65374在ASCII code是代表著全形大小寫英文和數字，加上鍵盤上的基本符號
			// 12288在ASCII code是代表著鍵盤上的全形SPACE
			for (int i = 0; i < charArray.length; i++)
			{
				int ic = charArray[i];
				if (ic >= 65281 && ic <= 65374)
				{
					// 65281~65374在ASCII code裡，這幾個全形與半都差65248
					charArray[i] = (char) (ic - 65248);
				}
				else if (ic == 12288)
				{
					charArray[i] = (char) 32;
				}
			}
		}
		else
		{
			// 65296~65305在ASCII code是代表全形0~9
			// 65313~65338在ASCII code是代表全形A~Z
			// 65345~65370在ASCII code是代表全形a~z
			for (int i = 0; i < charArray.length; i++)
			{
				int ic = charArray[i];
				if ((ic >= 65296 && ic <= 65305) || (ic >= 65313 && ic <= 65338) || (ic >= 65345 && ic <= 65370))
				{
					// 65281~65374在ASCII code裡，這幾個全形與半都差65248
					charArray[i] = (char) (ic - 65248);
				}
			}
		}
		return new String(charArray);
	}

	/**
	 * 將英文或數字轉成全形
	 *
	 * @param source 來源字串
	 * @param include 是否包含標點符號
	 * @return String
	 */
	public static String convertToFullStr(String source, boolean include)
	{
		if (null == source)
		{
			return null;
		}
		char[] charArray = source.toCharArray();
		if (include)
		{
			// 33~126在ASCII code是代表著半形大小寫英文和數字，加上鍵盤上的基本符號
			// 32在ASCII code是代表著鍵盤上的半形SPACE
			for (int i = 0; i < charArray.length; i++)
			{
				int ic = charArray[i];
				if (ic >= 33 && ic <= 126)
				{
					// 33~126在ASCII code裡，這幾個全形與半都差65248
					charArray[i] = (char) (ic + 65248);
				}
				else if (ic == 32)
				{
					charArray[i] = (char) 12288;
				}
			}
		}
		else
		{
			// 48~57在ASCII code是代表半形0~9
			// 65~90在ASCII code是代表半形A~Z
			// 97~122在ASCII code是代表半形a~z
			for (int i = 0; i < charArray.length; i++)
			{
				int ic = charArray[i];
				if ((ic >= 48 && ic <= 57) || (ic >= 65 && ic <= 90) || (ic >= 97 && ic <= 122))
				{
					// 33~126在ASCII code裡，這幾個全形與半都差65248
					charArray[i] = (char) (ic + 65248);
				}
			}
		}
		return new String(charArray);
	}

	public static String maskPersonId(String personId)
	{
		return (personId != null && personId.length() == 10) ? personId.substring(0, 6) + "****" : personId;
	}

	public static String maskPassportNo(String passportNo)
	{
		return (passportNo != null && passportNo.trim().length() > 8) ? passportNo.substring(0, 5) + "****"
				: passportNo;
	}

	public static String maskPermitNo(String permitNo)
	{
		return (permitNo != null && permitNo.trim().length() > 10) ? permitNo.substring(0, 8) + "****" : permitNo;
	}

	/**
	 * 檢查是否為收件號之格式
	 * @param receiveNo
	 * @return
	 */
	public static boolean isReceiveNoFormat(String receiveNo)
	{
		String recvNoStr = packReceiveNo(receiveNo);

		if (StringUtils.isBlank(recvNoStr))
		{
			return false;
		}

		if (recvNoStr.length() != 12)
		{
			return false;
		}

		if (!CommonUtils.isNumeric(recvNoStr))
		{
			return false;
		}

		return true;
	}

	public static boolean isDouble(String value)
	{
		try
		{
			Double.parseDouble(value);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * Copy一樣名稱的欄位值，欄位值不為null才Copy
	 * @param source
	 * @param target
	 * @return 失敗欄位名稱與值，欄位值不為null才紀錄
	 */
	public static Map<String, Object> copyValue(Object source, Object target)
	{
		Map<String, Object> failColumn = new HashMap<String, Object>();
		try
		{
			if (source == null || target == null)
			{
				return failColumn;
			}

			if (source instanceof Map)
			{
				@SuppressWarnings("unchecked")
				Map<String, Object> sourceMap = (Map<String, Object>) source;
				for (Map.Entry<String, Object> entry : sourceMap.entrySet())
				{
					String key = entry.getKey();
					Object value = entry.getValue();
					Field field = null;
					try
					{
						field = target.getClass().getDeclaredField(key);
					}
					catch (NoSuchFieldException fe)
					{
					}
					if (field != null)
					{
						try
						{
							field.setAccessible(true);
							field.set(target, value);
						}
						catch (Exception e)
						{
							// 紀錄塞值不成功的欄位
							failColumn.put(key, value);
						}
					}
					else
					{
						// 紀錄塞值不成功的欄位
						failColumn.put(key, value);
					}
				}
			}
			else
			{
				for (Field f : source.getClass().getDeclaredFields())
				{
					/** 有些欄位會放在 id 欄位，特殊處理 */
					if ("id".equals(f.getName()))
					{
						Object id = PropertyUtils.getProperty(source, "id");
						for (PropertyDescriptor pd : Introspector.getBeanInfo(id.getClass()).getPropertyDescriptors())
						{
							if (pd.getReadMethod() != null && !"class".equals(pd.getName()))
							{
								Object sourceValue = null;
								try
								{
									sourceValue = pd.getReadMethod().invoke(id);
								}
								catch (Exception ex)
								{
								}

								// 欄位值不為null才Copy
								if (sourceValue != null)
								{
									try
									{
										PropertyUtils.setProperty(target, pd.getName(), sourceValue);
									}
									catch (Exception e)
									{
										// 紀錄塞值不成功的欄位
										failColumn.put(pd.getName(), sourceValue);
									}
								}
							}
						}
					}
					else
					{
						f.setAccessible(true);
						Object sourceValue = null;
						try
						{
							sourceValue = f.get(source);
						}
						catch (Exception ex)
						{
						}

						// 欄位值不為null才Copy
						if (sourceValue != null)
						{
							try
							{
								Field field = target.getClass().getDeclaredField(f.getName());
								field.setAccessible(true);
								if (field != null)
								{
									field.set(target, sourceValue);
								}
							}
							catch (Exception e)
							{
								// 紀錄塞值不成功的欄位
								failColumn.put(f.getName(), sourceValue);
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			//logger.error("copyValue error", e);
		}
		return failColumn;
	}

}
