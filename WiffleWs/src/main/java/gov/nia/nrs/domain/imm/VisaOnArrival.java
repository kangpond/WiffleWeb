package gov.nia.nrs.domain.imm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 
 * @author Jay Lin
 * @since 2015/4/8 上午11:33:40
 */
@Entity
@Table(name = "VisaOnArrival")
public class VisaOnArrival implements Serializable {

	private static final long serialVersionUID = 1L;
	private String permitNo;
	private Integer receivePort;
	private String passengerId;
	private Integer type;
	private String chineseName;
	private String permitNo2;
	private Integer permitCode;
	private String passportNo;
	private String personId;
	private String birthDate;
	private String gender;
	private Integer birthPlaceCode;
	private Integer birthPlace1;
	private String birthPlace2;
	private String entryFlightNo;
	private Integer entryPort;
	private Integer departFrom;
	private String entryDate;
	private String exitFlightNo;
	private Integer exitPort;
	private Integer arriveTo;
	private String exitDate;
	private String approvalDate;
	private Integer overseaResident;
	private String addrType;
	private Integer zipCode;
	private String addr1;
	private String addr2;
	private String addr3;
	private String addr4;
	private Integer vioReasonCode;
	private String vioReasonWord;
	private String tempoEntryWord;
	private String tempoEntryNo;
	private Integer chinaWord;
	private Integer chinaNo;
	private String dispose;
	private String beginDate;
	private String endDate;
	private String passportNoWord;
	private String passportNoRcvNo;
	private String expiryDate;
	private Integer expiryHour;
	private Integer education;
	private Integer position;
	private Integer occupation;
	private Integer militaryType;
	private Integer approvalMark;
	private String suspectMark;
	private Integer applyReason;
	private Integer exitTime;
	private String officialId;
	private String permitType;
	private String firstRecvNo;
	private String barcode;
	private String reserved;
	private Date establishTime;
	private Date importTime;
	private String deleteFlag;
	private String mainUserId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String writeBackFlag;
	private String writeBackRcode;
	private Date writeBackTime;
	private Integer inspectTermNo;
	private String inspectTermLoc;
	private Date last2updateTime;
	private Integer txnMark;
	private Date syncTime;
	private String visaSrcFlag;
	private String writeUpFlag;
	private Date writeUpTime;
	private String multiCitiZenFlag;
	private String visaNationType;
	private String nationOversea;
	private String englishName;

	@Id
	@Column(name = "PermitNo", unique = true, nullable = false, length = 12)
	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	@Column(name = "ReceivePort", nullable = false, precision = 2, scale = 0)
	public Integer getReceivePort() {
		return this.receivePort;
	}

	public void setReceivePort(Integer receivePort) {
		this.receivePort = receivePort;
	}

	@Column(name = "PassengerId", nullable = false, length = 10)
	public String getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	@Column(name = "Type", nullable = false, precision = 2, scale = 0)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "ChineseName", nullable = false, length = 80)
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "PermitNo2", nullable = false, length = 12)
	public String getPermitNo2() {
		return this.permitNo2;
	}

	public void setPermitNo2(String permitNo2) {
		this.permitNo2 = permitNo2;
	}

	@Column(name = "PermitCode", nullable = false, precision = 3, scale = 0)
	public Integer getPermitCode() {
		return this.permitCode;
	}

	public void setPermitCode(Integer permitCode) {
		this.permitCode = permitCode;
	}

	@Column(name = "PassportNo", nullable = false, length = 12)
	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Column(name = "PersonId", nullable = false, length = 20)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "BirthDate", nullable = false, length = 8)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "Gender", nullable = false, length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "BirthPlaceCode", nullable = false, precision = 1, scale = 0)
	public Integer getBirthPlaceCode() {
		return this.birthPlaceCode;
	}

	public void setBirthPlaceCode(Integer birthPlaceCode) {
		this.birthPlaceCode = birthPlaceCode;
	}

	@Column(name = "BirthPlace1", nullable = false, precision = 3, scale = 0)
	public Integer getBirthPlace1() {
		return this.birthPlace1;
	}

	public void setBirthPlace1(Integer birthPlace1) {
		this.birthPlace1 = birthPlace1;
	}

	@Column(name = "BirthPlace2", nullable = false, length = 16)
	public String getBirthPlace2() {
		return this.birthPlace2;
	}

	public void setBirthPlace2(String birthPlace2) {
		this.birthPlace2 = birthPlace2;
	}

	@Column(name = "EntryFlightNo", nullable = false, length = 20)
	public String getEntryFlightNo() {
		return this.entryFlightNo;
	}

	public void setEntryFlightNo(String entryFlightNo) {
		this.entryFlightNo = entryFlightNo;
	}

	@Column(name = "EntryPort", nullable = false, precision = 2, scale = 0)
	public Integer getEntryPort() {
		return this.entryPort;
	}

	public void setEntryPort(Integer entryPort) {
		this.entryPort = entryPort;
	}

	@Column(name = "DepartFrom", nullable = false, precision = 3, scale = 0)
	public Integer getDepartFrom() {
		return this.departFrom;
	}

	public void setDepartFrom(Integer departFrom) {
		this.departFrom = departFrom;
	}

	@Column(name = "EntryDate", nullable = false, length = 8)
	public String getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "ExitFlightNo", nullable = false, length = 20)
	public String getExitFlightNo() {
		return this.exitFlightNo;
	}

	public void setExitFlightNo(String exitFlightNo) {
		this.exitFlightNo = exitFlightNo;
	}

	@Column(name = "ExitPort", nullable = false, precision = 2, scale = 0)
	public Integer getExitPort() {
		return this.exitPort;
	}

	public void setExitPort(Integer exitPort) {
		this.exitPort = exitPort;
	}

	@Column(name = "ArriveTo", nullable = false, precision = 3, scale = 0)
	public Integer getArriveTo() {
		return this.arriveTo;
	}

	public void setArriveTo(Integer arriveTo) {
		this.arriveTo = arriveTo;
	}

	@Column(name = "ExitDate", nullable = false, length = 8)
	public String getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	@Column(name = "ApprovalDate", nullable = false, length = 8)
	public String getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Column(name = "OverseaResident", nullable = false, precision = 3, scale = 0)
	public Integer getOverseaResident() {
		return this.overseaResident;
	}

	public void setOverseaResident(Integer overseaResident) {
		this.overseaResident = overseaResident;
	}

	@Column(name = "AddrType", nullable = false, length = 1)
	public String getAddrType() {
		return this.addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	@Column(name = "ZipCode", nullable = false, precision = 3, scale = 0)
	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "Addr1", nullable = false, length = 16)
	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	@Column(name = "Addr2", nullable = false, length = 4)
	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Column(name = "Addr3", nullable = false, length = 4)
	public String getAddr3() {
		return this.addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	@Column(name = "Addr4", nullable = false, length = 100)
	public String getAddr4() {
		return this.addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	@Column(name = "VioReasonCode", nullable = false, precision = 2, scale = 0)
	public Integer getVioReasonCode() {
		return this.vioReasonCode;
	}

	public void setVioReasonCode(Integer vioReasonCode) {
		this.vioReasonCode = vioReasonCode;
	}

	@Column(name = "VioReasonWord", nullable = false, length = 64)
	public String getVioReasonWord() {
		return this.vioReasonWord;
	}

	public void setVioReasonWord(String vioReasonWord) {
		this.vioReasonWord = vioReasonWord;
	}

	@Column(name = "TempoEntryWord", nullable = false, length = 9)
	public String getTempoEntryWord() {
		return this.tempoEntryWord;
	}

	public void setTempoEntryWord(String tempoEntryWord) {
		this.tempoEntryWord = tempoEntryWord;
	}

	@Column(name = "TempoEntryNo", nullable = false, length = 12)
	public String getTempoEntryNo() {
		return this.tempoEntryNo;
	}

	public void setTempoEntryNo(String tempoEntryNo) {
		this.tempoEntryNo = tempoEntryNo;
	}

	@Column(name = "ChinaWord", nullable = false, precision = 3, scale = 0)
	public Integer getChinaWord() {
		return this.chinaWord;
	}

	public void setChinaWord(Integer chinaWord) {
		this.chinaWord = chinaWord;
	}

	@Column(name = "ChinaNo", nullable = false, precision = 4, scale = 0)
	public Integer getChinaNo() {
		return this.chinaNo;
	}

	public void setChinaNo(Integer chinaNo) {
		this.chinaNo = chinaNo;
	}

	@Column(name = "Dispose", nullable = false, length = 48)
	public String getDispose() {
		return this.dispose;
	}

	public void setDispose(String dispose) {
		this.dispose = dispose;
	}

	@Column(name = "BeginDate", nullable = false, length = 8)
	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name = "EndDate", nullable = false, length = 8)
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column(name = "PassportNoWord", nullable = false, length = 12)
	public String getPassportNoWord() {
		return this.passportNoWord;
	}

	public void setPassportNoWord(String passportNoWord) {
		this.passportNoWord = passportNoWord;
	}

	@Column(name = "PassportNoRcvNo", nullable = false, length = 9)
	public String getPassportNoRcvNo() {
		return this.passportNoRcvNo;
	}

	public void setPassportNoRcvNo(String passportNoRcvNo) {
		this.passportNoRcvNo = passportNoRcvNo;
	}

	@Column(name = "ExpiryDate", nullable = false, length = 8)
	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "ExpiryHour", nullable = false, precision = 2, scale = 0)
	public Integer getExpiryHour() {
		return this.expiryHour;
	}

	public void setExpiryHour(Integer expiryHour) {
		this.expiryHour = expiryHour;
	}

	@Column(name = "Education", nullable = false, precision = 1, scale = 0)
	public Integer getEducation() {
		return this.education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	@Column(name = "Position", nullable = false, precision = 3, scale = 0)
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Column(name = "Occupation", nullable = false, precision = 2, scale = 0)
	public Integer getOccupation() {
		return this.occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	@Column(name = "MilitaryType", nullable = false, precision = 2, scale = 0)
	public Integer getMilitaryType() {
		return this.militaryType;
	}

	public void setMilitaryType(Integer militaryType) {
		this.militaryType = militaryType;
	}

	@Column(name = "ApprovalMark", nullable = false, precision = 1, scale = 0)
	public Integer getApprovalMark() {
		return this.approvalMark;
	}

	public void setApprovalMark(Integer approvalMark) {
		this.approvalMark = approvalMark;
	}

	@Column(name = "SuspectMark", nullable = false, length = 1)
	public String getSuspectMark() {
		return this.suspectMark;
	}

	public void setSuspectMark(String suspectMark) {
		this.suspectMark = suspectMark;
	}

	@Column(name = "ApplyReason", nullable = false, precision = 3, scale = 0)
	public Integer getApplyReason() {
		return this.applyReason;
	}

	public void setApplyReason(Integer applyReason) {
		this.applyReason = applyReason;
	}

	@Column(name = "ExitTime", nullable = false, precision = 4, scale = 0)
	public Integer getExitTime() {
		return this.exitTime;
	}

	public void setExitTime(Integer exitTime) {
		this.exitTime = exitTime;
	}

	@Column(name = "OfficialId", nullable = false, length = 5)
	public String getOfficialId() {
		return this.officialId;
	}

	public void setOfficialId(String officialId) {
		this.officialId = officialId;
	}

	@Column(name = "PermitType", length = 3)
	public String getPermitType() {
		return this.permitType;
	}

	public void setPermitType(String permitType) {
		this.permitType = permitType;
	}

	@Column(name = "FirstRecvNo", length = 12)
	public String getFirstRecvNo() {
		return this.firstRecvNo;
	}

	public void setFirstRecvNo(String firstRecvNo) {
		this.firstRecvNo = firstRecvNo;
	}

	@Column(name = "Barcode", length = 15)
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(name = "Reserved", length = 30)
	public String getReserved() {
		return this.reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EstablishTime", length = 23)
	public Date getEstablishTime() {
		return this.establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = (establishTime != null) ? new java.util.Date(establishTime.getTime()) : establishTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ImportTime", length = 23)
	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = (importTime != null) ? new java.util.Date(importTime.getTime()) : importTime;
	}

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "MainUserId", nullable = false, length = 10)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainProgramId", nullable = false, length = 10)
	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
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
		this.lastUpdateTime = (lastUpdateTime != null) ? new java.util.Date(lastUpdateTime.getTime()) : lastUpdateTime;
	}

	@Column(name = "WriteBackFlag", length = 1)
	public String getWriteBackFlag() {
		return this.writeBackFlag;
	}

	public void setWriteBackFlag(String writeBackFlag) {
		this.writeBackFlag = writeBackFlag;
	}

	@Column(name = "WriteBackRcode", length = 4)
	public String getWriteBackRcode() {
		return this.writeBackRcode;
	}

	public void setWriteBackRcode(String writeBackRcode) {
		this.writeBackRcode = writeBackRcode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "WriteBackTime", length = 23)
	public Date getWriteBackTime() {
		return this.writeBackTime;
	}

	public void setWriteBackTime(Date writeBackTime) {
		this.writeBackTime = (writeBackTime != null) ? new java.util.Date(writeBackTime.getTime()) : writeBackTime;
	}

	@Column(name = "InspectTermNo", precision = 4, scale = 0)
	public Integer getInspectTermNo() {
		return this.inspectTermNo;
	}

	public void setInspectTermNo(Integer inspectTermNo) {
		this.inspectTermNo = inspectTermNo;
	}

	@Column(name = "InspectTermLoc", length = 2)
	public String getInspectTermLoc() {
		return this.inspectTermLoc;
	}

	public void setInspectTermLoc(String inspectTermLoc) {
		this.inspectTermLoc = inspectTermLoc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last2UpdateTime", length = 23)
	public Date getLast2updateTime() {
		return this.last2updateTime;
	}

	public void setLast2updateTime(Date last2updateTime) {
		this.last2updateTime = (last2updateTime != null) ? new java.util.Date(last2updateTime.getTime()) : last2updateTime;
	}

	@Column(name = "TxnMark", precision = 1, scale = 0)
	public Integer getTxnMark() {
		return this.txnMark;
	}

	public void setTxnMark(Integer txnMark) {
		this.txnMark = txnMark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SyncTime", length = 23)
	public Date getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = (syncTime != null) ? new java.util.Date(syncTime.getTime()) : syncTime;
	}

	@Column(name = "VisaSrcFlag", length = 2)
	public String getVisaSrcFlag() {
		return this.visaSrcFlag;
	}

	public void setVisaSrcFlag(String visaSrcFlag) {
		this.visaSrcFlag = visaSrcFlag;
	}

	@Column(name = "WriteUpFlag", length = 2)
	public String getWriteUpFlag() {
		return this.writeUpFlag;
	}

	public void setWriteUpFlag(String writeUpFlag) {
		this.writeUpFlag = writeUpFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "WriteUpTime", length = 23)
	public Date getWriteUpTime() {
		return this.writeUpTime;
	}

	public void setWriteUpTime(Date writeUpTime) {
		this.writeUpTime = (writeUpTime != null) ? new java.util.Date(writeUpTime.getTime()) : writeUpTime;
	}

	@Column(name = "MultiCitiZenFlag", length = 2)
	public String getMultiCitiZenFlag() {
		return this.multiCitiZenFlag;
	}

	public void setMultiCitiZenFlag(String multiCitiZenFlag) {
		this.multiCitiZenFlag = multiCitiZenFlag;
	}

	@Column(name = "VisaNationType", length = 1)
	public String getVisaNationType() {
		return this.visaNationType;
	}

	public void setVisaNationType(String visaNationType) {
		this.visaNationType = visaNationType;
	}

	@Column(name = "NationOversea", length = 1)
	public String getNationOversea() {
		return this.nationOversea;
	}

	public void setNationOversea(String nationOversea) {
		this.nationOversea = nationOversea;
	}

	@Column(name = "EnglishName", length = 50)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VisaOnArrival").append(" [");
		builder.append("permitNo").append("=").append(permitNo).append(" ");
		builder.append("receivePort").append("=").append(receivePort).append(" ");
		builder.append("passengerId").append("=").append(passengerId).append(" ");
		builder.append("type").append("=").append(type).append(" ");
		builder.append("chineseName").append("=").append(chineseName).append(" ");
		builder.append("permitNo2").append("=").append(permitNo2).append(" ");
		builder.append("permitCode").append("=").append(permitCode).append(" ");
		builder.append("passportNo").append("=").append(passportNo).append(" ");
		builder.append("personId").append("=").append(personId).append(" ");
		builder.append("birthDate").append("=").append(birthDate).append(" ");
		builder.append("gender").append("=").append(gender).append(" ");
		builder.append("birthPlaceCode").append("=").append(birthPlaceCode).append(" ");
		builder.append("birthPlace1").append("=").append(birthPlace1).append(" ");
		builder.append("birthPlace2").append("=").append(birthPlace2).append(" ");
		builder.append("entryFlightNo").append("=").append(entryFlightNo).append(" ");
		builder.append("entryPort").append("=").append(entryPort).append(" ");
		builder.append("departFrom").append("=").append(departFrom).append(" ");
		builder.append("entryDate").append("=").append(entryDate).append(" ");
		builder.append("exitFlightNo").append("=").append(exitFlightNo).append(" ");
		builder.append("exitPort").append("=").append(exitPort).append(" ");
		builder.append("arriveTo").append("=").append(arriveTo).append(" ");
		builder.append("exitDate").append("=").append(exitDate).append(" ");
		builder.append("approvalDate").append("=").append(approvalDate).append(" ");
		builder.append("overseaResident").append("=").append(overseaResident).append(" ");
		builder.append("addrType").append("=").append(addrType).append(" ");
		builder.append("zipCode").append("=").append(zipCode).append(" ");
		builder.append("addr1").append("=").append(addr1).append(" ");
		builder.append("addr2").append("=").append(addr2).append(" ");
		builder.append("addr3").append("=").append(addr3).append(" ");
		builder.append("addr4").append("=").append(addr4).append(" ");
		builder.append("vioReasonCode").append("=").append(vioReasonCode).append(" ");
		builder.append("vioReasonWord").append("=").append(vioReasonWord).append(" ");
		builder.append("tempoEntryWord").append("=").append(tempoEntryWord).append(" ");
		builder.append("tempoEntryNo").append("=").append(tempoEntryNo).append(" ");
		builder.append("chinaWord").append("=").append(chinaWord).append(" ");
		builder.append("chinaNo").append("=").append(chinaNo).append(" ");
		builder.append("dispose").append("=").append(dispose).append(" ");
		builder.append("beginDate").append("=").append(beginDate).append(" ");
		builder.append("endDate").append("=").append(endDate).append(" ");
		builder.append("passportNoWord").append("=").append(passportNoWord).append(" ");
		builder.append("passportNoRcvNo").append("=").append(passportNoRcvNo).append(" ");
		builder.append("expiryDate").append("=").append(expiryDate).append(" ");
		builder.append("expiryHour").append("=").append(expiryHour).append(" ");
		builder.append("education").append("=").append(education).append(" ");
		builder.append("position").append("=").append(position).append(" ");
		builder.append("occupation").append("=").append(occupation).append(" ");
		builder.append("militaryType").append("=").append(militaryType).append(" ");
		builder.append("approvalMark").append("=").append(approvalMark).append(" ");
		builder.append("suspectMark").append("=").append(suspectMark).append(" ");
		builder.append("applyReason").append("=").append(applyReason).append(" ");
		builder.append("exitTime").append("=").append(exitTime).append(" ");
		builder.append("officialId").append("=").append(officialId).append(" ");
		builder.append("permitType").append("=").append(permitType).append(" ");
		builder.append("firstRecvNo").append("=").append(firstRecvNo).append(" ");
		builder.append("barcode").append("=").append(barcode).append(" ");
		builder.append("reserved").append("=").append(reserved).append(" ");
		builder.append("establishTime").append("=").append(establishTime).append(" ");
		builder.append("importTime").append("=").append(importTime).append(" ");
		builder.append("deleteFlag").append("=").append(deleteFlag).append(" ");
		builder.append("mainUserId").append("=").append(mainUserId).append(" ");
		builder.append("maintainProgramId").append("=").append(maintainProgramId).append(" ");
		builder.append("maintainHost").append("=").append(maintainHost).append(" ");
		builder.append("lastUpdateTime").append("=").append(lastUpdateTime).append(" ");
		builder.append("writeBackFlag").append("=").append(writeBackFlag).append(" ");
		builder.append("writeBackRcode").append("=").append(writeBackRcode).append(" ");
		builder.append("writeBackTime").append("=").append(writeBackTime).append(" ");
		builder.append("inspectTermNo").append("=").append(inspectTermNo).append(" ");
		builder.append("inspectTermLoc").append("=").append(inspectTermLoc).append(" ");
		builder.append("last2updateTime").append("=").append(last2updateTime).append(" ");
		builder.append("txnMark").append("=").append(txnMark).append(" ");
		builder.append("syncTime").append("=").append(syncTime).append(" ");
		builder.append("visaSrcFlag").append("=").append(visaSrcFlag).append(" ");
		builder.append("writeUpFlag").append("=").append(writeUpFlag).append(" ");
		builder.append("writeUpTime").append("=").append(writeUpTime).append(" ");
		builder.append("multiCitiZenFlag").append("=").append(multiCitiZenFlag).append(" ");
		builder.append("visaNationType").append("=").append(visaNationType).append(" ");
		builder.append("nationOversea").append("=").append(nationOversea).append(" ");
		builder.append("englishName").append("=").append(englishName).append(" ");
		builder.append("]");
		return builder.toString();
	}
}
