/**
 * 
 */
package gov.nia.nrs.bean;

import gov.nia.nrs.domain.Functions;

import java.util.Date;
import java.util.List;

/**
 * @author Yang
 *
 */
public class UserProfile {

	private String userId;
	private String userName;
	private String deptId;
	private String deptName;
	private String userTitle;
	private List<Functions> functions;
	private List<Functions> otherFunctions;
	
	private String applyKind;
	private String state;
	private Date lastLoginDate;
	private String errMsg;
	
	private String uuid;
	private String maintainFunctionId;


	/**
	 * @return the userTitle
	 */
	public String getUserTitle() {
		return userTitle;
	}

	/**
	 * @param userTitle the userTitle to set
	 */
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	/**
	 * @return the applyKind
	 */
	public String getApplyKind() {
		return applyKind;
	}

	/**
	 * @param applyKind the applyKind to set
	 */
	public void setApplyKind(String applyKind) {
		this.applyKind = applyKind;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
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
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the functions
	 */
	public List<Functions> getFunctions() {
		return functions;
	}

	/**
	 * @param functions
	 *            the functions to set
	 */
	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMaintainFunctionId() {
		return maintainFunctionId;
	}

	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Functions> getOtherFunctions() {
		return otherFunctions;
	}

	public void setOtherFunctions(List<Functions> otherFunctions) {
		this.otherFunctions = otherFunctions;
	}

}
