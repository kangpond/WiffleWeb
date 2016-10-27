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
 * TwSpouse
 */
@Entity
@Table(name="TwSpouse"
)
public class TwSpouse  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private TwSpouseId id;
    private String chineseName;
    private String englishName;
    private String gender;
    private String birthDate;
    private Integer occupation;
    private String education;
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
    private String veteranMark;
    private String nativeMark;
    private String deadMark;
    private String lowIncomeMark;
    private String midLowIncomeMark;
    private String disabledMark;
    private String oldAllowance;
    private String marry;
    private String marryDate;
    private String risNote;
    private String risNoteDate;
    private String patchFlag;
    private Date createTime;
    private Date lastUpdateTime;

    public TwSpouse() {}

	
    public TwSpouse(TwSpouseId id, String chineseName, String englishName, String gender, String birthDate, String marryDate) {
        this.id = id;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.marryDate = marryDate;
    }
    public TwSpouse(TwSpouseId id, String chineseName, String englishName, String gender, String birthDate, Integer occupation, String education, String cityA, String townshipA, String zipCodeA, String villageA, String neighborhoodA, String roadA, String districtA, String laneA, String alleyA, String numberA, String telA, String veteranMark, String nativeMark, String deadMark, String lowIncomeMark, String midLowIncomeMark, String disabledMark, String oldAllowance, String marry, String marryDate, String risNote, String risNoteDate, String patchFlag, Date createTime, Date lastUpdateTime) {
        this.id = id;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.education = education;
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
        this.veteranMark = veteranMark;
        this.nativeMark = nativeMark;
        this.deadMark = deadMark;
        this.lowIncomeMark = lowIncomeMark;
        this.midLowIncomeMark = midLowIncomeMark;
        this.disabledMark = disabledMark;
        this.oldAllowance = oldAllowance;
        this.marry = marry;
        this.marryDate = marryDate;
        this.risNote = risNote;
        this.risNoteDate = risNoteDate;
        this.patchFlag = patchFlag;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="personId", column=@Column(name="PersonId", nullable=false, length=15) ), 
        @AttributeOverride(name="spFirstReceiveNo", column=@Column(name="SpFirstReceiveNo", nullable=false, length=12) ) } )
    public TwSpouseId getId() {
        return this.id;
    }
    
    public void setId(TwSpouseId id) {
        this.id = id;
    }

    
    @Column(name="ChineseName", nullable=false)
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    
    @Column(name="EnglishName", nullable=false, length=80)
    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    
    @Column(name="Gender", nullable=false, length=1)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="BirthDate", nullable=false, length=8)
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

    
    @Column(name="CityA")
    public String getCityA() {
        return this.cityA;
    }
    
    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    
    @Column(name="TownshipA")
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

    
    @Column(name="NeighborhoodA")
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

    
    @Column(name="LaneA")
    public String getLaneA() {
        return this.laneA;
    }
    
    public void setLaneA(String laneA) {
        this.laneA = laneA;
    }

    
    @Column(name="AlleyA")
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

    
    @Column(name="VeteranMark", length=1)
    public String getVeteranMark() {
        return this.veteranMark;
    }
    
    public void setVeteranMark(String veteranMark) {
        this.veteranMark = veteranMark;
    }

    
    @Column(name="NativeMark", length=1)
    public String getNativeMark() {
        return this.nativeMark;
    }
    
    public void setNativeMark(String nativeMark) {
        this.nativeMark = nativeMark;
    }

    
    @Column(name="DeadMark", length=1)
    public String getDeadMark() {
        return this.deadMark;
    }
    
    public void setDeadMark(String deadMark) {
        this.deadMark = deadMark;
    }

    
    @Column(name="LowIncomeMark", length=1)
    public String getLowIncomeMark() {
        return this.lowIncomeMark;
    }
    
    public void setLowIncomeMark(String lowIncomeMark) {
        this.lowIncomeMark = lowIncomeMark;
    }

    
    @Column(name="MidLowIncomeMark", length=1)
    public String getMidLowIncomeMark() {
        return this.midLowIncomeMark;
    }
    
    public void setMidLowIncomeMark(String midLowIncomeMark) {
        this.midLowIncomeMark = midLowIncomeMark;
    }

    
    @Column(name="DisabledMark", length=1)
    public String getDisabledMark() {
        return this.disabledMark;
    }
    
    public void setDisabledMark(String disabledMark) {
        this.disabledMark = disabledMark;
    }

    
    @Column(name="OldAllowance", length=1)
    public String getOldAllowance() {
        return this.oldAllowance;
    }
    
    public void setOldAllowance(String oldAllowance) {
        this.oldAllowance = oldAllowance;
    }

    
    @Column(name="Marry", length=1)
    public String getMarry() {
        return this.marry;
    }
    
    public void setMarry(String marry) {
        this.marry = marry;
    }

    
    @Column(name="MarryDate", nullable=false, length=10)
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




}


