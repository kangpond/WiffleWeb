package gov.nia.nrs.monthof.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.multiquery.bean.DataSettingBean;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.ws.MultiQueryWebService;
import gov.nia.nrs.utils.MultiQueryUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

public class MonthOfAction extends BaseAction
{
	private static final long serialVersionUID = -2440964786777833225L;

	private static final Logger logger = Logger.getLogger(MonthOfAction.class);

	@Resource
	protected MultiQueryWebService multiQueryWebService;

	/** 查詢年月起 */
	protected String startYearResults;
	/** 查詢年月起 */
	protected String startMonthResults;
	/** 查詢年月迄 */
	protected String endYearResults;
	/** 查詢年月迄 */
	protected String endMonthResults;

	protected String cityResult;
	/** 配偶類別 */
	private String fsTypeResult;

	protected String tableHtml;

	protected String reportFileName;
	protected InputStream reportInputStream;

	protected List<String> getHeaderList(String sheetName)
	{
		List<String> headerList = new ArrayList<String>();
		headerList.add(sheetName);
		if (!MultiQueryUtils.isEmptyOrUnSelect(fsTypeResult))
		{
			List<DataSettingBean> fsTypeList;
			try
			{
				fsTypeList = multiQueryWebService.queryDataSetting(QueryAttrEnum.FsType.getCodeId());
				headerList.add("配偶種類：" + MultiQueryUtils.getCodeDesc(fsTypeList, fsTypeResult));
			}
			catch (Exception e)
			{
				logger.warn("getHeaderList warning", e);
			}
		}
		return headerList;
	}

	protected String getFileName(String sheetName)
	{
		return String.format("%s-%s年%s月 至 %s年%s月", sheetName, startYearResults, startMonthResults, endYearResults,
				startMonthResults);
	}

	protected String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		whereFilter.append(MultiQueryUtils.getDateFilter(startYearResults, endYearResults, startMonthResults, endMonthResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(fsTypeResult))
		{
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.SpouseType, fsTypeResult));
		}
		return whereFilter.toString();
	}

	protected MultiQueryForm getChartForm(TreeMap<Integer, QueryAttrEnum> attrMap)
	{
		MultiQueryForm form = new MultiQueryForm();
		form.setRowAttrMap(attrMap);
		form.setNeedRowSum(false);
		form.setNeedColSum(false);
		return form;
	}

	protected Map<String, String> getParamMap()
	{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("sYear", startYearResults);
		paramMap.put("eYear", endYearResults);
		paramMap.put("sMonth", startMonthResults);
		paramMap.put("eMonth", endMonthResults);
		return paramMap;
	}

	public String getStartYearResults()
	{
		return startYearResults;
	}

	public void setStartYearResults(String startYearResults)
	{
		this.startYearResults = startYearResults;
	}

	public String getStartMonthResults()
	{
		return startMonthResults;
	}

	public void setStartMonthResults(String startMonthResults)
	{
		this.startMonthResults = startMonthResults;
	}

	public String getEndYearResults()
	{
		return endYearResults;
	}

	public void setEndYearResults(String endYearResults)
	{
		this.endYearResults = endYearResults;
	}

	public String getEndMonthResults()
	{
		return endMonthResults;
	}

	public void setEndMonthResults(String endMonthResults)
	{
		this.endMonthResults = endMonthResults;
	}

	public String getCityResult()
	{
		return cityResult;
	}

	public void setCityResult(String cityResult)
	{
		this.cityResult = cityResult;
	}

	public String getFsTypeResult()
	{
		return fsTypeResult;
	}

	public void setFsTypeResult(String fsTypeResult)
	{
		this.fsTypeResult = fsTypeResult;
	}

	public String getTableHtml()
	{
		return tableHtml;
	}

	public void setTableHtml(String tableHtml)
	{
		this.tableHtml = tableHtml;
	}

	public String getReportFileName()
	{
		return reportFileName;
	}

	public void setReportFileName(String reportFileName)
	{
		this.reportFileName = reportFileName;
	}

	public InputStream getReportInputStream()
	{
		return reportInputStream;
	}

	public void setReportInputStream(InputStream reportInputStream)
	{
		this.reportInputStream = reportInputStream;
	}

}
