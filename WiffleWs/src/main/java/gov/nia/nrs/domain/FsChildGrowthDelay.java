package gov.nia.nrs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FsChildGrowthDelay
 */
@Entity
@Table(name = "FsChildGrowthDelay")
public class FsChildGrowthDelay implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String chineseName;
	private String birthDate;
	private String firstReceiveNo;
	private String gender;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String fatherChineseName;
	private String fatherBirthDate;
	private String fatherPersonId;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String motherChineseName;
	private String motheBirthDate;
	private String mothePersonId;
	private String announceDate;
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

	public FsChildGrowthDelay() {
	}

	public FsChildGrowthDelay(String personId, String deleteFlag,
			String createUserId, String createProgramId, Date createTime,
			String maintainHost, String mainUserId, String maintainProgramId,
			Date lastUpdateTime) {
		this.personId = personId;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createProgramId = createProgramId;
		this.createTime = createTime;
		this.maintainHost = maintainHost;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.lastUpdateTime = lastUpdateTime;
	}

	public FsChildGrowthDelay(String personId, String chineseName,
			String birthDate, String firstReceiveNo, String gender,
			String fatherChineseName, String fatherBirthDate,
			String fatherPersonId, String motherChineseName,
			String motheBirthDate, String mothePersonId, String announceDate,
			String maintainDeptId, String createDeptId, String deleteFlag,
			String createUserId, String createProgramId, Date createTime,
			String maintainHost, String mainUserId, String maintainProgramId,
			Date lastUpdateTime) {
		this.personId = personId;
		this.chineseName = chineseName;
		this.birthDate = birthDate;
		this.firstReceiveNo = firstReceiveNo;
		this.gender = gender;
		this.fatherChineseName = fatherChineseName;
		this.fatherBirthDate = fatherBirthDate;
		this.fatherPersonId = fatherPersonId;
		this.motherChineseName = motherChineseName;
		this.motheBirthDate = motheBirthDate;
		this.mothePersonId = mothePersonId;
		this.announceDate = announceDate;
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

	@Id
	@Column(name = "PersonId", unique = true, nullable = false, length = 10)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "ChineseName")
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "BirthDate", length = 8)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "FirstReceiveNo", length = 12)
	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	@Column(name = "Gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "FatherChineseName")
	public String getFatherChineseName() {
		return this.fatherChineseName;
	}

	public void setFatherChineseName(String fatherChineseName) {
		this.fatherChineseName = fatherChineseName;
	}

	@Column(name = "FatherBirthDate", length = 8)
	public String getFatherBirthDate() {
		return this.fatherBirthDate;
	}

	public void setFatherBirthDate(String fatherBirthDate) {
		this.fatherBirthDate = fatherBirthDate;
	}

	@Column(name = "FatherPersonId", length = 10)
	public String getFatherPersonId() {
		return this.fatherPersonId;
	}

	public void setFatherPersonId(String fatherPersonId) {
		this.fatherPersonId = fatherPersonId;
	}

	@Column(name = "MotherChineseName")
	public String getMotherChineseName() {
		return this.motherChineseName;
	}

	public void setMotherChineseName(String motherChineseName) {
		this.motherChineseName = motherChineseName;
	}

	@Column(name = "MotheBirthDate", length = 8)
	public String getMotheBirthDate() {
		return this.motheBirthDate;
	}

	public void setMotheBirthDate(String motheBirthDate) {
		this.motheBirthDate = motheBirthDate;
	}

	@Column(name = "MothePersonId", length = 10)
	public String getMothePersonId() {
		return this.mothePersonId;
	}

	public void setMothePersonId(String mothePersonId) {
		this.mothePersonId = mothePersonId;
	}

	@Column(name = "AnnounceDate", length = 8)
	public String getAnnounceDate() {
		return this.announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	@Column(name = "MaintainDeptId", length = 4)
	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	@Column(name = "CreateDeptId", length = 4)
	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name = "CreateUserId", nullable = false, length = 10)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "CreateProgramId", nullable = false, length = 20)
	public String getCreateProgramId() {
		return this.createProgramId;
	}

	public void setCreateProgramId(String createProgramId) {
		this.createProgramId = createProgramId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateTime", nullable = false, length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "MaintainHost", nullable = false, length = 2)
	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	@Column(name = "MainUserId", nullable = false, length = 10)
	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	@Column(name = "MaintainProgramId", nullable = false, length = 20)
	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
