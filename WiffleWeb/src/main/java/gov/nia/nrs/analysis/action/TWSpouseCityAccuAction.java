/**
 * 
 */
package gov.nia.nrs.analysis.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import gov.nia.nrs.cityof.action.CityOfAction;
import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.CityChartData;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;
import gov.nia.nrs.utils.ExcelToHtml;
import gov.nia.nrs.utils.MultiQueryUtils;
import gov.nia.nrs.utils.StringUtil;

import com.opensymphony.xwork2.Preparable;

/**
 * @author Yang
 *
 */
@Namespace("/twSpouseCity")
public class TWSpouseCityAccuAction extends CityOfAction implements Preparable {

	private static final Logger logger = Logger.getLogger(TWSpouseCityAccuAction.class);

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	@Override
	public void prepare() throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		if(StringUtil.isEmptyOrBlank(yearResults))
			yearResults = String.valueOf(c.get(Calendar.YEAR));
		if(StringUtil.isEmptyOrBlank(monthResults))
			monthResults = String.valueOf(c.get(Calendar.MONTH)+1);
		
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

	private ChartData barChartData;
	private ChartData graphChartData;
	private ChartData pieChartData;
	private CityChartData cityChartData;

	private List<String> yearList;
	private List<String> monthList;
	
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
	/**
	 * @return the cityChartData
	 */
	public CityChartData getCityChartData() {
		return cityChartData;
	}
	/**
	 * @param cityChartData the cityChartData to set
	 */
	public void setCityChartData(CityChartData cityChartData) {
		this.cityChartData = cityChartData;
	}
	
	
	@Action(value = "/twSpouseCity/query",results={
			@Result(name = "success", location = "twSpouseCity.query",type="tiles")
			})
	@SkipValidation
	public String query(){
		return SUCCESS;
	}
	
	@Action(value = "/twSpouseCity/list",results={
			@Result(name = SUCCESS, location = "twSpouseCity.result",type="tiles"),
			@Result(name = INPUT, location = "twSpouseCity.query",type="tiles")
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
		String fileName = "國人涉外婚姻趨勢統計分析表(台配縣市鄉鎮分佈)";

		TreeMap<Integer, QueryAttrEnum> rowAttrMap = new TreeMap<Integer, QueryAttrEnum>();

		if(MultiQueryUtils.isEmptyOrUnSelect(cityResult)){
			rowAttrMap.put(0, QueryAttrEnum.TwSpCity);
		}else{
			rowAttrMap.put(0, QueryAttrEnum.TwSpCityTown);
		}
		
		TreeMap<Integer, QueryAttrEnum> colAttrMap = new TreeMap<Integer, QueryAttrEnum>();
		colAttrMap.put(0, QueryAttrEnum.MarryStatus);
		colAttrMap.put(1, QueryAttrEnum.Gender);

		MultiQueryForm form = new MultiQueryForm();
		form.setTable(TableNameEnum.TwSpouseCityAccu);

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(QueryAttrEnum.TwSpCity.getColumnName(), cityResult);
		if (!MultiQueryUtils.isEmptyOrUnSelect(townResult)){
			form.setNeedColSum(false);
			paramMap.put(QueryAttrEnum.TwSpTownship.getColumnName(), townResult);
		}
		form.setParamMap(paramMap);
		
		List<String> headerList = getHeaderList(fileName);
		form.setHeaderList(headerList);
		form.setXlsSheetName(fileName);
		form.setRowAttrMap(rowAttrMap);
		form.setColAttrMap(colAttrMap);
		form.setWhereFilter(this.getWhereFilter());
		return form;
	}
	
	
	@Action(value = "report", results = {
			@Result(name = INPUT, location = "twSpouseCity.result",type="tiles"),
			@Result(name = SUCCESS, type = "stream", params = { "contentType", "application/octet-stream", "inputName",
					"reportInputStream", "bufferSize", "1024", "contentDisposition", "filename=\"${reportFileName}\"" }) })
	public String report() throws Exception{
		logger.debug(String.format("report, yearResults=%s, monthResults=%s, cityResult=%s, townResult=%s"
				, yearResults, monthResults, cityResult, townResult));

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
			attrMap.put(0, QueryAttrEnum.MarryStatus);
			attrMap.put(1, QueryAttrEnum.TwSpCity);

			MultiQueryForm form = getChartForm(attrMap);
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(QueryAttrEnum.TwSpCity.getColumnName(), cityResult);
			if (!MultiQueryUtils.isEmptyOrUnSelect(townResult)){
				paramMap.put(QueryAttrEnum.TwSpTownship.getColumnName(), townResult);
			}
			form.setParamMap(paramMap);
			
			form.setTable(TableNameEnum.TwSpouseCityAccu);
			form.setWhereFilter(this.getWhereFilter());
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
			attrMap.put(0, QueryAttrEnum.MarryStatus);
			attrMap.put(1, QueryAttrEnum.TwSpCity);

			MultiQueryForm form = getChartForm(attrMap);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(QueryAttrEnum.TwSpCity.getColumnName(), cityResult);
			if (!MultiQueryUtils.isEmptyOrUnSelect(townResult)){
				paramMap.put(QueryAttrEnum.TwSpTownship.getColumnName(), townResult);
			}
			form.setParamMap(paramMap);
			
			form.setTable(TableNameEnum.TwSpouseCityAccu);
			form.setWhereFilter(this.getWhereFilter());
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
			attrMap.put(0, QueryAttrEnum.TwSpCity);

			MultiQueryForm form = getChartForm(attrMap);
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(QueryAttrEnum.TwSpCity.getColumnName(), cityResult);
			if (!MultiQueryUtils.isEmptyOrUnSelect(townResult)){
				paramMap.put(QueryAttrEnum.TwSpTownship.getColumnName(), townResult);
			}
			form.setParamMap(paramMap);
			
			form.setTable(TableNameEnum.TwSpouseCityAccu);
			form.setWhereFilter(this.getWhereFilter());
			pieChartData = multiQueryWebService.queryChartData(form);
		} catch (Exception e) {
			logger.error("pieChart_ajax error", e);
		}
		logger.debug("pieChart_ajax, pieChartData=" + ReflectionToStringBuilder.toString(pieChartData));
		return SUCCESS;
	}
	
	
	@Action(value = "cityChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String cityChart_ajax() throws Exception{
		logger.debug("cityChart_ajax");
		cityChartData = new CityChartData();

		TreeMap<Integer, QueryAttrEnum> attrMap = new TreeMap<Integer, QueryAttrEnum>();
		attrMap.put(0, QueryAttrEnum.TwSpCity);
		try {
			MultiQueryForm form = getChartForm(attrMap);
			form.setTable(TableNameEnum.TwSpouseCityAccu);
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(QueryAttrEnum.TwSpCity.getColumnName(), cityResult);
			if (!MultiQueryUtils.isEmptyOrUnSelect(townResult)){
				paramMap.put(QueryAttrEnum.TwSpTownship.getColumnName(), townResult);
			}
			form.setParamMap(paramMap);
			
			form.setWhereFilter(this.getWhereFilter());
			cityChartData = multiQueryWebService.queryCityChartData(form);
		}catch (Exception e){
			logger.error("cityChart_ajax error", e);
		}
		logger.debug("cityChart_ajax, cityChartData=" + ReflectionToStringBuilder.toString(cityChartData));
		return SUCCESS;
	}
	
	@Override
	protected String getWhereFilter()
	{
		StringBuffer whereFilter = new StringBuffer();
		if (!MultiQueryUtils.isEmptyOrUnSelect(yearResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Year, yearResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(monthResults))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Month, monthResults));
		if (!MultiQueryUtils.isEmptyOrUnSelect(cityResult))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpCity, cityResult));
		if (!MultiQueryUtils.isEmptyOrUnSelect(townResult))
			whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpTownship, townResult));
		if (!MultiQueryUtils.isEmptyOrUnSelect(fsTypeResult))
		{
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.SpouseType, fsTypeResult));
		}
		return whereFilter.toString();
	}
}
