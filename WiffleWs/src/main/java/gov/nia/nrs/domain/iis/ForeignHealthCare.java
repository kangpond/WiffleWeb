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
 * ForeignHealthCare
 */
@Entity
@Table(name = "ForeignHealthCare")
public class ForeignHealthCare implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private ForeignHealthCareId id;
	private String personId;
	private String chineseName;
	private String englishName;
	private String birthDate;
	private String gender;
	private String twSpousePersonId;
	private String twSpouseChineseName;
	private String twSpouseBirthDate;
	private String twSpouseRegionCode;
	private String twSpouseAddr;
	private String tel;
	private String profileCreateDate;
	private String trackDate;
	private String mentalHealth;
	private String psychosis;
	private String disability;
	private String immature;
	private String foreignSpouseMark;
	private String pregnancy;
	private String birthCheckDate;
	private String birthControl;
	private String childNo;
	private String caseStudy;
	private String hygienGuide;
	private String liveRegionCode;
	private String liveAddr;
	private String dayTel;
	private String nightTel;
	private String mobile;
	private String firstChildPersonId;
	private String firstChildChineseName;
	private String firstChildBirthDate;
	private String firstChildHealth;
	private String firstChildLive;
	private String firstChildStunt;
	private String firstChildCheckDate;
	private String secondChildPersonId;
	private String secondChildChineseName;
	private String secondChildBirthDate;
	private String secondChildHealth;
	private String secondChildLive;
	private String secondChildStunt;
	private String secondChildCheckDate;
	private String thirdChildPersonId;
	private String thirdChildChineseName;
	private String thirdChildBirthDate;
	private String thirdChildHealth;
	private String thirdChildLive;
	private String thirdChildStunt;
	private String thirdChildCheckDate;
	private String fourthChildPersonId;
	private String fourthChildChineseName;
	private String fourthChildBirthDate;
	private String fourthChildHealth;
	private String fourthChildLive;
	private String fourthChildStunt;
	private String fourthChildCheckDate;
	private String fifthChildPersonId;
	private String fifthChildChineseName;
	private String fifthChildBirthDate;
	private String fifthChildHealth;
	private String fifthChildLive;
	private String fifthChildStunt;
	private String fifthChildCheckDate;
	private String sixthChildPersonId;
	private String sixthChildChineseName;
	private String sixthChildBirthDate;
	private String sixthChildHealth;
	private String sixthChildLive;
	private String sixthChildStunt;
	private String sixthChildCheckDate;
	private String profileUpdateDate;
	private String nationality;
	private String nationalityCode;
	private String marry;
	private String divorce;
	private String deathDate;
	private String passportNo;
	private String education;
	private String occupation;
	private String entryDate;
	private String exitDate;
	private String insureStatus;
	private String marryApplyDate;
	private String twSpouseHandiCapType;
	private String twSpouseDisabilityClass;
	private String lowIncome;
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

	public ForeignHealthCare() {
	}

	public ForeignHealthCare(ForeignHealthCareId id, String deleteFlag,
			String createUserId, String createProgramId, Date createTime,
			String maintainHost, String mainUserId, String maintainProgramId,
			Date lastUpdateTime) {
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

	public ForeignHealthCare(ForeignHealthCareId id, String personId,
			String chineseName, String englishName, String birthDate,
			String gender, String twSpousePersonId, String twSpouseChineseName,
			String twSpouseBirthDate, String twSpouseRegionCode,
			String twSpouseAddr, String tel, String profileCreateDate,
			String trackDate, String mentalHealth, String psychosis,
			String disability, String immature, String foreignSpouseMark,
			String pregnancy, String birthCheckDate, String birthControl,
			String childNo, String caseStudy, String hygienGuide,
			String liveRegionCode, String liveAddr, String dayTel,
			String nightTel, String mobile, String firstChildPersonId,
			String firstChildChineseName, String firstChildBirthDate,
			String firstChildHealth, String firstChildLive,
			String firstChildStunt, String firstChildCheckDate,
			String secondChildPersonId, String secondChildChineseName,
			String secondChildBirthDate, String secondChildHealth,
			String secondChildLive, String secondChildStunt,
			String secondChildCheckDate, String thirdChildPersonId,
			String thirdChildChineseName, String thirdChildBirthDate,
			String thirdChildHealth, String thirdChildLive,
			String thirdChildStunt, String thirdChildCheckDate,
			String fourthChildPersonId, String fourthChildChineseName,
			String fourthChildBirthDate, String fourthChildHealth,
			String fourthChildLive, String fourthChildStunt,
			String fourthChildCheckDate, String fifthChildPersonId,
			String fifthChildChineseName, String fifthChildBirthDate,
			String fifthChildHealth, String fifthChildLive,
			String fifthChildStunt, String fifthChildCheckDate,
			String sixthChildPersonId, String sixthChildChineseName,
			String sixthChildBirthDate, String sixthChildHealth,
			String sixthChildLive, String sixthChildStunt,
			String sixthChildCheckDate, String profileUpdateDate,
			String nationality, String nationalityCode, String marry,
			String divorce, String deathDate, String passportNo,
			String education, String occupation, String entryDate,
			String exitDate, String insureStatus, String marryApplyDate,
			String twSpouseHandiCapType, String twSpouseDisabilityClass,
			String lowIncome, String maintainDeptId, String createDeptId,
			String deleteFlag, String createUserId, String createProgramId,
			Date createTime, String maintainHost, String mainUserId,
			String maintainProgramId, Date lastUpdateTime) {
		this.id = id;
		this.personId = personId;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.twSpousePersonId = twSpousePersonId;
		this.twSpouseChineseName = twSpouseChineseName;
		this.twSpouseBirthDate = twSpouseBirthDate;
		this.twSpouseRegionCode = twSpouseRegionCode;
		this.twSpouseAddr = twSpouseAddr;
		this.tel = tel;
		this.profileCreateDate = profileCreateDate;
		this.trackDate = trackDate;
		this.mentalHealth = mentalHealth;
		this.psychosis = psychosis;
		this.disability = disability;
		this.immature = immature;
		this.foreignSpouseMark = foreignSpouseMark;
		this.pregnancy = pregnancy;
		this.birthCheckDate = birthCheckDate;
		this.birthControl = birthControl;
		this.childNo = childNo;
		this.caseStudy = caseStudy;
		this.hygienGuide = hygienGuide;
		this.liveRegionCode = liveRegionCode;
		this.liveAddr = liveAddr;
		this.dayTel = dayTel;
		this.nightTel = nightTel;
		this.mobile = mobile;
		this.firstChildPersonId = firstChildPersonId;
		this.firstChildChineseName = firstChildChineseName;
		this.firstChildBirthDate = firstChildBirthDate;
		this.firstChildHealth = firstChildHealth;
		this.firstChildLive = firstChildLive;
		this.firstChildStunt = firstChildStunt;
		this.firstChildCheckDate = firstChildCheckDate;
		this.secondChildPersonId = secondChildPersonId;
		this.secondChildChineseName = secondChildChineseName;
		this.secondChildBirthDate = secondChildBirthDate;
		this.secondChildHealth = secondChildHealth;
		this.secondChildLive = secondChildLive;
		this.secondChildStunt = secondChildStunt;
		this.secondChildCheckDate = secondChildCheckDate;
		this.thirdChildPersonId = thirdChildPersonId;
		this.thirdChildChineseName = thirdChildChineseName;
		this.thirdChildBirthDate = thirdChildBirthDate;
		this.thirdChildHealth = thirdChildHealth;
		this.thirdChildLive = thirdChildLive;
		this.thirdChildStunt = thirdChildStunt;
		this.thirdChildCheckDate = thirdChildCheckDate;
		this.fourthChildPersonId = fourthChildPersonId;
		this.fourthChildChineseName = fourthChildChineseName;
		this.fourthChildBirthDate = fourthChildBirthDate;
		this.fourthChildHealth = fourthChildHealth;
		this.fourthChildLive = fourthChildLive;
		this.fourthChildStunt = fourthChildStunt;
		this.fourthChildCheckDate = fourthChildCheckDate;
		this.fifthChildPersonId = fifthChildPersonId;
		this.fifthChildChineseName = fifthChildChineseName;
		this.fifthChildBirthDate = fifthChildBirthDate;
		this.fifthChildHealth = fifthChildHealth;
		this.fifthChildLive = fifthChildLive;
		this.fifthChildStunt = fifthChildStunt;
		this.fifthChildCheckDate = fifthChildCheckDate;
		this.sixthChildPersonId = sixthChildPersonId;
		this.sixthChildChineseName = sixthChildChineseName;
		this.sixthChildBirthDate = sixthChildBirthDate;
		this.sixthChildHealth = sixthChildHealth;
		this.sixthChildLive = sixthChildLive;
		this.sixthChildStunt = sixthChildStunt;
		this.sixthChildCheckDate = sixthChildCheckDate;
		this.profileUpdateDate = profileUpdateDate;
		this.nationality = nationality;
		this.nationalityCode = nationalityCode;
		this.marry = marry;
		this.divorce = divorce;
		this.deathDate = deathDate;
		this.passportNo = passportNo;
		this.education = education;
		this.occupation = occupation;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.insureStatus = insureStatus;
		this.marryApplyDate = marryApplyDate;
		this.twSpouseHandiCapType = twSpouseHandiCapType;
		this.twSpouseDisabilityClass = twSpouseDisabilityClass;
		this.lowIncome = lowIncome;
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

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "firstReceiveNo", column = @Column(name = "FirstReceiveNo", nullable = false, length = 12)),
			@AttributeOverride(name = "residentIdNo", column = @Column(name = "ResidentIdNo", nullable = false, length = 10)),
			@AttributeOverride(name = "residentIdNo1", column = @Column(name = "ResidentIdNo1", nullable = false, length = 10)) })
	public ForeignHealthCareId getId() {
		return this.id;
	}

	public void setId(ForeignHealthCareId id) {
		this.id = id;
	}

	@Column(name = "PersonId", length = 15)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "ChineseName")
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "EnglishName", length = 80)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "BirthDate", length = 8)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "Gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "TwSpousePersonId", length = 15)
	public String getTwSpousePersonId() {
		return this.twSpousePersonId;
	}

	public void setTwSpousePersonId(String twSpousePersonId) {
		this.twSpousePersonId = twSpousePersonId;
	}

	@Column(name = "TwSpouseChineseName")
	public String getTwSpouseChineseName() {
		return this.twSpouseChineseName;
	}

	public void setTwSpouseChineseName(String twSpouseChineseName) {
		this.twSpouseChineseName = twSpouseChineseName;
	}

	@Column(name = "TwSpouseBirthDate", length = 8)
	public String getTwSpouseBirthDate() {
		return this.twSpouseBirthDate;
	}

	public void setTwSpouseBirthDate(String twSpouseBirthDate) {
		this.twSpouseBirthDate = twSpouseBirthDate;
	}

	@Column(name = "TwSpouseRegionCode", length = 4)
	public String getTwSpouseRegionCode() {
		return this.twSpouseRegionCode;
	}

	public void setTwSpouseRegionCode(String twSpouseRegionCode) {
		this.twSpouseRegionCode = twSpouseRegionCode;
	}

	@Column(name = "TwSpouseAddr")
	public String getTwSpouseAddr() {
		return this.twSpouseAddr;
	}

	public void setTwSpouseAddr(String twSpouseAddr) {
		this.twSpouseAddr = twSpouseAddr;
	}

	@Column(name = "Tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "ProfileCreateDate", length = 8)
	public String getProfileCreateDate() {
		return this.profileCreateDate;
	}

	public void setProfileCreateDate(String profileCreateDate) {
		this.profileCreateDate = profileCreateDate;
	}

	@Column(name = "TrackDate", length = 8)
	public String getTrackDate() {
		return this.trackDate;
	}

	public void setTrackDate(String trackDate) {
		this.trackDate = trackDate;
	}

	@Column(name = "MentalHealth", length = 1)
	public String getMentalHealth() {
		return this.mentalHealth;
	}

	public void setMentalHealth(String mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

	@Column(name = "Psychosis", length = 1)
	public String getPsychosis() {
		return this.psychosis;
	}

	public void setPsychosis(String psychosis) {
		this.psychosis = psychosis;
	}

	@Column(name = "Disability", length = 1)
	public String getDisability() {
		return this.disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	@Column(name = "Immature", length = 1)
	public String getImmature() {
		return this.immature;
	}

	public void setImmature(String immature) {
		this.immature = immature;
	}

	@Column(name = "ForeignSpouseMark", length = 1)
	public String getForeignSpouseMark() {
		return this.foreignSpouseMark;
	}

	public void setForeignSpouseMark(String foreignSpouseMark) {
		this.foreignSpouseMark = foreignSpouseMark;
	}

	@Column(name = "Pregnancy", length = 1)
	public String getPregnancy() {
		return this.pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	@Column(name = "BirthCheckDate", length = 8)
	public String getBirthCheckDate() {
		return this.birthCheckDate;
	}

	public void setBirthCheckDate(String birthCheckDate) {
		this.birthCheckDate = birthCheckDate;
	}

	@Column(name = "BirthControl", length = 2)
	public String getBirthControl() {
		return this.birthControl;
	}

	public void setBirthControl(String birthControl) {
		this.birthControl = birthControl;
	}

	@Column(name = "ChildNo", length = 1)
	public String getChildNo() {
		return this.childNo;
	}

	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}

	@Column(name = "CaseStudy", length = 2)
	public String getCaseStudy() {
		return this.caseStudy;
	}

	public void setCaseStudy(String caseStudy) {
		this.caseStudy = caseStudy;
	}

	@Column(name = "HygienGuide", length = 1)
	public String getHygienGuide() {
		return this.hygienGuide;
	}

	public void setHygienGuide(String hygienGuide) {
		this.hygienGuide = hygienGuide;
	}

	@Column(name = "LiveRegionCode", length = 4)
	public String getLiveRegionCode() {
		return this.liveRegionCode;
	}

	public void setLiveRegionCode(String liveRegionCode) {
		this.liveRegionCode = liveRegionCode;
	}

	@Column(name = "LiveAddr")
	public String getLiveAddr() {
		return this.liveAddr;
	}

	public void setLiveAddr(String liveAddr) {
		this.liveAddr = liveAddr;
	}

	@Column(name = "DayTel", length = 20)
	public String getDayTel() {
		return this.dayTel;
	}

	public void setDayTel(String dayTel) {
		this.dayTel = dayTel;
	}

	@Column(name = "NightTel", length = 20)
	public String getNightTel() {
		return this.nightTel;
	}

	public void setNightTel(String nightTel) {
		this.nightTel = nightTel;
	}

	@Column(name = "Mobile", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "FirstChildPersonId", length = 10)
	public String getFirstChildPersonId() {
		return this.firstChildPersonId;
	}

	public void setFirstChildPersonId(String firstChildPersonId) {
		this.firstChildPersonId = firstChildPersonId;
	}

	@Column(name = "FirstChildChineseName")
	public String getFirstChildChineseName() {
		return this.firstChildChineseName;
	}

	public void setFirstChildChineseName(String firstChildChineseName) {
		this.firstChildChineseName = firstChildChineseName;
	}

	@Column(name = "FirstChildBirthDate", length = 8)
	public String getFirstChildBirthDate() {
		return this.firstChildBirthDate;
	}

	public void setFirstChildBirthDate(String firstChildBirthDate) {
		this.firstChildBirthDate = firstChildBirthDate;
	}

	@Column(name = "FirstChildHealth", length = 1)
	public String getFirstChildHealth() {
		return this.firstChildHealth;
	}

	public void setFirstChildHealth(String firstChildHealth) {
		this.firstChildHealth = firstChildHealth;
	}

	@Column(name = "FirstChildLive", length = 1)
	public String getFirstChildLive() {
		return this.firstChildLive;
	}

	public void setFirstChildLive(String firstChildLive) {
		this.firstChildLive = firstChildLive;
	}

	@Column(name = "FirstChildStunt", length = 1)
	public String getFirstChildStunt() {
		return this.firstChildStunt;
	}

	public void setFirstChildStunt(String firstChildStunt) {
		this.firstChildStunt = firstChildStunt;
	}

	@Column(name = "FirstChildCheckDate", length = 8)
	public String getFirstChildCheckDate() {
		return this.firstChildCheckDate;
	}

	public void setFirstChildCheckDate(String firstChildCheckDate) {
		this.firstChildCheckDate = firstChildCheckDate;
	}

	@Column(name = "SecondChildPersonId", length = 10)
	public String getSecondChildPersonId() {
		return this.secondChildPersonId;
	}

	public void setSecondChildPersonId(String secondChildPersonId) {
		this.secondChildPersonId = secondChildPersonId;
	}

	@Column(name = "SecondChildChineseName")
	public String getSecondChildChineseName() {
		return this.secondChildChineseName;
	}

	public void setSecondChildChineseName(String secondChildChineseName) {
		this.secondChildChineseName = secondChildChineseName;
	}

	@Column(name = "SecondChildBirthDate", length = 8)
	public String getSecondChildBirthDate() {
		return this.secondChildBirthDate;
	}

	public void setSecondChildBirthDate(String secondChildBirthDate) {
		this.secondChildBirthDate = secondChildBirthDate;
	}

	@Column(name = "SecondChildHealth", length = 1)
	public String getSecondChildHealth() {
		return this.secondChildHealth;
	}

	public void setSecondChildHealth(String secondChildHealth) {
		this.secondChildHealth = secondChildHealth;
	}

	@Column(name = "SecondChildLive", length = 1)
	public String getSecondChildLive() {
		return this.secondChildLive;
	}

	public void setSecondChildLive(String secondChildLive) {
		this.secondChildLive = secondChildLive;
	}

	@Column(name = "SecondChildStunt", length = 1)
	public String getSecondChildStunt() {
		return this.secondChildStunt;
	}

	public void setSecondChildStunt(String secondChildStunt) {
		this.secondChildStunt = secondChildStunt;
	}

	@Column(name = "SecondChildCheckDate", length = 8)
	public String getSecondChildCheckDate() {
		return this.secondChildCheckDate;
	}

	public void setSecondChildCheckDate(String secondChildCheckDate) {
		this.secondChildCheckDate = secondChildCheckDate;
	}

	@Column(name = "ThirdChildPersonId", length = 10)
	public String getThirdChildPersonId() {
		return this.thirdChildPersonId;
	}

	public void setThirdChildPersonId(String thirdChildPersonId) {
		this.thirdChildPersonId = thirdChildPersonId;
	}

	@Column(name = "ThirdChildChineseName")
	public String getThirdChildChineseName() {
		return this.thirdChildChineseName;
	}

	public void setThirdChildChineseName(String thirdChildChineseName) {
		this.thirdChildChineseName = thirdChildChineseName;
	}

	@Column(name = "ThirdChildBirthDate", length = 8)
	public String getThirdChildBirthDate() {
		return this.thirdChildBirthDate;
	}

	public void setThirdChildBirthDate(String thirdChildBirthDate) {
		this.thirdChildBirthDate = thirdChildBirthDate;
	}

	@Column(name = "ThirdChildHealth", length = 1)
	public String getThirdChildHealth() {
		return this.thirdChildHealth;
	}

	public void setThirdChildHealth(String thirdChildHealth) {
		this.thirdChildHealth = thirdChildHealth;
	}

	@Column(name = "ThirdChildLive", length = 1)
	public String getThirdChildLive() {
		return this.thirdChildLive;
	}

	public void setThirdChildLive(String thirdChildLive) {
		this.thirdChildLive = thirdChildLive;
	}

	@Column(name = "ThirdChildStunt", length = 1)
	public String getThirdChildStunt() {
		return this.thirdChildStunt;
	}

	public void setThirdChildStunt(String thirdChildStunt) {
		this.thirdChildStunt = thirdChildStunt;
	}

	@Column(name = "ThirdChildCheckDate", length = 8)
	public String getThirdChildCheckDate() {
		return this.thirdChildCheckDate;
	}

	public void setThirdChildCheckDate(String thirdChildCheckDate) {
		this.thirdChildCheckDate = thirdChildCheckDate;
	}

	@Column(name = "FourthChildPersonId", length = 10)
	public String getFourthChildPersonId() {
		return this.fourthChildPersonId;
	}

	public void setFourthChildPersonId(String fourthChildPersonId) {
		this.fourthChildPersonId = fourthChildPersonId;
	}

	@Column(name = "FourthChildChineseName")
	public String getFourthChildChineseName() {
		return this.fourthChildChineseName;
	}

	public void setFourthChildChineseName(String fourthChildChineseName) {
		this.fourthChildChineseName = fourthChildChineseName;
	}

	@Column(name = "FourthChildBirthDate", length = 8)
	public String getFourthChildBirthDate() {
		return this.fourthChildBirthDate;
	}

	public void setFourthChildBirthDate(String fourthChildBirthDate) {
		this.fourthChildBirthDate = fourthChildBirthDate;
	}

	@Column(name = "FourthChildHealth", length = 1)
	public String getFourthChildHealth() {
		return this.fourthChildHealth;
	}

	public void setFourthChildHealth(String fourthChildHealth) {
		this.fourthChildHealth = fourthChildHealth;
	}

	@Column(name = "FourthChildLive", length = 1)
	public String getFourthChildLive() {
		return this.fourthChildLive;
	}

	public void setFourthChildLive(String fourthChildLive) {
		this.fourthChildLive = fourthChildLive;
	}

	@Column(name = "FourthChildStunt", length = 1)
	public String getFourthChildStunt() {
		return this.fourthChildStunt;
	}

	public void setFourthChildStunt(String fourthChildStunt) {
		this.fourthChildStunt = fourthChildStunt;
	}

	@Column(name = "FourthChildCheckDate", length = 8)
	public String getFourthChildCheckDate() {
		return this.fourthChildCheckDate;
	}

	public void setFourthChildCheckDate(String fourthChildCheckDate) {
		this.fourthChildCheckDate = fourthChildCheckDate;
	}

	@Column(name = "FifthChildPersonId", length = 10)
	public String getFifthChildPersonId() {
		return this.fifthChildPersonId;
	}

	public void setFifthChildPersonId(String fifthChildPersonId) {
		this.fifthChildPersonId = fifthChildPersonId;
	}

	@Column(name = "FifthChildChineseName")
	public String getFifthChildChineseName() {
		return this.fifthChildChineseName;
	}

	public void setFifthChildChineseName(String fifthChildChineseName) {
		this.fifthChildChineseName = fifthChildChineseName;
	}

	@Column(name = "FifthChildBirthDate", length = 8)
	public String getFifthChildBirthDate() {
		return this.fifthChildBirthDate;
	}

	public void setFifthChildBirthDate(String fifthChildBirthDate) {
		this.fifthChildBirthDate = fifthChildBirthDate;
	}

	@Column(name = "FifthChildHealth", length = 1)
	public String getFifthChildHealth() {
		return this.fifthChildHealth;
	}

	public void setFifthChildHealth(String fifthChildHealth) {
		this.fifthChildHealth = fifthChildHealth;
	}

	@Column(name = "FifthChildLive", length = 1)
	public String getFifthChildLive() {
		return this.fifthChildLive;
	}

	public void setFifthChildLive(String fifthChildLive) {
		this.fifthChildLive = fifthChildLive;
	}

	@Column(name = "FifthChildStunt", length = 1)
	public String getFifthChildStunt() {
		return this.fifthChildStunt;
	}

	public void setFifthChildStunt(String fifthChildStunt) {
		this.fifthChildStunt = fifthChildStunt;
	}

	@Column(name = "FifthChildCheckDate", length = 8)
	public String getFifthChildCheckDate() {
		return this.fifthChildCheckDate;
	}

	public void setFifthChildCheckDate(String fifthChildCheckDate) {
		this.fifthChildCheckDate = fifthChildCheckDate;
	}

	@Column(name = "SixthChildPersonId", length = 10)
	public String getSixthChildPersonId() {
		return this.sixthChildPersonId;
	}

	public void setSixthChildPersonId(String sixthChildPersonId) {
		this.sixthChildPersonId = sixthChildPersonId;
	}

	@Column(name = "SixthChildChineseName")
	public String getSixthChildChineseName() {
		return this.sixthChildChineseName;
	}

	public void setSixthChildChineseName(String sixthChildChineseName) {
		this.sixthChildChineseName = sixthChildChineseName;
	}

	@Column(name = "SixthChildBirthDate", length = 8)
	public String getSixthChildBirthDate() {
		return this.sixthChildBirthDate;
	}

	public void setSixthChildBirthDate(String sixthChildBirthDate) {
		this.sixthChildBirthDate = sixthChildBirthDate;
	}

	@Column(name = "SixthChildHealth", length = 1)
	public String getSixthChildHealth() {
		return this.sixthChildHealth;
	}

	public void setSixthChildHealth(String sixthChildHealth) {
		this.sixthChildHealth = sixthChildHealth;
	}

	@Column(name = "SixthChildLive", length = 1)
	public String getSixthChildLive() {
		return this.sixthChildLive;
	}

	public void setSixthChildLive(String sixthChildLive) {
		this.sixthChildLive = sixthChildLive;
	}

	@Column(name = "SixthChildStunt", length = 1)
	public String getSixthChildStunt() {
		return this.sixthChildStunt;
	}

	public void setSixthChildStunt(String sixthChildStunt) {
		this.sixthChildStunt = sixthChildStunt;
	}

	@Column(name = "SixthChildCheckDate", length = 8)
	public String getSixthChildCheckDate() {
		return this.sixthChildCheckDate;
	}

	public void setSixthChildCheckDate(String sixthChildCheckDate) {
		this.sixthChildCheckDate = sixthChildCheckDate;
	}

	@Column(name = "ProfileUpdateDate", length = 8)
	public String getProfileUpdateDate() {
		return this.profileUpdateDate;
	}

	public void setProfileUpdateDate(String profileUpdateDate) {
		this.profileUpdateDate = profileUpdateDate;
	}

	@Column(name = "Nationality", length = 32)
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "NationalityCode", length = 4)
	public String getNationalityCode() {
		return this.nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	@Column(name = "Marry", length = 8)
	public String getMarry() {
		return this.marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	@Column(name = "Divorce", length = 8)
	public String getDivorce() {
		return this.divorce;
	}

	public void setDivorce(String divorce) {
		this.divorce = divorce;
	}

	@Column(name = "DeathDate", length = 8)
	public String getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	@Column(name = "PassportNo", length = 10)
	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Column(name = "Education", length = 1)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "Occupation", length = 2)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "EntryDate", length = 8)
	public String getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "ExitDate", length = 8)
	public String getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	@Column(name = "InsureStatus", length = 1)
	public String getInsureStatus() {
		return this.insureStatus;
	}

	public void setInsureStatus(String insureStatus) {
		this.insureStatus = insureStatus;
	}

	@Column(name = "MarryApplyDate", length = 8)
	public String getMarryApplyDate() {
		return this.marryApplyDate;
	}

	public void setMarryApplyDate(String marryApplyDate) {
		this.marryApplyDate = marryApplyDate;
	}

	@Column(name = "TwSpouseHandiCapType", length = 2)
	public String getTwSpouseHandiCapType() {
		return this.twSpouseHandiCapType;
	}

	public void setTwSpouseHandiCapType(String twSpouseHandiCapType) {
		this.twSpouseHandiCapType = twSpouseHandiCapType;
	}

	@Column(name = "TwSpouseDisabilityClass", length = 1)
	public String getTwSpouseDisabilityClass() {
		return this.twSpouseDisabilityClass;
	}

	public void setTwSpouseDisabilityClass(String twSpouseDisabilityClass) {
		this.twSpouseDisabilityClass = twSpouseDisabilityClass;
	}

	@Column(name = "LowIncome", length = 1)
	public String getLowIncome() {
		return this.lowIncome;
	}

	public void setLowIncome(String lowIncome) {
		this.lowIncome = lowIncome;
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
