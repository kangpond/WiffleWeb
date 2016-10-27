package gov.nia.nrs.domain.iis;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ApplyCaseForeign
 */
@Entity
@Table(name = "ApplyCaseForeign")
public class ApplyCaseForeign implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String receiveNo;
	private String telNo;
	private String addrTypeA;
	private String cityA;
	private String townshipA;
	private String zipCodeA;
	private String villageA;
	private String neighborhoodA;
	private String roadA;
	private String districtA;
	private String laneA;
	private String alleyA;
	private String numberA;
	private String telNoB;
	private String cityWk;
	private String townshipWk;
	private String zipCodeWk;
	private String villageWk;
	private String neighborhoodWk;
	private String roadWk;
	private String districtWk;
	private String laneWk;
	private String alleyWk;
	private String numberWk;
	private String createUserId;
	private String createDeptId;
	private Date createTime;
	private String mainUserId;
	private String maintainDeptId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String firstReceiveNo;
	private String addrB;
	private String invitedDept;
	private String contactName;
	private String contactTel;
	private String contactMobile;
	private Date importTime;
	private String deleteFlag;
	private String sourceTable;
	private String telNoWk;
	private Long txnMark;
	private Date syncTime;
	private String serviceOfficeCode;
	private String serviceOfficeName;
	private String serviceOfficeTel;
	private String jobTitle;
	private String firstRcEndDate;
	private String etlflag;
	private String workAllowDate;
	private String workAllowDept;
	private String workAllowDocNo;
	private String workAllowEndDate;
	private String workAllowStartDate;
	private String employDocNo;
	private String reasonReMark;
	private String noMultiReEntryReasonDesc;
	private String otherReasonDescCode;
	private String otherReasonDate;

	public ApplyCaseForeign() {
	}

	public ApplyCaseForeign(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	public ApplyCaseForeign(String receiveNo, String telNo, String addrTypeA,
			String cityA, String townshipA, String zipCodeA, String villageA,
			String neighborhoodA, String roadA, String districtA, String laneA,
			String alleyA, String numberA, String telNoB, String cityWk,
			String townshipWk, String zipCodeWk, String villageWk,
			String neighborhoodWk, String roadWk, String districtWk,
			String laneWk, String alleyWk, String numberWk,
			String createUserId, String createDeptId, Date createTime,
			String mainUserId, String maintainDeptId, String maintainProgramId,
			String maintainHost, Date lastUpdateTime, String firstReceiveNo,
			String addrB, String invitedDept, String contactName,
			String contactTel, String contactMobile, Date importTime,
			String deleteFlag, String sourceTable, String telNoWk,
			Long txnMark, Date syncTime, String serviceOfficeCode,
			String serviceOfficeName, String serviceOfficeTel, String jobTitle,
			String firstRcEndDate, String etlflag, String workAllowDate,
			String workAllowDept, String workAllowDocNo,
			String workAllowEndDate, String workAllowStartDate,
			String employDocNo, String reasonReMark,
			String noMultiReEntryReasonDesc, String otherReasonDescCode,
			String otherReasonDate) {
		this.receiveNo = receiveNo;
		this.telNo = telNo;
		this.addrTypeA = addrTypeA;
		this.cityA = cityA;
		this.townshipA = townshipA;
		this.zipCodeA = zipCodeA;
		this.villageA = villageA;
		this.neighborhoodA = neighborhoodA;
		this.roadA = roadA;
		this.districtA = districtA;
		this.laneA = laneA;
		this.alleyA = alleyA;
		this.numberA = numberA;
		this.telNoB = telNoB;
		this.cityWk = cityWk;
		this.townshipWk = townshipWk;
		this.zipCodeWk = zipCodeWk;
		this.villageWk = villageWk;
		this.neighborhoodWk = neighborhoodWk;
		this.roadWk = roadWk;
		this.districtWk = districtWk;
		this.laneWk = laneWk;
		this.alleyWk = alleyWk;
		this.numberWk = numberWk;
		this.createUserId = createUserId;
		this.createDeptId = createDeptId;
		this.createTime = createTime;
		this.mainUserId = mainUserId;
		this.maintainDeptId = maintainDeptId;
		this.maintainProgramId = maintainProgramId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.firstReceiveNo = firstReceiveNo;
		this.addrB = addrB;
		this.invitedDept = invitedDept;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.contactMobile = contactMobile;
		this.importTime = importTime;
		this.deleteFlag = deleteFlag;
		this.sourceTable = sourceTable;
		this.telNoWk = telNoWk;
		this.txnMark = txnMark;
		this.syncTime = syncTime;
		this.serviceOfficeCode = serviceOfficeCode;
		this.serviceOfficeName = serviceOfficeName;
		this.serviceOfficeTel = serviceOfficeTel;
		this.jobTitle = jobTitle;
		this.firstRcEndDate = firstRcEndDate;
		this.etlflag = etlflag;
		this.workAllowDate = workAllowDate;
		this.workAllowDept = workAllowDept;
		this.workAllowDocNo = workAllowDocNo;
		this.workAllowEndDate = workAllowEndDate;
		this.workAllowStartDate = workAllowStartDate;
		this.employDocNo = employDocNo;
		this.reasonReMark = reasonReMark;
		this.noMultiReEntryReasonDesc = noMultiReEntryReasonDesc;
		this.otherReasonDescCode = otherReasonDescCode;
		this.otherReasonDate = otherReasonDate;
	}

	@Id
	@Column(name = "ReceiveNo", unique = true, nullable = false, length = 12)
	public String getReceiveNo() {
		return this.receiveNo;
	}

	public void setReceiveNo(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	@Column(name = "TelNo", length = 15)
	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Column(name = "AddrTypeA", length = 1)
	public String getAddrTypeA() {
		return this.addrTypeA;
	}

	public void setAddrTypeA(String addrTypeA) {
		this.addrTypeA = addrTypeA;
	}

	@Column(name = "CityA", length = 5)
	public String getCityA() {
		return this.cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
	}

	@Column(name = "TownshipA", length = 3)
	public String getTownshipA() {
		return this.townshipA;
	}

	public void setTownshipA(String townshipA) {
		this.townshipA = townshipA;
	}

	@Column(name = "ZipCodeA", length = 5)
	public String getZipCodeA() {
		return this.zipCodeA;
	}

	public void setZipCodeA(String zipCodeA) {
		this.zipCodeA = zipCodeA;
	}

	@Column(name = "VillageA", length = 20)
	public String getVillageA() {
		return this.villageA;
	}

	public void setVillageA(String villageA) {
		this.villageA = villageA;
	}

	@Column(name = "NeighborhoodA", length = 20)
	public String getNeighborhoodA() {
		return this.neighborhoodA;
	}

	public void setNeighborhoodA(String neighborhoodA) {
		this.neighborhoodA = neighborhoodA;
	}

	@Column(name = "RoadA", length = 40)
	public String getRoadA() {
		return this.roadA;
	}

	public void setRoadA(String roadA) {
		this.roadA = roadA;
	}

	@Column(name = "DistrictA", length = 18)
	public String getDistrictA() {
		return this.districtA;
	}

	public void setDistrictA(String districtA) {
		this.districtA = districtA;
	}

	@Column(name = "LaneA", length = 24)
	public String getLaneA() {
		return this.laneA;
	}

	public void setLaneA(String laneA) {
		this.laneA = laneA;
	}

	@Column(name = "AlleyA", length = 20)
	public String getAlleyA() {
		return this.alleyA;
	}

	public void setAlleyA(String alleyA) {
		this.alleyA = alleyA;
	}

	@Column(name = "NumberA", length = 200)
	public String getNumberA() {
		return this.numberA;
	}

	public void setNumberA(String numberA) {
		this.numberA = numberA;
	}

	@Column(name = "TelNoB", length = 15)
	public String getTelNoB() {
		return this.telNoB;
	}

	public void setTelNoB(String telNoB) {
		this.telNoB = telNoB;
	}

	@Column(name = "CityWK", length = 5)
	public String getCityWk() {
		return this.cityWk;
	}

	public void setCityWk(String cityWk) {
		this.cityWk = cityWk;
	}

	@Column(name = "TownshipWK", length = 3)
	public String getTownshipWk() {
		return this.townshipWk;
	}

	public void setTownshipWk(String townshipWk) {
		this.townshipWk = townshipWk;
	}

	@Column(name = "ZipCodeWK", length = 5)
	public String getZipCodeWk() {
		return this.zipCodeWk;
	}

	public void setZipCodeWk(String zipCodeWk) {
		this.zipCodeWk = zipCodeWk;
	}

	@Column(name = "VillageWK", length = 20)
	public String getVillageWk() {
		return this.villageWk;
	}

	public void setVillageWk(String villageWk) {
		this.villageWk = villageWk;
	}

	@Column(name = "NeighborhoodWK", length = 20)
	public String getNeighborhoodWk() {
		return this.neighborhoodWk;
	}

	public void setNeighborhoodWk(String neighborhoodWk) {
		this.neighborhoodWk = neighborhoodWk;
	}

	@Column(name = "RoadWK", length = 40)
	public String getRoadWk() {
		return this.roadWk;
	}

	public void setRoadWk(String roadWk) {
		this.roadWk = roadWk;
	}

	@Column(name = "DistrictWK", length = 18)
	public String getDistrictWk() {
		return this.districtWk;
	}

	public void setDistrictWk(String districtWk) {
		this.districtWk = districtWk;
	}

	@Column(name = "LaneWK", length = 24)
	public String getLaneWk() {
		return this.laneWk;
	}

	public void setLaneWk(String laneWk) {
		this.laneWk = laneWk;
	}

	@Column(name = "AlleyWK", length = 20)
	public String getAlleyWk() {
		return this.alleyWk;
	}

	public void setAlleyWk(String alleyWk) {
		this.alleyWk = alleyWk;
	}

	@Column(name = "NumberWK", length = 200)
	public String getNumberWk() {
		return this.numberWk;
	}

	public void setNumberWk(String numberWk) {
		this.numberWk = numberWk;
	}

	@Column(name = "CreateUserId", length = 10)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "CreateDeptId", length = 4)
	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateTime", length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "MainUserId", length = 10)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainDeptId", length = 4)
	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	@Column(name = "MaintainProgramId", length = 20)
	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	@Column(name = "MaintainHost", length = 25)
	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "FirstReceiveNo", length = 12)
	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	@Column(name = "AddrB", length = 200)
	public String getAddrB() {
		return this.addrB;
	}

	public void setAddrB(String addrB) {
		this.addrB = addrB;
	}

	@Column(name = "InvitedDept", length = 120)
	public String getInvitedDept() {
		return this.invitedDept;
	}

	public void setInvitedDept(String invitedDept) {
		this.invitedDept = invitedDept;
	}

	@Column(name = "ContactName", length = 80)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "ContactTel", length = 20)
	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	@Column(name = "ContactMobile", length = 20)
	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ImportTime", length = 23)
	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	@Column(name = "DeleteFlag", length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "SourceTable", length = 24)
	public String getSourceTable() {
		return this.sourceTable;
	}

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	@Column(name = "TelNoWK", length = 15)
	public String getTelNoWk() {
		return this.telNoWk;
	}

	public void setTelNoWk(String telNoWk) {
		this.telNoWk = telNoWk;
	}

	@Column(name = "TxnMark")
	public Long getTxnMark() {
		return this.txnMark;
	}

	public void setTxnMark(Long txnMark) {
		this.txnMark = txnMark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SyncTime", length = 23)
	public Date getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	@Column(name = "ServiceOfficeCode", length = 4)
	public String getServiceOfficeCode() {
		return this.serviceOfficeCode;
	}

	public void setServiceOfficeCode(String serviceOfficeCode) {
		this.serviceOfficeCode = serviceOfficeCode;
	}

	@Column(name = "ServiceOfficeName", length = 120)
	public String getServiceOfficeName() {
		return this.serviceOfficeName;
	}

	public void setServiceOfficeName(String serviceOfficeName) {
		this.serviceOfficeName = serviceOfficeName;
	}

	@Column(name = "ServiceOfficeTel", length = 15)
	public String getServiceOfficeTel() {
		return this.serviceOfficeTel;
	}

	public void setServiceOfficeTel(String serviceOfficeTel) {
		this.serviceOfficeTel = serviceOfficeTel;
	}

	@Column(name = "JobTitle", length = 40)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "FirstRcEndDate", length = 8)
	public String getFirstRcEndDate() {
		return this.firstRcEndDate;
	}

	public void setFirstRcEndDate(String firstRcEndDate) {
		this.firstRcEndDate = firstRcEndDate;
	}

	@Column(name = "ETLFlag", length = 1)
	public String getEtlflag() {
		return this.etlflag;
	}

	public void setEtlflag(String etlflag) {
		this.etlflag = etlflag;
	}

	@Column(name = "WorkAllowDate", length = 8)
	public String getWorkAllowDate() {
		return this.workAllowDate;
	}

	public void setWorkAllowDate(String workAllowDate) {
		this.workAllowDate = workAllowDate;
	}

	@Column(name = "WorkAllowDept", length = 4)
	public String getWorkAllowDept() {
		return this.workAllowDept;
	}

	public void setWorkAllowDept(String workAllowDept) {
		this.workAllowDept = workAllowDept;
	}

	@Column(name = "WorkAllowDocNo", length = 20)
	public String getWorkAllowDocNo() {
		return this.workAllowDocNo;
	}

	public void setWorkAllowDocNo(String workAllowDocNo) {
		this.workAllowDocNo = workAllowDocNo;
	}

	@Column(name = "WorkAllowEndDate", length = 8)
	public String getWorkAllowEndDate() {
		return this.workAllowEndDate;
	}

	public void setWorkAllowEndDate(String workAllowEndDate) {
		this.workAllowEndDate = workAllowEndDate;
	}

	@Column(name = "WorkAllowStartDate", length = 8)
	public String getWorkAllowStartDate() {
		return this.workAllowStartDate;
	}

	public void setWorkAllowStartDate(String workAllowStartDate) {
		this.workAllowStartDate = workAllowStartDate;
	}

	@Column(name = "EmployDocNo", length = 20)
	public String getEmployDocNo() {
		return this.employDocNo;
	}

	public void setEmployDocNo(String employDocNo) {
		this.employDocNo = employDocNo;
	}

	@Column(name = "ReasonReMark", length = 200)
	public String getReasonReMark() {
		return this.reasonReMark;
	}

	public void setReasonReMark(String reasonReMark) {
		this.reasonReMark = reasonReMark;
	}

	@Column(name = "NoMultiReEntryReasonDesc", length = 200)
	public String getNoMultiReEntryReasonDesc() {
		return this.noMultiReEntryReasonDesc;
	}

	public void setNoMultiReEntryReasonDesc(String noMultiReEntryReasonDesc) {
		this.noMultiReEntryReasonDesc = noMultiReEntryReasonDesc;
	}

	@Column(name = "OtherReasonDescCode", length = 4)
	public String getOtherReasonDescCode() {
		return this.otherReasonDescCode;
	}

	public void setOtherReasonDescCode(String otherReasonDescCode) {
		this.otherReasonDescCode = otherReasonDescCode;
	}

	@Column(name = "OtherReasonDate", length = 8)
	public String getOtherReasonDate() {
		return this.otherReasonDate;
	}

	public void setOtherReasonDate(String otherReasonDate) {
		this.otherReasonDate = otherReasonDate;
	}

}
