package gov.nia.nrs.domain.iis;



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
 * ForeignSpouse
 */
@Entity
@Table(name="ForeignSpouse"
)
public class ForeignSpouse  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ForeignSpouseId id;
    private String residentIdNo1;
    private String personId;
    private String chineseName;
    private String englishName;
    private String gender;
    private String birthDate;
    private Integer nation;
    private String latestReceiveNo;
    private String lossMark;
    private String exitExpiryDate;
    private Integer position;
    private Integer reason;
    private String marry;
    private String marryDate;
    private String fsType;
    private String sourceTable;
    private String spouseStatus;
    private String residenceStatus;
    private String twSpousePersonId;
    private String twSpouseChineseName;
    private String twSpouseBirthDate;
    private String twSpouseNote;
    private String patchFlag;
    private Date createTime;
    private Date lastUpdateTime;
    private String compareFlag;
    private String foreignPassportNo;
    private String passportNo;

    public ForeignSpouse() {}

	
    public ForeignSpouse(ForeignSpouseId id) {
        this.id = id;
    }
    public ForeignSpouse(ForeignSpouseId id, String residentIdNo1, String personId, String chineseName, String englishName, String gender, String birthDate, Integer nation, String latestReceiveNo, String lossMark, String exitExpiryDate, Integer position, Integer reason, String marry, String marryDate, String fsType, String sourceTable, String spouseStatus, String residenceStatus, String twSpousePersonId, String twSpouseChineseName, String twSpouseBirthDate, String twSpouseNote, String patchFlag, Date createTime, Date lastUpdateTime, String compareFlag, String foreignPassportNo, String passportNo) {
        this.id = id;
        this.residentIdNo1 = residentIdNo1;
        this.personId = personId;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.nation = nation;
        this.latestReceiveNo = latestReceiveNo;
        this.lossMark = lossMark;
        this.exitExpiryDate = exitExpiryDate;
        this.position = position;
        this.reason = reason;
        this.marry = marry;
        this.marryDate = marryDate;
        this.fsType = fsType;
        this.sourceTable = sourceTable;
        this.spouseStatus = spouseStatus;
        this.residenceStatus = residenceStatus;
        this.twSpousePersonId = twSpousePersonId;
        this.twSpouseChineseName = twSpouseChineseName;
        this.twSpouseBirthDate = twSpouseBirthDate;
        this.twSpouseNote = twSpouseNote;
        this.patchFlag = patchFlag;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.compareFlag = compareFlag;
        this.foreignPassportNo = foreignPassportNo;
        this.passportNo = passportNo;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="firstReceiveNo", column=@Column(name="FirstReceiveNo", nullable=false, length=12) ), 
        @AttributeOverride(name="residentIdNo", column=@Column(name="ResidentIdNo", nullable=false, length=10) ) } )
    public ForeignSpouseId getId() {
        return this.id;
    }
    
    public void setId(ForeignSpouseId id) {
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

    
    @Column(name="Nation", precision=4, scale=0)
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

    
    @Column(name="FsType", length=1)
    public String getFsType() {
        return this.fsType;
    }
    
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    
    @Column(name="SourceTable")
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateTime", length=23)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
    @Column(name="CompareFlag", length=1)
    public String getCompareFlag() {
        return this.compareFlag;
    }
    
    public void setCompareFlag(String compareFlag) {
        this.compareFlag = compareFlag;
    }

    
    @Column(name="ForeignPassportNo", length=20)
    public String getForeignPassportNo() {
        return this.foreignPassportNo;
    }
    
    public void setForeignPassportNo(String foreignPassportNo) {
        this.foreignPassportNo = foreignPassportNo;
    }

    
    @Column(name="PassportNo", length=20)
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }




}


