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
 * FsForeignHealthIsurance
 */
@Entity
@Table(name="FsForeignHealthIsurance"
)
public class FsForeignHealthIsurance  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private FsForeignHealthIsuranceId id;
    private String firstReceiveNo;
    private String birthDate;
    @org.hibernate.annotations.Type(type="gov.nia.nrs.system.dialect.NStringUserType")
    private String insureChineseName;
    private String insureBirthdate;
    private String insureRemark;
    private String insureClass;
    private String insureStatus;
    private String markInfo;
    private String createDeptId;
    private String deleteFlag;
    private String createUserId;
    private String createProgramId;
    private Date createTime;
    private String maintainHost;
    private String mainUserId;
    private String maintainProgramId;
    private Date lastUpdateTime;

    public FsForeignHealthIsurance() {}

	
    public FsForeignHealthIsurance(FsForeignHealthIsuranceId id, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
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
    public FsForeignHealthIsurance(FsForeignHealthIsuranceId id, String firstReceiveNo, String birthDate, String insureChineseName, String insureBirthdate, String insureRemark, String insureClass, String insureStatus, String markInfo, String createDeptId, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.id = id;
        this.firstReceiveNo = firstReceiveNo;
        this.birthDate = birthDate;
        this.insureChineseName = insureChineseName;
        this.insureBirthdate = insureBirthdate;
        this.insureRemark = insureRemark;
        this.insureClass = insureClass;
        this.insureStatus = insureStatus;
        this.markInfo = markInfo;
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
        @AttributeOverride(name="residentIdNo1", column=@Column(name="ResidentIdNo1", nullable=false, length=10) ), 
        @AttributeOverride(name="personId", column=@Column(name="PersonId", nullable=false, length=10) ), 
        @AttributeOverride(name="insurePersonId", column=@Column(name="InsurePersonId", nullable=false, length=10) ) } )
    public FsForeignHealthIsuranceId getId() {
        return this.id;
    }
    
    public void setId(FsForeignHealthIsuranceId id) {
        this.id = id;
    }

    
    @Column(name="FirstReceiveNo", length=12)
    public String getFirstReceiveNo() {
        return this.firstReceiveNo;
    }
    
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }

    
    @Column(name="BirthDate", length=8)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="InsureChineseName")
    public String getInsureChineseName() {
        return this.insureChineseName;
    }
    
    public void setInsureChineseName(String insureChineseName) {
        this.insureChineseName = insureChineseName;
    }

    
    @Column(name="InsureBirthdate", length=8)
    public String getInsureBirthdate() {
        return this.insureBirthdate;
    }
    
    public void setInsureBirthdate(String insureBirthdate) {
        this.insureBirthdate = insureBirthdate;
    }

    
    @Column(name="InsureRemark", length=1)
    public String getInsureRemark() {
        return this.insureRemark;
    }
    
    public void setInsureRemark(String insureRemark) {
        this.insureRemark = insureRemark;
    }

    
    @Column(name="InsureClass", length=3)
    public String getInsureClass() {
        return this.insureClass;
    }
    
    public void setInsureClass(String insureClass) {
        this.insureClass = insureClass;
    }

    
    @Column(name="InsureStatus", length=1)
    public String getInsureStatus() {
        return this.insureStatus;
    }
    
    public void setInsureStatus(String insureStatus) {
        this.insureStatus = insureStatus;
    }

    
    @Column(name="MarkInfo", length=1)
    public String getMarkInfo() {
        return this.markInfo;
    }
    
    public void setMarkInfo(String markInfo) {
        this.markInfo = markInfo;
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


