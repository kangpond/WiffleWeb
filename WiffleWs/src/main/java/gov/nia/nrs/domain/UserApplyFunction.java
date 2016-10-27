package gov.nia.nrs.domain;

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
 * UserApplyFunction
 */
@Entity
@Table(name = "UserApplyFunction")
public class UserApplyFunction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private UserApplyFunctionId id;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String deleteFlag;
	private Date lastUpdateTime;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;

	public UserApplyFunction() {
	}

	public UserApplyFunction(UserApplyFunctionId id, String deleteFlag,
			Date lastUpdateTime, String mainUserId, String maintainFunctionId,
			String maintainHost) {
		this.id = id;
		this.deleteFlag = deleteFlag;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
	}

	public UserApplyFunction(UserApplyFunctionId id, String createDate,
			String createTime, String createUserId, String deleteFlag,
			Date lastUpdateTime, String mainUserId, String maintainFunctionId,
			String maintainHost) {
		this.id = id;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.deleteFlag = deleteFlag;
		this.lastUpdateTime = lastUpdateTime;
		this.mainUserId = mainUserId;
		this.maintainFunctionId = maintainFunctionId;
		this.maintainHost = maintainHost;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "functionId", column = @Column(name = "FunctionId", nullable = false, length = 100)),
			@AttributeOverride(name = "uuid", column = @Column(name = "Uuid", nullable = false, length = 32)) })
	public UserApplyFunctionId getId() {
		return this.id;
	}

	public void setId(UserApplyFunctionId id) {
		this.id = id;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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

}
