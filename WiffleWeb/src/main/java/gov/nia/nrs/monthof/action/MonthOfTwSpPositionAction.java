package gov.nia.nrs.monthof.action;

import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;
import gov.nia.nrs.utils.ExcelToHtml;
import gov.nia.nrs.utils.MultiQueryUtils;
import gov.nia.nrs.utils.StringUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * 台籍配偶身份每月分析表
 * @author Tim
 */
@Namespace("/monthOfTwSpPosition")
public class MonthOfTwSpPositionAction extends MonthOfAction
{
	private static final long serialVersionUID = -962196517682008779L;

	private static final Logger logger = Logger.getLogger(MonthOfTwSpPositionAction.class);

	private static TableNameEnum table = TableNameEnum.ForeignSpouseCityAccu;

	private ChartData barChartData;
	private ChartData graphChartData;
	private ChartData pieChartData;

	@Action(value = "query", results = { @Result(name = SUCCESS, location = "monthOfTwSpPositionQuery", type = "tiles") })
	public String query() throws Exception
	{
		logger.debug("query");
		message = "";
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = SUCCESS, location = "monthOfTwSpPositionList", type = "tiles"),
			@Result(name = INPUT, location = "monthOfTwSpPositionQuery", type = "tiles") })
	public String list() throws Exception
	{
		logger.debug(String.format("list, startYear=%s, startMonth=%s, endYear=%s, endMonth=%s, cityResult=%s",
				startYearResults, startMonthResults, endYearResults, endMonthResults, cityResult));

		if (MultiQueryUtils.isEmptyOrUnSelect(startYearResults) || MultiQueryUtils.isEmptyOrUnSelect(startMonthResults))
		{
			message = "請選擇起始日期";
			return INPUT;
		}

		message = "";
		try
		{
			MultiQueryForm form = getReportForm();
			String reportBase64Str = multiQueryWebService.dlReport(form);
			if (!StringUtil.isEmpty(reportBase64Str))
			{
				logger.debug("list, reportBase64Str.len=" + reportBase64Str.length());
				InputStream is = new ByteArrayInputStream(Base64.decodeBase64(reportBase64Str));
				if (is != null)
				{
					ExcelToHtml eth = new ExcelToHtml(is);
					tableHtml = eth.getHTML();
				}
			}
		}
		catch (Exception e)
		{
			message = "執行失敗！";
			logger.error("list error", e);
			return INPUT;
		}
		return SUCCESS;
	}

	private MultiQueryForm getReportForm()
	{
		String fileName = getFileName("臺籍配偶身份每月分析表");

		TreeMap<Integer, QueryAttrEnum> rowAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		rowAttrMap.put(0, QueryAttrEnum.TwSpPosition);

		TreeMap<Integer, QueryAttrEnum> colAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		colAttrMap.put(0, QueryAttrEnum.YearMonth);
		colAttrMap.put(1, QueryAttrEnum.Gender);

		MultiQueryForm form = new MultiQueryForm();
		form.setTable(table);

		List<String> headerList = getHeaderList(fileName);
		form.setHeaderList(headerList);
		form.setXlsSheetName(fileName);
		form.setRowAttrMap(rowAttrMap);
		form.setColAttrMap(colAttrMap);
		form.setWhereFilter(getWhereFilter());
		form.setParamMap(getParamMap());
		return form;
	}

	@Override
	public String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		whereFilter.append(super.getWhereFilter());
		if (!MultiQueryUtils.isEmptyOrUnSelect(cityResult))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpCity, cityResult));
		return whereFilter.toString();
	}

	@Action(value = "report", results = {
			@Result(name = INPUT, location = "monthOfTwSpPositionList", type = "tiles"),
			@Result(name = SUCCESS, type = "stream", params = { "contentType", "application/octet-stream", "inputName",
					"reportInputStream", "bufferSize", "1024", "contentDisposition", "filename=\"${reportFileName}\"" }) })
	public String report() throws Exception
	{
		logger.debug(String.format("report, startYear=%s, startMonth=%s, endYear=%s, endMonth=%s, cityResult=%s",
				startYearResults, startMonthResults, endYearResults, endMonthResults, cityResult));

		message = "";
		try
		{
			MultiQueryForm form = getReportForm();
			String reportBase64Str = multiQueryWebService.dlReport(form);
			if (StringUtil.isEmpty(reportBase64Str))
			{
				message = "報表產生失敗";
				return INPUT;
			}
			else
			{
				reportFileName = MultiQueryUtils.getEncodeFileName(form.getXlsSheetName() + ".xls");
				logger.debug("report, reportBase64Str.len=" + reportBase64Str.length());
				reportInputStream = new ByteArrayInputStream(Base64.decodeBase64(reportBase64Str));
				if (reportInputStream == null)
				{
					message = "報表產生失敗";
					return INPUT;
				}
			}
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("report error", e);
			message = "執行發生錯誤";
			return INPUT;
		}
	}

	@Action(value = "barChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String barChart_ajax() throws Exception
	{
		logger.debug("barChart_ajax");

		barChartData = new ChartData();
		try
		{
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, QueryAttrEnum.YearMonth);
			attrMap.put(1, QueryAttrEnum.TwSpPosition);

			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
			form.setParamMap(getParamMap());
			barChartData = multiQueryWebService.queryChartData(form);
		}
		catch (Exception e)
		{
			logger.error("barChart_ajax error", e);
		}
		logger.debug("barChart_ajax, barChartData=" + ReflectionToStringBuilder.toString(barChartData));
		return SUCCESS;
	}

	@Action(value = "graphChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String graphChart_ajax() throws Exception
	{
		logger.debug("graphChart_ajax");

		graphChartData = new ChartData();
		try
		{
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, QueryAttrEnum.YearMonth);
			attrMap.put(1, QueryAttrEnum.TwSpPosition);

			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
			form.setParamMap(getParamMap());
			graphChartData = multiQueryWebService.queryChartData(form);
		}
		catch (Exception e)
		{
			logger.error("graphChart_ajax error", e);
		}
		logger.debug("graphChart_ajax, graphChartData=" + ReflectionToStringBuilder.toString(graphChartData));
		return SUCCESS;
	}

	@Action(value = "pieChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String pieChart_ajax() throws Exception
	{
		logger.debug("pieChart_ajax");

		pieChartData = new ChartData();
		try
		{
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, QueryAttrEnum.TwSpPosition);

			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
			form.setParamMap(getParamMap());
			pieChartData = multiQueryWebService.queryChartData(form);
		}
		catch (Exception e)
		{
			logger.error("pieChart_ajax error", e);
		}
		logger.debug("pieChart_ajax, pieChartData=" + ReflectionToStringBuilder.toString(pieChartData));
		return SUCCESS;
	}

	public ChartData getBarChartData()
	{
		return barChartData;
	}

	public void setBarChartData(ChartData barChartData)
	{
		this.barChartData = barChartData;
	}

	public ChartData getGraphChartData()
	{
		return graphChartData;
	}

	public void setGraphChartData(ChartData graphChartData)
	{
		this.graphChartData = graphChartData;
	}

	public ChartData getPieChartData()
	{
		return pieChartData;
	}

	public void setPieChartData(ChartData pieChartData)
	{
		this.pieChartData = pieChartData;
	}
}
