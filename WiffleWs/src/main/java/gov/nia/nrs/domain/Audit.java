package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Audit
 */
@Entity
@Table(name = "Audit")
public class Audit implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String nosqlKey;
	private String userId;
	private String userName;
	private Date auditTime;
	private String functionId;
	private String functionName;
	private String deptId;
	private String deptName;
	private String deptType;
	private String type;
	private String subType;
	private String actionType;
	private String auditMark;
	private String terminalId;
	private String ip;
	private String chineseName;
	private String englishName;
	private String birthDate;
	private String personId;
	private String passportNo;
	private String passengerId;
	private String nation;
	private String flightNo;
	private String permitNo;
	private String firstReceiveNo;
	private String residentIdNo;
	private Date syncTime;
	private Date last2updateTime;
	private String queryValue;
	private String txnMark;
	private String valueBefore;
	private String valueAfter;

	public Audit() {
	}

	public Audit(String nosqlKey, String userId, String userName,
			Date auditTime, String functionId, String functionName,
			String deptId, String deptName, String deptType, String type,
			String subType, String actionType) {
		this.nosqlKey = nosqlKey;
		this.userId = userId;
		this.userName = userName;
		this.auditTime = auditTime;
		this.functionId = functionId;
		this.functionName = functionName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptType = deptType;
		this.type = type;
		this.subType = subType;
		this.actionType = actionType;
	}

	public Audit(String nosqlKey, String userId, String userName,
			Date auditTime, String functionId, String functionName,
			String deptId, String deptName, String deptType, String type,
			String subType, String actionType, String auditMark,
			String terminalId, String ip, String chineseName,
			String englishName, String birthDate, String personId,
			String passportNo, String passengerId, String nation,
			String flightNo, String permitNo, String firstReceiveNo,
			String residentIdNo, Date syncTime, Date last2updateTime,
			String queryValue, String txnMark, String valueBefore,
			String valueAfter) {
		this.nosqlKey = nosqlKey;
		this.userId = userId;
		this.userName = userName;
		this.auditTime = auditTime;
		this.functionId = functionId;
		this.functionName = functionName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptType = deptType;
		this.type = type;
		this.subType = subType;
		this.actionType = actionType;
		this.auditMark = auditMark;
		this.terminalId = terminalId;
		this.ip = ip;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.birthDate = birthDate;
		this.personId = personId;
		this.passportNo = passportNo;
		this.passengerId = passengerId;
		this.nation = nation;
		this.flightNo = flightNo;
		this.permitNo = permitNo;
		this.firstReceiveNo = firstReceiveNo;
		this.residentIdNo = residentIdNo;
		this.syncTime = syncTime;
		this.last2updateTime = last2updateTime;
		this.queryValue = queryValue;
		this.txnMark = txnMark;
		this.valueBefore = valueBefore;
		this.valueAfter = valueAfter;
	}

	@Id
	@Column(name = "NosqlKey", unique = true, nullable = false, length = 25)
	public String getNosqlKey() {
		return this.nosqlKey;
	}

	public void setNosqlKey(String nosqlKey) {
		this.nosqlKey = nosqlKey;
	}

	@Column(name = "UserId", nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", nullable = false, length = 80)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AuditTime", nullable = false, length = 23)
	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	@Column(name = "FunctionId", nullable = false, length = 100)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "FunctionName", nullable = false, length = 100)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "DeptId", nullable = false, length = 50)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "DeptName", nullable = false, length = 80)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "DeptType", nullable = false, length = 1)
	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	@Column(name = "Type", nullable = false, length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "SubType", nullable = false, length = 1)
	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Column(name = "ActionType", nullable = false, length = 2)
	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Column(name = "AuditMark", length = 300)
	public String getAuditMark() {
		return this.auditMark;
	}

	public void setAuditMark(String auditMark) {
		this.auditMark = auditMark;
	}

	@Column(name = "TerminalId", length = 20)
	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	@Column(name = "IP", length = 39)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	@Column(name = "BirthDate", length = 8)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "PersonId", length = 20)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "PassportNo", length = 15)
	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Column(name = "PassengerId", length = 10)
	public String getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	@Column(name = "Nation", length = 3)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "FlightNo", length = 20)
	public String getFlightNo() {
		return this.flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Column(name = "PermitNo", length = 12)
	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	@Column(name = "FirstReceiveNo", length = 12)
	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	@Column(name = "ResidentIdNo", length = 10)
	public String getResidentIdNo() {
		return this.residentIdNo;
	}

	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = residentIdNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SyncTime", length = 23)
	public Date getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last2UpdateTime", length = 23)
	public Date getLast2updateTime() {
		return this.last2updateTime;
	}

	public void setLast2updateTime(Date last2updateTime) {
		this.last2updateTime = last2updateTime;
	}

	@Column(name = "QueryValue", length = 300)
	public String getQueryValue() {
		return this.queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	@Column(name = "TxnMark", length = 1)
	public String getTxnMark() {
		return this.txnMark;
	}

	public void setTxnMark(String txnMark) {
		this.txnMark = txnMark;
	}

	@Column(name = "ValueBefore")
	public String getValueBefore() {
		return this.valueBefore;
	}

	public void setValueBefore(String valueBefore) {
		this.valueBefore = valueBefore;
	}

	@Column(name = "ValueAfter")
	public String getValueAfter() {
		return this.valueAfter;
	}

	public void setValueAfter(String valueAfter) {
		this.valueAfter = valueAfter;
	}

}
