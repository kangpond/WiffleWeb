package gov.nia.nrs.domain;

import java.util.Date;

/**
 * Audit
 */
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

	/**
	 * @return the nosqlKey
	 */
	public String getNosqlKey() {
		return nosqlKey;
	}

	/**
	 * @param nosqlKey the nosqlKey to set
	 */
	public void setNosqlKey(String nosqlKey) {
		this.nosqlKey = nosqlKey;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the auditTime
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @return the functionId
	 */
	public String getFunctionId() {
		return functionId;
	}

	/**
	 * @param functionId the functionId to set
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the deptType
	 */
	public String getDeptType() {
		return deptType;
	}

	/**
	 * @param deptType the deptType to set
	 */
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return the actionType
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return the auditMark
	 */
	public String getAuditMark() {
		return auditMark;
	}

	/**
	 * @param auditMark the auditMark to set
	 */
	public void setAuditMark(String auditMark) {
		this.auditMark = auditMark;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the chineseName
	 */
	public String getChineseName() {
		return chineseName;
	}

	/**
	 * @param chineseName the chineseName to set
	 */
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	/**
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * @param passportNo the passportNo to set
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * @return the passengerId
	 */
	public String getPassengerId() {
		return passengerId;
	}

	/**
	 * @param passengerId the passengerId to set
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * @return the permitNo
	 */
	public String getPermitNo() {
		return permitNo;
	}

	/**
	 * @param permitNo the permitNo to set
	 */
	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	/**
	 * @return the firstReceiveNo
	 */
	public String getFirstReceiveNo() {
		return firstReceiveNo;
	}

	/**
	 * @param firstReceiveNo the firstReceiveNo to set
	 */
	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	/**
	 * @return the residentIdNo
	 */
	public String getResidentIdNo() {
		return residentIdNo;
	}

	/**
	 * @param residentIdNo the residentIdNo to set
	 */
	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = residentIdNo;
	}

	/**
	 * @return the syncTime
	 */
	public Date getSyncTime() {
		return syncTime;
	}

	/**
	 * @param syncTime the syncTime to set
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	/**
	 * @return the last2updateTime
	 */
	public Date getLast2updateTime() {
		return last2updateTime;
	}

	/**
	 * @param last2updateTime the last2updateTime to set
	 */
	public void setLast2updateTime(Date last2updateTime) {
		this.last2updateTime = last2updateTime;
	}

	/**
	 * @return the queryValue
	 */
	public String getQueryValue() {
		return queryValue;
	}

	/**
	 * @param queryValue the queryValue to set
	 */
	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	/**
	 * @return the txnMark
	 */
	public String getTxnMark() {
		return txnMark;
	}

	/**
	 * @param txnMark the txnMark to set
	 */
	public void setTxnMark(String txnMark) {
		this.txnMark = txnMark;
	}

	/**
	 * @return the valueBefore
	 */
	public String getValueBefore() {
		return valueBefore;
	}

	/**
	 * @param valueBefore the valueBefore to set
	 */
	public void setValueBefore(String valueBefore) {
		this.valueBefore = valueBefore;
	}

	/**
	 * @return the valueAfter
	 */
	public String getValueAfter() {
		return valueAfter;
	}

	/**
	 * @param valueAfter the valueAfter to set
	 */
	public void setValueAfter(String valueAfter) {
		this.valueAfter = valueAfter;
	}

	

}
