package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Government
 */
@Entity
@Table(name = "Government")
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

	@Id
	@Column(name = "DeptId", unique = true, nullable = false, length = 10)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "DeptName", nullable = false, length = 100)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DeptLevel", nullable = false, length = 1)
	public String getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	@Column(name = "ParentDeptId", nullable = false, length = 10)
	public String getParentDeptId() {
		return this.parentDeptId;
	}

	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	@Column(name = "RevokeMark", length = 1)
	public String getRevokeMark() {
		return this.revokeMark;
	}

	public void setRevokeMark(String revokeMark) {
		this.revokeMark = revokeMark;
	}

	@Column(name = "EffectiveDate", length = 8)
	public String getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name = "RevokeDate", length = 8)
	public String getRevokeDate() {
		return this.revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = revokeDate;
	}

	@Column(name = "MainUserId", nullable = false, length = 20)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainFunctionId", nullable = false, length = 100)
	public String getMaintainFunctionId() {
		return this.maintainFunctionId;
	}

	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	@Column(name = "MaintainHost", nullable = false, length = 2)
	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CreateDate", length = 8)
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CreateTime", length = 6)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CreateUserId", length = 20)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "Address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
