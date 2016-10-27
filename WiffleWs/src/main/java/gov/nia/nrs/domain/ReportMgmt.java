package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ReportMgmt
 */
@Entity
@Table(name = "ReportMgmt")
public class ReportMgmt implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ReportId", unique = true, nullable = false, length = 100)
	private String reportId;

	@Column(name = "ReportName", length = 1000)
	private String reportName;

	@Column(name = "UserId", nullable = false, length = 20)
	private String userId;

	@Column(name = "DeptId", length = 10)
	private String deptId;

	@Column(name = "RequestTime", nullable = false, length = 23)
	private Date requestTime;

	@Column(name = "ResponTime", length = 23)
	private Date responTime;

	@Column(name = "ProcessState", length = 1)
	private String processState;

	@Column(name = "FilePath", length = 1000)
	private String filePath;

	@Column(name = "StartDate", length = 8)
	private String startDate;

	@Column(name = "EndDate", length = 8)
	private String endDate;

	@Column(name = "Type", length = 10)
	private String type;

	@Column(name = "ActionType", length = 6)
	private String actionType;

	@Column(name = "ChineseName", length = 80)
	private String chineseName;

	@Column(name = "EnglishName", length = 50)
	private String englishName;

	@Column(name = "BirthDate", length = 8)
	private String birthDate;

	@Column(name = "PersonId", length = 20)
	private String personId;

	@Column(name = "PassportNo", length = 15)
	private String passportNo;

	@Column(name = "Nation", length = 3)
	private String nation;

	@Column(name = "PermitNo", length = 12)
	private String permitNo;

	@Column(name = "FirstReceiveNo", length = 12)
	private String firstReceiveNo;

	@Column(name = "ResidentIdNo", length = 10)
	private String residentIdNo;

	@Column(name = "UserName", length = 80)
	private String userName;

	@Column(name = "DeptType", length = 1)
	private String deptType;

	@Column(name = "DepId", length = 10)
	private String depId;

	@Column(name = "SubType", nullable = false, length = 1)
	private String subType;

	@Column(name = "ReportUserId", nullable = false, length = 20)
	private String reportUserId;
	

	@Column(name = "ReportDeptId", nullable = false, length = 10)
	private String reportDeptId;
	
	public ReportMgmt() {
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Date getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getResponTime() {
		return this.responTime;
	}

	public void setResponTime(Date responTime) {
		this.responTime = responTime;
	}

	public String getProcessState() {
		return this.processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getDepId() {
		return this.depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}
	
	public String getReportUserId() {
		return reportUserId;
	}

	public void setReportUserId(String reportUserId) {
		this.reportUserId = reportUserId;
	}

	public String getReportDeptId() {
		return reportDeptId;
	}

	public void setReportDeptId(String reportDeptId) {
		this.reportDeptId = reportDeptId;
	}

}
