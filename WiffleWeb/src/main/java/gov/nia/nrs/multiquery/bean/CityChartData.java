package gov.nia.nrs.multiquery.bean;

import java.util.List;
import java.util.Map;

public class CityChartData
{
	private Integer minCnt;
	private Integer maxCnt;
	private Map<String, Integer> dataMap;
	private List<CityTipsData> cityTipsList;

	public Integer getMinCnt()
	{
		return minCnt;
	}

	public void setMinCnt(Integer minCnt)
	{
		this.minCnt = minCnt;
	}

	public Integer getMaxCnt()
	{
		return maxCnt;
	}

	public void setMaxCnt(Integer maxCnt)
	{
		this.maxCnt = maxCnt;
	}

	public Map<String, Integer> getDataMap()
	{
		return dataMap;
	}

	public void setDataMap(Map<String, Integer> dataMap)
	{
		this.dataMap = dataMap;
	}

	public List<CityTipsData> getCityTipsList()
	{
		return cityTipsList;
	}

	public void setCityTipsList(List<CityTipsData> cityTipsList)
	{
		this.cityTipsList = cityTipsList;
	}

	@Override
	public String toString()
	{
		return "CityChartData [minCnt=" + minCnt + ", maxCnt=" + maxCnt + ", dataMap=" + dataMap + ", cityTipsList="
				+ cityTipsList + "]";
	}

}
