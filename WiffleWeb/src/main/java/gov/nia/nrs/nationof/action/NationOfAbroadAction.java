package gov.nia.nrs.nationof.action;

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
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * 外配國籍分布-依子女出國未歸年
 * @author Tim
 */
@Namespace("/nationOfAbroad")
public class NationOfAbroadAction extends NationOfAction
{
	private static final long serialVersionUID = -7730867850119755009L;

	private static final Logger logger = Logger.getLogger(NationOfAbroadAction.class);

	private static TableNameEnum table = TableNameEnum.NewResidenceChildAbroadNaAccu;

	private ChartData barChartData;
	private ChartData graphChartData;
	private ChartData pieChartData;

	@Action(value = "query", results = { @Result(name = SUCCESS, location = "nationOfAbroadQuery", type = "tiles") })
	public String query() throws Exception
	{
		logger.debug("query");
		message = "";
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = SUCCESS, location = "nationOfAbroadList", type = "tiles"),
			@Result(name = INPUT, location = "nationOfAbroadQuery", type = "tiles") })
	public String list() throws Exception
	{
		logger.debug(String.format("list, yearResults=%s, monthResults=%s"
				, yearResults, monthResults));

		if (MultiQueryUtils.isEmptyOrUnSelect(yearResults) || MultiQueryUtils.isEmptyOrUnSelect(monthResults))
		{
			message = "請選擇年月";
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
		String fileName = getFileName("外配國籍分布-依子女出國未歸年統計表");

		TreeMap<Integer, QueryAttrEnum> rowAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		rowAttrMap.put(0, QueryAttrEnum.Nation);

		TreeMap<Integer, QueryAttrEnum> colAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		colAttrMap.put(0, QueryAttrEnum.AbroadYear);
		colAttrMap.put(1, QueryAttrEnum.Gender);

		MultiQueryForm form = new MultiQueryForm();
		form.setTable(table);

		List<String> headerList = getHeaderList(fileName);
		form.setHeaderList(headerList);
		form.setXlsSheetName(fileName);
		form.setRowAttrMap(rowAttrMap);
		form.setColAttrMap(colAttrMap);
		form.setWhereFilter(getWhereFilter());
		return form;
	}

	@Override
	public String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		whereFilter.append(super.getWhereFilter());
		return whereFilter.toString();
	}

	@Action(value = "report", results = {
			@Result(name = INPUT, location = "nationOfAbroadList", type = "tiles"),
			@Result(name = SUCCESS, type = "stream", params = { "contentType", "application/octet-stream", "inputName",
					"reportInputStream", "bufferSize", "1024", "contentDisposition", "filename=\"${reportFileName}\"" }) })
	public String report() throws Exception
	{
		logger.debug(String.format("report, yearResults=%s, monthResults=%s"
				, yearResults, monthResults));

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

		TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
		attrMap.put(0, QueryAttrEnum.Nation);
		attrMap.put(1, QueryAttrEnum.AbroadYear);
		try
		{
			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
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

		TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
		attrMap.put(0, QueryAttrEnum.Nation);
		attrMap.put(1, QueryAttrEnum.AbroadYear);
		try
		{
			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
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

		TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
		attrMap.put(0, QueryAttrEnum.AbroadYear);
		try
		{
			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(table);
			form.setWhereFilter(getWhereFilter());
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
