package gov.nia.nrs.domain;



import gov.nia.nrs.system.dialect.NStringUserType;
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
 * FsForeignLaborIsurance
 */
@Entity
@Table(name="FsForeignLaborIsurance"
)
public class FsForeignLaborIsurance  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private FsForeignLaborIsuranceId id;
    private String firstReceiveNo;
    @org.hibernate.annotations.Type(type="gov.nia.nrs.system.dialect.NStringUserType")
    private String chineseName;
    private String birthDate;
    private String gender;
    private String insureCheckId;
    @org.hibernate.annotations.Type(type="gov.nia.nrs.system.dialect.NStringUserType")
    private String insureUnit;
    @org.hibernate.annotations.Type(type="gov.nia.nrs.system.dialect.NStringUserType")
    private String insureUnitAddr;
    private String insureOccupation;
    private String changeId;
    private Integer salary;
    @org.hibernate.annotations.Type(type="gov.nia.nrs.system.dialect.NStringUserType")
    private String remark;
    private String changeId1;
    private Integer salary1;
    private String createDeptId;
    private String deleteFlag;
    private String createUserId;
    private String createProgramId;
    private Date createTime;
    private String maintainHost;
    private String mainUserId;
    private String maintainProgramId;
    private Date lastUpdateTime;

    public FsForeignLaborIsurance() {}

	
    public FsForeignLaborIsurance(FsForeignLaborIsuranceId id, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.id = id;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
    public FsForeignLaborIsurance(FsForeignLaborIsuranceId id, String firstReceiveNo, String chineseName, String birthDate, String gender, String insureCheckId, String insureUnit, String insureUnitAddr, String insureOccupation, String changeId, Integer salary, String remark, String changeId1, Integer salary1, String createDeptId, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.id = id;
        this.firstReceiveNo = firstReceiveNo;
        this.chineseName = chineseName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.insureCheckId = insureCheckId;
        this.insureUnit = insureUnit;
        this.insureUnitAddr = insureUnitAddr;
        this.insureOccupation = insureOccupation;
        this.changeId = changeId;
        this.salary = salary;
        this.remark = remark;
        this.changeId1 = changeId1;
        this.salary1 = salary1;
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
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="residentIdNo", column=@Column(name="ResidentIdNo", nullable=false, length=10) ), 
        @AttributeOverride(name="insureId", column=@Column(name="InsureId", nullable=false, length=8) ), 
        @AttributeOverride(name="effectiveDate", column=@Column(name="EffectiveDate", nullable=false, length=8) ), 
        @AttributeOverride(name="effectiveDate1", column=@Column(name="EffectiveDate1", nullable=false, length=8) ) } )
    public FsForeignLaborIsuranceId getId() {
        return this.id;
    }
    
    public void setId(FsForeignLaborIsuranceId id) {
        this.id = id;
    }

    
    @Column(name="FirstReceiveNo", length=12)
    public String getFirstReceiveNo() {
        return this.firstReceiveNo;
    }
    
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }

    
    @Column(name="ChineseName")
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    
    @Column(name="BirthDate", length=8)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="Gender", length=1)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="InsureCheckId", length=1)
    public String getInsureCheckId() {
        return this.insureCheckId;
    }
    
    public void setInsureCheckId(String insureCheckId) {
        this.insureCheckId = insureCheckId;
    }

    
    @Column(name="InsureUnit")
    public String getInsureUnit() {
        return this.insureUnit;
    }
    
    public void setInsureUnit(String insureUnit) {
        this.insureUnit = insureUnit;
    }

    
    @Column(name="InsureUnitAddr")
    public String getInsureUnitAddr() {
        return this.insureUnitAddr;
    }
    
    public void setInsureUnitAddr(String insureUnitAddr) {
        this.insureUnitAddr = insureUnitAddr;
    }

    
    @Column(name="InsureOccupation", length=4)
    public String getInsureOccupation() {
        return this.insureOccupation;
    }
    
    public void setInsureOccupation(String insureOccupation) {
        this.insureOccupation = insureOccupation;
    }

    
    @Column(name="ChangeId", length=2)
    public String getChangeId() {
        return this.changeId;
    }
    
    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    
    @Column(name="Salary", precision=7, scale=0)
    public Integer getSalary() {
        return this.salary;
    }
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    
    @Column(name="Remark")
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    @Column(name="ChangeId1", length=2)
    public String getChangeId1() {
        return this.changeId1;
    }
    
    public void setChangeId1(String changeId1) {
        this.changeId1 = changeId1;
    }

    
    @Column(name="Salary1", precision=7, scale=0)
    public Integer getSalary1() {
        return this.salary1;
    }
    
    public void setSalary1(Integer salary1) {
        this.salary1 = salary1;
    }

    
    @Column(name="CreateDeptId", length=4)
    public String getCreateDeptId() {
        return this.createDeptId;
    }
    
    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    
    @Column(name="DeleteFlag", nullable=false, length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    @Column(name="CreateUserId", nullable=false, length=10)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    
    @Column(name="CreateProgramId", nullable=false, length=20)
    public String getCreateProgramId() {
        return this.createProgramId;
    }
    
    public void setCreateProgramId(String createProgramId) {
        this.createProgramId = createProgramId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateTime", nullable=false, length=23)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    @Column(name="MaintainHost", nullable=false, length=2)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    
    @Column(name="MainUserId", nullable=false, length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="MaintainProgramId", nullable=false, length=20)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", nullable=false, length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }




}


