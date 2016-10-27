package gov.nia.nrs.multiquery.bean;

public class CityTipsData
{
	private String codeDataValue;
	private String codeDataValueDesc;
	private double lon;
	private double lat;
	private double x2;
	private double y2;
	private int cnt;

	public String getCodeDataValue()
	{
		return codeDataValue;
	}

	public void setCodeDataValue(String codeDataValue)
	{
		this.codeDataValue = codeDataValue;
	}

	public String getCodeDataValueDesc()
	{
		return codeDataValueDesc;
	}

	public void setCodeDataValueDesc(String codeDataValueDesc)
	{
		this.codeDataValueDesc = codeDataValueDesc;
	}

	public double getLat()
	{
		return lat;
	}

	public void setLat(double lat)
	{
		this.lat = lat;
	}

	public double getLon()
	{
		return lon;
	}

	public void setLon(double lon)
	{
		this.lon = lon;
	}

	public int getCnt()
	{
		return cnt;
	}

	public void setCnt(int cnt)
	{
		this.cnt = cnt;
	}

	public double getX2()
	{
		return x2;
	}

	public void setX2(double x2)
	{
		this.x2 = x2;
	}

	public double getY2()
	{
		return y2;
	}

	public void setY2(double y2)
	{
		this.y2 = y2;
	}

	@Override
	public String toString()
	{
		return "CityTipsData [codeDataValue=" + codeDataValue + ", codeDataValueDesc=" + codeDataValueDesc + ", lon="
				+ lon + ", lat=" + lat + ", x2=" + x2 + ", y2=" + y2 + ", cnt=" + cnt + "]";
	}

}
