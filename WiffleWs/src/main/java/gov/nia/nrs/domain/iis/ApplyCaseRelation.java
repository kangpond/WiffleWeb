package gov.nia.nrs.domain.iis;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ApplyCaseRelation
 */
@Entity
@Table(name = "ApplyCaseRelation")
public class ApplyCaseRelation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String receiveNo;
	private String chineseName;
	private String englishName;
	private String relPeopleBirth;
	private String relPeopleSex;
	private String relNativeCode;
	private String relBirthPlace1;
	private String relBirthPlace2;
	private String relPosition;
	private String relOccupation;
	private String relEducation;
	private String relWorkOrgId;
	private String relOffPosId;
	private String relTel;
	private String relAddrMark;
	private String relAddrType;
	private String relation;
	private String relationIdg;
	private String hospital;
	private String hospitalName;
	private String hospitalDate;
	private String doctorName;
	private String patientRef;
	private String relationIdNo;
	private String relationMobile;
	private String relCity;
	private String relTownship;
	private String relZipCode;
	private String relVillage;
	private String relNeighborhood;
	private String relRoad;
	private String relDistrict;
	private String relLane;
	private String relAlley;
	private String relNumber;
	private String createUserId;
	private String createDeptId;
	private Date createTime;
	private String maintainDeptId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String mainUserId;
	private Date importTime;
	private String deleteFlag;
	private String email;
	private String relRegistTel;
	private String relRegistZipCode;
	private String relRegistCity;
	private String relRegistTownship;
	private String relRegistVillage;
	private String relRegistNeighborhood;
	private String relRegistRoad;
	private String relRegistLane;
	private String relRegistAlley;
	private String relRegistNumber;
	private String nation;
	private String etlflag;
	private String sourceTable;
	private String name0;
	private String name1;
	private String name2;
	private String sortEnglishName;
	private Long txnMark;
	private Date syncTime;

	public ApplyCaseRelation() {
	}

	public ApplyCaseRelation(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	public ApplyCaseRelation(String receiveNo, String chineseName,
			String englishName, String relPeopleBirth, String relPeopleSex,
			String relNativeCode, String relBirthPlace1, String relBirthPlace2,
			String relPosition, String relOccupation, String relEducation,
			String relWorkOrgId, String relOffPosId, String relTel,
			String relAddrMark, String relAddrType, String relation,
			String relationIdg, String hospital, String hospitalName,
			String hospitalDate, String doctorName, String patientRef,
			String relationIdNo, String relationMobile, String relCity,
			String relTownship, String relZipCode, String relVillage,
			String relNeighborhood, String relRoad, String relDistrict,
			String relLane, String relAlley, String relNumber,
			String createUserId, String createDeptId, Date createTime,
			String maintainDeptId, String maintainProgramId,
			String maintainHost, Date lastUpdateTime, String mainUserId,
			Date importTime, String deleteFlag, String email,
			String relRegistTel, String relRegistZipCode, String relRegistCity,
			String relRegistTownship, String relRegistVillage,
			String relRegistNeighborhood, String relRegistRoad,
			String relRegistLane, String relRegistAlley,
			String relRegistNumber, String nation, String etlflag,
			String sourceTable, String name0, String name1, String name2,
			String sortEnglishName, Long txnMark, Date syncTime) {
		this.receiveNo = receiveNo;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.relPeopleBirth = relPeopleBirth;
		this.relPeopleSex = relPeopleSex;
		this.relNativeCode = relNativeCode;
		this.relBirthPlace1 = relBirthPlace1;
		this.relBirthPlace2 = relBirthPlace2;
		this.relPosition = relPosition;
		this.relOccupation = relOccupation;
		this.relEducation = relEducation;
		this.relWorkOrgId = relWorkOrgId;
		this.relOffPosId = relOffPosId;
		this.relTel = relTel;
		this.relAddrMark = relAddrMark;
		this.relAddrType = relAddrType;
		this.relation = relation;
		this.relationIdg = relationIdg;
		this.hospital = hospital;
		this.hospitalName = hospitalName;
		this.hospitalDate = hospitalDate;
		this.doctorName = doctorName;
		this.patientRef = patientRef;
		this.relationIdNo = relationIdNo;
		this.relationMobile = relationMobile;
		this.relCity = relCity;
		this.relTownship = relTownship;
		this.relZipCode = relZipCode;
		this.relVillage = relVillage;
		this.relNeighborhood = relNeighborhood;
		this.relRoad = relRoad;
		this.relDistrict = relDistrict;
		this.relLane = relLane;
		this.relAlley = relAlley;
		this.relNumber = relNumber;
		this.createUserId = createUserId;
		this.createDeptId = createDeptId;
		this.createTime = createTime;
		this.maintainDeptId = maintainDeptId;
		this.maintainProgramId = maintainProgramId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.importTime = importTime;
		this.deleteFlag = deleteFlag;
		this.email = email;
		this.relRegistTel = relRegistTel;
		this.relRegistZipCode = relRegistZipCode;
		this.relRegistCity = relRegistCity;
		this.relRegistTownship = relRegistTownship;
		this.relRegistVillage = relRegistVillage;
		this.relRegistNeighborhood = relRegistNeighborhood;
		this.relRegistRoad = relRegistRoad;
		this.relRegistLane = relRegistLane;
		this.relRegistAlley = relRegistAlley;
		this.relRegistNumber = relRegistNumber;
		this.nation = nation;
		this.etlflag = etlflag;
		this.sourceTable = sourceTable;
		this.name0 = name0;
		this.name1 = name1;
		this.name2 = name2;
		this.sortEnglishName = sortEnglishName;
		this.txnMark = txnMark;
		this.syncTime = syncTime;
	}

	@Id
	@Column(name = "ReceiveNo", unique = true, nullable = false, length = 12)
	public String getReceiveNo() {
		return this.receiveNo;
	}

	public void setReceiveNo(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	@Column(name = "ChineseName", length = 80)
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "EnglishName", length = 50)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "RelPeopleBirth", length = 8)
	public String getRelPeopleBirth() {
		return this.relPeopleBirth;
	}

	public void setRelPeopleBirth(String relPeopleBirth) {
		this.relPeopleBirth = relPeopleBirth;
	}

	@Column(name = "RelPeopleSex", length = 1)
	public String getRelPeopleSex() {
		return this.relPeopleSex;
	}

	public void setRelPeopleSex(String relPeopleSex) {
		this.relPeopleSex = relPeopleSex;
	}

	@Column(name = "RelNativeCode", length = 1)
	public String getRelNativeCode() {
		return this.relNativeCode;
	}

	public void setRelNativeCode(String relNativeCode) {
		this.relNativeCode = relNativeCode;
	}

	@Column(name = "RelBirthPlace1", length = 4)
	public String getRelBirthPlace1() {
		return this.relBirthPlace1;
	}

	public void setRelBirthPlace1(String relBirthPlace1) {
		this.relBirthPlace1 = relBirthPlace1;
	}

	@Column(name = "RelBirthPlace2", length = 16)
	public String getRelBirthPlace2() {
		return this.relBirthPlace2;
	}

	public void setRelBirthPlace2(String relBirthPlace2) {
		this.relBirthPlace2 = relBirthPlace2;
	}

	@Column(name = "RelPosition", length = 2)
	public String getRelPosition() {
		return this.relPosition;
	}

	public void setRelPosition(String relPosition) {
		this.relPosition = relPosition;
	}

	@Column(name = "RelOccupation", length = 1)
	public String getRelOccupation() {
		return this.relOccupation;
	}

	public void setRelOccupation(String relOccupation) {
		this.relOccupation = relOccupation;
	}

	@Column(name = "RelEducation", length = 1)
	public String getRelEducation() {
		return this.relEducation;
	}

	public void setRelEducation(String relEducation) {
		this.relEducation = relEducation;
	}

	@Column(name = "RelWorkOrgId", length = 60)
	public String getRelWorkOrgId() {
		return this.relWorkOrgId;
	}

	public void setRelWorkOrgId(String relWorkOrgId) {
		this.relWorkOrgId = relWorkOrgId;
	}

	@Column(name = "RelOffPosId", length = 20)
	public String getRelOffPosId() {
		return this.relOffPosId;
	}

	public void setRelOffPosId(String relOffPosId) {
		this.relOffPosId = relOffPosId;
	}

	@Column(name = "RelTel", length = 20)
	public String getRelTel() {
		return this.relTel;
	}

	public void setRelTel(String relTel) {
		this.relTel = relTel;
	}

	@Column(name = "RelAddrMark", length = 1)
	public String getRelAddrMark() {
		return this.relAddrMark;
	}

	public void setRelAddrMark(String relAddrMark) {
		this.relAddrMark = relAddrMark;
	}

	@Column(name = "RelAddrType", length = 1)
	public String getRelAddrType() {
		return this.relAddrType;
	}

	public void setRelAddrType(String relAddrType) {
		this.relAddrType = relAddrType;
	}

	@Column(name = "Relation", length = 2)
	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Column(name = "RelationIDG", length = 28)
	public String getRelationIdg() {
		return this.relationIdg;
	}

	public void setRelationIdg(String relationIdg) {
		this.relationIdg = relationIdg;
	}

	@Column(name = "Hospital", length = 2)
	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "HospitalName", length = 48)
	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Column(name = "HospitalDate", length = 8)
	public String getHospitalDate() {
		return this.hospitalDate;
	}

	public void setHospitalDate(String hospitalDate) {
		this.hospitalDate = hospitalDate;
	}

	@Column(name = "DoctorName", length = 80)
	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "PatientRef", length = 80)
	public String getPatientRef() {
		return this.patientRef;
	}

	public void setPatientRef(String patientRef) {
		this.patientRef = patientRef;
	}

	@Column(name = "RelationIdNo", length = 15)
	public String getRelationIdNo() {
		return this.relationIdNo;
	}

	public void setRelationIdNo(String relationIdNo) {
		this.relationIdNo = relationIdNo;
	}

	@Column(name = "RelationMobile", length = 20)
	public String getRelationMobile() {
		return this.relationMobile;
	}

	public void setRelationMobile(String relationMobile) {
		this.relationMobile = relationMobile;
	}

	@Column(name = "RelCity", length = 5)
	public String getRelCity() {
		return this.relCity;
	}

	public void setRelCity(String relCity) {
		this.relCity = relCity;
	}

	@Column(name = "RelTownship", length = 3)
	public String getRelTownship() {
		return this.relTownship;
	}

	public void setRelTownship(String relTownship) {
		this.relTownship = relTownship;
	}

	@Column(name = "RelZipCode", length = 5)
	public String getRelZipCode() {
		return this.relZipCode;
	}

	public void setRelZipCode(String relZipCode) {
		this.relZipCode = relZipCode;
	}

	@Column(name = "RelVillage", length = 20)
	public String getRelVillage() {
		return this.relVillage;
	}

	public void setRelVillage(String relVillage) {
		this.relVillage = relVillage;
	}

	@Column(name = "RelNeighborhood", length = 20)
	public String getRelNeighborhood() {
		return this.relNeighborhood;
	}

	public void setRelNeighborhood(String relNeighborhood) {
		this.relNeighborhood = relNeighborhood;
	}

	@Column(name = "RelRoad", length = 40)
	public String getRelRoad() {
		return this.relRoad;
	}

	public void setRelRoad(String relRoad) {
		this.relRoad = relRoad;
	}

	@Column(name = "RelDistrict", length = 18)
	public String getRelDistrict() {
		return this.relDistrict;
	}

	public void setRelDistrict(String relDistrict) {
		this.relDistrict = relDistrict;
	}

	@Column(name = "RelLane", length = 24)
	public String getRelLane() {
		return this.relLane;
	}

	public void setRelLane(String relLane) {
		this.relLane = relLane;
	}

	@Column(name = "RelAlley", length = 20)
	public String getRelAlley() {
		return this.relAlley;
	}

	public void setRelAlley(String relAlley) {
		this.relAlley = relAlley;
	}

	@Column(name = "RelNumber", length = 200)
	public String getRelNumber() {
		return this.relNumber;
	}

	public void setRelNumber(String relNumber) {
		this.relNumber = relNumber;
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

	@Column(name = "MainUserId", length = 10)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
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

	@Column(name = "Email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "RelRegistTel", length = 15)
	public String getRelRegistTel() {
		return this.relRegistTel;
	}

	public void setRelRegistTel(String relRegistTel) {
		this.relRegistTel = relRegistTel;
	}

	@Column(name = "RelRegistZipCode", length = 5)
	public String getRelRegistZipCode() {
		return this.relRegistZipCode;
	}

	public void setRelRegistZipCode(String relRegistZipCode) {
		this.relRegistZipCode = relRegistZipCode;
	}

	@Column(name = "RelRegistCity", length = 5)
	public String getRelRegistCity() {
		return this.relRegistCity;
	}

	public void setRelRegistCity(String relRegistCity) {
		this.relRegistCity = relRegistCity;
	}

	@Column(name = "RelRegistTownship", length = 3)
	public String getRelRegistTownship() {
		return this.relRegistTownship;
	}

	public void setRelRegistTownship(String relRegistTownship) {
		this.relRegistTownship = relRegistTownship;
	}

	@Column(name = "RelRegistVillage", length = 12)
	public String getRelRegistVillage() {
		return this.relRegistVillage;
	}

	public void setRelRegistVillage(String relRegistVillage) {
		this.relRegistVillage = relRegistVillage;
	}

	@Column(name = "RelRegistNeighborhood", length = 3)
	public String getRelRegistNeighborhood() {
		return this.relRegistNeighborhood;
	}

	public void setRelRegistNeighborhood(String relRegistNeighborhood) {
		this.relRegistNeighborhood = relRegistNeighborhood;
	}

	@Column(name = "RelRegistRoad", length = 30)
	public String getRelRegistRoad() {
		return this.relRegistRoad;
	}

	public void setRelRegistRoad(String relRegistRoad) {
		this.relRegistRoad = relRegistRoad;
	}

	@Column(name = "RelRegistLane", length = 18)
	public String getRelRegistLane() {
		return this.relRegistLane;
	}

	public void setRelRegistLane(String relRegistLane) {
		this.relRegistLane = relRegistLane;
	}

	@Column(name = "RelRegistAlley", length = 12)
	public String getRelRegistAlley() {
		return this.relRegistAlley;
	}

	public void setRelRegistAlley(String relRegistAlley) {
		this.relRegistAlley = relRegistAlley;
	}

	@Column(name = "RelRegistNumber", length = 60)
	public String getRelRegistNumber() {
		return this.relRegistNumber;
	}

	public void setRelRegistNumber(String relRegistNumber) {
		this.relRegistNumber = relRegistNumber;
	}

	@Column(name = "Nation", length = 3)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "ETLFlag", length = 1)
	public String getEtlflag() {
		return this.etlflag;
	}

	public void setEtlflag(String etlflag) {
		this.etlflag = etlflag;
	}

	@Column(name = "SourceTable", length = 24)
	public String getSourceTable() {
		return this.sourceTable;
	}

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	@Column(name = "Name0", length = 68)
	public String getName0() {
		return this.name0;
	}

	public void setName0(String name0) {
		this.name0 = name0;
	}

	@Column(name = "Name1", length = 4)
	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	@Column(name = "Name2", length = 8)
	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Column(name = "SortEnglishName", length = 100)
	public String getSortEnglishName() {
		return this.sortEnglishName;
	}

	public void setSortEnglishName(String sortEnglishName) {
		this.sortEnglishName = sortEnglishName;
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

}
