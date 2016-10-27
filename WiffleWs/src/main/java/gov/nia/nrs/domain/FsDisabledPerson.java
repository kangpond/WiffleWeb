package gov.nia.nrs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FsDisabledPerson
 */
@Entity
@Table(name = "FsDisabledPerson")
public class FsDisabledPerson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String chineseName;
	private String birthDate;
	private String gender;
	private String cityA;
	private String townshipA;
	private String neighborhood;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String road;
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String commAddr;
	private String tel;
	private String handiCapType;
	private String disabilityClass;
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

	public FsDisabledPerson() {
	}

	public FsDisabledPerson(String personId, String deleteFlag,
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

	public FsDisabledPerson(String personId, String chineseName,
			String birthDate, String gender, String cityA, String townshipA,
			String neighborhood, String road,
			String commAddr, String tel, String handiCapType,
			String disabilityClass, String maintainDeptId, String createDeptId,
			String deleteFlag, String createUserId, String createProgramId,
			Date createTime, String maintainHost, String mainUserId,
			String maintainProgramId, Date lastUpdateTime) {
		this.personId = personId;
		this.chineseName = chineseName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.cityA = cityA;
		this.townshipA = townshipA;
		this.neighborhood = neighborhood;
		this.road = road;
		this.commAddr = commAddr;
		this.tel = tel;
		this.handiCapType = handiCapType;
		this.disabilityClass = disabilityClass;
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
	@Column(name = "PersonId", unique = true, nullable = false, length = 15)
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

	@Column(name = "Gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "CityA", length = 5)
	public String getCityA() {
		return this.cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
	}

	@Column(name = "TownshipA", length = 3)
	public String getTownshipA() {
		return this.townshipA;
	}

	public void setTownshipA(String townshipA) {
		this.townshipA = townshipA;
	}

	@Column(name = "Neighborhood", length = 5)
	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Column(name = "Road")
	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	@Column(name = "CommAddr")
	public String getCommAddr() {
		return this.commAddr;
	}

	public void setCommAddr(String commAddr) {
		this.commAddr = commAddr;
	}

	@Column(name = "Tel", length = 30)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "HandiCapType", length = 2)
	public String getHandiCapType() {
		return this.handiCapType;
	}

	public void setHandiCapType(String handiCapType) {
		this.handiCapType = handiCapType;
	}

	@Column(name = "DisabilityClass", length = 1)
	public String getDisabilityClass() {
		return this.disabilityClass;
	}

	public void setDisabilityClass(String disabilityClass) {
		this.disabilityClass = disabilityClass;
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
