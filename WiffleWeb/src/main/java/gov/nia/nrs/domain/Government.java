package gov.nia.nrs.domain;

import java.util.Date;

/**
 * Government
 */
public class Government implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String deptId;
	private String deptName;
	private String deptLevel;
	private String parentDeptId;
	private String revokeMark;
	private String effectiveDate;
	private String revokeDate;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String deleteFlag;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String address;

	public Government() {
	}

	public Government(String deptId, String deptName, String deptLevel,
			String parentDeptId, String mainUserId, String maintainFunctionId,
			String maintainHost, Date lastUpdateTime, String deleteFlag) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLevel = deptLevel;
		this.parentDeptId = parentDeptId;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.deleteFlag = deleteFlag;
	}

	public Government(String deptId, String deptName, String deptLevel,
			String parentDeptId, String revokeMark, String effectiveDate,
			String revokeDate, String mainUserId, String maintainFunctionId,
			String maintainHost, Date lastUpdateTime, String deleteFlag,
			String createDate, String createTime, String createUserId,
			String address) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLevel = deptLevel;
		this.parentDeptId = parentDeptId;
		this.revokeMark = revokeMark;
		this.effectiveDate = effectiveDate;
		this.revokeDate = revokeDate;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.address = address;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getParentDeptId() {
		return this.parentDeptId;
	}

	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public String getRevokeMark() {
		return this.revokeMark;
	}

	public void setRevokeMark(String revokeMark) {
		this.revokeMark = revokeMark;
	}

	public String getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getRevokeDate() {
		return this.revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = revokeDate;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	public String getMaintainFunctionId() {
		return this.maintainFunctionId;
	}

	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
