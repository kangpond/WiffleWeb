package gov.nia.nrs.domain;

import java.util.Date;

/**
 * Functions
 */
public class Functions implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String functionId;
	private String actionType;
	private String className;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String deleteFlag;
	private String functionDesc;
	private String functionName;
	private String functionType;
	private String isLeaf;
	private Date lastUpdateTime;
	private String linkUrl;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;
	private Long sequence;
	private String state;
	private String upperFunctionId;
	private String visible;

	public Functions() {
	}

	public Functions(String functionId, String deleteFlag, Date lastUpdateTime,
			String mainUserId, String maintainFunctionId, String maintainHost,
			Long sequence, String state) {
		this.functionId = functionId;
		this.deleteFlag = deleteFlag;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.sequence = sequence;
		this.state = state;
	}

	public Functions(String functionId, String actionType, String className,
			String createDate, String createTime, String createUserId,
			String deleteFlag, String functionDesc, String functionName,
			String functionType, String isLeaf, Date lastUpdateTime,
			String linkUrl, String mainUserId, String maintainFunctionId,
			String maintainHost, Long sequence, String state,
			String upperFunctionId, String visible) {
		this.functionId = functionId;
		this.actionType = actionType;
		this.className = className;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.deleteFlag = deleteFlag;
		this.functionDesc = functionDesc;
		this.functionName = functionName;
		this.functionType = functionType;
		this.isLeaf = isLeaf;
		this.lastUpdateTime = lastUpdateTime;
		this.linkUrl = linkUrl;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
		this.sequence = sequence;
		this.state = state;
		this.upperFunctionId = upperFunctionId;
		this.visible = visible;
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
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the functionDesc
	 */
	public String getFunctionDesc() {
		return functionDesc;
	}

	/**
	 * @param functionDesc the functionDesc to set
	 */
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
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
	 * @return the functionType
	 */
	public String getFunctionType() {
		return functionType;
	}

	/**
	 * @param functionType the functionType to set
	 */
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	/**
	 * @return the isLeaf
	 */
	public String getIsLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf the isLeaf to set
	 */
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * @param linkUrl the linkUrl to set
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
	 * @return the mainUserId
	 */
	public String getMainUserId() {
		return mainUserId;
	}

	/**
	 * @param mainUserId the mainUserId to set
	 */
	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	/**
	 * @return the maintainFunctionId
	 */
	public String getMaintainFunctionId() {
		return maintainFunctionId;
	}

	/**
	 * @param maintainFunctionId the maintainFunctionId to set
	 */
	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	/**
	 * @return the maintainHost
	 */
	public String getMaintainHost() {
		return maintainHost;
	}

	/**
	 * @param maintainHost the maintainHost to set
	 */
	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	/**
	 * @return the sequence
	 */
	public Long getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
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
	 * @return the upperFunctionId
	 */
	public String getUpperFunctionId() {
		return upperFunctionId;
	}

	/**
	 * @param upperFunctionId the upperFunctionId to set
	 */
	public void setUpperFunctionId(String upperFunctionId) {
		this.upperFunctionId = upperFunctionId;
	}

	/**
	 * @return the visible
	 */
	public String getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(String visible) {
		this.visible = visible;
	}

	
}
