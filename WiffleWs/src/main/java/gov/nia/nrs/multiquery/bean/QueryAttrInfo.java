package gov.nia.nrs.multiquery.bean;

import gov.nia.nrs.domain.iis.DataSetting;

import java.util.Map;

/**
 * 多維度Excel查詢屬性的資訊
 * @author Tim
 */
public class QueryAttrInfo
{
	/** 屬性對應DataSetting的CodeId */
	private String codeId;
	private Map<Integer, DataSetting> dsMap;
	/** 屬性的個數，例性別屬性的個數為2，若為最內層的屬性多了合計則會多加1 */
	private int attrCnt;
	/** 屬性的Excel間隔，越外層的Excel屬性，間隔越寬，受到內層屬性個數影響 */
	private int attrSpan;
	/** 屬性對應的Table的ColumnName */
	private String attrColumnName;
	/** 屬性對應的Table的中文描述 */
	private String attrColumnDesc;

	public String getCodeId()
	{
		return codeId;
	}

	public void setCodeId(String codeId)
	{
		this.codeId = codeId;
	}

	public Map<Integer, DataSetting> getDsMap()
	{
		return dsMap;
	}

	public void setDsMap(Map<Integer, DataSetting> dsMap)
	{
		this.dsMap = dsMap;
	}

	public int getAttrCnt()
	{
		return attrCnt;
	}

	public void setAttrCnt(int attrCnt)
	{
		this.attrCnt = attrCnt;
	}

	public int getAttrSpan()
	{
		return attrSpan;
	}

	public void setAttrSpan(int attrSpan)
	{
		this.attrSpan = attrSpan;
	}

	public String getAttrColumnName()
	{
		return attrColumnName;
	}

	public void setAttrColumnName(String attrColumnName)
	{
		this.attrColumnName = attrColumnName;
	}

	public String getAttrColumnDesc()
	{
		return attrColumnDesc;
	}

	public void setAttrColumnDesc(String attrColumnDesc)
	{
		this.attrColumnDesc = attrColumnDesc;
	}

	@Override
	public String toString()
	{
		return "QueryAttrInfo [codeId=" + codeId + ", dsMap=" + dsMap + ", attrCnt=" + attrCnt + ", attrSpan="
				+ attrSpan + ", attrColumnName=" + attrColumnName + ", attrColumnDesc=" + attrColumnDesc + "]";
	}

}
