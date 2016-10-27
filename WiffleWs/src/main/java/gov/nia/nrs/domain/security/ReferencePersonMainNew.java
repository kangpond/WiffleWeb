package gov.nia.nrs.domain.security;

import gov.nia.nrs.utils.StringUtil;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ReferencePersonMainNew
 */
@Entity
@Table(name = "ReferencePersonMainNew")
public class ReferencePersonMainNew implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ReferencePersonId", unique = true, nullable = false, length = 20)
	private String referencePersonId;

	@Column(name = "PersonId", length = 20)
	private String personId;

	@Column(name = "BirthDate", length = 8)
	private String birthDate;

	@Column(name = "Gender", length = 1)
	private String gender;

	@Column(name = "NativeCode", length = 1)
	private String nativeCode;

	@Column(name = "Native1", length = 4)
	private String native1;

	@Column(name = "Native2", length = 16)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String native2;

	@Column(name = "BirthPlaceCode", length = 1)
	private String birthPlaceCode;

	@Column(name = "BirthPlace1", length = 4)
	private String birthPlace1;

	@Column(name = "BirthPlace2", length = 16)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String birthPlace2;

	@Column(name = "ChineseName", length = 80)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String chineseName;

	@Column(name = "Name0", length = 68)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String name0;

	@Column(name = "Name1", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String name1;

	@Column(name = "Name2", length = 8)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String name2;

	@Column(name = "EnglishName", length = 50)
	private String englishName;

	@Column(name = "SortEnglishName", length = 50)
	private String sortEnglishName;

	@Column(name = "Nation", precision = 3, scale = 0)
	private Integer nation;

	@Column(name = "ForeignPassport", length = 15)
	private String foreignPassport;

	@Column(name = "Passport", length = 12)
	private String passport;

	@Column(name = "FirstReceiveNo", length = 12)
	private String firstReceiveNo;

	@Column(name = "ResidentIdNo", length = 10)
	private String residentIdNo;

	@Column(name = "PassengerId", length = 10)
	private String passengerId;

	@Column(name = "Addr", length = 200)
	private String addr;

	@Column(name = "CreateUserId", nullable = false, length = 50)
	private String createUserId;

	@Column(name = "CreateDeptId", nullable = false, length = 4)
	private String createDeptId;

	@Column(name = "CreateTime", nullable = false, length = 23)
	private Date createTime;

	@Column(name = "MainUserId", nullable = false, length = 50)
	private String mainUserId;

	@Column(name = "MaintainDeptId", nullable = false, length = 4)
	private String maintainDeptId;

	@Column(name = "MaintainProgramId", nullable = false, length = 100)
	private String maintainProgramId;

	@Column(name = "MaintainHost", nullable = false, length = 2)
	private String maintainHost;

	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	private Date lastUpdateTime;

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	private String deleteFlag;

	public ReferencePersonMainNew() {
	}

	public String getReferencePersonId() {
		return this.referencePersonId;
	}

	public void setReferencePersonId(String referencePersonId) {
		this.referencePersonId = referencePersonId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNativeCode() {
		return this.nativeCode;
	}

	public void setNativeCode(String nativeCode) {
		this.nativeCode = StringUtil.chkNull2empty(nativeCode);
	}

	public String getNative1() {
		return this.native1;
	}

	public void setNative1(String native1) {
		this.native1 = StringUtil.chkNull2empty(native1);
	}

	public String getNative2() {
		return this.native2;
	}

	public void setNative2(String native2) {
		this.native2 = StringUtil.chkNull2empty(native2);
	}

	public String getBirthPlaceCode() {
		return this.birthPlaceCode;
	}

	public void setBirthPlaceCode(String birthPlaceCode) {
		this.birthPlaceCode = StringUtil.chkNull2empty(birthPlaceCode);
	}

	public String getBirthPlace1() {
		return this.birthPlace1;
	}

	public void setBirthPlace1(String birthPlace1) {
		this.birthPlace1 = StringUtil.chkNull2empty(birthPlace1);
	}

	public String getBirthPlace2() {
		return this.birthPlace2;
	}

	public void setBirthPlace2(String birthPlace2) {
		this.birthPlace2 = StringUtil.chkNull2empty(birthPlace2);
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = StringUtil.chkNull2empty(chineseName);
	}

	public String getName0() {
		return this.name0;
	}

	public void setName0(String name0) {
		this.name0 = StringUtil.chkNull2empty(name0);
	}

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = StringUtil.chkNull2empty(name1);
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = StringUtil.chkNull2empty(name2);
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = StringUtil.chkNull2empty(englishName);
	}

	public String getSortEnglishName() {
		return this.sortEnglishName;
	}

	public void setSortEnglishName(String sortEnglishName) {
		this.sortEnglishName = StringUtil.chkNull2empty(sortEnglishName);
	}

	public Integer getNation() {
		return this.nation;
	}

	public void setNation(Integer nation) {
		this.nation = StringUtil.parseInt(String.valueOf(nation));
	}

	public String getForeignPassport() {
		return this.foreignPassport;
	}

	public void setForeignPassport(String foreignPassport) {
		this.foreignPassport = StringUtil.chkNull2empty(foreignPassport);
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = StringUtil.chkNull2empty(passport);
	}

	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = StringUtil.chkNull2empty(firstReceiveNo);
	}

	public String getResidentIdNo() {
		return this.residentIdNo;
	}

	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = StringUtil.chkNull2empty(residentIdNo);
	}

	public String getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = StringUtil.chkNull2empty(passengerId);
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = StringUtil.chkNull2empty(addr);
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReferencePersonMainNew [referencePersonId=" + referencePersonId
				+ ", personId=" + personId + ", birthDate=" + birthDate
				+ ", gender=" + gender + ", nativeCode=" + nativeCode
				+ ", native1=" + native1 + ", native2=" + native2
				+ ", birthPlaceCode=" + birthPlaceCode + ", birthPlace1="
				+ birthPlace1 + ", birthPlace2=" + birthPlace2
				+ ", chineseName=" + chineseName + ", name0=" + name0
				+ ", name1=" + name1 + ", name2=" + name2 + ", englishName="
				+ englishName + ", sortEnglishName=" + sortEnglishName
				+ ", nation=" + nation + ", foreignPassport=" + foreignPassport
				+ ", passport=" + passport + ", firstReceiveNo="
				+ firstReceiveNo + ", residentIdNo=" + residentIdNo
				+ ", passengerId=" + passengerId + ", addr=" + addr
				+ ", createUserId=" + createUserId + ", createDeptId="
				+ createDeptId + ", createTime=" + createTime + ", mainUserId="
				+ mainUserId + ", maintainDeptId=" + maintainDeptId
				+ ", maintainProgramId=" + maintainProgramId
				+ ", maintainHost=" + maintainHost + ", lastUpdateTime="
				+ lastUpdateTime + ", deleteFlag=" + deleteFlag + "]";
	}
	
}
