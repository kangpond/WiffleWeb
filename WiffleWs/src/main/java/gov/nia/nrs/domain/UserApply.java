package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserApply
 */
@Entity
@Table(name = "UserApply")
public class UserApply implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String userId;
	private String userName;
	private String deptId;
	private String email;
	private String certificateSn;
	private String applyDate;
	private String applyTime;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String deleteFlag;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String tel;
	private String telExt;
	private String fax;
	private String deptAddr;
	private String userTitle;
	private String reportCity;
	private String applyKind;
	private String caseStatus;

	public UserApply() {
	}

	public UserApply(String uuid, String userId, String deptId, String email,
			String applyDate, String applyTime, String mainUserId,
			String maintainFunctionId, String maintainHost,
			Date lastUpdateTime, String deleteFlag, String applyKind,
			String caseStatus) {
		this.uuid = uuid;
		this.userId = userId;
		this.deptId = deptId;
		this.email = email;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.deleteFlag = deleteFlag;
		this.applyKind = applyKind;
		this.caseStatus = caseStatus;
	}

	public UserApply(String uuid, String userId, String userName,
			String deptId, String email, String certificateSn,
			String applyDate, String applyTime, String mainUserId,
			String maintainFunctionId, String maintainHost,
			Date lastUpdateTime, String deleteFlag, String createDate,
			String createTime, String createUserId, String tel, String telExt,
			String fax, String deptAddr, String userTitle, String reportCity,
			String applyKind, String caseStatus) {
		this.uuid = uuid;
		this.userId = userId;
		this.userName = userName;
		this.deptId = deptId;
		this.email = email;
		this.certificateSn = certificateSn;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.tel = tel;
		this.telExt = telExt;
		this.fax = fax;
		this.deptAddr = deptAddr;
		this.userTitle = userTitle;
		this.reportCity = reportCity;
		this.applyKind = applyKind;
		this.caseStatus = caseStatus;
	}

	@Id
	@Column(name = "Uuid", unique = true, nullable = false, length = 32)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "UserId", nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", length = 15)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "DeptId", nullable = false, length = 10)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "Email", nullable = false, length = 150)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CertificateSN", length = 32)
	public String getCertificateSn() {
		return this.certificateSn;
	}

	public void setCertificateSn(String certificateSn) {
		this.certificateSn = certificateSn;
	}

	@Column(name = "ApplyDate", nullable = false, length = 8)
	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "ApplyTime", nullable = false, length = 6)
	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
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

	@Column(name = "Tel", length = 10)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "TelExt", length = 6)
	public String getTelExt() {
		return this.telExt;
	}

	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	@Column(name = "Fax", length = 10)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	@Column(name = "CaseStatus", nullable = false, length = 1)
	public String getCaseStatus() {
		return this.caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserApply [uuid=" + uuid + ", userId=" + userId + ", userName="
				+ userName + ", deptId=" + deptId + ", email=" + email
				+ ", certificateSn=" + certificateSn + ", applyDate="
				+ applyDate + ", applyTime=" + applyTime + ", mainUserId="
				+ mainUserId + ", maintainFunctionId=" + maintainFunctionId
				+ ", maintainHost=" + maintainHost + ", lastUpdateTime="
				+ lastUpdateTime + ", deleteFlag=" + deleteFlag
				+ ", createDate=" + createDate + ", createTime=" + createTime
				+ ", createUserId=" + createUserId + ", tel=" + tel
				+ ", telExt=" + telExt + ", fax=" + fax + ", deptAddr="
				+ deptAddr + ", userTitle=" + userTitle + ", reportCity="
				+ reportCity + ", applyKind=" + applyKind + ", caseStatus="
				+ caseStatus + "]";
	}

	
}
