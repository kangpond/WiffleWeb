package gov.nia.nrs.multiquery.enums;

/**
 * 外配資料彙總檔,凍結檔Table
 * @author Tim
 */
public enum TableNameEnum
{
	/** 外籍配偶資料凍結檔 */
	ForeignSpouseHist("ForeignSpouseHist", "", "外籍配偶資料凍結檔"),
	/** 配偶國籍縣市彙總表 */
	ForeignSpouseNaCityAccu("ForeignSpouseNaCityAccu", "SpCount", "配偶國籍縣市彙總表"),
	/** 外配各縣市彙總表 */
	ForeignSpouseCityAccu("ForeignSpouseCityAccu", "ForeignSpCount", "外配各縣市彙總表"),
	/** 台配各縣市彙總表 */
	TwSpouseCityAccu("TwSpouseCityAccu", "TwSpCount", "台配各縣市彙總表"),
	/** 配偶職業及教育程度縣市彙總表 */
	SpouseOccEduAccu("SpouseOccEduAccu", "SpCount", "配偶職業及教育程度縣市彙總表"),
	/** 陸配出生地彙總表 */
	CnSpouseBirthPlaceAccu("CnSpouseBirthPlaceAccu", "SpCount", "陸配出生地彙總表"),
	/** 年齡差距彙總表 */
	SpouseAgeDiff("SpouseAgeDiff", "SpAgeDiffCount", "年齡差距彙總表"),
	/** 配偶年齡彙總表 */
	SpouseAgeAccu("SpouseAgeAccu", "ForeignSpCount", "配偶年齡彙總表"),
	/** 配偶年齡彙總表 */
	TWSpouseAgeAccu("TWSpouseAgeAccu", "TwSpCount", "臺籍配偶年齡分佈表"),
	/** 子女出國未歸-外配國籍分布彙總表 */
	NewResidenceChildAbroadNaAccu("NewResidenceChildAbroadNaAccu", "SpCount", "子女出國未歸-外配國籍分布彙總表"),

	/** 無定義 */
	NONE("", "", "無定義");

	private String tableName;
	private String countColumn;
	private String desc;

	TableNameEnum(String tableName, String countColumn, String desc)
	{
		this.tableName = tableName;
		this.countColumn = countColumn;
		this.desc = desc;
	}

	public String getTableName()
	{
		return tableName;
	}

	public String getCountColumn()
	{
		return countColumn;
	}

	public String getDesc()
	{
		return desc;
	}

	public static TableNameEnum getByTableName(String tableName)
	{
		for (TableNameEnum instance : TableNameEnum.values())
		{
			if (instance.getTableName().equals(tableName))
			{
				return instance;
			}
		}
		return TableNameEnum.NONE;
	}
}
