package gov.nia.nrs.multiquery.bean;

import java.util.List;

public class ChartData
{
	private String xName;
	private String yName;
	private List<List<String>> dataList;

	public String getxName()
	{
		return xName;
	}

	public void setxName(String xName)
	{
		this.xName = xName;
	}

	public String getyName()
	{
		return yName;
	}

	public void setyName(String yName)
	{
		this.yName = yName;
	}

	public List<List<String>> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<List<String>> dataList)
	{
		this.dataList = dataList;
	}

	@Override
	public String toString()
	{
		return "ChartData [xName=" + xName + ", yName=" + yName + ", dataList=" + dataList + "]";
	}

}
