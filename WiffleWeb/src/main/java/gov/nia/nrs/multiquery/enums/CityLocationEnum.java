package gov.nia.nrs.multiquery.enums;

/**
 * 查詢欄位
 * @author Tim
 */
public enum CityLocationEnum
{
	Lienchiang("09007", "Lienchiang", "連江縣", 119.9397, 26.17737, 119.9397-1.5, 26.17737-0.2),
	Keelung("10017", "Keelung", "基隆市", 121.7081, 25.10898, 121.7081+0.7, 25.10898+0.2),
	NewTaipei("65000", "NewTaipei", "新北市", 121.6739, 24.91571, 121.6739+0.8, 24.91571),
	Taipei("63000", "Taipei", "臺北市", 121.5598, 25.09108, 121.5598+0.5, 25.09108+0.6),
	Yilan("10002", "Yilan", "宜蘭縣", 121.7095, 24.60295, 121.7095+0.7, 24.60295-0.1),
	Nantou("10008", "Nantou", "南投縣", 120.9876, 23.83876, 120.9876+1.1, 23.83876+0.2),
	Hualien("10015", "Hualien", "花蓮縣", 121.3542, 23.7569, 121.3542+1, 23.7569-0.2),
	Taitung("10014", "Taitung", "臺東縣", 121.0876, 22.98461, 121.0876+1.1, 22.98461),
	Pingtung("10013", "Pingtung", "屏東縣", 120.62, 22.54951, 120.62+1.5, 22.54951-0.2),
	Taoyuan("10003", "Taoyuan", "桃園市", 121.2168, 24.93759, 121.2168-0.8, 24.93759+0.8),
	HsinchuCity("10018", "HsinchuCity", "新竹市", 120.9647, 24.80395, 120.9647-1.4, 24.80395+0.6),
	Hsinchu("10004", "Hsinchu", "新竹縣", 121.1252, 24.70328, 121.1252-1.9, 24.70328+0.4),
	Miaoli("10005", "Miaoli", "苗栗縣", 120.9417, 24.48927, 120.9417-1.7, 24.48927+0.3),
	Taichung("66000", "Taichung", "臺中市", 120.8417, 24.28321, 120.8417 - 1.6, 24.28321+0.2),
	Changhua("10007", "Changhua", "彰化縣", 120.4818, 23.99297, 120.4818 - 1.8, 23.99297 + 0.2),
	Yunlin("10009", "Yunlin", "雲林縣", 120.3897, 23.75585, 120.3897 - 1.5, 23.75585 + 0.1),
	Chiayi("10010", "Chiayi", "嘉義縣", 120.574, 23.45889, 120.574-2.1, 23.45889-0.55),
	ChiayiCity("10020", "ChiayiCity", "嘉義市", 120.4473, 23.47545, 120.4473-2.5, 23.47545-0.2),
	Tainan("67000", "Tainan", "臺南市", 120.2513, 23.1417, 120.2513-1.6, 23.1417-0.6),
	Kaohsiung("64000", "Kaohsiung", "高雄市", 120.666, 23.01087, 120.666-1.7, 23.01087-0.8),
	Penghu("10016", "Penghu", "澎湖縣", 119.6151, 23.56548, 119.6151-2.2, 23.56548 + 0.2),
	Kinmen("09020", "Kinmen", "金門縣", 118.3186, 24.43679, 118.3186-0.9, 24.43679 + 0.3),

	NONE("", "", "無定義", 0, 0, 0, 0);

	private String codeId;
	private String eName;
	private String desc;
	private double lon;
	private double lat;
	private double x2;
	private double y2;

	CityLocationEnum(String codeId, String eName, String desc, double lon, double lat, double x2, double y2)
	{
		this.codeId = codeId;
		this.eName = eName;
		this.desc = desc;
		this.lon = lon;
		this.lat = lat;
		this.x2 = x2;
		this.y2 = y2;
	}

	public String getCodeId()
	{
		return codeId;
	}

	public String geteName()
	{
		return eName;
	}

	public String getDesc()
	{
		return desc;
	}

	public double getLon()
	{
		return lon;
	}

	public double getLat()
	{
		return lat;
	}

	public double getX2()
	{
		return x2;
	}

	public double getY2()
	{
		return y2;
	}

	public static CityLocationEnum getByCode(String codeId)
	{
		for (CityLocationEnum instance : CityLocationEnum.values())
		{
			if (instance.getCodeId().equals(codeId))
			{
				return instance;
			}
		}
		return CityLocationEnum.NONE;
	}
}
