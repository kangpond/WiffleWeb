package gov.nia.nrs.multiquery.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.CityChartData;
import gov.nia.nrs.multiquery.bean.CityTipsData;
import gov.nia.nrs.multiquery.bean.DataSettingBean;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.bean.SuggestListBoxBean;
import gov.nia.nrs.multiquery.enums.ChartTypeEnum;
import gov.nia.nrs.multiquery.enums.CityLocationEnum;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;
import gov.nia.nrs.multiquery.ws.MultiQueryWebService;
import gov.nia.nrs.utils.MultiQueryUtils;
import gov.nia.nrs.utils.StringUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/multiquery")
public class MultiQueryAction extends BaseAction
{
	private static final long serialVersionUID = 5040008041844087710L;
	private static final Logger logger = Logger.getLogger(MultiQueryAction.class);

	@Resource
	private MultiQueryWebService multiQueryWebService;

	private String codeId;
	private List<DataSettingBean> codeList;
	private List<SuggestListBoxBean> codeSgList;

	private String cityCodeValue;

	/** 配偶類別 */
	private String fsTypeResult;
	/** 國籍 */
	private String nationResult;
	/** 婚姻狀態 */
	private String marryResult;
	/** 性別 */
	private String genderResult;
	/** 教育程度 */
	private String eduResult;
	/** 職業 */
	private String occupationResult;
	/** 年齡分佈 */
	private String ageResult;
	/** 證別 */
	private String permitNoCodeResult;
	/** 事由 */
	private String reasonResult;
	/** 證件狀態 */
	private String lossMarkResult;
	/** 子女數 */
	private String childNumResult;
	/** 是否有行方不明註記 */
	private String referenceMarkResult;
	/** 是否在台 */
	private String entryDateResult;
	/** 是否死亡 */
	private String deadMarkResult;

	// 外配生活狀態
	/** 是否遭遇家暴 */
	private String rapeMarkResult;
	/** 是否遭遇性侵 */
	private String domViolenceMarkResult;
	/** 是否取得駕照 */
	private String driverLicenseMarkResult;
	/** 是否投保勞保 */
	private String insureMarkResult;
	/** 是否投保健保 */
	private String healthCareMark;
	/** 與台配年齡差距狀況 */
	private String ageDiffResult;

	// 台配背景
	/** 性別 */
	private String twSpouseGenderResult;
	/** 年齡分佈 */
	private String twSpouseAgeResult;
	/** 教育程度 */
	private String twSpouseEducationResult;

	// 台配生活狀態
	/** 符合原住民 */
	private String twSpouseNativeMarkResult;
	/** 符合台女陸男 */
	private String twSpouseTypeResult;
	/** 符合榮民 */
	private String twSpouseVeteranMarkResult;
	/** 符合身心障礙 */
	private String twSpouseDisabledMarkResult;
	/** 符合中低收入 */
	private String twSpouseMidLowIncomeMarkResult;
	/** 符合低收入 */
	private String twSpouseLowIncomeMarkResult;
	/** 符合中低收入老人津貼 */
	private String twSpouseOldAllowanceMarkResult;

	// 地區分佈
	/** 外配縣市 */
	private String cityAResult;
	/** 外配鄉鎮市區 */
	private String townshipAResult;
	/** 台配縣市 */
	private String twSpouseCityAResult;
	/** 台配鄉鎮市區 */
	private String twSpouseTownshipAResult;

	// 時間區間
	/** 查詢年月起 */
	private String startYearResults;
	/** 查詢年月起 */
	private String startMonthResults;
	/** 查詢年月迄 */
	private String endYearResults;
	/** 查詢年月迄 */
	private String endMonthResults;

	/** DataSetting類別對應 */
	private List<DataSettingBean> dsCodeList;

	private String attrFilter;

	private List<String> colAttrResults;
	private List<String> rowAttrResults;
	private String barAttrResults;
	private String graphAttrResults;
	private String pieAttrResults;
	private String cityAttrResults;

	private String reportFileName;
	private InputStream reportInputStream;

	private ChartData barChartData;
	private ChartData graphChartData;
	private ChartData pieChartData;
	private CityChartData cityChartData;

	@Action(value = "query", results = { @Result(name = SUCCESS, location = "multiQuery", type = "tiles") })
	public String query() throws Exception
	{
		logger.debug("query");
		message = "";
		return SUCCESS;
	}

	@Action(value = "code_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String code_ajax() throws Exception
	{
//		logger.debug("code_ajax, codeId=" + codeId);
		codeList = new ArrayList<DataSettingBean>();
		if (!StringUtil.isEmpty(codeId)) {
			codeList = multiQueryWebService.queryDataSetting(codeId);
		}
		return SUCCESS;
	}

	@Action(value = "code_sg_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String code_sg_ajax() throws Exception
	{
//		logger.debug("code_sg_ajax, codeId=" + codeId);
		codeSgList = new ArrayList<SuggestListBoxBean>();
		if (!StringUtil.isEmpty(codeId)) {
			codeSgList = getSuggestBean(codeId);
		}
		return SUCCESS;
	}

	private List<SuggestListBoxBean> getSuggestBean(String codeId)
	{
		List<SuggestListBoxBean> result = new ArrayList<SuggestListBoxBean>();
		try
		{
			List<DataSettingBean> dataList = multiQueryWebService.queryDataSetting(codeId);
			if (dataList != null && dataList.size() > 0)
			{
				for (DataSettingBean ds : dataList)
				{
					SuggestListBoxBean sb = new SuggestListBoxBean();
					if (QueryAttrEnum.Nation.getCodeId().equals(codeId))
					{
						sb.setValue(ds.getCodeDataValue());
						sb.setLabel(ds.getCodeDataValueDesc2());
						sb.setDesc(ds.getCodeDataValueDesc());
					}
					else
					{
						sb.setValue(ds.getCodeDataValue());
						sb.setLabel(ds.getCodeDataValueDesc());
						sb.setDesc(ds.getCodeDataValueDesc());
					}
					result.add(sb);
				}
			}
		}
		catch (Exception e)
		{
			logger.debug("getSuggestBean error, codeId=" + codeId);
			logger.error("getSuggestBean error", e);
		}
		return result;
	}

	@Action(value = "cityTown_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String cityTown_ajax() throws Exception
	{
//		logger.debug("cityTown_ajax, cityCodeValue=" + cityCodeValue);
		codeList = new ArrayList<DataSettingBean>();
		if (!StringUtil.isEmpty(cityCodeValue)) {
			codeList = multiQueryWebService.queryTownDs(cityCodeValue);
		}
		return SUCCESS;
	}

	@Action(value = "ds_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String ds_ajax() throws Exception
	{
		dsCodeList = new ArrayList<DataSettingBean>();
		for (QueryAttrEnum ds : QueryAttrEnum.values())
		{
			if (ds.getCodeId().startsWith("Y") || ds.getCodeId().startsWith("X"))
			{
				//自定屬性，不加入選單
				continue;
			}
			DataSettingBean dsb = new DataSettingBean();
			dsb.setCodeDataValue(ds.getCodeId());
			dsb.setCodeDataValueDesc(ds.getDesc());
			dsCodeList.add(dsb);
		}
		logger.debug("ds_ajax, dsCodeList=" + dsCodeList);
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = SUCCESS, location = "multiList", type = "tiles"),
			@Result(name = INPUT, location = "multiQuery", type = "tiles") })
	public String list() throws Exception
	{
		logger.debug("list");

		message = "";
		attrFilter = "";
		try
		{
			StringBuffer whereFilter = new StringBuffer();
			if (!StringUtil.isEmpty(fsTypeResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.FsType, fsTypeResult));
			if (!StringUtil.isEmpty(nationResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Nation, nationResult));
			if (!StringUtil.isEmpty(marryResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Marry, marryResult));
			if (!StringUtil.isEmpty(genderResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Gender, genderResult));
			if (!StringUtil.isEmpty(eduResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Education, eduResult));
			if (!StringUtil.isEmpty(occupationResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Occupation, occupationResult));
			if (!StringUtil.isEmpty(ageResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Age, ageResult));
			if (!StringUtil.isEmpty(permitNoCodeResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.PermitNoCode, permitNoCodeResult));
			if (!StringUtil.isEmpty(reasonResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.Reason, reasonResult));
			if (!StringUtil.isEmpty(lossMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.LossMark, lossMarkResult));
			if (!StringUtil.isEmpty(childNumResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.ChildNum, childNumResult));

			if (!StringUtil.isEmpty(referenceMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.ReferenceMark, referenceMarkResult));
			if (!StringUtil.isEmpty(entryDateResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.EntryDate, entryDateResult));
			if (!StringUtil.isEmpty(deadMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.DeadMark, deadMarkResult));
			if (!StringUtil.isEmpty(rapeMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.RapeMark, rapeMarkResult));
			if (!StringUtil.isEmpty(domViolenceMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.DomViolenceMark, domViolenceMarkResult));
			if (!StringUtil.isEmpty(driverLicenseMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.DriverLicenseMark, driverLicenseMarkResult));
			if (!StringUtil.isEmpty(insureMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.InsureMark, insureMarkResult));
			if (!StringUtil.isEmpty(healthCareMark))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.HealthCareMark, healthCareMark));
			if (!StringUtil.isEmpty(ageDiffResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.AgeDiff, ageDiffResult));

			if (!StringUtil.isEmpty(twSpouseGenderResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseGender, twSpouseGenderResult));
			if (!StringUtil.isEmpty(twSpouseAgeResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseAge, twSpouseAgeResult));
			if (!StringUtil.isEmpty(twSpouseEducationResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseEducation, twSpouseEducationResult));
			if (!StringUtil.isEmpty(twSpouseNativeMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseNativeMark, twSpouseNativeMarkResult));
			if (!StringUtil.isEmpty(twSpouseTypeResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseType, twSpouseTypeResult));
			if (!StringUtil.isEmpty(twSpouseVeteranMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseVeteranMark, twSpouseVeteranMarkResult));
			if (!StringUtil.isEmpty(twSpouseDisabledMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseDisabledMark, twSpouseDisabledMarkResult));
			if (!StringUtil.isEmpty(twSpouseMidLowIncomeMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseMidLowIncomeMark, twSpouseMidLowIncomeMarkResult));
			if (!StringUtil.isEmpty(twSpouseLowIncomeMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseLowIncomeMark, twSpouseLowIncomeMarkResult));
			if (!StringUtil.isEmpty(twSpouseOldAllowanceMarkResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseOldAllowanceMark, twSpouseOldAllowanceMarkResult));
			if (!StringUtil.isEmpty(cityAResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.CityA, cityAResult));
			if (!StringUtil.isEmpty(townshipAResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TownshipA, townshipAResult));
			if (!StringUtil.isEmpty(twSpouseCityAResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseCityA, twSpouseCityAResult));
			if (!StringUtil.isEmpty(twSpouseTownshipAResult))
				whereFilter.append(MultiQueryUtils.getWhereFilter(QueryAttrEnum.TwSpouseTownshipA, twSpouseTownshipAResult));

			whereFilter.append(MultiQueryUtils.getDateFilter(startYearResults, endYearResults, startMonthResults,
					endMonthResults));

			attrFilter = whereFilter.toString();
			logger.debug("list, attrFilter=" + attrFilter);
		}
		catch (Exception e)
		{
			message = "執行失敗！";
			logger.error("list error", e);
			return INPUT;
		}
		return SUCCESS;
	}

	@Action(value = "dlReport", results = {
			@Result(name = INPUT, location = "multiList", type = "tiles"),
			@Result(name = SUCCESS, type = "stream", params = { "contentType", "application/octet-stream", "inputName",
					"reportInputStream", "bufferSize", "1024", "contentDisposition", "filename=\"${reportFileName}\"" }) })
	public String dlReport() throws Exception
	{
		logger.debug(String.format("dlReport, colAttrResults=%s, rowAttrResults=%s, attrFilter=%s",
				colAttrResults, rowAttrResults, attrFilter));
		message = "";
		try
		{
			TreeMap<Integer, QueryAttrEnum> rowAttrMap = MultiQueryUtils.getAttrTreeMap(rowAttrResults);
			TreeMap<Integer, QueryAttrEnum> colAttrMap = MultiQueryUtils.getAttrTreeMap(colAttrResults);

			if (rowAttrMap == null || rowAttrMap.size() <= 0)
			{
				message = "請至少選擇一項報表的「列」屬性";
				return INPUT;
			}
			if (colAttrMap == null || colAttrMap.size() <= 0)
			{
				message = "請至少選擇一項報表的「欄」屬性";
				return INPUT;
			}

			String fileName = "多維度查詢統計表";

			List<String> headerList = new ArrayList<String>();
			headerList.add(fileName);

			MultiQueryForm form = new MultiQueryForm();
			form.setXlsSheetName(fileName);
			form.setHeaderList(headerList);
			form.setColAttrMap(colAttrMap);
			form.setRowAttrMap(rowAttrMap);
			form.setTable(TableNameEnum.ForeignSpouseHist);
			form.setWhereFilter(attrFilter);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("sYear", startYearResults);
			paramMap.put("eYear", endYearResults);
			paramMap.put("sMonth", startMonthResults);
			paramMap.put("eMonth", endMonthResults);
			form.setParamMap(paramMap);

			String reportBase64Str = multiQueryWebService.dlReport(form);
			if (StringUtil.isEmpty(reportBase64Str))
			{
				message = "報表產生失敗";
				return INPUT;
			}
			else
			{
				reportFileName = MultiQueryUtils.getEncodeFileName(fileName + ".xls");
				logger.debug("dlReport, reportBase64Str.len=" + reportBase64Str.length());
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
			logger.error("dlReport error", e);
			message = "執行發生錯誤";
			return INPUT;
		}
	}

	@Action(value = "barChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String barChart_ajax() throws Exception
	{
		logger.debug("barChart_ajax, barAttrResults=" + barAttrResults + ", attrFilter=" + attrFilter);
		barChartData = new ChartData();

		if (StringUtil.isEmpty(barAttrResults) || barAttrResults.startsWith("-1"))
		{
			return null;
		}

		String[] barAttrArray = barAttrResults.split(",");
		TreeMap<Integer, QueryAttrEnum> barAttrMap = MultiQueryUtils.getAttrTreeMap(Arrays.asList(barAttrArray));

		try
		{
			MultiQueryForm form = new MultiQueryForm();
			form.setRowAttrMap(barAttrMap);
			form.setTable(TableNameEnum.ForeignSpouseHist);
			form.setWhereFilter(attrFilter);
			form.setNeedRowSum(false);
			form.setNeedColSum(false);
//			barChartData = multiQueryWebService.queryChartData(form);
			barChartData = testChartData();
		}
		catch (Exception e)
		{
			logger.error("barChart_ajax error", e);
		}
		logger.debug("barChart_ajax, barChartData=" + ReflectionToStringBuilder.toString(barChartData));
		return SUCCESS;
	}

	private ChartData testChartData()
	{
		ChartData chartData = new ChartData();

		int dataSize = 7;
		int dataMaxVal = 1000;

		//[['x', '一月', '二月', '三月', '四月', '五月', '六月'], ['資料1', 30, 200, 100, 400, 150, 250],['資料2', 50, 20, 10, 40, 15, 25],['資料3', 60, 100, 70, 120, 85, 150]]
		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> xAttr = new ArrayList<String>();
		xAttr.add("x");
		for (int i = 0; i < dataSize; i++)
		{
			xAttr.add(i + "月");
		}
		dataList.add(xAttr);

		java.util.Random r = new java.util.Random();
		List<String> attr1 = new ArrayList<String>();
		attr1.add("外籍");
		for (int i = 0; i < dataSize; i++)
		{
			attr1.add(String.valueOf(r.nextInt(dataMaxVal)));
		}
		dataList.add(attr1);

		List<String> attr2 = new ArrayList<String>();
		attr2.add("大陸");
		for (int i = 0; i < dataSize; i++)
		{
			attr2.add(String.valueOf(r.nextInt(dataMaxVal)));
		}
		dataList.add(attr2);

		List<String> attr3 = new ArrayList<String>();
		attr3.add("港澳");
		for (int i = 0; i < dataSize; i++)
		{
			attr3.add(String.valueOf(r.nextInt(dataMaxVal)));
		}
		dataList.add(attr3);
		chartData.setxName("月份");
		chartData.setyName("人");
		chartData.setDataList(dataList);
		return chartData;
	}

	@Action(value = "graphChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String graphChart_ajax() throws Exception
	{
		logger.debug("graphChart_ajax, graphAttrResults=" + graphAttrResults + ", attrFilter=" + attrFilter);
		graphChartData = new ChartData();

		if (StringUtil.isEmpty(graphAttrResults) || graphAttrResults.startsWith("-1"))
		{
			return null;
		}

		String[] graphAttrArray = graphAttrResults.split(",");
		TreeMap<Integer, QueryAttrEnum> graphAttrMap = MultiQueryUtils.getAttrTreeMap(Arrays.asList(graphAttrArray));

		try
		{
			MultiQueryForm form = new MultiQueryForm();
			form.setRowAttrMap(graphAttrMap);
			form.setTable(TableNameEnum.ForeignSpouseHist);
			form.setWhereFilter(attrFilter);
			form.setNeedRowSum(false);
			form.setNeedColSum(false);
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
		logger.debug("pieChart_ajax, pieAttrResults=" + pieAttrResults + ", attrFilter=" + attrFilter);
		pieChartData = new ChartData();

		if (StringUtil.isEmpty(pieAttrResults) || pieAttrResults.startsWith("-1"))
		{
			return null;
		}

		String[] pieAttrArray = pieAttrResults.split(",");
		TreeMap<Integer, QueryAttrEnum> pieAttrMap = MultiQueryUtils.getAttrTreeMap(Arrays.asList(pieAttrArray));

		try
		{
			MultiQueryForm form = new MultiQueryForm();
			form.setRowAttrMap(pieAttrMap);
			form.setTable(TableNameEnum.ForeignSpouseHist);
			form.setWhereFilter(attrFilter);
			form.setNeedRowSum(false);
			form.setNeedColSum(false);
			form.setChartType(ChartTypeEnum.Pie);
			pieChartData = multiQueryWebService.queryChartData(form);
		}
		catch (Exception e)
		{
			logger.error("pieChart_ajax error", e);
		}
		logger.debug("pieChart_ajax, pieChartData=" + ReflectionToStringBuilder.toString(pieChartData));
		return SUCCESS;
	}

	@Action(value = "cityChart_ajax", results = { @Result(name = SUCCESS, type = "json") })
	public String cityChart_ajax() throws Exception
	{
		logger.debug("cityChart_ajax, attrFilter=" + attrFilter);
		cityChartData = new CityChartData();

		try
		{
			TreeMap<Integer, QueryAttrEnum> cityAttrMap = new TreeMap<Integer, QueryAttrEnum>();
			cityAttrMap.put(0, QueryAttrEnum.CityA);

			MultiQueryForm form = new MultiQueryForm();
			form.setRowAttrMap(cityAttrMap);
			form.setTable(TableNameEnum.ForeignSpouseHist);
			form.setWhereFilter(attrFilter);
			cityChartData = getTestCityChartData();

//			Map<String, Integer> dataMap = new HashMap<String, Integer>();
//			List<DataSettingBean> cityAList = multiQueryWebService.queryDataSetting(QueryAttrEnum.CityA.getCodeId());
//			{
//				Random r = new Random();
//				for (DataSettingBean ds : cityAList)
//				{
//					dataMap.put(ds.getCodeDataValueDesc(), (r.nextInt(10000)));
//				}
//			};
//			cityChartData.setDataMap(dataMap);
		}
		catch (Exception e)
		{
			logger.error("cityChart_ajax error", e);
		}
		logger.debug("cityChart_ajax, cityChartData=" + ReflectionToStringBuilder.toString(cityChartData));
		return SUCCESS;
	}

	private CityChartData getTestCityChartData()
	{
		logger.debug("getTestCityChartData");

		CityChartData cityChartData = new CityChartData();
		// key:縣市名(台北市), value:統計數(Count)
		java.util.Random r = new java.util.Random();
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		// 人數資訊顯示框
		List<CityTipsData> cityTipsList = new ArrayList<CityTipsData>();
		for (CityLocationEnum cityLoc : CityLocationEnum.values())
		{
			String codeValue = cityLoc.getCodeId();
			String codeDesc = cityLoc.getDesc();
			int cnt = r.nextInt(10000);
			dataMap.put(codeDesc, cnt);

			CityLocationEnum location = CityLocationEnum.getByCode(codeValue);
			CityTipsData tipsData = new CityTipsData();
			tipsData.setCodeDataValue(codeValue);
			tipsData.setCodeDataValueDesc(codeDesc);
			tipsData.setLon(location.getLon());
			tipsData.setLat(location.getLat());
			tipsData.setX2(location.getX2());
			tipsData.setY2(location.getY2());
			tipsData.setCnt(cnt);
			cityTipsList.add(tipsData);
		}
		cityChartData.setMaxCnt(10000);
		cityChartData.setDataMap(dataMap);
		cityChartData.setCityTipsList(cityTipsList);
		return cityChartData;
	}

	@Action(value = "multiChart", results = { @Result(name = SUCCESS, location = "multiChart", type = "tiles") })
	public String multiChart() throws Exception
	{
		logger.debug("multiChart");
		message = "";
		return SUCCESS;
	}

	public List<DataSettingBean> getDsCodeList()
	{
		return dsCodeList;
	}

	public void setDsCodeList(List<DataSettingBean> dsCodeList)
	{
		this.dsCodeList = dsCodeList;
	}

	public String getCodeId()
	{
		return codeId;
	}

	public void setCodeId(String codeId)
	{
		this.codeId = codeId;
	}

	public String getCityCodeValue()
	{
		return cityCodeValue;
	}

	public void setCityCodeValue(String cityCodeValue)
	{
		this.cityCodeValue = cityCodeValue;
	}

	public List<DataSettingBean> getCodeList()
	{
		return codeList;
	}

	public void setCodeList(List<DataSettingBean> codeList)
	{
		this.codeList = codeList;
	}

	public List<SuggestListBoxBean> getCodeSgList()
	{
		return codeSgList;
	}

	public void setCodeSgList(List<SuggestListBoxBean> codeSgList)
	{
		this.codeSgList = codeSgList;
	}

	public String getFsTypeResult()
	{
		return fsTypeResult;
	}

	public void setFsTypeResult(String fsTypeResult)
	{
		this.fsTypeResult = fsTypeResult;
	}

	public String getNationResult()
	{
		return nationResult;
	}

	public void setNationResult(String nationResult)
	{
		this.nationResult = nationResult;
	}

	public String getMarryResult()
	{
		return marryResult;
	}

	public void setMarryResult(String marryResult)
	{
		this.marryResult = marryResult;
	}

	public String getGenderResult()
	{
		return genderResult;
	}

	public void setGenderResult(String genderResult)
	{
		this.genderResult = genderResult;
	}

	public String getEduResult()
	{
		return eduResult;
	}

	public void setEduResult(String eduResult)
	{
		this.eduResult = eduResult;
	}

	public String getOccupationResult()
	{
		return occupationResult;
	}

	public void setOccupationResult(String occupationResult)
	{
		this.occupationResult = occupationResult;
	}

	public String getAgeResult()
	{
		return ageResult;
	}

	public void setAgeResult(String ageResult)
	{
		this.ageResult = ageResult;
	}

	public String getPermitNoCodeResult()
	{
		return permitNoCodeResult;
	}

	public void setPermitNoCodeResult(String permitNoCodeResult)
	{
		this.permitNoCodeResult = permitNoCodeResult;
	}

	public String getReasonResult()
	{
		return reasonResult;
	}

	public void setReasonResult(String reasonResult)
	{
		this.reasonResult = reasonResult;
	}

	public String getLossMarkResult()
	{
		return lossMarkResult;
	}

	public void setLossMarkResult(String lossMarkResult)
	{
		this.lossMarkResult = lossMarkResult;
	}

	public String getChildNumResult()
	{
		return childNumResult;
	}

	public void setChildNumResult(String childNumResult)
	{
		this.childNumResult = childNumResult;
	}

	public String getReferenceMarkResult()
	{
		return referenceMarkResult;
	}

	public void setReferenceMarkResult(String referenceMarkResult)
	{
		this.referenceMarkResult = referenceMarkResult;
	}

	public String getEntryDateResult()
	{
		return entryDateResult;
	}

	public void setEntryDateResult(String entryDateResult)
	{
		this.entryDateResult = entryDateResult;
	}

	public String getDeadMarkResult()
	{
		return deadMarkResult;
	}

	public void setDeadMarkResult(String deadMarkResult)
	{
		this.deadMarkResult = deadMarkResult;
	}

	public String getRapeMarkResult()
	{
		return rapeMarkResult;
	}

	public void setRapeMarkResult(String rapeMarkResult)
	{
		this.rapeMarkResult = rapeMarkResult;
	}

	public String getDomViolenceMarkResult()
	{
		return domViolenceMarkResult;
	}

	public void setDomViolenceMarkResult(String domViolenceMarkResult)
	{
		this.domViolenceMarkResult = domViolenceMarkResult;
	}

	public String getDriverLicenseMarkResult()
	{
		return driverLicenseMarkResult;
	}

	public void setDriverLicenseMarkResult(String driverLicenseMarkResult)
	{
		this.driverLicenseMarkResult = driverLicenseMarkResult;
	}

	public String getInsureMarkResult()
	{
		return insureMarkResult;
	}

	public void setInsureMarkResult(String insureMarkResult)
	{
		this.insureMarkResult = insureMarkResult;
	}

	public String getHealthCareMark()
	{
		return healthCareMark;
	}

	public void setHealthCareMark(String healthCareMark)
	{
		this.healthCareMark = healthCareMark;
	}

	public String getAgeDiffResult()
	{
		return ageDiffResult;
	}

	public void setAgeDiffResult(String ageDiffResult)
	{
		this.ageDiffResult = ageDiffResult;
	}

	public String getTwSpouseGenderResult()
	{
		return twSpouseGenderResult;
	}

	public void setTwSpouseGenderResult(String twSpouseGenderResult)
	{
		this.twSpouseGenderResult = twSpouseGenderResult;
	}

	public String getTwSpouseAgeResult()
	{
		return twSpouseAgeResult;
	}

	public void setTwSpouseAgeResult(String twSpouseAgeResult)
	{
		this.twSpouseAgeResult = twSpouseAgeResult;
	}

	public String getTwSpouseEducationResult()
	{
		return twSpouseEducationResult;
	}

	public void setTwSpouseEducationResult(String twSpouseEducationResult)
	{
		this.twSpouseEducationResult = twSpouseEducationResult;
	}

	public String getTwSpouseNativeMarkResult()
	{
		return twSpouseNativeMarkResult;
	}

	public void setTwSpouseNativeMarkResult(String twSpouseNativeMarkResult)
	{
		this.twSpouseNativeMarkResult = twSpouseNativeMarkResult;
	}

	public String getTwSpouseTypeResult()
	{
		return twSpouseTypeResult;
	}

	public void setTwSpouseTypeResult(String twSpouseTypeResult)
	{
		this.twSpouseTypeResult = twSpouseTypeResult;
	}

	public String getTwSpouseVeteranMarkResult()
	{
		return twSpouseVeteranMarkResult;
	}

	public void setTwSpouseVeteranMarkResult(String twSpouseVeteranMarkResult)
	{
		this.twSpouseVeteranMarkResult = twSpouseVeteranMarkResult;
	}

	public String getTwSpouseDisabledMarkResult()
	{
		return twSpouseDisabledMarkResult;
	}

	public void setTwSpouseDisabledMarkResult(String twSpouseDisabledMarkResult)
	{
		this.twSpouseDisabledMarkResult = twSpouseDisabledMarkResult;
	}

	public String getTwSpouseMidLowIncomeMarkResult()
	{
		return twSpouseMidLowIncomeMarkResult;
	}

	public void setTwSpouseMidLowIncomeMarkResult(String twSpouseMidLowIncomeMarkResult)
	{
		this.twSpouseMidLowIncomeMarkResult = twSpouseMidLowIncomeMarkResult;
	}

	public String getTwSpouseLowIncomeMarkResult()
	{
		return twSpouseLowIncomeMarkResult;
	}

	public void setTwSpouseLowIncomeMarkResult(String twSpouseLowIncomeMarkResult)
	{
		this.twSpouseLowIncomeMarkResult = twSpouseLowIncomeMarkResult;
	}

	public String getTwSpouseOldAllowanceMarkResult()
	{
		return twSpouseOldAllowanceMarkResult;
	}

	public void setTwSpouseOldAllowanceMarkResult(String twSpouseOldAllowanceMarkResult)
	{
		this.twSpouseOldAllowanceMarkResult = twSpouseOldAllowanceMarkResult;
	}

	public String getCityAResult()
	{
		return cityAResult;
	}

	public void setCityAResult(String cityAResult)
	{
		this.cityAResult = cityAResult;
	}

	public String getTownshipAResult()
	{
		return townshipAResult;
	}

	public void setTownshipAResult(String townshipAResult)
	{
		this.townshipAResult = townshipAResult;
	}

	public String getTwSpouseCityAResult()
	{
		return twSpouseCityAResult;
	}

	public void setTwSpouseCityAResult(String twSpouseCityAResult)
	{
		this.twSpouseCityAResult = twSpouseCityAResult;
	}

	public String getTwSpouseTownshipAResult()
	{
		return twSpouseTownshipAResult;
	}

	public void setTwSpouseTownshipAResult(String twSpouseTownshipAResult)
	{
		this.twSpouseTownshipAResult = twSpouseTownshipAResult;
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

	public String getAttrFilter()
	{
		return attrFilter;
	}

	public void setAttrFilter(String attrFilter)
	{
		this.attrFilter = attrFilter;
	}

	public List<String> getColAttrResults()
	{
		return colAttrResults;
	}

	public void setColAttrResults(List<String> colAttrResults)
	{
		this.colAttrResults = colAttrResults;
	}

	public List<String> getRowAttrResults()
	{
		return rowAttrResults;
	}

	public void setRowAttrResults(List<String> rowAttrResults)
	{
		this.rowAttrResults = rowAttrResults;
	}

	public String getBarAttrResults()
	{
		return barAttrResults;
	}

	public void setBarAttrResults(String barAttrResults)
	{
		this.barAttrResults = barAttrResults;
	}

	public String getGraphAttrResults()
	{
		return graphAttrResults;
	}

	public void setGraphAttrResults(String graphAttrResults)
	{
		this.graphAttrResults = graphAttrResults;
	}

	public String getPieAttrResults()
	{
		return pieAttrResults;
	}

	public void setPieAttrResults(String pieAttrResults)
	{
		this.pieAttrResults = pieAttrResults;
	}

	public String getCityAttrResults()
	{
		return cityAttrResults;
	}

	public void setCityAttrResults(String cityAttrResults)
	{
		this.cityAttrResults = cityAttrResults;
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

	public CityChartData getCityChartData()
	{
		return cityChartData;
	}

	public void setCityChartData(CityChartData cityChartData)
	{
		this.cityChartData = cityChartData;
	}

}
