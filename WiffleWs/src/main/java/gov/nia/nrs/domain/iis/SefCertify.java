package gov.nia.nrs.domain.iis;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SefCertify
 */
@Entity
@Table(name = "SefCertify")
public class SefCertify implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String documentNo;
	private String documentCheckNo;
	private String applyDate;
	private String profileCreateDate;
	private String chineseName;
	private String personId;
	private String birthDate;
	private String tel1;
	private String tel2;
	private String address;
	private String agentChineseName;
	private String agentPersonId;
	private String agentBirthDate;
	private String agentTel1;
	private String agentTel2;
	private String agentAddress;
	private String notarizePlace;
	private String notarizeId;
	private String notarizeDate;
	private String notarizeOrigId;
	private String notarizeClass;
	private String notarizePurpose;
	private String remarkForward;
	private String remarkGetWay;
	private String remarkGetName;
	private String remarkApplyCopy;
	private String remarkRightWay;
	private String remarkData;
	private String copyLetterNo;
	private String copyDeliverDate;
	private String copyParty;
	private String statusData;
	private String statusItem;
	private String statusProcessDate;
	private String hastenLetterNo;
	private String hastenDate;
	private String processReceiptNo;
	private String processHastenTimes;
	private String processIssueDate;
	private String processResult;
	private String maintainDeptId;
	private String createDeptId;
	private String deleteFlag;
	private String createUserId;
	private String createProgramId;
	private Date createTime;
	private String maintainHost;
	private String mainUserId;
	private String maintainProgramId;
	private Date lastUpdateTime;

	public SefCertify() {
	}

	public SefCertify(String documentNo, String deleteFlag,
			String createUserId, String createProgramId, Date createTime,
			String maintainHost, String mainUserId, String maintainProgramId,
			Date lastUpdateTime) {
		this.documentNo = documentNo;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createProgramId = createProgramId;
		this.createTime = createTime;
		this.maintainHost = maintainHost;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.lastUpdateTime = lastUpdateTime;
	}

	public SefCertify(String documentNo, String documentCheckNo,
			String applyDate, String profileCreateDate, String chineseName,
			String personId, String birthDate, String tel1, String tel2,
			String address, String agentChineseName, String agentPersonId,
			String agentBirthDate, String agentTel1, String agentTel2,
			String agentAddress, String notarizePlace, String notarizeId,
			String notarizeDate, String notarizeOrigId, String notarizeClass,
			String notarizePurpose, String remarkForward, String remarkGetWay,
			String remarkGetName, String remarkApplyCopy,
			String remarkRightWay, String remarkData, String copyLetterNo,
			String copyDeliverDate, String copyParty, String statusData,
			String statusItem, String statusProcessDate, String hastenLetterNo,
			String hastenDate, String processReceiptNo,
			String processHastenTimes, String processIssueDate,
			String processResult, String maintainDeptId, String createDeptId,
			String deleteFlag, String createUserId, String createProgramId,
			Date createTime, String maintainHost, String mainUserId,
			String maintainProgramId, Date lastUpdateTime) {
		this.documentNo = documentNo;
		this.documentCheckNo = documentCheckNo;
		this.applyDate = applyDate;
		this.profileCreateDate = profileCreateDate;
		this.chineseName = chineseName;
		this.personId = personId;
		this.birthDate = birthDate;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.address = address;
		this.agentChineseName = agentChineseName;
		this.agentPersonId = agentPersonId;
		this.agentBirthDate = agentBirthDate;
		this.agentTel1 = agentTel1;
		this.agentTel2 = agentTel2;
		this.agentAddress = agentAddress;
		this.notarizePlace = notarizePlace;
		this.notarizeId = notarizeId;
		this.notarizeDate = notarizeDate;
		this.notarizeOrigId = notarizeOrigId;
		this.notarizeClass = notarizeClass;
		this.notarizePurpose = notarizePurpose;
		this.remarkForward = remarkForward;
		this.remarkGetWay = remarkGetWay;
		this.remarkGetName = remarkGetName;
		this.remarkApplyCopy = remarkApplyCopy;
		this.remarkRightWay = remarkRightWay;
		this.remarkData = remarkData;
		this.copyLetterNo = copyLetterNo;
		this.copyDeliverDate = copyDeliverDate;
		this.copyParty = copyParty;
		this.statusData = statusData;
		this.statusItem = statusItem;
		this.statusProcessDate = statusProcessDate;
		this.hastenLetterNo = hastenLetterNo;
		this.hastenDate = hastenDate;
		this.processReceiptNo = processReceiptNo;
		this.processHastenTimes = processHastenTimes;
		this.processIssueDate = processIssueDate;
		this.processResult = processResult;
		this.maintainDeptId = maintainDeptId;
		this.createDeptId = createDeptId;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createProgramId = createProgramId;
		this.createTime = createTime;
		this.maintainHost = maintainHost;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.lastUpdateTime = lastUpdateTime;
	}

	@Id
	@Column(name = "DocumentNo", unique = true, nullable = false, length = 8)
	public String getDocumentNo() {
		return this.documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	@Column(name = "DocumentCheckNo", length = 11)
	public String getDocumentCheckNo() {
		return this.documentCheckNo;
	}

	public void setDocumentCheckNo(String documentCheckNo) {
		this.documentCheckNo = documentCheckNo;
	}

	@Column(name = "ApplyDate", length = 8)
	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "ProfileCreateDate", length = 8)
	public String getProfileCreateDate() {
		return this.profileCreateDate;
	}

	public void setProfileCreateDate(String profileCreateDate) {
		this.profileCreateDate = profileCreateDate;
	}

	@Column(name = "ChineseName")
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "PersonId", length = 10)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "BirthDate", length = 15)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "Tel1", length = 30)
	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@Column(name = "Tel2", length = 30)
	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "AgentChineseName")
	public String getAgentChineseName() {
		return this.agentChineseName;
	}

	public void setAgentChineseName(String agentChineseName) {
		this.agentChineseName = agentChineseName;
	}

	@Column(name = "AgentPersonId", length = 10)
	public String getAgentPersonId() {
		return this.agentPersonId;
	}

	public void setAgentPersonId(String agentPersonId) {
		this.agentPersonId = agentPersonId;
	}

	@Column(name = "AgentBirthDate", length = 8)
	public String getAgentBirthDate() {
		return this.agentBirthDate;
	}

	public void setAgentBirthDate(String agentBirthDate) {
		this.agentBirthDate = agentBirthDate;
	}

	@Column(name = "AgentTel1", length = 30)
	public String getAgentTel1() {
		return this.agentTel1;
	}

	public void setAgentTel1(String agentTel1) {
		this.agentTel1 = agentTel1;
	}

	@Column(name = "AgentTel2", length = 30)
	public String getAgentTel2() {
		return this.agentTel2;
	}

	public void setAgentTel2(String agentTel2) {
		this.agentTel2 = agentTel2;
	}

	@Column(name = "AgentAddress")
	public String getAgentAddress() {
		return this.agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	@Column(name = "NotarizePlace")
	public String getNotarizePlace() {
		return this.notarizePlace;
	}

	public void setNotarizePlace(String notarizePlace) {
		this.notarizePlace = notarizePlace;
	}

	@Column(name = "NotarizeId")
	public String getNotarizeId() {
		return this.notarizeId;
	}

	public void setNotarizeId(String notarizeId) {
		this.notarizeId = notarizeId;
	}

	@Column(name = "NotarizeDate", length = 8)
	public String getNotarizeDate() {
		return this.notarizeDate;
	}

	public void setNotarizeDate(String notarizeDate) {
		this.notarizeDate = notarizeDate;
	}

	@Column(name = "NotarizeOrigId")
	public String getNotarizeOrigId() {
		return this.notarizeOrigId;
	}

	public void setNotarizeOrigId(String notarizeOrigId) {
		this.notarizeOrigId = notarizeOrigId;
	}

	@Column(name = "NotarizeClass")
	public String getNotarizeClass() {
		return this.notarizeClass;
	}

	public void setNotarizeClass(String notarizeClass) {
		this.notarizeClass = notarizeClass;
	}

	@Column(name = "NotarizePurpose")
	public String getNotarizePurpose() {
		return this.notarizePurpose;
	}

	public void setNotarizePurpose(String notarizePurpose) {
		this.notarizePurpose = notarizePurpose;
	}

	@Column(name = "RemarkForward", length = 2)
	public String getRemarkForward() {
		return this.remarkForward;
	}

	public void setRemarkForward(String remarkForward) {
		this.remarkForward = remarkForward;
	}

	@Column(name = "RemarkGetWay", length = 6)
	public String getRemarkGetWay() {
		return this.remarkGetWay;
	}

	public void setRemarkGetWay(String remarkGetWay) {
		this.remarkGetWay = remarkGetWay;
	}

	@Column(name = "RemarkGetName")
	public String getRemarkGetName() {
		return this.remarkGetName;
	}

	public void setRemarkGetName(String remarkGetName) {
		this.remarkGetName = remarkGetName;
	}

	@Column(name = "RemarkApplyCopy")
	public String getRemarkApplyCopy() {
		return this.remarkApplyCopy;
	}

	public void setRemarkApplyCopy(String remarkApplyCopy) {
		this.remarkApplyCopy = remarkApplyCopy;
	}

	@Column(name = "RemarkRightWay", length = 8)
	public String getRemarkRightWay() {
		return this.remarkRightWay;
	}

	public void setRemarkRightWay(String remarkRightWay) {
		this.remarkRightWay = remarkRightWay;
	}

	@Column(name = "RemarkData")
	public String getRemarkData() {
		return this.remarkData;
	}

	public void setRemarkData(String remarkData) {
		this.remarkData = remarkData;
	}

	@Column(name = "CopyLetterNo")
	public String getCopyLetterNo() {
		return this.copyLetterNo;
	}

	public void setCopyLetterNo(String copyLetterNo) {
		this.copyLetterNo = copyLetterNo;
	}

	@Column(name = "CopyDeliverDate", length = 8)
	public String getCopyDeliverDate() {
		return this.copyDeliverDate;
	}

	public void setCopyDeliverDate(String copyDeliverDate) {
		this.copyDeliverDate = copyDeliverDate;
	}

	@Column(name = "CopyParty")
	public String getCopyParty() {
		return this.copyParty;
	}

	public void setCopyParty(String copyParty) {
		this.copyParty = copyParty;
	}

	@Column(name = "StatusData")
	public String getStatusData() {
		return this.statusData;
	}

	public void setStatusData(String statusData) {
		this.statusData = statusData;
	}

	@Column(name = "StatusItem")
	public String getStatusItem() {
		return this.statusItem;
	}

	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}

	@Column(name = "StatusProcessDate", length = 8)
	public String getStatusProcessDate() {
		return this.statusProcessDate;
	}

	public void setStatusProcessDate(String statusProcessDate) {
		this.statusProcessDate = statusProcessDate;
	}

	@Column(name = "HastenLetterNo")
	public String getHastenLetterNo() {
		return this.hastenLetterNo;
	}

	public void setHastenLetterNo(String hastenLetterNo) {
		this.hastenLetterNo = hastenLetterNo;
	}

	@Column(name = "HastenDate", length = 8)
	public String getHastenDate() {
		return this.hastenDate;
	}

	public void setHastenDate(String hastenDate) {
		this.hastenDate = hastenDate;
	}

	@Column(name = "ProcessReceiptNo")
	public String getProcessReceiptNo() {
		return this.processReceiptNo;
	}

	public void setProcessReceiptNo(String processReceiptNo) {
		this.processReceiptNo = processReceiptNo;
	}

	@Column(name = "ProcessHastenTimes", length = 3)
	public String getProcessHastenTimes() {
		return this.processHastenTimes;
	}

	public void setProcessHastenTimes(String processHastenTimes) {
		this.processHastenTimes = processHastenTimes;
	}

	@Column(name = "ProcessIssueDate", length = 8)
	public String getProcessIssueDate() {
		return this.processIssueDate;
	}

	public void setProcessIssueDate(String processIssueDate) {
		this.processIssueDate = processIssueDate;
	}

	@Column(name = "ProcessResult")
	public String getProcessResult() {
		return this.processResult;
	}

	public void setProcessResult(String processResult) {
		this.processResult = processResult;
	}

	@Column(name = "MaintainDeptId", length = 4)
	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	@Column(name = "CreateDeptId", length = 4)
	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CreateUserId", nullable = false, length = 10)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "CreateProgramId", nullable = false, length = 20)
	public String getCreateProgramId() {
		return this.createProgramId;
	}

	public void setCreateProgramId(String createProgramId) {
		this.createProgramId = createProgramId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateTime", nullable = false, length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "MaintainHost", nullable = false, length = 2)
	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	@Column(name = "MainUserId", nullable = false, length = 10)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainProgramId", nullable = false, length = 20)
	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
