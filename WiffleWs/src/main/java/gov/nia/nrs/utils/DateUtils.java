package gov.nia.nrs.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	 private static final SimpleDateFormat YEAR_MONTH_FORMAT = new SimpleDateFormat("yyyyMM");
	private static SimpleDateFormat getSimpleDateFormat(String patten){
		return new SimpleDateFormat(patten);
	}

	/**
	 * 取得預設HHmmss的時間字串
	 * @param date
	 * @return
	 */
	public static String getTimeStr(Date date)
	{
		return getSimpleDateFormat("HHmmss").format(date);
	}

	/**
	 * 取得預設yyyyMMdd的日期字串
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date){
		return getSimpleDateFormat("yyyyMMdd").format(date);
	}

	public static String getDateToString(Date date,String patten){
		return getSimpleDateFormat(patten).format(date);
	}

	public static boolean before(Date src,Date target){
		try {
			return src.getTime() < target.getTime();
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static boolean after(Date src,Date target){
		if(src != null && target != null){
			return !before(src,target);
		}else
			return false;
	}


	public static long dateDiff(Date beginDate, Date endDate){
		return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
	}

	public static Date getDateFromString(Date date, String hour, String minute, String second){
		if(date != null){
			Date temDate = date;
			if(hour !=null || minute !=null || second !=null){
				try{
					Integer h = null ;
					Integer m = null;
					Integer s = null;
					if(hour != null)
						h = Integer.parseInt(hour);
					if(minute != null)
						m = Integer.parseInt(minute);
					if(second != null)
						s = Integer.parseInt(second);
					temDate = setTimetoDate(temDate, h, m, s);
				}catch(Exception e){
					e.printStackTrace();
					return new Date();
				}
			}
			return temDate;
		}
		return null;
	}

	public static Date getDateFromString(String strDate, String hour, String minute, String second){
		Date date = null;
		try {
			date = getSimpleDateFormat("yyyyMMdd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getDateFromString(date	,hour,minute,second);
	}


	public static Date setTimetoDate(Date tem, Integer h, Integer m, Integer s){
		Calendar c = Calendar.getInstance();
		c.setTime(tem);
		c.set(Calendar.HOUR_OF_DAY, h!=null?h:c.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, m !=null?m:c.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, s !=null?s:c.get(Calendar.SECOND));
		return new Date(c.getTimeInMillis());
	}

	/**
	 * 時間相加
	 * @param tem
	 * @param h --> 時
	 * @param m --> 分
	 * @param s --> 秒
	 * @return
	 */
	public static Date setPlusTimetoDate(Date tem, Integer h, Integer m, Integer s){
		Calendar c = Calendar.getInstance();
		c.setTime(tem);
		c.set(Calendar.HOUR_OF_DAY, h!=null?c.get(Calendar.HOUR_OF_DAY)+h:c.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, m !=null?c.get(Calendar.MINUTE)+m:c.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, s !=null?c.get(Calendar.SECOND)+s:c.get(Calendar.SECOND));
		return new Date(c.getTimeInMillis());
	}

	public static Date setPlusTimetoDate(Date tem, Integer y, Integer m){
		Calendar c = Calendar.getInstance();
		c.setTime(tem);
		c.set(Calendar.YEAR, y!=null?c.get(Calendar.YEAR)+y:c.get(Calendar.YEAR));
		c.set(Calendar.MONTH, m !=null?m+1:c.get(Calendar.MONTH));
		return new Date(c.getTimeInMillis());
	}

	// ===== 日期字串轉換 =====
	/**
	 * 將yyyy/MM/dd轉為格式yyyyMMdd<br>
	 * 若傳入 Null或格式不符,則不轉換
	 * @param strDate yyyy/MM/dd字串
	 * @return yyyyMMdd字串
	 * @author Rita (A0104)
	 */
	public static String formatStrDateWOSlash(String strDate) {
		// format: 2012/01/01 -> 20120101
		if (null != strDate && strDate.matches("\\d{4}/\\d{2}/\\d{2}")) {
			return strDate.replaceAll("/", "");
		} else {
			return strDate;
		}
	}


    /**
     * 判斷該日期是否合法
     *
     * @param date
     * @return
     */
    public static boolean isValidDate(String date)
    {
        try{
            return date.equals(DATE_FORMAT.format(DATE_FORMAT.parse(StringUtil.chkNull2empty(date))));
        }catch(ParseException e){
            return false;
        }
    }

	/**
	 *  輸入兩個字串類型的日期，格式為yyyyMMdd，回傳兩日期相減的天數(int)</br>
	 *	回傳正數:　A日期大於B日期幾天</br>
	 *  回傳負數:　A日期小於B日期幾天</br>
	 *  回傳0:　　A日期等於B日期</br>
	 * @param strDateA
	 * @param strDateB
	 * @return 回傳兩日期相減的天數(int)
	 */
	public static int calculateDays(String strDateA, String strDateB) throws Exception {

		if (!isValidDate(strDateA) || !isValidDate(strDateB)) {
			throw new IllegalArgumentException("Wrong input Date str data: strDateA="+strDateA+", strDateB="+strDateB);
		}

		//把String 轉成 日期的格式
		Date dateA = null;
		Date dateB = null;

		dateA = DATE_FORMAT.parse(strDateA);
		dateB = DATE_FORMAT.parse(strDateB);

		long resultTime = dateA.getTime() - dateB.getTime();
		int result = (int) (resultTime/1000/60/60/24);

		return result;
	}

	/**
	 *  輸入兩個字串類型的日期，格式為yyyyMMdd，回傳兩日期相差的天數(int，數值取絕對值)</br>
	 *	回傳:　A日期與B日期相差日期</br>
	 *  回傳0:　　A日期等於B日期</br>
	 *  舉例說明: 20150424, 20150425 --> 相差1天</br>
	 * @param strDateA
	 * @param strDateB
	 * @return |回傳兩日期相減的天數(int)|，數值取絕對值。
	 */
	public static int absCalculateDays(String strDateA, String strDateB) throws Exception {
		return Math.abs(calculateDays(strDateA, strDateB));
	}

	/**
	 *  輸入兩個字串類型的日期，格式為yyyyMMdd，回傳兩日期相差的天數加一天(int，數值取絕對值+1)</br>
	 *	回傳:　A日期與B日期相差日期</br>
	 *  回傳0:　　A日期等於B日期</br>
	 *  舉例說明: 20150424, 20150425 --> 相差2天</br>
	 * @param strDateA
	 * @param strDateB
	 * @return |回傳兩日期相減的天數(int)|，數值取絕對值。
	 */
	public static int absCalculateDaysPlusOneDay(String strDateA, String strDateB) throws Exception {
		return Math.abs(calculateDays(strDateA, strDateB));
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
     * 取得下一年的日期，格式：yyyymmdd
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getNextYearDate(String date) throws ParseException
    {
        return getNextYearDate(date, 1);
    }

    /**
     * 取得下N年的日期，格式：yyyymmdd
     *
     * @param date
     * @param months
     * @return
     * @throws ParseException
     */
    public static String getNextYearDate(String date, int years) throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(date));
        calendar.add(Calendar.YEAR, years);

        return DATE_FORMAT.format(calendar.getTime());
    }

    /**
     * 取得前一年的日期，格式：yyyymmdd
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getPreviousYearDate(String date) throws ParseException
    {
        return getPreviousYearDate(date, 1);
    }

    /**
     * 取得前N年的日期，格式：yyyymmdd
     *
     * @param date
     * @param months
     * @return
     * @throws ParseException
     */
    public static String getPreviousYearDate(String date, int years) throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(date));
        calendar.add(Calendar.YEAR, -years);

        return DATE_FORMAT.format(calendar.getTime());
    }

    /**
	 * 取民國年
	 * @param tem
	 * @return
	 */
	public static String getROCDate(Date tem){
		StringBuffer roc = new StringBuffer("民國 ");

		 Calendar cal = Calendar.getInstance();
		 cal.setTime(tem);
		 if (cal.get(Calendar.YEAR) > 1492)
			 cal.add(Calendar.YEAR, -1911);
		 roc.append(cal.get(Calendar.YEAR)+"年 ");
		 roc.append((cal.get(Calendar.MONTH)+1)+"月 ");
		 roc.append(cal.get(Calendar.DAY_OF_MONTH)+"日 ");
		 roc.append(cal.get(Calendar.HOUR_OF_DAY)+" 時 ");
		 roc.append(cal.get(Calendar.MINUTE)+"分");
		return roc.toString();
	}

	/**
     * 將yyyyMMdd轉為格式yyyy/MM/dd<br>
     * 若傳入 Null或格式不符,則不轉換
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

    /**
     * 西元年轉換為民國年
     *
     * @param acYear
     *            西元年 (EX:2012)
     *
     */
    public static int adConvert_ToROCYear(String adYear)
    {
        int ROC_YEAR = 0;

        if(StringUtil.isNumeric(adYear))
        {
            // 將西元年轉換為民國
            int AD_YEAR = Integer.parseInt(adYear);
            ROC_YEAR = AD_YEAR - 1911;

            if(ROC_YEAR <= 0)
                ROC_YEAR--;
        }

        return ROC_YEAR;
    }
    /**
     * 轉換指定的日期格式
     *
     * @param date
     * @param origFormat
     * @param format
     *
     * @throws ParseException
     */
    public static String transfer(String date, String origFormat, String format) throws ParseException
    {
        return new SimpleDateFormat(format).format(new SimpleDateFormat(origFormat).parse(date));
    }
    /**
     * 取得此月的第一天日期，格式：yyyymmdd
     *
     * @param yearMonth
     *
     * @throws ParseException
     */
    public static String getFirstDayOfMonth(String yearMonth) throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YEAR_MONTH_FORMAT.parse(yearMonth));

        return DATE_FORMAT.format(calendar.getTime());
    }

    /**
     * 取得此月的最後一天日期，格式：yyyymmdd
     *
     * @param yearMonth
     *            格式yyyymm
     *
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String yearMonth) throws ParseException
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YEAR_MONTH_FORMAT.parse(yearMonth));
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        return DATE_FORMAT.format(calendar.getTime());
    }
    public static void main(String args[]) {
      System.out.println(getTimeStr(new Date()));
    }
}
