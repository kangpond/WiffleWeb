package gov.nia.nrs.domain;

import java.util.Date;

/**
 * FsForeignHealthCare
 */
public class FsForeignHealthCare implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private FsForeignHealthCareId id;
	private String residentIdNo1;
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

	public FsForeignHealthCare() {
	}

	public FsForeignHealthCare(FsForeignHealthCareId id, String deleteFlag,
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

	public FsForeignHealthCare(FsForeignHealthCareId id, String residentIdNo1,
			String personId, String chineseName, String englishName,
			String birthDate, String gender, String twSpousePersonId,
			String twSpouseChineseName, String twSpouseBirthDate,
			String twSpouseRegionCode, String twSpouseAddr, String tel,
			String profileCreateDate, String trackDate, String mentalHealth,
			String psychosis, String disability, String immature,
			String foreignSpouseMark, String pregnancy, String birthCheckDate,
			String birthControl, String childNo, String caseStudy,
			String hygienGuide, String liveRegionCode, String liveAddr,
			String dayTel, String nightTel, String mobile,
			String firstChildPersonId, String firstChildChineseName,
			String firstChildBirthDate, String firstChildHealth,
			String firstChildLive, String firstChildStunt,
			String firstChildCheckDate, String secondChildPersonId,
			String secondChildChineseName, String secondChildBirthDate,
			String secondChildHealth, String secondChildLive,
			String secondChildStunt, String secondChildCheckDate,
			String thirdChildPersonId, String thirdChildChineseName,
			String thirdChildBirthDate, String thirdChildHealth,
			String thirdChildLive, String thirdChildStunt,
			String thirdChildCheckDate, String fourthChildPersonId,
			String fourthChildChineseName, String fourthChildBirthDate,
			String fourthChildHealth, String fourthChildLive,
			String fourthChildStunt, String fourthChildCheckDate,
			String fifthChildPersonId, String fifthChildChineseName,
			String fifthChildBirthDate, String fifthChildHealth,
			String fifthChildLive, String fifthChildStunt,
			String fifthChildCheckDate, String sixthChildPersonId,
			String sixthChildChineseName, String sixthChildBirthDate,
			String sixthChildHealth, String sixthChildLive,
			String sixthChildStunt, String sixthChildCheckDate,
			String profileUpdateDate, String nationality,
			String nationalityCode, String marry, String divorce,
			String deathDate, String passportNo, String education,
			String occupation, String entryDate, String exitDate,
			String insureStatus, String marryApplyDate,
			String twSpouseHandiCapType, String twSpouseDisabilityClass,
			String lowIncome, String maintainDeptId, String createDeptId,
			String deleteFlag, String createUserId, String createProgramId,
			Date createTime, String maintainHost, String mainUserId,
			String maintainProgramId, Date lastUpdateTime) {
		this.id = id;
		this.residentIdNo1 = residentIdNo1;
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

	public FsForeignHealthCareId getId() {
		return this.id;
	}

	public void setId(FsForeignHealthCareId id) {
		this.id = id;
	}

	public String getResidentIdNo1() {
		return this.residentIdNo1;
	}

	public void setResidentIdNo1(String residentIdNo1) {
		this.residentIdNo1 = residentIdNo1;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTwSpousePersonId() {
		return this.twSpousePersonId;
	}

	public void setTwSpousePersonId(String twSpousePersonId) {
		this.twSpousePersonId = twSpousePersonId;
	}

	public String getTwSpouseChineseName() {
		return this.twSpouseChineseName;
	}

	public void setTwSpouseChineseName(String twSpouseChineseName) {
		this.twSpouseChineseName = twSpouseChineseName;
	}

	public String getTwSpouseBirthDate() {
		return this.twSpouseBirthDate;
	}

	public void setTwSpouseBirthDate(String twSpouseBirthDate) {
		this.twSpouseBirthDate = twSpouseBirthDate;
	}

	public String getTwSpouseRegionCode() {
		return this.twSpouseRegionCode;
	}

	public void setTwSpouseRegionCode(String twSpouseRegionCode) {
		this.twSpouseRegionCode = twSpouseRegionCode;
	}

	public String getTwSpouseAddr() {
		return this.twSpouseAddr;
	}

	public void setTwSpouseAddr(String twSpouseAddr) {
		this.twSpouseAddr = twSpouseAddr;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProfileCreateDate() {
		return this.profileCreateDate;
	}

	public void setProfileCreateDate(String profileCreateDate) {
		this.profileCreateDate = profileCreateDate;
	}

	public String getTrackDate() {
		return this.trackDate;
	}

	public void setTrackDate(String trackDate) {
		this.trackDate = trackDate;
	}

	public String getMentalHealth() {
		return this.mentalHealth;
	}

	public void setMentalHealth(String mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

	public String getPsychosis() {
		return this.psychosis;
	}

	public void setPsychosis(String psychosis) {
		this.psychosis = psychosis;
	}

	public String getDisability() {
		return this.disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getImmature() {
		return this.immature;
	}

	public void setImmature(String immature) {
		this.immature = immature;
	}

	public String getForeignSpouseMark() {
		return this.foreignSpouseMark;
	}

	public void setForeignSpouseMark(String foreignSpouseMark) {
		this.foreignSpouseMark = foreignSpouseMark;
	}

	public String getPregnancy() {
		return this.pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	public String getBirthCheckDate() {
		return this.birthCheckDate;
	}

	public void setBirthCheckDate(String birthCheckDate) {
		this.birthCheckDate = birthCheckDate;
	}

	public String getBirthControl() {
		return this.birthControl;
	}

	public void setBirthControl(String birthControl) {
		this.birthControl = birthControl;
	}

	public String getChildNo() {
		return this.childNo;
	}

	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}

	public String getCaseStudy() {
		return this.caseStudy;
	}

	public void setCaseStudy(String caseStudy) {
		this.caseStudy = caseStudy;
	}

	public String getHygienGuide() {
		return this.hygienGuide;
	}

	public void setHygienGuide(String hygienGuide) {
		this.hygienGuide = hygienGuide;
	}

	public String getLiveRegionCode() {
		return this.liveRegionCode;
	}

	public void setLiveRegionCode(String liveRegionCode) {
		this.liveRegionCode = liveRegionCode;
	}

	public String getLiveAddr() {
		return this.liveAddr;
	}

	public void setLiveAddr(String liveAddr) {
		this.liveAddr = liveAddr;
	}

	public String getDayTel() {
		return this.dayTel;
	}

	public void setDayTel(String dayTel) {
		this.dayTel = dayTel;
	}

	public String getNightTel() {
		return this.nightTel;
	}

	public void setNightTel(String nightTel) {
		this.nightTel = nightTel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFirstChildPersonId() {
		return this.firstChildPersonId;
	}

	public void setFirstChildPersonId(String firstChildPersonId) {
		this.firstChildPersonId = firstChildPersonId;
	}

	public String getFirstChildChineseName() {
		return this.firstChildChineseName;
	}

	public void setFirstChildChineseName(String firstChildChineseName) {
		this.firstChildChineseName = firstChildChineseName;
	}

	public String getFirstChildBirthDate() {
		return this.firstChildBirthDate;
	}

	public void setFirstChildBirthDate(String firstChildBirthDate) {
		this.firstChildBirthDate = firstChildBirthDate;
	}

	public String getFirstChildHealth() {
		return this.firstChildHealth;
	}

	public void setFirstChildHealth(String firstChildHealth) {
		this.firstChildHealth = firstChildHealth;
	}

	public String getFirstChildLive() {
		return this.firstChildLive;
	}

	public void setFirstChildLive(String firstChildLive) {
		this.firstChildLive = firstChildLive;
	}

	public String getFirstChildStunt() {
		return this.firstChildStunt;
	}

	public void setFirstChildStunt(String firstChildStunt) {
		this.firstChildStunt = firstChildStunt;
	}

	public String getFirstChildCheckDate() {
		return this.firstChildCheckDate;
	}

	public void setFirstChildCheckDate(String firstChildCheckDate) {
		this.firstChildCheckDate = firstChildCheckDate;
	}

	public String getSecondChildPersonId() {
		return this.secondChildPersonId;
	}

	public void setSecondChildPersonId(String secondChildPersonId) {
		this.secondChildPersonId = secondChildPersonId;
	}

	public String getSecondChildChineseName() {
		return this.secondChildChineseName;
	}

	public void setSecondChildChineseName(String secondChildChineseName) {
		this.secondChildChineseName = secondChildChineseName;
	}

	public String getSecondChildBirthDate() {
		return this.secondChildBirthDate;
	}

	public void setSecondChildBirthDate(String secondChildBirthDate) {
		this.secondChildBirthDate = secondChildBirthDate;
	}

	public String getSecondChildHealth() {
		return this.secondChildHealth;
	}

	public void setSecondChildHealth(String secondChildHealth) {
		this.secondChildHealth = secondChildHealth;
	}

	public String getSecondChildLive() {
		return this.secondChildLive;
	}

	public void setSecondChildLive(String secondChildLive) {
		this.secondChildLive = secondChildLive;
	}

	public String getSecondChildStunt() {
		return this.secondChildStunt;
	}

	public void setSecondChildStunt(String secondChildStunt) {
		this.secondChildStunt = secondChildStunt;
	}

	public String getSecondChildCheckDate() {
		return this.secondChildCheckDate;
	}

	public void setSecondChildCheckDate(String secondChildCheckDate) {
		this.secondChildCheckDate = secondChildCheckDate;
	}

	public String getThirdChildPersonId() {
		return this.thirdChildPersonId;
	}

	public void setThirdChildPersonId(String thirdChildPersonId) {
		this.thirdChildPersonId = thirdChildPersonId;
	}

	public String getThirdChildChineseName() {
		return this.thirdChildChineseName;
	}

	public void setThirdChildChineseName(String thirdChildChineseName) {
		this.thirdChildChineseName = thirdChildChineseName;
	}

	public String getThirdChildBirthDate() {
		return this.thirdChildBirthDate;
	}

	public void setThirdChildBirthDate(String thirdChildBirthDate) {
		this.thirdChildBirthDate = thirdChildBirthDate;
	}

	public String getThirdChildHealth() {
		return this.thirdChildHealth;
	}

	public void setThirdChildHealth(String thirdChildHealth) {
		this.thirdChildHealth = thirdChildHealth;
	}

	public String getThirdChildLive() {
		return this.thirdChildLive;
	}

	public void setThirdChildLive(String thirdChildLive) {
		this.thirdChildLive = thirdChildLive;
	}

	public String getThirdChildStunt() {
		return this.thirdChildStunt;
	}

	public void setThirdChildStunt(String thirdChildStunt) {
		this.thirdChildStunt = thirdChildStunt;
	}

	public String getThirdChildCheckDate() {
		return this.thirdChildCheckDate;
	}

	public void setThirdChildCheckDate(String thirdChildCheckDate) {
		this.thirdChildCheckDate = thirdChildCheckDate;
	}

	public String getFourthChildPersonId() {
		return this.fourthChildPersonId;
	}

	public void setFourthChildPersonId(String fourthChildPersonId) {
		this.fourthChildPersonId = fourthChildPersonId;
	}

	public String getFourthChildChineseName() {
		return this.fourthChildChineseName;
	}

	public void setFourthChildChineseName(String fourthChildChineseName) {
		this.fourthChildChineseName = fourthChildChineseName;
	}

	public String getFourthChildBirthDate() {
		return this.fourthChildBirthDate;
	}

	public void setFourthChildBirthDate(String fourthChildBirthDate) {
		this.fourthChildBirthDate = fourthChildBirthDate;
	}

	public String getFourthChildHealth() {
		return this.fourthChildHealth;
	}

	public void setFourthChildHealth(String fourthChildHealth) {
		this.fourthChildHealth = fourthChildHealth;
	}

	public String getFourthChildLive() {
		return this.fourthChildLive;
	}

	public void setFourthChildLive(String fourthChildLive) {
		this.fourthChildLive = fourthChildLive;
	}

	public String getFourthChildStunt() {
		return this.fourthChildStunt;
	}

	public void setFourthChildStunt(String fourthChildStunt) {
		this.fourthChildStunt = fourthChildStunt;
	}

	public String getFourthChildCheckDate() {
		return this.fourthChildCheckDate;
	}

	public void setFourthChildCheckDate(String fourthChildCheckDate) {
		this.fourthChildCheckDate = fourthChildCheckDate;
	}

	public String getFifthChildPersonId() {
		return this.fifthChildPersonId;
	}

	public void setFifthChildPersonId(String fifthChildPersonId) {
		this.fifthChildPersonId = fifthChildPersonId;
	}

	public String getFifthChildChineseName() {
		return this.fifthChildChineseName;
	}

	public void setFifthChildChineseName(String fifthChildChineseName) {
		this.fifthChildChineseName = fifthChildChineseName;
	}

	public String getFifthChildBirthDate() {
		return this.fifthChildBirthDate;
	}

	public void setFifthChildBirthDate(String fifthChildBirthDate) {
		this.fifthChildBirthDate = fifthChildBirthDate;
	}

	public String getFifthChildHealth() {
		return this.fifthChildHealth;
	}

	public void setFifthChildHealth(String fifthChildHealth) {
		this.fifthChildHealth = fifthChildHealth;
	}

	public String getFifthChildLive() {
		return this.fifthChildLive;
	}

	public void setFifthChildLive(String fifthChildLive) {
		this.fifthChildLive = fifthChildLive;
	}

	public String getFifthChildStunt() {
		return this.fifthChildStunt;
	}

	public void setFifthChildStunt(String fifthChildStunt) {
		this.fifthChildStunt = fifthChildStunt;
	}

	public String getFifthChildCheckDate() {
		return this.fifthChildCheckDate;
	}

	public void setFifthChildCheckDate(String fifthChildCheckDate) {
		this.fifthChildCheckDate = fifthChildCheckDate;
	}

	public String getSixthChildPersonId() {
		return this.sixthChildPersonId;
	}

	public void setSixthChildPersonId(String sixthChildPersonId) {
		this.sixthChildPersonId = sixthChildPersonId;
	}

	public String getSixthChildChineseName() {
		return this.sixthChildChineseName;
	}

	public void setSixthChildChineseName(String sixthChildChineseName) {
		this.sixthChildChineseName = sixthChildChineseName;
	}

	public String getSixthChildBirthDate() {
		return this.sixthChildBirthDate;
	}

	public void setSixthChildBirthDate(String sixthChildBirthDate) {
		this.sixthChildBirthDate = sixthChildBirthDate;
	}

	public String getSixthChildHealth() {
		return this.sixthChildHealth;
	}

	public void setSixthChildHealth(String sixthChildHealth) {
		this.sixthChildHealth = sixthChildHealth;
	}

	public String getSixthChildLive() {
		return this.sixthChildLive;
	}

	public void setSixthChildLive(String sixthChildLive) {
		this.sixthChildLive = sixthChildLive;
	}

	public String getSixthChildStunt() {
		return this.sixthChildStunt;
	}

	public void setSixthChildStunt(String sixthChildStunt) {
		this.sixthChildStunt = sixthChildStunt;
	}

	public String getSixthChildCheckDate() {
		return this.sixthChildCheckDate;
	}

	public void setSixthChildCheckDate(String sixthChildCheckDate) {
		this.sixthChildCheckDate = sixthChildCheckDate;
	}

	public String getProfileUpdateDate() {
		return this.profileUpdateDate;
	}

	public void setProfileUpdateDate(String profileUpdateDate) {
		this.profileUpdateDate = profileUpdateDate;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityCode() {
		return this.nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public String getMarry() {
		return this.marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getDivorce() {
		return this.divorce;
	}

	public void setDivorce(String divorce) {
		this.divorce = divorce;
	}

	public String getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getInsureStatus() {
		return this.insureStatus;
	}

	public void setInsureStatus(String insureStatus) {
		this.insureStatus = insureStatus;
	}

	public String getMarryApplyDate() {
		return this.marryApplyDate;
	}

	public void setMarryApplyDate(String marryApplyDate) {
		this.marryApplyDate = marryApplyDate;
	}

	public String getTwSpouseHandiCapType() {
		return this.twSpouseHandiCapType;
	}

	public void setTwSpouseHandiCapType(String twSpouseHandiCapType) {
		this.twSpouseHandiCapType = twSpouseHandiCapType;
	}

	public String getTwSpouseDisabilityClass() {
		return this.twSpouseDisabilityClass;
	}

	public void setTwSpouseDisabilityClass(String twSpouseDisabilityClass) {
		this.twSpouseDisabilityClass = twSpouseDisabilityClass;
	}

	public String getLowIncome() {
		return this.lowIncome;
	}

	public void setLowIncome(String lowIncome) {
		this.lowIncome = lowIncome;
	}

	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateProgramId() {
		return this.createProgramId;
	}

	public void setCreateProgramId(String createProgramId) {
		this.createProgramId = createProgramId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
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

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
