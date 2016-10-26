package gov.nia.nrs.utils;

import gov.nia.nrs.multiquery.bean.DataSettingBean;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;

import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class MultiQueryUtils
{
	private static final Logger logger = Logger.getLogger(MultiQueryUtils.class);

	public static boolean isEmptyOrUnSelect(String s)
	{
		return s == null || s.trim().isEmpty() || s.replaceAll("[\\s]", "").equals("-1");
	}

	/**
	 * 依瀏覽器取得中文下載檔案名
	 * @param fileName
	 * @return
	 */
	public static String getEncodeFileName(String fileName)
	{
		try
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			String userAgent = request.getHeader("User-Agent");
			if ((userAgent.contains("MSIE")) || (userAgent.contains("Trident")))
			{
				//IE6.11正常、FF的中文部分會出現%XX%XX的代碼
				return java.net.URLEncoder.encode(fileName, "UTF-8");
			}
			else
			{
				//Firefox / google Chrome正常，IE6檔名整個亂碼 (連副檔名都看不見)
				return new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
		}
		catch (Exception e)
		{
			logger.error("getEncodeFileName error", e);
		}
		return fileName;
	}

	public static TreeMap<Integer, QueryAttrEnum> getAttrTreeMap(List<String> attrResults)
	{
		TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
		if (attrResults != null && attrResults.size() > 0)
		{
			for (int i = 0; i < attrResults.size(); i++)
			{
				QueryAttrEnum attrEnum = QueryAttrEnum.getByCode(attrResults.get(i));
				if (attrEnum != QueryAttrEnum.NONE)
					attrMap.put(i, attrEnum);
			}
		}
		return attrMap;
	}

	/**
	 * 組合Sql Where條件
	 * @param attrEnum
	 * @param attrResult
	 * @return
	 */
	public static String getWhereFilter(QueryAttrEnum attrEnum, String attrResult)
	{
		StringBuffer result = new StringBuffer();
		if (attrEnum != null && !StringUtil.isEmpty(attrResult))
		{
			if (attrResult.contains(":"))
			{
				if (attrResult.contains(","))
				{
					String[] attrResultArray = attrResult.split(",");
					for (String attrRes : attrResultArray)
					{
						String startKeyCode = attrRes.split(":")[0].replaceAll("\\s", "");
						String endKeyCode = attrRes.split(":")[1].replaceAll("\\s", "");
						if (!StringUtil.isNumeric(startKeyCode) || !StringUtil.isNumeric(endKeyCode))
						{
							logger.error("getWhereFilter format error");
						}
						else
						{
							String strQuot = ""; //判斷attrEnum是否需要單引號
							result.append(" and " + attrEnum.getColumnName() + " in (" + strQuot);
							for (int i = Integer.parseInt(startKeyCode); i <= Integer.parseInt(endKeyCode); i++)
							{
								result.append(String.valueOf(i));
								if (i != Integer.parseInt(endKeyCode))
									result.append(strQuot + ",");
							}
							result.append(strQuot + ")");
						}
					}
				}
			}
			else if (attrResult.contains(","))
			{
				result.append(" and ");
				String inFilter = String.format("%s in ('%s')", attrEnum.getColumnName(),
						attrResult.replaceAll("\\s", ""));
				result.append(inFilter.replaceAll(",", "','"));
			}
			else
			{
				result.append(" and ");
				result.append(String.format("%s='%s'", attrEnum.getColumnName(), attrResult.replaceAll("\\s", "")));
			}
		}
		return result.toString();
	}

	public static String getDateFilter(String startYear, String endYear, String startMonth, String endMonth)
	{
		int sYear = Calendar.getInstance().get(Calendar.YEAR);
		int eYear = Calendar.getInstance().get(Calendar.YEAR);
		if (!MultiQueryUtils.isEmptyOrUnSelect(startYear))
			sYear = Integer.parseInt(startYear);
		if (!MultiQueryUtils.isEmptyOrUnSelect(endYear))
			eYear = Integer.parseInt(endYear);
		int sMonth = 1;
		int eMonth = 12;
		if (!MultiQueryUtils.isEmptyOrUnSelect(startMonth))
			sMonth = Integer.parseInt(startMonth);
		if (!MultiQueryUtils.isEmptyOrUnSelect(endMonth))
			eMonth = Integer.parseInt(endMonth);

		StringBuffer dateFilter = new StringBuffer();
		dateFilter.append(String.format(" and ("));
		for (int year = sYear; year <= eYear; year++)
		{
			dateFilter.append(String.format(" (%s='%d'", QueryAttrEnum.Year.getColumnName(), year));
			dateFilter.append(String.format(" and %s in ('", QueryAttrEnum.Month.getColumnName()));
			for (int month = 1; month <= 12; month++)
			{
				if (year == sYear && month < sMonth)
				{
					continue;
				}

				dateFilter.append(StringUtil.padLeft(String.valueOf(month), 2, '0'));

				if (year == eYear && month == eMonth)
				{
					break;
				}
				if (month < 12)
				{
					dateFilter.append("','");
				}
			}
			dateFilter.append("'))");
			if (year != eYear)
			{
				dateFilter.append(" or ");
			}
		}
		dateFilter.append(")");
		return dateFilter.toString();
	}

	public static String getCodeDesc(List<DataSettingBean> codeList, String codeValues)
	{
		if (StringUtil.isEmpty(codeValues) || codeList == null || codeList.size() <= 0)
		{
			return "";
		}

		String fsTypeDescResult = "";
		try
		{
			String[] codeValArray = codeValues.split(",");
			for (int i = 0; i < codeValArray.length; i++)
			{
				String codeVal = codeValArray[i];
				for (DataSettingBean ds : codeList)
				{
					if (codeVal.trim().equals(ds.getCodeDataValue()))
						fsTypeDescResult += ds.getCodeDataValueDesc();
				}
				if (i < (codeValArray.length - 1))
				{
					fsTypeDescResult += ",";
				}
			}
			return fsTypeDescResult;
		}
		catch (Exception e)
		{
			logger.error("getCodeDesc error", e);
		}
		return "";
	}

//	public static void main(String[] args)
//	{
//		System.out.println(getDateFilter("2016", "2018", "09", "08"));
//	}
}
