package gov.nia.nrs.domain;

import java.util.Date;

/**
 * UserApply
 */
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

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the certificateSn
	 */
	public String getCertificateSn() {
		return certificateSn;
	}

	/**
	 * @param certificateSn the certificateSn to set
	 */
	public void setCertificateSn(String certificateSn) {
		this.certificateSn = certificateSn;
	}

	/**
	 * @return the applyDate
	 */
	public String getApplyDate() {
		return applyDate;
	}

	/**
	 * @param applyDate the applyDate to set
	 */
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * @return the applyTime
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * @param applyTime the applyTime to set
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
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
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the telExt
	 */
	public String getTelExt() {
		return telExt;
	}

	/**
	 * @param telExt the telExt to set
	 */
	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the deptAddr
	 */
	public String getDeptAddr() {
		return deptAddr;
	}

	/**
	 * @param deptAddr the deptAddr to set
	 */
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}

	/**
	 * @return the userTitle
	 */
	public String getUserTitle() {
		return userTitle;
	}

	/**
	 * @param userTitle the userTitle to set
	 */
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	/**
	 * @return the reportCity
	 */
	public String getReportCity() {
		return reportCity;
	}

	/**
	 * @param reportCity the reportCity to set
	 */
	public void setReportCity(String reportCity) {
		this.reportCity = reportCity;
	}

	/**
	 * @return the applyKind
	 */
	public String getApplyKind() {
		return applyKind;
	}

	/**
	 * @param applyKind the applyKind to set
	 */
	public void setApplyKind(String applyKind) {
		this.applyKind = applyKind;
	}

	/**
	 * @return the caseStaus
	 */
	public String getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @param caseStaus the caseStaus to set
	 */
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
