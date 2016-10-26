package gov.nia.nrs.cityof.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.multiquery.bean.DataSettingBean;
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

public class CityOfAction extends BaseAction
{
	private static final long serialVersionUID = -1857993503599586237L;

	private static final Logger logger = Logger.getLogger(CityOfAction.class);

	@Resource
	protected MultiQueryWebService multiQueryWebService;

	/** 查詢年 */
	protected String yearResults;
	/** 查詢月 */
	protected String monthResults;
	protected String cityResult;
	protected String townResult;
	/** 配偶類別 */
	protected String fsTypeResult;

	protected String tableHtml;

	protected String reportFileName;
	protected InputStream reportInputStream;

	protected List<String> getHeaderList(String sheetName)
	{
		List<String> headerList = new ArrayList<String>();
		headerList.add(sheetName);
		if (!MultiQueryUtils.isEmptyOrUnSelect(fsTypeResult))
		{
			List<DataSettingBean> codeList = null;
			try
			{
				codeList = multiQueryWebService.queryDataSetting(QueryAttrEnum.FsType.getCodeId());
				headerList.add("配偶種類：" + MultiQueryUtils.getCodeDesc(codeList, fsTypeResult));
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
		return String.format("%s-%s年%s月", sheetName, yearResults, monthResults);
	}

	protected String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		if (!MultiQueryUtils.isEmptyOrUnSelect(yearResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Year, yearResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(monthResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Month, monthResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(cityResult))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.CityA, cityResult));
		if (!MultiQueryUtils.isEmptyOrUnSelect(townResult))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TownshipA, townResult));
		if (!MultiQueryUtils.isEmptyOrUnSelect(fsTypeResult))
		{
			if (!MultiQueryUtils.isEmptyOrUnSelect(cityResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.FsType, fsTypeResult));
			else
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

	public String getCityResult()
	{
		return cityResult;
	}

	public void setCityResult(String cityResult)
	{
		this.cityResult = cityResult;
	}

	public String getTownResult()
	{
		return townResult;
	}

	public void setTownResult(String townResult)
	{
		this.townResult = townResult;
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
