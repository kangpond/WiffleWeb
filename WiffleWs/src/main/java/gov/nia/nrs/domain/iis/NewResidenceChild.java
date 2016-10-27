package gov.nia.nrs.domain.iis;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * NewResidenceChild
 */
@Entity
@Table(name="NewResidenceChild"
)
public class NewResidenceChild  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String personId;
    private String chineseName;
    private String englishName;
    private String gender;
    private String birthDate;
    private Integer occupation;
    private String education;
    private String cityA;
    private String townshipA;
    private String zipCodeA;
    private String addr1a;
    private String addr2a;
    private String addr3a;
    private String addr4a;
    private String relFirstReceiveNo;
    private String relResidenceNo;
    private String relNation;
    private String fetusNo;
    private String fetusCode;
    private String birthId;
    private String deadMark;
    private String nativeMark;
    private String fatherPersonId;
    private String fatherChineseName;
    private String fatherBirthDate;
    private String fatherNativeMark;
    private String motherPersonId;
    private String motherChineseName;
    private String motherBirthDate;
    private String motherNativeMark;
    private String entryDate;
    private String exitDate;
    private String deleteFlag;
    private String createUserId;
    private String createProgramId;
    private Date createTime;
    private String maintainHost;
    private String mainUserId;
    private String maintainProgramId;
    private Date lastUpdateTime;

    public NewResidenceChild() {}

	
    public NewResidenceChild(String personId, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.personId = personId;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
    public NewResidenceChild(String personId, String chineseName, String englishName, String gender, String birthDate, Integer occupation, String education, String cityA, String townshipA, String zipCodeA, String addr1a, String addr2a, String addr3a, String addr4a, String relFirstReceiveNo, String relResidenceNo, String relNation, String fetusNo, String fetusCode, String birthId, String deadMark, String nativeMark, String fatherPersonId, String fatherChineseName, String fatherBirthDate, String fatherNativeMark, String motherPersonId, String motherChineseName, String motherBirthDate, String motherNativeMark, String entryDate, String exitDate, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.personId = personId;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.education = education;
        this.cityA = cityA;
        this.townshipA = townshipA;
        this.zipCodeA = zipCodeA;
        this.addr1a = addr1a;
        this.addr2a = addr2a;
        this.addr3a = addr3a;
        this.addr4a = addr4a;
        this.relFirstReceiveNo = relFirstReceiveNo;
        this.relResidenceNo = relResidenceNo;
        this.relNation = relNation;
        this.fetusNo = fetusNo;
        this.fetusCode = fetusCode;
        this.birthId = birthId;
        this.deadMark = deadMark;
        this.nativeMark = nativeMark;
        this.fatherPersonId = fatherPersonId;
        this.fatherChineseName = fatherChineseName;
        this.fatherBirthDate = fatherBirthDate;
        this.fatherNativeMark = fatherNativeMark;
        this.motherPersonId = motherPersonId;
        this.motherChineseName = motherChineseName;
        this.motherBirthDate = motherBirthDate;
        this.motherNativeMark = motherNativeMark;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
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

    
    @Column(name="PersonId", unique=true, nullable=false, length=15)
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

    
    @Column(name="Addr1A")
    public String getAddr1a() {
        return this.addr1a;
    }
    
    public void setAddr1a(String addr1a) {
        this.addr1a = addr1a;
    }

    
    @Column(name="Addr2A", length=3)
    public String getAddr2a() {
        return this.addr2a;
    }
    
    public void setAddr2a(String addr2a) {
        this.addr2a = addr2a;
    }

    
    @Column(name="Addr3A")
    public String getAddr3a() {
        return this.addr3a;
    }
    
    public void setAddr3a(String addr3a) {
        this.addr3a = addr3a;
    }

    
    @Column(name="Addr4A")
    public String getAddr4a() {
        return this.addr4a;
    }
    
    public void setAddr4a(String addr4a) {
        this.addr4a = addr4a;
    }

    
    @Column(name="RelFirstReceiveNo", length=12)
    public String getRelFirstReceiveNo() {
        return this.relFirstReceiveNo;
    }
    
    public void setRelFirstReceiveNo(String relFirstReceiveNo) {
        this.relFirstReceiveNo = relFirstReceiveNo;
    }

    
    @Column(name="RelResidenceNo", length=10)
    public String getRelResidenceNo() {
        return this.relResidenceNo;
    }
    
    public void setRelResidenceNo(String relResidenceNo) {
        this.relResidenceNo = relResidenceNo;
    }

    
    @Column(name="RelNation", length=3)
    public String getRelNation() {
        return this.relNation;
    }
    
    public void setRelNation(String relNation) {
        this.relNation = relNation;
    }

    
    @Column(name="FetusNo", length=2)
    public String getFetusNo() {
        return this.fetusNo;
    }
    
    public void setFetusNo(String fetusNo) {
        this.fetusNo = fetusNo;
    }

    
    @Column(name="FetusCode", length=1)
    public String getFetusCode() {
        return this.fetusCode;
    }
    
    public void setFetusCode(String fetusCode) {
        this.fetusCode = fetusCode;
    }

    
    @Column(name="BirthId", length=2)
    public String getBirthId() {
        return this.birthId;
    }
    
    public void setBirthId(String birthId) {
        this.birthId = birthId;
    }

    
    @Column(name="DeadMark", length=1)
    public String getDeadMark() {
        return this.deadMark;
    }
    
    public void setDeadMark(String deadMark) {
        this.deadMark = deadMark;
    }

    
    @Column(name="NativeMark", length=1)
    public String getNativeMark() {
        return this.nativeMark;
    }
    
    public void setNativeMark(String nativeMark) {
        this.nativeMark = nativeMark;
    }

    
    @Column(name="FatherPersonId", length=20)
    public String getFatherPersonId() {
        return this.fatherPersonId;
    }
    
    public void setFatherPersonId(String fatherPersonId) {
        this.fatherPersonId = fatherPersonId;
    }

    
    @Column(name="FatherChineseName")
    public String getFatherChineseName() {
        return this.fatherChineseName;
    }
    
    public void setFatherChineseName(String fatherChineseName) {
        this.fatherChineseName = fatherChineseName;
    }

    
    @Column(name="FatherBirthDate", length=8)
    public String getFatherBirthDate() {
        return this.fatherBirthDate;
    }
    
    public void setFatherBirthDate(String fatherBirthDate) {
        this.fatherBirthDate = fatherBirthDate;
    }

    
    @Column(name="FatherNativeMark", length=1)
    public String getFatherNativeMark() {
        return this.fatherNativeMark;
    }
    
    public void setFatherNativeMark(String fatherNativeMark) {
        this.fatherNativeMark = fatherNativeMark;
    }

    
    @Column(name="MotherPersonId", length=20)
    public String getMotherPersonId() {
        return this.motherPersonId;
    }
    
    public void setMotherPersonId(String motherPersonId) {
        this.motherPersonId = motherPersonId;
    }

    
    @Column(name="MotherChineseName")
    public String getMotherChineseName() {
        return this.motherChineseName;
    }
    
    public void setMotherChineseName(String motherChineseName) {
        this.motherChineseName = motherChineseName;
    }

    
    @Column(name="MotherBirthDate", length=8)
    public String getMotherBirthDate() {
        return this.motherBirthDate;
    }
    
    public void setMotherBirthDate(String motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }

    
    @Column(name="MotherNativeMark", length=1)
    public String getMotherNativeMark() {
        return this.motherNativeMark;
    }
    
    public void setMotherNativeMark(String motherNativeMark) {
        this.motherNativeMark = motherNativeMark;
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


