/**
 * 
 */
package gov.nia.nrs.analysis.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import gov.nia.nrs.monthof.action.MonthOfAction;
import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;
import gov.nia.nrs.utils.ExcelToHtml;
import gov.nia.nrs.utils.MultiQueryUtils;
import gov.nia.nrs.utils.StringUtil;

import com.opensymphony.xwork2.Preparable;

/**
 * 
 * 年齡狀況分布
 * @author A0017
 *
 */
@Namespace("/spouseAgeAccu")
public class SpouseAgeAccuAction extends MonthOfAction implements Preparable {

	private static final Logger logger = Logger.getLogger(SpouseAgeAccuAction.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	public void prepare() throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		if(StringUtil.isEmptyOrBlank(startYearResults))
			startYearResults = String.valueOf(c.get(Calendar.YEAR));
		if(StringUtil.isEmptyOrBlank(startMonthResults))
			startMonthResults = String.valueOf(c.get(Calendar.MONTH)+1);
		
		if(yearList == null)
			yearList = new ArrayList<String>();
		if(monthList == null)
			monthList = new ArrayList<String>();
		
		for(int i=0;i<10;i++){
			yearList.add(String.valueOf(c.get(Calendar.YEAR)-i));
		}
		
		for(int i=1;i<=12;i++){
			monthList.add(String.valueOf(i));
		}
	}

	protected ChartData barChartData;
	protected ChartData graphChartData;
	protected ChartData pieChartData;
	
	protected List<String> yearList;
	protected List<String> monthList;
	
	/**
	 * @return the barChartData
	 */
	public ChartData getBarChartData() {
		return barChartData;
	}
	/**
	 * @param barChartData the barChartData to set
	 */
	public void setBarChartData(ChartData barChartData) {
		this.barChartData = barChartData;
	}
	/**
	 * @return the graphChartData
	 */
	public ChartData getGraphChartData() {
		return graphChartData;
	}
	/**
	 * @param graphChartData the graphChartData to set
	 */
	public void setGraphChartData(ChartData graphChartData) {
		this.graphChartData = graphChartData;
	}
	/**
	 * @return the pieChartData
	 */
	public ChartData getPieChartData() {
		return pieChartData;
	}
	/**
	 * @param pieChartData the pieChartData to set
	 */
	public void setPieChartData(ChartData pieChartData) {
		this.pieChartData = pieChartData;
	}

	/**
	 * @return the yearList
	 */
	public List<String> getYearList() {
		return yearList;
	}
	/**
	 * @param yearList the yearList to set
	 */
	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}
	/**
	 * @return the monthList
	 */
	public List<String> getMonthList() {
		return monthList;
	}
	/**
	 * @param monthList the monthList to set
	 */
	public void setMonthList(List<String> monthList) {
		this.monthList = monthList;
	}
	
	@Action(value = "/spouseAgeAccu/query",results={
			@Result(name = "success", location = "spouseAgeAccu.query",type="tiles")
			})
	@SkipValidation
	public String query(){
		return SUCCESS;
	}
	
	@Action(value = "/spouseAgeAccu/list",results={
			@Result(name = SUCCESS, location = "spouseAgeAccu.result",type="tiles"),
			@Result(name = INPUT, location = "spouseAgeAccu.query",type="tiles")
			})
	@SkipValidation
	public String list(){
		try{
			MultiQueryForm form = getReportForm();
			String reportBase64Str = multiQueryWebService.dlReport(form);
			if (!StringUtil.isEmpty(reportBase64Str)){
				logger.debug("list, reportBase64Str.len=" + reportBase64Str.length());
				reportInputStream = new ByteArrayInputStream(Base64.decodeBase64(reportBase64Str));
				if (reportInputStream != null){
					ExcelToHtml eth = new ExcelToHtml(reportInputStream);
					tableHtml = eth.getHTML();
				}
			}
		}catch (Exception e) {
			message = "執行失敗！";
			logger.error("list error", e);
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	private MultiQueryForm getReportForm(){
		String fileName = "國人涉外婚姻趨勢統計分析表(年齡狀況分布)";
		TreeMap<Integer, QueryAttrEnum> rowAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		rowAttrMap.put(0, isBefore2016() ?QueryAttrEnum.ForeignSpAge2016:QueryAttrEnum.ForeignSpAge2017);

		TreeMap<Integer, QueryAttrEnum> colAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		colAttrMap.put(0, QueryAttrEnum.MarryStatus);
		colAttrMap.put(1, QueryAttrEnum.Gender);

		MultiQueryForm form = new MultiQueryForm();
		form.setTable(TableNameEnum.SpouseAgeAccu);

		List<String> headerList = getHeaderList(fileName);
		form.setHeaderList(headerList);
		form.setXlsSheetName(fileName);
		form.setRowAttrMap(rowAttrMap);
		form.setColAttrMap(colAttrMap);
		
		if(!StringUtil.isEmptyOrBlank(startYearResults))
			endYearResults = startYearResults;
		if(!StringUtil.isEmptyOrBlank(startMonthResults))
			endMonthResults = startMonthResults;
		
		form.setWhereFilter(getWhereFilter());
		return form;
	}
	
	
	@Action(value = "report", results = {
			@Result(name = INPUT, location = "spouseAgeAccu.result",type="tiles"),
			@Result(name = SUCCESS, type = "stream", params = { "contentType", "application/octet-stream", "inputName",
					"reportInputStream", "bufferSize", "1024", "contentDisposition", "filename=\"${reportFileName}\"" }) })
	public String report() throws Exception{
		logger.debug(String.format("report, startYear=%s, startMonth=%s, endYear=%s, endMonth=%s, cityResult=%s",
				startYearResults, startMonthResults, endYearResults, endMonthResults, cityResult));

		message = "";
		try{
			MultiQueryForm form = getReportForm();
			String reportBase64Str = multiQueryWebService.dlReport(form);
			if (StringUtil.isEmpty(reportBase64Str)){
				message = "報表產生失敗";
				return INPUT;
			}else{
				reportFileName = MultiQueryUtils.getEncodeFileName(form.getXlsSheetName() + ".xls");
				logger.debug("report, reportBase64Str.len=" + reportBase64Str.length());
				reportInputStream = new ByteArrayInputStream(Base64.decodeBase64(reportBase64Str));
				if (reportInputStream == null){
					message = "報表產生失敗";
					return INPUT;
				}
			}
			return SUCCESS;
		}catch (Exception e){
			logger.error("report error", e);
			message = "執行發生錯誤";
			return INPUT;
		}
	}
	
	@Action(value = "barChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String barChart_ajax() throws Exception {
		logger.debug("barChart_ajax");

		barChartData = new ChartData();
		try {
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, QueryAttrEnum.SpouseType);
			attrMap.put(1, isBefore2016() ?QueryAttrEnum.ForeignSpAge2016:QueryAttrEnum.ForeignSpAge2017);

			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(TableNameEnum.SpouseAgeAccu);
			form.setWhereFilter(getWhereFilter());
			barChartData = multiQueryWebService.queryChartData(form);
		}catch (Exception e){
			logger.error("barChart_ajax error", e);
		}
		logger.debug("barChart_ajax, barChartData=" + ReflectionToStringBuilder.toString(barChartData));
		return SUCCESS;
	}

	@Action(value = "graphChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String graphChart_ajax() throws Exception{
		logger.debug("graphChart_ajax");

		graphChartData = new ChartData();
		try{
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, QueryAttrEnum.SpouseType);
			attrMap.put(1, isBefore2016() ?QueryAttrEnum.ForeignSpAge2016:QueryAttrEnum.ForeignSpAge2017);


			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(TableNameEnum.SpouseAgeAccu);
			form.setWhereFilter(getWhereFilter());
			graphChartData = multiQueryWebService.queryChartData(form);
		}catch (Exception e) {
			logger.error("graphChart_ajax error", e);
		}
		logger.debug("graphChart_ajax, graphChartData=" + ReflectionToStringBuilder.toString(graphChartData));
		return SUCCESS;
	}

	@Action(value = "pieChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String pieChart_ajax() throws Exception {
		logger.debug("pieChart_ajax");

		pieChartData = new ChartData();
		try{
			TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
			attrMap.put(0, isBefore2016() ?QueryAttrEnum.ForeignSpAge2016:QueryAttrEnum.ForeignSpAge2017);

			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(TableNameEnum.SpouseAgeAccu);
			form.setWhereFilter(getWhereFilter());
			pieChartData = multiQueryWebService.queryChartData(form);
		} catch (Exception e) {
			logger.error("pieChart_ajax error", e);
		}
		logger.debug("pieChart_ajax, pieChartData=" + ReflectionToStringBuilder.toString(pieChartData));
		return SUCCESS;
	}
	
	//如果 年度為2016前(含)
	private boolean isBefore2016(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return (c.get(Calendar.YEAR) <= 2016);
	}
}
