package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserDef
 */
@Entity
@Table(name = "UserDef")
public class UserDef implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String applyDate;
	private String applyTime;
	private String certificateSn;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String deleteFlag;
	private String deptId;
	private String email;
	private Date lastUpdateTime;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;
	private String tel;
	private String telExt;
	private String userName;
	private String deptAddr;
	private String userTitle;
	private String reportCity;
	private String applyKind;
	private String state;
	private String fax;
	private String uuid;

	public UserDef() {
	}

	public UserDef(String userId, String deleteFlag, String deptId,
			Date lastUpdateTime, String mainUserId, String maintainFunctionId,
			String maintainHost, String applyKind, String state, String uuid) {
		this.userId = userId;
		this.deleteFlag = deleteFlag;
		this.deptId = deptId;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.applyKind = applyKind;
		this.state = state;
		this.uuid = uuid;
	}

	public UserDef(String userId, String applyDate, String applyTime,
			String certificateSn, String createDate, String createTime,
			String createUserId, String deleteFlag, String deptId,
			String email, Date lastUpdateTime, String mainUserId,
			String maintainFunctionId, String maintainHost, String tel,
			String telExt, String userName, String deptAddr, String userTitle,
			String reportCity, String applyKind, String state, String fax,
			String uuid) {
		this.userId = userId;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
		this.certificateSn = certificateSn;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.deleteFlag = deleteFlag;
		this.deptId = deptId;
		this.email = email;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.tel = tel;
		this.telExt = telExt;
		this.userName = userName;
		this.deptAddr = deptAddr;
		this.userTitle = userTitle;
		this.reportCity = reportCity;
		this.applyKind = applyKind;
		this.state = state;
		this.fax = fax;
		this.uuid = uuid;
	}

	@Id
	@Column(name = "UserId", unique = true, nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "ApplyDate", length = 8)
	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "ApplyTime", length = 6)
	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	@Column(name = "CertificateSN", length = 32)
	public String getCertificateSn() {
		return this.certificateSn;
	}

	public void setCertificateSn(String certificateSn) {
		this.certificateSn = certificateSn;
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

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "DeptId", nullable = false, length = 10)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "Email", length = 150)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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

	@Column(name = "Tel", length = 10)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "TelExt", length = 4)
	public String getTelExt() {
		return this.telExt;
	}

	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	@Column(name = "UserName", length = 15)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "DeptAddr")
	public String getDeptAddr() {
		return this.deptAddr;
	}

	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}

	@Column(name = "UserTitle")
	public String getUserTitle() {
		return this.userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	@Column(name = "ReportCity", length = 50)
	public String getReportCity() {
		return this.reportCity;
	}

	public void setReportCity(String reportCity) {
		this.reportCity = reportCity;
	}

	@Column(name = "ApplyKind", nullable = false, length = 1)
	public String getApplyKind() {
		return this.applyKind;
	}

	public void setApplyKind(String applyKind) {
		this.applyKind = applyKind;
	}

	@Column(name = "State", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "Fax", length = 10)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "Uuid", nullable = false, length = 32)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
