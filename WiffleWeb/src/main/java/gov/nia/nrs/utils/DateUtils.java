package gov.nia.nrs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils
{
	/** jdbc取出的日期欄位型式 */
	public static final String DB_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 判斷字串是否為預設格式(yyyyMMdd)日期
	 * @param datestr
	 * @return
	 */
	public static boolean isDate(String datestr)
	{
		return isDate(datestr, "yyyyMMdd");
	}
	/**
     * 取得系統日期<br/>
     * ex: 20120628
     * @return 系統日期文字(yyyyMMdd)
     */
    public static String getSysDate() {
        return DATE_FORMAT.format(new Date());
    }
	/**
	 * 判斷字串是否為指定格式的日期
	 * @param datestr
	 * @param pattern - 指定的日期格式
	 * @return
	 */
	public static boolean isDate(String datestr, String pattern)
	{
		try
		{
			DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
			DateTime jodatime = dtf.parseDateTime(datestr);
			DateTimeFormatter dtfOut = DateTimeFormat.forPattern(pattern);
			return datestr.equals(dtfOut.print(jodatime));
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * 將字串轉換成預設格式(yyyyMMdd)日期
	 * @param datestr
	 * @return
	 */
	public static Date parseDate(String datestr) throws Exception
	{
		return parseDate(datestr, "yyyyMMdd");
	}

	/**
	 * 將字串轉換成指定格式日期
	 * @param datestr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String datestr, String pattern) throws Exception
	{
		DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
		DateTime jodatime = dtf.parseDateTime(datestr);
		return jodatime.toDate();
	}

	/**
	 * 將日期轉換成為預設格式(yyyyMMdd)日期字串
	 * @param date
	 * @return
	 */
	public static String getDate(Date date)
	{
		return getDate(date, "yyyyMMdd");
	}

	public static String getDate(Date date, String pattern)
	{
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern(pattern);
		return dtfOut.print(date.getTime());
	}

	public static Date addDate(Date date, int addNum)
	{
		DateTime dtOrg = new DateTime(date);
		DateTime dtPlus = dtOrg.plusDays(addNum);
		return dtPlus.toDate();
	}

	public static Date minusDate(Date date, int addNum)
	{
		DateTime dtOrg = new DateTime(date);
		DateTime dtPlus = dtOrg.minusDays(addNum);
		return dtPlus.toDate();
	}

	/**
     * 將yyyyMMdd轉為格式yyyy/MM/dd<br>
     * 若傳入 Null或格式不符,則不轉換
     *
     * @param strDate yyyyMMdd字串
     * @return yyyy/MM/dd字串
     */
    public static String formatStrDate(String strDate) {
        // format: 20120101 -> 2012/01/01
        if (null != strDate && strDate.matches("\\d{8}")) {
            return new StringBuffer(strDate).insert(4, "/").insert(7, "/").toString();
        } else {
            return strDate;
        }
    }

	public static void main(String[] args)
	{
		String date = "2016-02-22 17:18:11.19";
//		System.out.println(date.length());
//		date = CommonUtils.padRight(date, 23, '0');
//		System.out.println(date);
		try
		{
//			SimpleDateFormat fmt = new SimpleDateFormat(DB_FORMAT);
//			System.out.println(fmt.format(DateUtils.parseDate(date, DB_FORMAT)));
			System.out.println(DateUtils.getDate(DateUtils.parseDate(date, DB_FORMAT)));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
