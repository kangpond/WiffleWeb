package gov.nia.nrs.domain.iis;

import java.util.Date;

/**
 * HouseholdMarriage
 */
public class HouseholdMarriage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private HouseholdMarriageId id;
	private String chineseName;
	private String birthDate;
	private String applyDate;
	private String indigenousPosition;
	private String indigenousGroup;
	private String englishName;
	private String foreignPassportNo;
	private String foreignNation;
	private String foreignNationCode;
	private String birthCode;
	private String beforeMarrCode;
	private String fatherName;
	private String motherName;
	private String fosterFatherName;
	private String fosterMotherName;
	private String education;
	private String familyHeadName;
	private String familyHeadRln;
	private String addr1;
	private String addr2;
	private String addr3;
	private String addr4;
	private String spousePersonId;
	private String marrageDate;
	private String divorceDate;
	private String divorceType;
	private String remark1;
	private String remark2;
	private String apply1name;
	private String apply2name;
	private String apply1personId;
	private String apply2personId;
	private String reason1;
	private String reason2;
	private String entrustPersonId;
	private String headPersonId;
	private Integer apply1zipCode;
	private String apply1addr1;
	private String apply1addr2;
	private String apply1addr3;
	private String apply1addr4;
	private Integer apply2zipCode;
	private String apply2addr1;
	private String apply2addr2;
	private String apply2addr3;
	private String apply2addr4;
	private String revokeReason;
	private String revokeDate;
	private String uploadDate;
	private String uploadTime;
	private String residentNo;
	private Date establishTime;
	private Date importTime;
	private String deleteFlag;
	private String mainUserId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String alleyA;
	private String apply1alleyA;
	private String apply1cityA;
	private String apply1districtA;
	private String apply1laneA;
	private String apply1neighborhoodA;
	private String apply1numberA;
	private String apply1roadA;
	private String apply1townshipA;
	private String apply1villageA;
	private String apply1zipCodeA;
	private String apply2alleyA;
	private String apply2cityA;
	private String apply2districtA;
	private String apply2laneA;
	private String apply2neighborhoodA;
	private String apply2numberA;
	private String apply2roadA;
	private String apply2townshipA;
	private String apply2villageA;
	private String apply2zipCodeA;
	private String cityA;
	private String createDeptId;
	private Date createTime;
	private String createUserId;
	private String districtA;
	private String laneA;
	private String maintainDeptId;
	private String neighborhoodA;
	private String numberA;
	private String postNo;
	private String roadA;
	private String townshipA;
	private String villageA;
	private String zipCodeA;
	private String importFileName;
	private Long txnMark;
	private Date syncTime;
	private String importFileNameUpd;
	private String importFileNameIns;
	private String importFileNameDel;
	private Date importFileTimeUpd;
	private Date importFileTimeIns;
	private Date importFileTimeDel;

	public HouseholdMarriage() {
	}

	public HouseholdMarriage(HouseholdMarriageId id, String deleteFlag,
			String mainUserId, String maintainProgramId, String maintainHost,
			Date lastUpdateTime) {
		this.id = id;
		this.deleteFlag = deleteFlag;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
	}

	public HouseholdMarriage(HouseholdMarriageId id, String chineseName,
			String birthDate, String applyDate, String indigenousPosition,
			String indigenousGroup, String englishName,
			String foreignPassportNo, String foreignNation,
			String foreignNationCode, String birthCode, String beforeMarrCode,
			String fatherName, String motherName, String fosterFatherName,
			String fosterMotherName, String education, String familyHeadName,
			String familyHeadRln, String addr1, String addr2, String addr3,
			String addr4, String spousePersonId, String marrageDate,
			String divorceDate, String divorceType, String remark1,
			String remark2, String apply1name, String apply2name,
			String apply1personId, String apply2personId, String reason1,
			String reason2, String entrustPersonId, String headPersonId,
			Integer apply1zipCode, String apply1addr1, String apply1addr2,
			String apply1addr3, String apply1addr4, Integer apply2zipCode,
			String apply2addr1, String apply2addr2, String apply2addr3,
			String apply2addr4, String revokeReason, String revokeDate,
			String uploadDate, String uploadTime, String residentNo,
			Date establishTime, Date importTime, String deleteFlag,
			String mainUserId, String maintainProgramId, String maintainHost,
			Date lastUpdateTime, String alleyA, String apply1alleyA,
			String apply1cityA, String apply1districtA, String apply1laneA,
			String apply1neighborhoodA, String apply1numberA,
			String apply1roadA, String apply1townshipA, String apply1villageA,
			String apply1zipCodeA, String apply2alleyA, String apply2cityA,
			String apply2districtA, String apply2laneA,
			String apply2neighborhoodA, String apply2numberA,
			String apply2roadA, String apply2townshipA, String apply2villageA,
			String apply2zipCodeA, String cityA, String createDeptId,
			Date createTime, String createUserId, String districtA,
			String laneA, String maintainDeptId, String neighborhoodA,
			String numberA, String postNo, String roadA, String townshipA,
			String villageA, String zipCodeA, String importFileName,
			Long txnMark, Date syncTime, String importFileNameUpd,
			String importFileNameIns, String importFileNameDel,
			Date importFileTimeUpd, Date importFileTimeIns,
			Date importFileTimeDel) {
		this.id = id;
		this.chineseName = chineseName;
		this.birthDate = birthDate;
		this.applyDate = applyDate;
		this.indigenousPosition = indigenousPosition;
		this.indigenousGroup = indigenousGroup;
		this.englishName = englishName;
		this.foreignPassportNo = foreignPassportNo;
		this.foreignNation = foreignNation;
		this.foreignNationCode = foreignNationCode;
		this.birthCode = birthCode;
		this.beforeMarrCode = beforeMarrCode;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fosterFatherName = fosterFatherName;
		this.fosterMotherName = fosterMotherName;
		this.education = education;
		this.familyHeadName = familyHeadName;
		this.familyHeadRln = familyHeadRln;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.spousePersonId = spousePersonId;
		this.marrageDate = marrageDate;
		this.divorceDate = divorceDate;
		this.divorceType = divorceType;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.apply1name = apply1name;
		this.apply2name = apply2name;
		this.apply1personId = apply1personId;
		this.apply2personId = apply2personId;
		this.reason1 = reason1;
		this.reason2 = reason2;
		this.entrustPersonId = entrustPersonId;
		this.headPersonId = headPersonId;
		this.apply1zipCode = apply1zipCode;
		this.apply1addr1 = apply1addr1;
		this.apply1addr2 = apply1addr2;
		this.apply1addr3 = apply1addr3;
		this.apply1addr4 = apply1addr4;
		this.apply2zipCode = apply2zipCode;
		this.apply2addr1 = apply2addr1;
		this.apply2addr2 = apply2addr2;
		this.apply2addr3 = apply2addr3;
		this.apply2addr4 = apply2addr4;
		this.revokeReason = revokeReason;
		this.revokeDate = revokeDate;
		this.uploadDate = uploadDate;
		this.uploadTime = uploadTime;
		this.residentNo = residentNo;
		this.establishTime = establishTime;
		this.importTime = importTime;
		this.deleteFlag = deleteFlag;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.maintainHost = maintainHost;
		this.lastUpdateTime = lastUpdateTime;
		this.alleyA = alleyA;
		this.apply1alleyA = apply1alleyA;
		this.apply1cityA = apply1cityA;
		this.apply1districtA = apply1districtA;
		this.apply1laneA = apply1laneA;
		this.apply1neighborhoodA = apply1neighborhoodA;
		this.apply1numberA = apply1numberA;
		this.apply1roadA = apply1roadA;
		this.apply1townshipA = apply1townshipA;
		this.apply1villageA = apply1villageA;
		this.apply1zipCodeA = apply1zipCodeA;
		this.apply2alleyA = apply2alleyA;
		this.apply2cityA = apply2cityA;
		this.apply2districtA = apply2districtA;
		this.apply2laneA = apply2laneA;
		this.apply2neighborhoodA = apply2neighborhoodA;
		this.apply2numberA = apply2numberA;
		this.apply2roadA = apply2roadA;
		this.apply2townshipA = apply2townshipA;
		this.apply2villageA = apply2villageA;
		this.apply2zipCodeA = apply2zipCodeA;
		this.cityA = cityA;
		this.createDeptId = createDeptId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.districtA = districtA;
		this.laneA = laneA;
		this.maintainDeptId = maintainDeptId;
		this.neighborhoodA = neighborhoodA;
		this.numberA = numberA;
		this.postNo = postNo;
		this.roadA = roadA;
		this.townshipA = townshipA;
		this.villageA = villageA;
		this.zipCodeA = zipCodeA;
		this.importFileName = importFileName;
		this.txnMark = txnMark;
		this.syncTime = syncTime;
		this.importFileNameUpd = importFileNameUpd;
		this.importFileNameIns = importFileNameIns;
		this.importFileNameDel = importFileNameDel;
		this.importFileTimeUpd = importFileTimeUpd;
		this.importFileTimeIns = importFileTimeIns;
		this.importFileTimeDel = importFileTimeDel;
	}

	public HouseholdMarriageId getId() {
		return this.id;
	}

	public void setId(HouseholdMarriageId id) {
		this.id = id;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getIndigenousPosition() {
		return this.indigenousPosition;
	}

	public void setIndigenousPosition(String indigenousPosition) {
		this.indigenousPosition = indigenousPosition;
	}

	public String getIndigenousGroup() {
		return this.indigenousGroup;
	}

	public void setIndigenousGroup(String indigenousGroup) {
		this.indigenousGroup = indigenousGroup;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getForeignPassportNo() {
		return this.foreignPassportNo;
	}

	public void setForeignPassportNo(String foreignPassportNo) {
		this.foreignPassportNo = foreignPassportNo;
	}

	public String getForeignNation() {
		return this.foreignNation;
	}

	public void setForeignNation(String foreignNation) {
		this.foreignNation = foreignNation;
	}

	public String getForeignNationCode() {
		return this.foreignNationCode;
	}

	public void setForeignNationCode(String foreignNationCode) {
		this.foreignNationCode = foreignNationCode;
	}

	public String getBirthCode() {
		return this.birthCode;
	}

	public void setBirthCode(String birthCode) {
		this.birthCode = birthCode;
	}

	public String getBeforeMarrCode() {
		return this.beforeMarrCode;
	}

	public void setBeforeMarrCode(String beforeMarrCode) {
		this.beforeMarrCode = beforeMarrCode;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFosterFatherName() {
		return this.fosterFatherName;
	}

	public void setFosterFatherName(String fosterFatherName) {
		this.fosterFatherName = fosterFatherName;
	}

	public String getFosterMotherName() {
		return this.fosterMotherName;
	}

	public void setFosterMotherName(String fosterMotherName) {
		this.fosterMotherName = fosterMotherName;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getFamilyHeadName() {
		return this.familyHeadName;
	}

	public void setFamilyHeadName(String familyHeadName) {
		this.familyHeadName = familyHeadName;
	}

	public String getFamilyHeadRln() {
		return this.familyHeadRln;
	}

	public void setFamilyHeadRln(String familyHeadRln) {
		this.familyHeadRln = familyHeadRln;
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return this.addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return this.addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getSpousePersonId() {
		return this.spousePersonId;
	}

	public void setSpousePersonId(String spousePersonId) {
		this.spousePersonId = spousePersonId;
	}

	public String getMarrageDate() {
		return this.marrageDate;
	}

	public void setMarrageDate(String marrageDate) {
		this.marrageDate = marrageDate;
	}

	public String getDivorceDate() {
		return this.divorceDate;
	}

	public void setDivorceDate(String divorceDate) {
		this.divorceDate = divorceDate;
	}

	public String getDivorceType() {
		return this.divorceType;
	}

	public void setDivorceType(String divorceType) {
		this.divorceType = divorceType;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getApply1name() {
		return this.apply1name;
	}

	public void setApply1name(String apply1name) {
		this.apply1name = apply1name;
	}

	public String getApply2name() {
		return this.apply2name;
	}

	public void setApply2name(String apply2name) {
		this.apply2name = apply2name;
	}

	public String getApply1personId() {
		return this.apply1personId;
	}

	public void setApply1personId(String apply1personId) {
		this.apply1personId = apply1personId;
	}

	public String getApply2personId() {
		return this.apply2personId;
	}

	public void setApply2personId(String apply2personId) {
		this.apply2personId = apply2personId;
	}

	public String getReason1() {
		return this.reason1;
	}

	public void setReason1(String reason1) {
		this.reason1 = reason1;
	}

	public String getReason2() {
		return this.reason2;
	}

	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}

	public String getEntrustPersonId() {
		return this.entrustPersonId;
	}

	public void setEntrustPersonId(String entrustPersonId) {
		this.entrustPersonId = entrustPersonId;
	}

	public String getHeadPersonId() {
		return this.headPersonId;
	}

	public void setHeadPersonId(String headPersonId) {
		this.headPersonId = headPersonId;
	}

	public Integer getApply1zipCode() {
		return this.apply1zipCode;
	}

	public void setApply1zipCode(Integer apply1zipCode) {
		this.apply1zipCode = apply1zipCode;
	}

	public String getApply1addr1() {
		return this.apply1addr1;
	}

	public void setApply1addr1(String apply1addr1) {
		this.apply1addr1 = apply1addr1;
	}

	public String getApply1addr2() {
		return this.apply1addr2;
	}

	public void setApply1addr2(String apply1addr2) {
		this.apply1addr2 = apply1addr2;
	}

	public String getApply1addr3() {
		return this.apply1addr3;
	}

	public void setApply1addr3(String apply1addr3) {
		this.apply1addr3 = apply1addr3;
	}

	public String getApply1addr4() {
		return this.apply1addr4;
	}

	public void setApply1addr4(String apply1addr4) {
		this.apply1addr4 = apply1addr4;
	}

	public Integer getApply2zipCode() {
		return this.apply2zipCode;
	}

	public void setApply2zipCode(Integer apply2zipCode) {
		this.apply2zipCode = apply2zipCode;
	}

	public String getApply2addr1() {
		return this.apply2addr1;
	}

	public void setApply2addr1(String apply2addr1) {
		this.apply2addr1 = apply2addr1;
	}

	public String getApply2addr2() {
		return this.apply2addr2;
	}

	public void setApply2addr2(String apply2addr2) {
		this.apply2addr2 = apply2addr2;
	}

	public String getApply2addr3() {
		return this.apply2addr3;
	}

	public void setApply2addr3(String apply2addr3) {
		this.apply2addr3 = apply2addr3;
	}

	public String getApply2addr4() {
		return this.apply2addr4;
	}

	public void setApply2addr4(String apply2addr4) {
		this.apply2addr4 = apply2addr4;
	}

	public String getRevokeReason() {
		return this.revokeReason;
	}

	public void setRevokeReason(String revokeReason) {
		this.revokeReason = revokeReason;
	}

	public String getRevokeDate() {
		return this.revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = revokeDate;
	}

	public String getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getResidentNo() {
		return this.residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public Date getEstablishTime() {
		return this.establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
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

	public String getAlleyA() {
		return this.alleyA;
	}

	public void setAlleyA(String alleyA) {
		this.alleyA = alleyA;
	}

	public String getApply1alleyA() {
		return this.apply1alleyA;
	}

	public void setApply1alleyA(String apply1alleyA) {
		this.apply1alleyA = apply1alleyA;
	}

	public String getApply1cityA() {
		return this.apply1cityA;
	}

	public void setApply1cityA(String apply1cityA) {
		this.apply1cityA = apply1cityA;
	}

	public String getApply1districtA() {
		return this.apply1districtA;
	}

	public void setApply1districtA(String apply1districtA) {
		this.apply1districtA = apply1districtA;
	}

	public String getApply1laneA() {
		return this.apply1laneA;
	}

	public void setApply1laneA(String apply1laneA) {
		this.apply1laneA = apply1laneA;
	}

	public String getApply1neighborhoodA() {
		return this.apply1neighborhoodA;
	}

	public void setApply1neighborhoodA(String apply1neighborhoodA) {
		this.apply1neighborhoodA = apply1neighborhoodA;
	}

	public String getApply1numberA() {
		return this.apply1numberA;
	}

	public void setApply1numberA(String apply1numberA) {
		this.apply1numberA = apply1numberA;
	}

	public String getApply1roadA() {
		return this.apply1roadA;
	}

	public void setApply1roadA(String apply1roadA) {
		this.apply1roadA = apply1roadA;
	}

	public String getApply1townshipA() {
		return this.apply1townshipA;
	}

	public void setApply1townshipA(String apply1townshipA) {
		this.apply1townshipA = apply1townshipA;
	}

	public String getApply1villageA() {
		return this.apply1villageA;
	}

	public void setApply1villageA(String apply1villageA) {
		this.apply1villageA = apply1villageA;
	}

	public String getApply1zipCodeA() {
		return this.apply1zipCodeA;
	}

	public void setApply1zipCodeA(String apply1zipCodeA) {
		this.apply1zipCodeA = apply1zipCodeA;
	}

	public String getApply2alleyA() {
		return this.apply2alleyA;
	}

	public void setApply2alleyA(String apply2alleyA) {
		this.apply2alleyA = apply2alleyA;
	}

	public String getApply2cityA() {
		return this.apply2cityA;
	}

	public void setApply2cityA(String apply2cityA) {
		this.apply2cityA = apply2cityA;
	}

	public String getApply2districtA() {
		return this.apply2districtA;
	}

	public void setApply2districtA(String apply2districtA) {
		this.apply2districtA = apply2districtA;
	}

	public String getApply2laneA() {
		return this.apply2laneA;
	}

	public void setApply2laneA(String apply2laneA) {
		this.apply2laneA = apply2laneA;
	}

	public String getApply2neighborhoodA() {
		return this.apply2neighborhoodA;
	}

	public void setApply2neighborhoodA(String apply2neighborhoodA) {
		this.apply2neighborhoodA = apply2neighborhoodA;
	}

	public String getApply2numberA() {
		return this.apply2numberA;
	}

	public void setApply2numberA(String apply2numberA) {
		this.apply2numberA = apply2numberA;
	}

	public String getApply2roadA() {
		return this.apply2roadA;
	}

	public void setApply2roadA(String apply2roadA) {
		this.apply2roadA = apply2roadA;
	}

	public String getApply2townshipA() {
		return this.apply2townshipA;
	}

	public void setApply2townshipA(String apply2townshipA) {
		this.apply2townshipA = apply2townshipA;
	}

	public String getApply2villageA() {
		return this.apply2villageA;
	}

	public void setApply2villageA(String apply2villageA) {
		this.apply2villageA = apply2villageA;
	}

	public String getApply2zipCodeA() {
		return this.apply2zipCodeA;
	}

	public void setApply2zipCodeA(String apply2zipCodeA) {
		this.apply2zipCodeA = apply2zipCodeA;
	}

	public String getCityA() {
		return this.cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
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

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getDistrictA() {
		return this.districtA;
	}

	public void setDistrictA(String districtA) {
		this.districtA = districtA;
	}

	public String getLaneA() {
		return this.laneA;
	}

	public void setLaneA(String laneA) {
		this.laneA = laneA;
	}

	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	public String getNeighborhoodA() {
		return this.neighborhoodA;
	}

	public void setNeighborhoodA(String neighborhoodA) {
		this.neighborhoodA = neighborhoodA;
	}

	public String getNumberA() {
		return this.numberA;
	}

	public void setNumberA(String numberA) {
		this.numberA = numberA;
	}

	public String getPostNo() {
		return this.postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getRoadA() {
		return this.roadA;
	}

	public void setRoadA(String roadA) {
		this.roadA = roadA;
	}

	public String getTownshipA() {
		return this.townshipA;
	}

	public void setTownshipA(String townshipA) {
		this.townshipA = townshipA;
	}

	public String getVillageA() {
		return this.villageA;
	}

	public void setVillageA(String villageA) {
		this.villageA = villageA;
	}

	public String getZipCodeA() {
		return this.zipCodeA;
	}

	public void setZipCodeA(String zipCodeA) {
		this.zipCodeA = zipCodeA;
	}

	public String getImportFileName() {
		return this.importFileName;
	}

	public void setImportFileName(String importFileName) {
		this.importFileName = importFileName;
	}

	public Long getTxnMark() {
		return this.txnMark;
	}

	public void setTxnMark(Long txnMark) {
		this.txnMark = txnMark;
	}

	public Date getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getImportFileNameUpd() {
		return this.importFileNameUpd;
	}

	public void setImportFileNameUpd(String importFileNameUpd) {
		this.importFileNameUpd = importFileNameUpd;
	}

	public String getImportFileNameIns() {
		return this.importFileNameIns;
	}

	public void setImportFileNameIns(String importFileNameIns) {
		this.importFileNameIns = importFileNameIns;
	}

	public String getImportFileNameDel() {
		return this.importFileNameDel;
	}

	public void setImportFileNameDel(String importFileNameDel) {
		this.importFileNameDel = importFileNameDel;
	}

	public Date getImportFileTimeUpd() {
		return this.importFileTimeUpd;
	}

	public void setImportFileTimeUpd(Date importFileTimeUpd) {
		this.importFileTimeUpd = importFileTimeUpd;
	}

	public Date getImportFileTimeIns() {
		return this.importFileTimeIns;
	}

	public void setImportFileTimeIns(Date importFileTimeIns) {
		this.importFileTimeIns = importFileTimeIns;
	}

	public Date getImportFileTimeDel() {
		return this.importFileTimeDel;
	}

	public void setImportFileTimeDel(Date importFileTimeDel) {
		this.importFileTimeDel = importFileTimeDel;
	}

}
