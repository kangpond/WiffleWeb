package gov.nia.nrs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FsOldAllowance
 */
@Entity
@Table(name = "FsOldAllowance")
public class FsOldAllowance implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String header;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String chineseName;
	private String marry;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String spouseName;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String cityA;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String townshipA;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String addr1a;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String addr2a;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String addr3a;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String addr4a;
	private String note;
	private String gender;
	private String birthDate;
	private String createDeptId;
	private String maintainDeptId;
	private String deleteFlag;
	private String createUserId;
	private String createProgramId;
	private Date createTime;
	private String maintainHost;
	private String mainUserId;
	private String maintainProgramId;
	private Date lastUpdateTime;

	public FsOldAllowance() {
	}

	public FsOldAllowance(String personId, String deleteFlag,
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

	public FsOldAllowance(String personId, String header,
			String chineseName, String marry,
			String spouseName, String cityA,
			String townshipA, String addr1a,
			String addr2a, String addr3a,
			String addr4a, String note, String gender,
			String birthDate, String createDeptId, String maintainDeptId,
			String deleteFlag, String createUserId, String createProgramId,
			Date createTime, String maintainHost, String mainUserId,
			String maintainProgramId, Date lastUpdateTime) {
		this.personId = personId;
		this.header = header;
		this.chineseName = chineseName;
		this.marry = marry;
		this.spouseName = spouseName;
		this.cityA = cityA;
		this.townshipA = townshipA;
		this.addr1a = addr1a;
		this.addr2a = addr2a;
		this.addr3a = addr3a;
		this.addr4a = addr4a;
		this.note = note;
		this.gender = gender;
		this.birthDate = birthDate;
		this.createDeptId = createDeptId;
		this.maintainDeptId = maintainDeptId;
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
	@Column(name = "PersonId", unique = true, nullable = false, length = 15)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "Header", length = 60)
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Column(name = "ChineseName")
	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	@Column(name = "Marry", length = 1)
	public String getMarry() {
		return this.marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	@Column(name = "SpouseName")
	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	@Column(name = "CityA")
	public String getCityA() {
		return this.cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
	}

	@Column(name = "TownshipA")
	public String getTownshipA() {
		return this.townshipA;
	}

	public void setTownshipA(String townshipA) {
		this.townshipA = townshipA;
	}

	@Column(name = "Addr1A")
	public String getAddr1a() {
		return this.addr1a;
	}

	public void setAddr1a(String addr1a) {
		this.addr1a = addr1a;
	}

	@Column(name = "Addr2A")
	public String getAddr2a() {
		return this.addr2a;
	}

	public void setAddr2a(String addr2a) {
		this.addr2a = addr2a;
	}

	@Column(name = "Addr3A")
	public String getAddr3a() {
		return this.addr3a;
	}

	public void setAddr3a(String addr3a) {
		this.addr3a = addr3a;
	}

	@Column(name = "Addr4A")
	public String getAddr4a() {
		return this.addr4a;
	}

	public void setAddr4a(String addr4a) {
		this.addr4a = addr4a;
	}

	@Column(name = "Note", length = 1)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "Gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "BirthDate", length = 8)
	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "CreateDeptId", length = 4)
	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	@Column(name = "MaintainDeptId", length = 4)
	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
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
