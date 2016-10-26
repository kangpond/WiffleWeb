package gov.nia.nrs.multiquery.enums;

/**
 * 查詢欄位
 * Z開頭的CodeId為DataSetting沒有的，程式定義的代碼
 * Y開頭的CodeId為DataSetting沒有的，程式定義的代碼，複合欄位，不出現在畫面選單的欄位
 * X開頭的CodeId為程式定義的代碼，不出現在畫面選單的欄位
 * @author Tim
 */
public enum QueryAttrEnum
{
	Year("Year", "Z000", "年"),
	Month("Month", "Z001", "月"),

	// 外配背景資料
	FsType("FsType", "Z002", "配偶類別"),
	Nation("Nation", "15", "國籍"),
	Marry("Marry", "10", "婚姻狀態"),
	Gender("Gender", "70", "性別"),
	Education("Education", "14", "教育程度"),
	Occupation("Occupation", "4", "職業別"),
	Age("Age", "Z003", "年齡分佈"),
	PermitNoCode("PermitNoCode", "18", "證別"),
	Reason("Reason", "1", "事由"),
	LossMark("LossMark", "54", "證件狀態"),
	ChildNum("ChildNum", "Z004", "子女數"),
	ReferenceMark("ReferenceMark", "Z005", "是否有行方不明註記"),
	EntryDate("EntryDate", "Z006", "是否在台"),//TODO EntryDate>ExitDate
	DeadMark("DeadMark", "74", "是否死亡"),

	// 外配生活狀態
	RapeMark("RapeMark", "Z007", "是否遭遇家暴"),
	DomViolenceMark("DomViolenceMark", "Z020", "是否遭遇性侵"),
	DriverLicenseMark("DriverLicenseMark", "Z008", "是否取得駕照"),
	InsureMark("InsureMark", "Z009", "是否投保勞保"),
	HealthCareMark("HealthCareMark", "Z010", "是否投保健保"),
	AgeDiff("AgeDiff", "Z011", "與台配年齡差距狀況"),

	// 台配背景
	TwSpouseGender("TwSpouseGender", "70", "性別"),
	TwSpouseAge("TwSpouseAge", "Z012", "年齡分佈"),
	TwSpouseEducation("TwSpouseEducation", "14", "教育程度"),

	// 台配生活狀態
	TwSpouseNativeMark("TwSpouseNativeMark", "Z013", "符合原住民"),
	TwSpouseType("TwSpouseType", "Z014", "符合台女陸男"),
	TwSpouseVeteranMark("TwSpouseVeteranMark", "Z015", "符合榮民"),
	TwSpouseDisabledMark("TwSpouseDisabledMark", "Z016", "符合身心障礙"),
	TwSpouseMidLowIncomeMark("TwSpouseMidLowIncomeMark", "Z017", "符合中低收入"),
	TwSpouseLowIncomeMark("TwSpouseLowIncomeMark", "Z018", "符合低收入"),
	TwSpouseOldAllowanceMark("TwSpouseOldAllowanceMark", "Z019", "符合中低收入老人津貼"),

	// 地區分佈
	CityA("CityA", "612", "外配縣市"),
	TownshipA("TownshipA", "613-634", "外配鄉鎮市區"),
	TwSpouseCityA("TwSpouseCityA", "612", "台配縣市"), //TODO 無欄位
	TwSpouseTownshipA("TwSpouseTownshipA", "613-634", "台配鄉鎮市區"), //TODO 無欄位

	/** 組合縣市與鄉鎮 */
	CityTown("CityA,TownshipA", "Y001", "縣市鄉鎮"),
	/** 組合年月 */
	YearMonth("Year,Month", "Y002", "年月"),
	/** 組合縣市與鄉鎮 */
	TwSpCityTown("TwSpCity,TwSpTownship", "Y003", "台配縣市鄉鎮"),

	City("City", "X612", "縣市"),
	TwSpCity("TwSpCity", "X612", "台配縣市"),
	TwSpTownship("TwSpTownship", "X613-634", "台配鄉鎮"),
	SpouseOccEduAccu_Occupation("DataCode", "X4", "職業別"),
	SpouseOccEduAccu_Education("DataCode", "X14", "教育程度"),
	SpouseType("SpouseType", "XZ002", "配偶類別"),
	BirthPlace("BirthPlace", "X3", "大陸省份"),
	MarryStatus("MarryStatus", "X10", "婚姻狀態"),
	SpAgeDiffInterval("SpAgeDiffInterval", "XZ011", "配偶年齡差距狀況"),
	ForeignSpAge2017("ForeignSpAgeInterval", "XZ021", "2017年後的年齡分佈"),
	ForeignSpAge2016("ForeignSpAgeInterval", "XZ012", "2017年前的年齡分佈"),
	TwSpAge2017("TwSpAgeInterval", "XZ021", "2017年後的年齡分佈"),
	TwSpAge2016("TwSpAgeInterval", "XZ012", "2017年前的年齡分佈"),
	AbroadYear("AbroadYear", "XZ022", "出國未歸年份"),
	TwSpPosition("TwSpPosition", "XZ023", "台配身分"),
	TwSpPositionHist("TwSpPosition", "XZ024", "台配身分"),

	NONE("", "", "無定義");

	private String columnName;
	private String codeId;
	private String desc;

	QueryAttrEnum(String columnName, String codeId, String desc)
	{
		this.columnName = columnName;
		this.codeId = codeId;
		this.desc = desc;
	}

	public String getColumnName()
	{
		return columnName;
	}

	public String getCodeId()
	{
		return codeId;
	}

	public String getDesc()
	{
		return desc;
	}

	public static QueryAttrEnum getByCode(String codeId)
	{
		for (QueryAttrEnum instance : QueryAttrEnum.values())
		{
			if (instance.getCodeId().equals(codeId))
			{
				return instance;
			}
		}
		return QueryAttrEnum.NONE;
	}
}
