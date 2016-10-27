package gov.nia.nrs.multiquery.bean;

import gov.nia.nrs.utils.StringUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * 多維度查詢欄位對應Value
 * (在DataSetting查不到的資料)
 * @author Tim
 */
public class QueryAttrStorage
{
	private static QueryAttrStorage instance = new QueryAttrStorage();

	/**
	 * <pre>
	 * key:codeId
	 * val:map
	 *     {
	 *       key:codeDataValue
	 *       val:codeDataValueDesc
	 *     }
	 * </pre>
	 */
	private Map<String, Map<String, String>> attrMap;

	private QueryAttrStorage()
	{
		initStorage();
	}

	public static QueryAttrStorage Instance()
	{
		return instance;
	}

	public Map<String, Map<String, String>> getAttrMap()
	{
		return attrMap;
	}

	private void initStorage()
	{
		attrMap = new TreeMap<String, Map<String, String>>();

//		Year("Year", "Z000", "年"),
		Map<String, String> yearMap = new TreeMap<String, String>();
		for (int i = 2016; i <= 2035; i++)
		{
			yearMap.put(String.valueOf(i), String.valueOf(i));
		}
		attrMap.put("Z000", yearMap);

//		Month("Month", "Z001", "月"),
		Map<String, String> monthMap = new TreeMap<String, String>();
		for (int i = 1; i <= 12; i++)
		{
			String month = StringUtil.padLeft(String.valueOf(i), 2, '0');
			monthMap.put(month, month);
		}
		attrMap.put("Z001", monthMap);

//		FsType("FsType", "Z002", "配偶類別"),
		Map<String, String> fsTypeMap = new TreeMap<String, String>();
		fsTypeMap.put("0", "外籍");
		fsTypeMap.put("1", "大陸");
		fsTypeMap.put("2", "港澳");
		attrMap.put("Z002", fsTypeMap);

//		Age("Age", "Z003", "年齡分佈"),
		Map<String, String> ageMap = new TreeMap<String, String>();
		ageMap.put("0:20", "20歲以下");
		ageMap.put("21:25", "21~25歲");
		ageMap.put("26:30", "26~30歲");
		ageMap.put("31:35", "31~35歲");
		ageMap.put("36:40", "36~40歲");
		ageMap.put("41:45", "41~45歲");
		ageMap.put("46:50", "46~50歲");
		ageMap.put("51:55", "51~55歲");
		ageMap.put("56:60", "56~60歲");
		ageMap.put("61:65", "61~65歲");
		ageMap.put("66:130", "66歲以上");
		attrMap.put("Z003", ageMap);

//		ChildNum("ChildNum", "Z004", "子女數"),
		Map<String, String> childNumMap = new TreeMap<String, String>();
		childNumMap.put("1", "1");
		childNumMap.put("2", "2");
		childNumMap.put("3", "3");
		childNumMap.put("4:30", "4(含以上)");
		attrMap.put("Z004", childNumMap);

		Map<String, String> yesNoMap = new TreeMap<String, String>();
		yesNoMap.put("0", "否");
		yesNoMap.put("1", "是");

//		ReferenceMark("ReferenceMark", "Z005", "是否有行方不明註記")
		Map<String, String> referenceMarkMap = yesNoMap;
		attrMap.put("Z005", referenceMarkMap);

//		EntryDate("EntryDate", "Z006", "是否在台"),//TODO EntryDate>ExitDate
		Map<String, String> entryDateMarkMap = yesNoMap;
		attrMap.put("Z006", entryDateMarkMap);

//		RapeMark("RapeMark", "Z007", "是否遭遇家暴"),
		Map<String, String> rapeMarkMarkMap = yesNoMap;
		attrMap.put("Z007", rapeMarkMarkMap);

//		DomViolenceMark("DomViolenceMark", "Z020", "是否遭遇性侵"),
		Map<String, String> domViolenceMarkMap = yesNoMap;
		attrMap.put("Z020", domViolenceMarkMap);

//		DriverLicenseMark("DriverLicenseMark", "Z008", "是否取得駕照"),
		Map<String, String> driverLicenseMarkMap = yesNoMap;
		attrMap.put("Z008", driverLicenseMarkMap);

//		InsureMark("InsureMark", "Z009", "是否投保勞保"),
		Map<String, String> insureMarkMap = yesNoMap;
		attrMap.put("Z009", insureMarkMap);

//		HealthCareMark("HealthCareMark", "Z010", "是否投保健保"),
		Map<String, String> healthCareMap = yesNoMap;
		attrMap.put("Z010", healthCareMap);

//		AgeDiff("AgeDiff", "Z011", "與台配年齡差距狀況"),
		Map<String, String> ageDiffMap = new TreeMap<String, String>();
		ageDiffMap.put("0:5", "5歲以下");
		ageDiffMap.put("6:10", "6~10歲");
		ageDiffMap.put("11:15", "11~15歲");
		ageDiffMap.put("16:20", "16~20歲");
		ageDiffMap.put("21:25", "21~25歲");
		ageDiffMap.put("26:30", "26~30歲");
		ageDiffMap.put("31:35", "31~35歲");
		ageDiffMap.put("36:40", "36~40歲");
		ageDiffMap.put("41:45", "41~45歲");
		ageDiffMap.put("46:130", "46歲以上");
		attrMap.put("Z011", ageDiffMap);

//		TwSpouseAge("TwSpouseAge", "Z012", "年齡分佈"),
		Map<String, String> twSpouseAgeMap = ageMap;
		attrMap.put("Z012", twSpouseAgeMap);

//		TwSpouseNativeMark("TwSpouseNativeMark", "Z013", "符合原住民"),
		Map<String, String> twSpouseNativeMarkMap = yesNoMap;
		attrMap.put("Z013", twSpouseNativeMarkMap);

//		TwSpouseAgeMark("TwSpouseAgeMark", "Z014", "符合台女陸男"),
		Map<String, String> twSpouseAgeMarkMap = yesNoMap;
		attrMap.put("Z014", twSpouseAgeMarkMap);

//		TwSpouseVeteranMarkMark("TwSpouseVeteranMark", "Z015", "符合榮民"),
		Map<String, String> twSpouseVeteranMarkMap = yesNoMap;
		attrMap.put("Z015", twSpouseVeteranMarkMap);

//		TwSpouseDisabledMark("TwSpouseDisabledMark", "Z016", "符合身心障礙"),
		Map<String, String> twSpouseDisabledMarkMap = yesNoMap;
		attrMap.put("Z016", twSpouseDisabledMarkMap);

//		TwSpouseMidLowIncomeMark("TwSpouseMidLowIncomeMark", "Z017", "符合中低收入"),
		Map<String, String> twSpouseMidLowIncomeMarkMap = yesNoMap;
		attrMap.put("Z017", twSpouseMidLowIncomeMarkMap);

//		TwSpouseLowIncomeMark("TwSpouseLowIncomeMark", "Z018", "符合低收入"),
		Map<String, String> twSpouseLowIncomeMarkMap = yesNoMap;
		attrMap.put("Z018", twSpouseLowIncomeMarkMap);

//		TwSpouseOldAllowanceMark("TwSpouseOldAllowanceMark", "Z019", "符合中低收入老人津貼"),
		Map<String, String> twSpouseOldAllowanceMarkMap = yesNoMap;
		attrMap.put("Z019", twSpouseOldAllowanceMarkMap);

//		Age2017("ForeignSpAgeInterval", "Z021", "2017年後的年齡分佈"),
		Map<String, String> age2017Map = new TreeMap<String, String>();
		age2017Map.put("0:20", "20歲以下");
		age2017Map.put("21:25", "21~25歲");
		age2017Map.put("26:30", "26~30歲");
		age2017Map.put("31:35", "31~35歲");
		age2017Map.put("36:40", "36~40歲");
		age2017Map.put("41:45", "41~45歲");
		age2017Map.put("46:50", "46~50歲");
		age2017Map.put("51:55", "51~55歲");
		age2017Map.put("56:60", "56~60歲");
		age2017Map.put("61:130", "61歲以上");
		attrMap.put("Z021", age2017Map);

//		AbroadYear("AbroadYear", "Z022", "出國未歸年份"),
		Map<String, String> abroadYearMap = new TreeMap<String, String>();
		abroadYearMap.put("1", "出國未滿一年未歸");
		abroadYearMap.put("2", "出國兩年未歸");
		abroadYearMap.put("3", "出國三年未歸");
		abroadYearMap.put("4", "出國四年未歸");
		abroadYearMap.put("5:100", "出國四年以上未歸");
		attrMap.put("Z022", abroadYearMap);

//		TwSpPosition("TwSpPosition", "Z023", "台配身分"),
		Map<String, String> twSpPositionMap = new TreeMap<String, String>();
		twSpPositionMap.put("1", "原住民");
		twSpPositionMap.put("2", "台女陸男");
		twSpPositionMap.put("3", "榮民");
		attrMap.put("Z023", twSpPositionMap);

//		TwSpPositionHist("TwSpPosition", "XZ024", "台配身分"),
		Map<String, String> twSpPositionHistMap = new TreeMap<String, String>();
		twSpPositionHistMap.put("100;101;110;111", "原住民");
		twSpPositionHistMap.put("010;011;110;111", "台女陸男");
		twSpPositionHistMap.put("001;011;101;111", "榮民");
		attrMap.put("Z024", twSpPositionHistMap);
	}
}
