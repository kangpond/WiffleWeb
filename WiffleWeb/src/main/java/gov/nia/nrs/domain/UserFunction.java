package gov.nia.nrs.domain;

import java.util.Date;

/**
 * UserFunction
 */
public class UserFunction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private UserFunctionId id;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String deleteFlag;
	private Date lastUpdateTime;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;

	public UserFunction() {
	}

	public UserFunction(UserFunctionId id, String deleteFlag,
			Date lastUpdateTime, String mainUserId, String maintainFunctionId,
			String maintainHost) {
		this.id = id;
		this.deleteFlag = deleteFlag;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
	}

	public UserFunction(UserFunctionId id, String createDate,
			String createTime, String createUserId, String deleteFlag,
			Date lastUpdateTime, String mainUserId, String maintainFunctionId,
			String maintainHost) {
		this.id = id;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.deleteFlag = deleteFlag;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
	}

	/**
	 * @return the id
	 */
	public UserFunctionId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UserFunctionId id) {
		this.id = id;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the mainUserId
	 */
	public String getMainUserId() {
		return mainUserId;
	}

	/**
	 * @param mainUserId the mainUserId to set
	 */
	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	/**
	 * @return the maintainFunctionId
	 */
	public String getMaintainFunctionId() {
		return maintainFunctionId;
	}

	/**
	 * @param maintainFunctionId the maintainFunctionId to set
	 */
	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	/**
	 * @return the maintainHost
	 */
	public String getMaintainHost() {
		return maintainHost;
	}

	/**
	 * @param maintainHost the maintainHost to set
	 */
	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	

}
