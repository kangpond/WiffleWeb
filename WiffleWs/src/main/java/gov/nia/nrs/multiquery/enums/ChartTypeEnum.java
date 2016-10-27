package gov.nia.nrs.multiquery.enums;

/**
 * 圖種類
 * @author Tim
 */
public enum ChartTypeEnum
{
	Bar("Bar", "長條圖"),
	Graph("Graph", "曲線圖"),
	Pie("Pie", "圓餅圖"),
	NONE("", "無定義");

	private String type;
	private String desc;

	ChartTypeEnum(String type, String desc)
	{
		this.type = type;
		this.desc = desc;
	}

	public String getType()
	{
		return type;
	}

	public String getDesc()
	{
		return desc;
	}

	public static ChartTypeEnum getByTableName(String type)
	{
		for (ChartTypeEnum instance : ChartTypeEnum.values())
		{
			if (instance.getType().equals(type))
			{
				return instance;
			}
		}
		return ChartTypeEnum.NONE;
	}
}
