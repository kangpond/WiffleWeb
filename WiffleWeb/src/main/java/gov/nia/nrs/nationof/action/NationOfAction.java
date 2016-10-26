package gov.nia.nrs.nationof.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.ws.MultiQueryWebService;
import gov.nia.nrs.utils.MultiQueryUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

public class NationOfAction extends BaseAction
{
	private static final long serialVersionUID = -1857993503599586237L;

	private static final Logger logger = Logger.getLogger(NationOfAction.class);

	@Resource
	protected MultiQueryWebService multiQueryWebService;

	/** 查詢年 */
	protected String yearResults;
	/** 查詢月 */
	protected String monthResults;

	protected String tableHtml;

	protected String reportFileName;
	protected InputStream reportInputStream;

	protected List<String> getHeaderList(String sheetName)
	{
		List<String> headerList = new ArrayList<String>();
		headerList.add(sheetName);
		return headerList;
	}

	protected String getFileName(String sheetName)
	{
		return String.format("%s-%s年%s月", sheetName, yearResults, monthResults);
	}

	protected String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		if (!MultiQueryUtils.isEmptyOrUnSelect(yearResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Year, yearResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(monthResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Month, monthResults));
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

	public String getYearResults()
	{
		return yearResults;
	}

	public void setYearResults(String yearResults)
	{
		this.yearResults = yearResults;
	}

	public String getMonthResults()
	{
		return monthResults;
	}

	public void setMonthResults(String monthResults)
	{
		this.monthResults = monthResults;
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
