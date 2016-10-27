package gov.nia.nrs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Functions
 */
@Entity
@Table(name = "Functions")
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

	public Functions(String isLeaf,String state,String functionId,
			 					String functionType, String upperFunctionId) {
		this.functionId = functionId;
		this.functionType = functionType;
		this.isLeaf = isLeaf;
		this.state = state;
		this.upperFunctionId = upperFunctionId;
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

	@Id
	@Column(name = "FunctionId", unique = true, nullable = false, length = 100)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "ActionType", length = 32)
	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Column(name = "ClassName", length = 100)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "CreateDate", length = 8)
	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CreateTime", length = 6)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CreateUserId", length = 20)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "FunctionDesc", length = 100)
	public String getFunctionDesc() {
		return this.functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	@Column(name = "FunctionName", length = 100)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "FunctionType", length = 1)
	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	@Column(name = "IsLeaf", length = 1)
	public String getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "LinkURL", length = 256)
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(name = "MainUserId", nullable = false, length = 20)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainFunctionId", nullable = false, length = 100)
	public String getMaintainFunctionId() {
		return this.maintainFunctionId;
	}

	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}

	@Column(name = "MaintainHost", nullable = false, length = 2)
	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	@Column(name = "Sequence", nullable = false)
	public Long getSequence() {
		return this.sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	@Column(name = "State", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "UpperFunctionId", length = 100)
	public String getUpperFunctionId() {
		return this.upperFunctionId;
	}

	public void setUpperFunctionId(String upperFunctionId) {
		this.upperFunctionId = upperFunctionId;
	}

	@Column(name = "Visible", length = 1)
	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}
