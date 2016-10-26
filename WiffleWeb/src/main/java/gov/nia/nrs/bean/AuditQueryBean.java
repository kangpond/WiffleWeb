package gov.nia.nrs.bean;


public class AuditQueryBean {

	private String type;
	private String startDate;
	private String endDate;
	private String actionType;

	private String personId;
	private String passportNo;
	private String permitNo;
	private String residentIdNo;
	private String firstReceiveNo;
	private String nation;
	private String chineseName;
	private String englishName;
	private String birthDate;

	private String userId;
	private String userName;
	private String deptId;
	private String deptType;

	private String operationType;

	private Integer startYear;
	private Integer startMons;
	private Integer endYear;
	private Integer endMons;


	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	public String getResidentIdNo() {
		return this.residentIdNo;
	}

	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = residentIdNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getStartMons() {
		return startMons;
	}

	public void setStartMons(Integer startMons) {
		this.startMons = startMons;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public Integer getEndMons() {
		return endMons;
	}

	public void setEndMons(Integer endMons) {
		this.endMons = endMons;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Override
	public String toString() {
		return "AuditQueryBean [type=" + type + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", actionType=" + actionType
				+ ", personId=" + personId + ", passportNo=" + passportNo
				+ ", permitNo=" + permitNo + ", residentIdNo=" + residentIdNo
				+ ", firstReceiveNo=" + firstReceiveNo + ", nation=" + nation
				+ ", chineseName=" + chineseName + ", englishName="
				+ englishName + ", birthDate=" + birthDate + ", userId="
				+ userId + ", userName=" + userName + ", deptId=" + deptId
				+ ", deptType=" + deptType + ", operationType=" + operationType
				+ ", startYear=" + startYear + ", startMons=" + startMons
				+ ", endYear=" + endYear + ", endMons=" + endMons + "]";
	}
	
}
