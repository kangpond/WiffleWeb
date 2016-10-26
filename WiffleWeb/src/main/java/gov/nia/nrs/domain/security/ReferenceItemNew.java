package gov.nia.nrs.domain.security;

import gov.nia.nrs.utils.StringUtil;

import java.util.Date;

/**
 * ReferenceItemNew
 */
public class ReferenceItemNew implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String itemSerialNo;
	private String referencePersonId;
	private Integer kind;
	private String status;
	private String applyDate;
	private String referenceDate;
	private String expiryDate;
	private String processDept;
	private String reportKind;
	private String foundDept;
	private String missingDate;
	private String reportDate;
	private String foundDate;
	private String result;
	private String fineType;
	private String fineReceiptNo;
	private String lastProcess;
	private Integer process;
	private String crimKind;
	private String reportDept;
	private String catchPersonName;
	private String relName;
	private String revokeMark;
	private String revokeCation;
	private String disappearReason;
	private String otherReason;
	private String disappearDesc;
	private String catchingDesc;
	private String contactTel;
	private String reporterName;
	private String reporterBirthDate;
	private String reporterTel;
	private String relation;
	private String catchingAddr;
	private String hidePlace;
	private String comments;
	private String revokeDate;
	private String revokeType;
	private String signTeam;
	private String signNo;
	private String signResult;
	private Date signDate;
	private String signApply;
	private String signRemark;
	private String source;
	private String receiveNo;
	private String firstReceiveNo;
	private String passportNo;
	private Integer reason;
	private String applicantType;
	private String identification;
	private Integer bureau;
	private String bureauDate;
	private String bureauNo1;
	private String bureauNo2;
	private String undertakerTeam;
	private String undertakerNo;
	private String insuredType;
	private String insuredName;
	private String insuredBirthDate;
	private String insuredGender;
	private String insuredPersonId;
	private String insuredPermitNo;
	private String importantMark;
	private String fileType;
	private Long serialNo;
	private String filmNo;
	private String remark;
	private Integer oldPaperSerialNo;
	private String createUserId;
	private String createDeptId;
	private Date createTime;
	private String mainUserId;
	private String maintainDeptId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String deleteFlag;
	private String reporterAddr;
	private String reporterGender;
	private String reporterRegNo;
	private String reporterPersonId;
	
	public ReferenceItemNew() {
	}

	public String getItemSerialNo() {
		return this.itemSerialNo;
	}

	public void setItemSerialNo(String itemSerialNo) {
		this.itemSerialNo = StringUtil.chkNull2empty(itemSerialNo);
	}

	public String getReferencePersonId() {
		return this.referencePersonId;
	}

	public void setReferencePersonId(String referencePersonId) {
		this.referencePersonId = referencePersonId;
	}

	public Integer getKind() {
		return this.kind;
	}

	public void setKind(Integer kind) {
		this.kind = StringUtil.parseInt(String.valueOf(kind));;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = StringUtil.chkNull2empty(status);
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getReferenceDate() {
		return this.referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getProcessDept() {
		return this.processDept;
	}

	public void setProcessDept(String processDept) {
		this.processDept = StringUtil.chkNull2empty(processDept);
	}

	public String getReportKind() {
		return this.reportKind;
	}

	public void setReportKind(String reportKind) {
		this.reportKind = reportKind;
	}

	public String getFoundDept() {
		return this.foundDept;
	}

	public void setFoundDept(String foundDept) {
		this.foundDept = foundDept;
	}

	public String getMissingDate() {
		return this.missingDate;
	}

	public void setMissingDate(String missingDate) {
		this.missingDate = StringUtil.chkNull2empty(missingDate);
	}

	public String getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = StringUtil.chkNull2empty(reportDate);
	}

	public String getFoundDate() {
		return this.foundDate;
	}

	public void setFoundDate(String foundDate) {
		this.foundDate = StringUtil.chkNull2empty(foundDate);
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = StringUtil.chkNull2empty(result);
	}

	public String getFineType() {
		return this.fineType;
	}

	public void setFineType(String fineType) {
		this.fineType =  StringUtil.chkNull2empty(fineType);
	}

	public String getFineReceiptNo() {
		return this.fineReceiptNo;
	}

	public void setFineReceiptNo(String fineReceiptNo) {
		this.fineReceiptNo = StringUtil.chkNull2empty(fineReceiptNo);
	}

	public String getLastProcess() {
		return this.lastProcess;
	}

	public void setLastProcess(String lastProcess) {
		this.lastProcess = StringUtil.chkNull2empty(lastProcess);
	}

	public Integer getProcess() {
		return this.process;
	}

	public void setProcess(Integer process) {
		this.process = StringUtil.parseInt(String.valueOf(process));
	}

	public String getCrimKind() {
		return this.crimKind;
	}

	public void setCrimKind(String crimKind) {
		this.crimKind = StringUtil.chkNull2empty(crimKind);
	}

	public String getReportDept() {
		return this.reportDept;
	}

	public void setReportDept(String reportDept) {
		this.reportDept = StringUtil.chkNull2empty(reportDept);
	}

	public String getCatchPersonName() {
		return this.catchPersonName;
	}

	public void setCatchPersonName(String catchPersonName) {
		this.catchPersonName = StringUtil.chkNull2empty(catchPersonName);
	}

	public String getRelName() {
		return this.relName;
	}

	public void setRelName(String relName) {
		this.relName = StringUtil.chkNull2empty(relName);
	}

	public String getRevokeMark() {
		return this.revokeMark;
	}

	public void setRevokeMark(String revokeMark) {
		this.revokeMark = StringUtil.chkNull2empty(revokeMark);
	}

	public String getRevokeCation() {
		return this.revokeCation;
	}

	public void setRevokeCation(String revokeCation) {
		this.revokeCation = StringUtil.chkNull2empty(revokeCation);
	}

	public String getDisappearReason() {
		return this.disappearReason;
	}

	public void setDisappearReason(String disappearReason) {
		this.disappearReason = StringUtil.chkNull2empty(disappearReason);
	}

	public String getOtherReason() {
		return this.otherReason;
	}

	public void setOtherReason(String otherReason) {
		this.otherReason = StringUtil.chkNull2empty(otherReason);
	}

	public String getDisappearDesc() {
		return this.disappearDesc;
	}

	public void setDisappearDesc(String disappearDesc) {
		this.disappearDesc = StringUtil.chkNull2empty(disappearDesc);
	}

	public String getCatchingDesc() {
		return this.catchingDesc;
	}

	public void setCatchingDesc(String catchingDesc) {
		this.catchingDesc = StringUtil.chkNull2empty(catchingDesc);
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = StringUtil.chkNull2empty(contactTel);
	}

	public String getReporterName() {
		return this.reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = StringUtil.chkNull2empty(reporterName);
	}

	public String getReporterBirthDate() {
		return this.reporterBirthDate;
	}

	public void setReporterBirthDate(String reporterBirthDate) {
		this.reporterBirthDate = StringUtil.chkNull2empty(reporterBirthDate);
	}

	public String getReporterTel() {
		return this.reporterTel;
	}

	public void setReporterTel(String reporterTel) {
		this.reporterTel = StringUtil.chkNull2empty(reporterTel);
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = StringUtil.chkNull2empty(relation);
	}

	public String getCatchingAddr() {
		return this.catchingAddr;
	}

	public void setCatchingAddr(String catchingAddr) {
		this.catchingAddr = StringUtil.chkNull2empty(catchingAddr);
	}

	public String getHidePlace() {
		return this.hidePlace;
	}

	public void setHidePlace(String hidePlace) {
		this.hidePlace = StringUtil.chkNull2empty(hidePlace);
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = StringUtil.chkNull2empty(comments);
	}

	public String getRevokeDate() {
		return this.revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = StringUtil.chkNull2empty(revokeDate);
	}

	public String getRevokeType() {
		return this.revokeType;
	}

	public void setRevokeType(String revokeType) {
		this.revokeType = StringUtil.chkNull2empty(revokeType);
	}

	public String getSignTeam() {
		return this.signTeam;
	}

	public void setSignTeam(String signTeam) {
		this.signTeam = StringUtil.chkNull2empty(signTeam);
	}

	public String getSignNo() {
		return this.signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = StringUtil.chkNull2empty(signNo);
	}

	public String getSignResult() {
		return this.signResult;
	}

	public void setSignResult(String signResult) {
		this.signResult = StringUtil.chkNull2empty(signResult);
	}

	public Date getSignDate() {
		return this.signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getSignApply() {
		return this.signApply;
	}

	public void setSignApply(String signApply) {
		this.signApply = StringUtil.chkNull2empty(signApply);
	}

	public String getSignRemark() {
		return this.signRemark;
	}

	public void setSignRemark(String signRemark) {
		this.signRemark = StringUtil.chkNull2empty(signRemark);
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = StringUtil.chkNull2empty(source);
	}
	
	/**
	 * @return the firstReceiveNo
	 */
	public String getFirstReceiveNo() {
		return firstReceiveNo;
	}

	/**
	 * @param firstReceiveNo the firstReceiveNo to set
	 */
	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = StringUtil.chkNull2empty(firstReceiveNo);
	}
	
	public String getReceiveNo() {
		return this.receiveNo;
	}

	public void setReceiveNo(String receiveNo) {
		this.receiveNo = StringUtil.chkNull2empty(receiveNo);
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = StringUtil.chkNull2empty(passportNo);
	}

	public Integer getReason() {
		return this.reason;
	}

	public void setReason(Integer reason) {
		this.reason = StringUtil.parseInt(String.valueOf(reason));
	}

	public String getApplicantType() {
		return this.applicantType;
	}

	public void setApplicantType(String applicantType) {
		this.applicantType = StringUtil.chkNull2empty(applicantType);
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = StringUtil.chkNull2empty(identification);
	}

	public Integer getBureau() {
		return this.bureau;
	}

	public void setBureau(Integer bureau) {
		this.bureau = StringUtil.parseInt(String.valueOf(bureau));
	}

	public String getBureauDate() {
		return this.bureauDate;
	}

	public void setBureauDate(String bureauDate) {
		this.bureauDate = StringUtil.chkNull2empty(bureauDate);
	}

	public String getBureauNo1() {
		return this.bureauNo1;
	}

	public void setBureauNo1(String bureauNo1) {
		this.bureauNo1 = StringUtil.chkNull2empty(bureauNo1);
	}

	public String getBureauNo2() {
		return this.bureauNo2;
	}

	public void setBureauNo2(String bureauNo2) {
		this.bureauNo2 = StringUtil.chkNull2empty(bureauNo2);
	}

	public String getUndertakerTeam() {
		return this.undertakerTeam;
	}

	public void setUndertakerTeam(String undertakerTeam) {
		this.undertakerTeam = StringUtil.chkNull2empty(undertakerTeam);
	}

	public String getUndertakerNo() {
		return this.undertakerNo;
	}

	public void setUndertakerNo(String undertakerNo) {
		this.undertakerNo = StringUtil.chkNull2empty(undertakerNo);
	}

	public String getInsuredType() {
		return this.insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = StringUtil.chkNull2empty(insuredType);
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = StringUtil.chkNull2empty(insuredName);
	}

	public String getInsuredBirthDate() {
		return this.insuredBirthDate;
	}

	public void setInsuredBirthDate(String insuredBirthDate) {
		this.insuredBirthDate = StringUtil.chkNull2empty(insuredBirthDate);
	}

	public String getInsuredGender() {
		return this.insuredGender;
	}

	public void setInsuredGender(String insuredGender) {
		this.insuredGender = StringUtil.chkNull2empty(insuredGender);
	}

	public String getInsuredPersonId() {
		return this.insuredPersonId;
	}

	public void setInsuredPersonId(String insuredPersonId) {
		this.insuredPersonId = StringUtil.chkNull2empty(insuredPersonId);
	}

	public String getInsuredPermitNo() {
		return this.insuredPermitNo;
	}

	public void setInsuredPermitNo(String insuredPermitNo) {
		this.insuredPermitNo = StringUtil.chkNull2empty(insuredPermitNo);
	}

	public String getImportantMark() {
		return this.importantMark;
	}

	public void setImportantMark(String importantMark) {
		this.importantMark = StringUtil.chkNull2empty(importantMark);
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = StringUtil.chkNull2empty(fileType);
	}

	public Long getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = StringUtil.parseLong(String.valueOf(serialNo));
	}

	public String getFilmNo() {
		return this.filmNo;
	}

	public void setFilmNo(String filmNo) {
		this.filmNo = StringUtil.chkNull2empty(filmNo);
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = StringUtil.chkNull2empty(remark);
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
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

	/**
	 * @return the reporterAddr
	 */
	public String getReporterAddr() {
		return reporterAddr;
	}

	/**
	 * @param reporterAddr the reporterAddr to set
	 */
	public void setReporterAddr(String reporterAddr) {
		this.reporterAddr = reporterAddr;
	}

	/**
	 * @return the reporterGender
	 */
	public String getReporterGender() {
		return reporterGender;
	}

	/**
	 * @param reporterGender the reporterGender to set
	 */
	public void setReporterGender(String reporterGender) {
		this.reporterGender = reporterGender;
	}

	/**
	 * @return the reporterRegNo
	 */
	public String getReporterRegNo() {
		return reporterRegNo;
	}

	/**
	 * @param reporterRegNo the reporterRegNo to set
	 */
	public void setReporterRegNo(String reporterRegNo) {
		this.reporterRegNo = reporterRegNo;
	}

	/**
	 * @return the reporterPersonId
	 */
	public String getReporterPersonId() {
		return reporterPersonId;
	}

	/**
	 * @param reporterPersonId the reporterPersonId to set
	 */
	public void setReporterPersonId(String reporterPersonId) {
		this.reporterPersonId = reporterPersonId;
	}
	/**
	 * @return the oldPaperSerialNo
	 */
	public Integer getOldPaperSerialNo() {
		return oldPaperSerialNo;
	}

	/**
	 * @param oldPaperSerialNo the oldPaperSerialNo to set
	 */
	public void setOldPaperSerialNo(Integer oldPaperSerialNo) {
		this.oldPaperSerialNo = oldPaperSerialNo;
	}
}
