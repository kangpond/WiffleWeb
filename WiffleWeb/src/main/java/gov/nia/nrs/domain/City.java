package gov.nia.nrs.domain;

import java.util.Date;

/**
 * City
 */
public class City implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String cityCode;
	private String cityName;
	private String createUserId;
	private String mainUserId;
	private Date lastUpdateTime;
	private Date createTime;
	private String deleteFlag;

	public City() {
	}

	public City(String cityCode) {
		this.cityCode = cityCode;
	}

	public City(String cityCode, String cityName, String createUserId,
			String mainUserId, Date lastUpdateTime, Date createTime,
			String deleteFlag) {
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.createUserId = createUserId;
		this.mainUserId = mainUserId;
		this.lastUpdateTime = lastUpdateTime;
		this.createTime = createTime;
		this.deleteFlag = deleteFlag;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
