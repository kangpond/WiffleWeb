package gov.nia.nrs.domain;

import java.util.Date;

/**
 * FsOldAllowance
 */
public class FsOldAllowance implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String header;
	private String chineseName;
	private String marry;
	private String spouseName;
	private String cityA;
	private String townshipA;
	private String addr1a;
	private String addr2a;
	private String addr3a;
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

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getMarry() {
		return this.marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getCityA() {
		return this.cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
	}

	public String getTownshipA() {
		return this.townshipA;
	}

	public void setTownshipA(String townshipA) {
		this.townshipA = townshipA;
	}

	public String getAddr1a() {
		return this.addr1a;
	}

	public void setAddr1a(String addr1a) {
		this.addr1a = addr1a;
	}

	public String getAddr2a() {
		return this.addr2a;
	}

	public void setAddr2a(String addr2a) {
		this.addr2a = addr2a;
	}

	public String getAddr3a() {
		return this.addr3a;
	}

	public void setAddr3a(String addr3a) {
		this.addr3a = addr3a;
	}

	public String getAddr4a() {
		return this.addr4a;
	}

	public void setAddr4a(String addr4a) {
		this.addr4a = addr4a;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCreateDeptId() {
		return this.createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

	public String getMaintainDeptId() {
		return this.maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
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
