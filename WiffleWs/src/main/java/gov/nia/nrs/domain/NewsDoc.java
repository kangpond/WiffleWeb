package gov.nia.nrs.domain;

import gov.nia.nrs.system.dialect.NStringUserType;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NewsDoc
 */
@Entity
@Table(name = "NewsDoc")
public class NewsDoc implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "newsSeq", column = @Column(name = "NewsSeq", nullable = false, precision = 6, scale = 0)),
			@AttributeOverride(name = "uuid", column = @Column(name = "Uuid", nullable = false, length = 32)) })
	private NewsDocId id;

	@Column(name = "UploadDeptId", length = 10)
	private String uploadDeptId;

	@Column(name = "UploadUserId", length = 10)
	private String uploadUserId;

	@Column(name = "FileName")
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.dialect.NStringUserType")
	private String fileName;

	@Column(name = "CreateDate", length = 8)
	private String createDate;

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	private String deleteFlag;

	@Column(name = "CreateUserId", nullable = false, length = 10)
	private String createUserId;

	@Column(name = "CreateProgramId", nullable = false, length = 20)
	private String createProgramId;

	@Column(name = "CreateTime", nullable = false, length = 23)
	private Date createTime;

	@Column(name = "MaintainHost", nullable = false, length = 2)
	private String maintainHost;

	@Column(name = "MainUserId", nullable = false, length = 10)
	private String mainUserId;

	@Column(name = "MaintainProgramId", nullable = false, length = 20)
	private String maintainProgramId;

	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	private Date lastUpdateTime;

	public NewsDoc() {
	}

	public NewsDocId getId() {
		return this.id;
	}

	public void setId(NewsDocId id) {
		this.id = id;
	}

	public String getUploadDeptId() {
		return this.uploadDeptId;
	}

	public void setUploadDeptId(String uploadDeptId) {
		this.uploadDeptId = uploadDeptId;
	}

	public String getUploadUserId() {
		return this.uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
