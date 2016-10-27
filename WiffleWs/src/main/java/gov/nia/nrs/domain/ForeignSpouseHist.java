package gov.nia.nrs.domain;



import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ForeignSpouseHist
 */
@Entity
@Table(name="ForeignSpouseHist"
)
public class ForeignSpouseHist  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ForeignSpouseHistId id;
    private String residentIdNo1;
    private String personId;
    private String chineseName;
    private String englishName;
    private String gender;
    private String birthDate;
    private Integer occupation;
    private String education;
    private String nativeCode;
    private String birthPlace1;
    private String birthPlace2;
    private Integer nation;
    private String latestReceiveNo;
    private String applyDate;
    private String decideDate;
    private String lossMark;
    private String exitExpiryDate;
    private String foreignPassportNo;
    private Integer position;
    private Integer reason;
    private String mainlandIdNo;
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
    private String telA;
    private String entryDate;
    private String exitDate;
    private String deadMark;
    private String marry;
    private String marryDate;
    private String risNote;
    private String risNoteDate;
    private String fsType;
    private String sourceTable;
    private String spouseStatus;
    private String residenceStatus;
    private String twSpousePersonId;
    private String twSpouseChineseName;
    private String twSpouseBirthDate;
    private String twSpouseNote;
    private String patchFlag;
    private String compareFlag;
    private Integer childNum;
    private Integer age;
    private Integer twSpouseAge;
    private Integer ageDiff;
    private String processDate;
    private String deleteFlag;
    private String createUserId;
    private String createProgramId;
    private Date createTime;
    private String maintainHost;
    private String mainUserId;
    private String maintainProgramId;
    private Date lastUpdateTime;

    public ForeignSpouseHist() {}

	
    public ForeignSpouseHist(ForeignSpouseHistId id, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.id = id;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
    public ForeignSpouseHist(ForeignSpouseHistId id, String residentIdNo1, String personId, String chineseName, String englishName, String gender, String birthDate, Integer occupation, String education, String nativeCode, String birthPlace1, String birthPlace2, Integer nation, String latestReceiveNo, String applyDate, String decideDate, String lossMark, String exitExpiryDate, String foreignPassportNo, Integer position, Integer reason, String mainlandIdNo, String cityA, String townshipA, String zipCodeA, String villageA, String neighborhoodA, String roadA, String districtA, String laneA, String alleyA, String numberA, String telA, String entryDate, String exitDate, String deadMark, String marry, String marryDate, String risNote, String risNoteDate, String fsType, String sourceTable, String spouseStatus, String residenceStatus, String twSpousePersonId, String twSpouseChineseName, String twSpouseBirthDate, String twSpouseNote, String patchFlag, String compareFlag, Integer childNum, Integer age, Integer twSpouseAge, Integer ageDiff, String processDate, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.id = id;
        this.residentIdNo1 = residentIdNo1;
        this.personId = personId;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.education = education;
        this.nativeCode = nativeCode;
        this.birthPlace1 = birthPlace1;
        this.birthPlace2 = birthPlace2;
        this.nation = nation;
        this.latestReceiveNo = latestReceiveNo;
        this.applyDate = applyDate;
        this.decideDate = decideDate;
        this.lossMark = lossMark;
        this.exitExpiryDate = exitExpiryDate;
        this.foreignPassportNo = foreignPassportNo;
        this.position = position;
        this.reason = reason;
        this.mainlandIdNo = mainlandIdNo;
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
        this.telA = telA;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.deadMark = deadMark;
        this.marry = marry;
        this.marryDate = marryDate;
        this.risNote = risNote;
        this.risNoteDate = risNoteDate;
        this.fsType = fsType;
        this.sourceTable = sourceTable;
        this.spouseStatus = spouseStatus;
        this.residenceStatus = residenceStatus;
        this.twSpousePersonId = twSpousePersonId;
        this.twSpouseChineseName = twSpouseChineseName;
        this.twSpouseBirthDate = twSpouseBirthDate;
        this.twSpouseNote = twSpouseNote;
        this.patchFlag = patchFlag;
        this.compareFlag = compareFlag;
        this.childNum = childNum;
        this.age = age;
        this.twSpouseAge = twSpouseAge;
        this.ageDiff = ageDiff;
        this.processDate = processDate;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="year", column=@Column(name="Year", nullable=false, length=4) ), 
        @AttributeOverride(name="month", column=@Column(name="Month", nullable=false, length=2) ), 
        @AttributeOverride(name="firstReceiveNo", column=@Column(name="FirstReceiveNo", nullable=false, length=12) ), 
        @AttributeOverride(name="residentIdNo", column=@Column(name="ResidentIdNo", nullable=false, length=10) ) } )
    public ForeignSpouseHistId getId() {
        return this.id;
    }
    
    public void setId(ForeignSpouseHistId id) {
        this.id = id;
    }

    
    @Column(name="ResidentIdNo1", length=10)
    public String getResidentIdNo1() {
        return this.residentIdNo1;
    }
    
    public void setResidentIdNo1(String residentIdNo1) {
        this.residentIdNo1 = residentIdNo1;
    }

    
    @Column(name="PersonId", length=15)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    
    @Column(name="ChineseName")
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    
    @Column(name="EnglishName", length=80)
    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    
    @Column(name="Gender", length=1)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="BirthDate", length=8)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="Occupation", precision=4, scale=0)
    public Integer getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    
    @Column(name="Education", length=4)
    public String getEducation() {
        return this.education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }

    
    @Column(name="NativeCode", length=1)
    public String getNativeCode() {
        return this.nativeCode;
    }
    
    public void setNativeCode(String nativeCode) {
        this.nativeCode = nativeCode;
    }

    
    @Column(name="BirthPlace1", length=4)
    public String getBirthPlace1() {
        return this.birthPlace1;
    }
    
    public void setBirthPlace1(String birthPlace1) {
        this.birthPlace1 = birthPlace1;
    }

    
    @Column(name="BirthPlace2", length=16)
    public String getBirthPlace2() {
        return this.birthPlace2;
    }
    
    public void setBirthPlace2(String birthPlace2) {
        this.birthPlace2 = birthPlace2;
    }

    
    @Column(name="Nation", precision=3, scale=0)
    public Integer getNation() {
        return this.nation;
    }
    
    public void setNation(Integer nation) {
        this.nation = nation;
    }

    
    @Column(name="LatestReceiveNo", length=12)
    public String getLatestReceiveNo() {
        return this.latestReceiveNo;
    }
    
    public void setLatestReceiveNo(String latestReceiveNo) {
        this.latestReceiveNo = latestReceiveNo;
    }

    
    @Column(name="ApplyDate", length=8)
    public String getApplyDate() {
        return this.applyDate;
    }
    
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    
    @Column(name="DecideDate", length=8)
    public String getDecideDate() {
        return this.decideDate;
    }
    
    public void setDecideDate(String decideDate) {
        this.decideDate = decideDate;
    }

    
    @Column(name="LossMark", length=1)
    public String getLossMark() {
        return this.lossMark;
    }
    
    public void setLossMark(String lossMark) {
        this.lossMark = lossMark;
    }

    
    @Column(name="ExitExpiryDate", length=8)
    public String getExitExpiryDate() {
        return this.exitExpiryDate;
    }
    
    public void setExitExpiryDate(String exitExpiryDate) {
        this.exitExpiryDate = exitExpiryDate;
    }

    
    @Column(name="ForeignPassportNo", length=20)
    public String getForeignPassportNo() {
        return this.foreignPassportNo;
    }
    
    public void setForeignPassportNo(String foreignPassportNo) {
        this.foreignPassportNo = foreignPassportNo;
    }

    
    @Column(name="Position", precision=4, scale=0)
    public Integer getPosition() {
        return this.position;
    }
    
    public void setPosition(Integer position) {
        this.position = position;
    }

    
    @Column(name="Reason", precision=4, scale=0)
    public Integer getReason() {
        return this.reason;
    }
    
    public void setReason(Integer reason) {
        this.reason = reason;
    }

    
    @Column(name="MainlandIdNo", length=20)
    public String getMainlandIdNo() {
        return this.mainlandIdNo;
    }
    
    public void setMainlandIdNo(String mainlandIdNo) {
        this.mainlandIdNo = mainlandIdNo;
    }

    
    @Column(name="CityA", length=5)
    public String getCityA() {
        return this.cityA;
    }
    
    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    
    @Column(name="TownshipA", length=3)
    public String getTownshipA() {
        return this.townshipA;
    }
    
    public void setTownshipA(String townshipA) {
        this.townshipA = townshipA;
    }

    
    @Column(name="ZipCodeA", length=5)
    public String getZipCodeA() {
        return this.zipCodeA;
    }
    
    public void setZipCodeA(String zipCodeA) {
        this.zipCodeA = zipCodeA;
    }

    
    @Column(name="VillageA")
    public String getVillageA() {
        return this.villageA;
    }
    
    public void setVillageA(String villageA) {
        this.villageA = villageA;
    }

    
    @Column(name="NeighborhoodA", length=20)
    public String getNeighborhoodA() {
        return this.neighborhoodA;
    }
    
    public void setNeighborhoodA(String neighborhoodA) {
        this.neighborhoodA = neighborhoodA;
    }

    
    @Column(name="RoadA")
    public String getRoadA() {
        return this.roadA;
    }
    
    public void setRoadA(String roadA) {
        this.roadA = roadA;
    }

    
    @Column(name="DistrictA")
    public String getDistrictA() {
        return this.districtA;
    }
    
    public void setDistrictA(String districtA) {
        this.districtA = districtA;
    }

    
    @Column(name="LaneA", length=24)
    public String getLaneA() {
        return this.laneA;
    }
    
    public void setLaneA(String laneA) {
        this.laneA = laneA;
    }

    
    @Column(name="AlleyA", length=20)
    public String getAlleyA() {
        return this.alleyA;
    }
    
    public void setAlleyA(String alleyA) {
        this.alleyA = alleyA;
    }

    
    @Column(name="NumberA")
    public String getNumberA() {
        return this.numberA;
    }
    
    public void setNumberA(String numberA) {
        this.numberA = numberA;
    }

    
    @Column(name="TelA", length=20)
    public String getTelA() {
        return this.telA;
    }
    
    public void setTelA(String telA) {
        this.telA = telA;
    }

    
    @Column(name="EntryDate", length=8)
    public String getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    
    @Column(name="ExitDate", length=8)
    public String getExitDate() {
        return this.exitDate;
    }
    
    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    
    @Column(name="DeadMark", length=1)
    public String getDeadMark() {
        return this.deadMark;
    }
    
    public void setDeadMark(String deadMark) {
        this.deadMark = deadMark;
    }

    
    @Column(name="Marry", length=1)
    public String getMarry() {
        return this.marry;
    }
    
    public void setMarry(String marry) {
        this.marry = marry;
    }

    
    @Column(name="MarryDate", length=10)
    public String getMarryDate() {
        return this.marryDate;
    }
    
    public void setMarryDate(String marryDate) {
        this.marryDate = marryDate;
    }

    
    @Column(name="RisNote", length=1)
    public String getRisNote() {
        return this.risNote;
    }
    
    public void setRisNote(String risNote) {
        this.risNote = risNote;
    }

    
    @Column(name="RisNoteDate", length=8)
    public String getRisNoteDate() {
        return this.risNoteDate;
    }
    
    public void setRisNoteDate(String risNoteDate) {
        this.risNoteDate = risNoteDate;
    }

    
    @Column(name="FsType", length=1)
    public String getFsType() {
        return this.fsType;
    }
    
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    
    @Column(name="SourceTable", length=48)
    public String getSourceTable() {
        return this.sourceTable;
    }
    
    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    
    @Column(name="SpouseStatus", length=4)
    public String getSpouseStatus() {
        return this.spouseStatus;
    }
    
    public void setSpouseStatus(String spouseStatus) {
        this.spouseStatus = spouseStatus;
    }

    
    @Column(name="ResidenceStatus", length=4)
    public String getResidenceStatus() {
        return this.residenceStatus;
    }
    
    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    
    @Column(name="TwSpousePersonId", length=15)
    public String getTwSpousePersonId() {
        return this.twSpousePersonId;
    }
    
    public void setTwSpousePersonId(String twSpousePersonId) {
        this.twSpousePersonId = twSpousePersonId;
    }

    
    @Column(name="TwSpouseChineseName")
    public String getTwSpouseChineseName() {
        return this.twSpouseChineseName;
    }
    
    public void setTwSpouseChineseName(String twSpouseChineseName) {
        this.twSpouseChineseName = twSpouseChineseName;
    }

    
    @Column(name="TwSpouseBirthDate", length=8)
    public String getTwSpouseBirthDate() {
        return this.twSpouseBirthDate;
    }
    
    public void setTwSpouseBirthDate(String twSpouseBirthDate) {
        this.twSpouseBirthDate = twSpouseBirthDate;
    }

    
    @Column(name="TwSpouseNote", length=1)
    public String getTwSpouseNote() {
        return this.twSpouseNote;
    }
    
    public void setTwSpouseNote(String twSpouseNote) {
        this.twSpouseNote = twSpouseNote;
    }

    
    @Column(name="PatchFlag", length=1)
    public String getPatchFlag() {
        return this.patchFlag;
    }
    
    public void setPatchFlag(String patchFlag) {
        this.patchFlag = patchFlag;
    }

    
    @Column(name="CompareFlag", length=1)
    public String getCompareFlag() {
        return this.compareFlag;
    }
    
    public void setCompareFlag(String compareFlag) {
        this.compareFlag = compareFlag;
    }

    
    @Column(name="ChildNum", precision=2, scale=0)
    public Integer getChildNum() {
        return this.childNum;
    }
    
    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    
    @Column(name="Age", precision=3, scale=0)
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    
    @Column(name="TwSpouseAge", precision=3, scale=0)
    public Integer getTwSpouseAge() {
        return this.twSpouseAge;
    }
    
    public void setTwSpouseAge(Integer twSpouseAge) {
        this.twSpouseAge = twSpouseAge;
    }

    
    @Column(name="AgeDiff", precision=3, scale=0)
    public Integer getAgeDiff() {
        return this.ageDiff;
    }
    
    public void setAgeDiff(Integer ageDiff) {
        this.ageDiff = ageDiff;
    }

    
    @Column(name="ProcessDate", length=8)
    public String getProcessDate() {
        return this.processDate;
    }
    
    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    
    @Column(name="DeleteFlag", nullable=false, length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    @Column(name="CreateUserId", nullable=false, length=10)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    
    @Column(name="CreateProgramId", nullable=false, length=20)
    public String getCreateProgramId() {
        return this.createProgramId;
    }
    
    public void setCreateProgramId(String createProgramId) {
        this.createProgramId = createProgramId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateTime", nullable=false, length=23)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    @Column(name="MaintainHost", nullable=false, length=2)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    
    @Column(name="MainUserId", nullable=false, length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="MaintainProgramId", nullable=false, length=20)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", nullable=false, length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }




}


