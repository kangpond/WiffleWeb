package gov.nia.nrs.domain;

import java.util.Date;

/**
 * UserDef
 */
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getCertificateSn() {
		return this.certificateSn;
	}

	public void setCertificateSn(String certificateSn) {
		this.certificateSn = certificateSn;
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

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTelExt() {
		return this.telExt;
	}

	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptAddr() {
		return this.deptAddr;
	}

	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}

	public String getUserTitle() {
		return this.userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getReportCity() {
		return this.reportCity;
	}

	public void setReportCity(String reportCity) {
		this.reportCity = reportCity;
	}

	public String getApplyKind() {
		return this.applyKind;
	}

	public void setApplyKind(String applyKind) {
		this.applyKind = applyKind;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDef [userId=" + userId + ", applyDate=" + applyDate
				+ ", applyTime=" + applyTime + ", certificateSn="
				+ certificateSn + ", createDate=" + createDate
				+ ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", deleteFlag=" + deleteFlag + ", deptId="
				+ deptId + ", email=" + email + ", lastUpdateTime="
				+ lastUpdateTime + ", mainUserId=" + mainUserId
				+ ", maintainFunctionId=" + maintainFunctionId
				+ ", maintainHost=" + maintainHost + ", tel=" + tel
				+ ", telExt=" + telExt + ", userName=" + userName
				+ ", deptAddr=" + deptAddr + ", userTitle=" + userTitle
				+ ", reportCity=" + reportCity + ", applyKind=" + applyKind
				+ ", state=" + state + ", fax=" + fax + ", uuid=" + uuid + "]";
	}

	
}
