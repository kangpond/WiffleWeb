package gov.nia.nrs.domain.iis;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * CodeSetting generated by hbm2java
 */
@Entity
@Table(name="CodeSetting"
    , uniqueConstraints = @UniqueConstraint(columnNames="CodeName") 
)
public class CodeSetting  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Long version;
    private String codeName;
    private String codeNameDesc;
    private String parentCodeId;
    private String activeStatus;
    private String comments;
    private String createUserId;
    private Date createDate;
    private String mainUserId;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;
    private String dataFlag;
    private Long txnMark;
    private Date syncTime;

    public CodeSetting() {}

	
    public CodeSetting(String id) {
        this.id = id;
    }
    public CodeSetting(String id, String codeName, String codeNameDesc, String parentCodeId, String activeStatus, String comments, String createUserId, Date createDate, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime, String dataFlag, Long txnMark, Date syncTime) {
        this.id = id;
        this.codeName = codeName;
        this.codeNameDesc = codeNameDesc;
        this.parentCodeId = parentCodeId;
        this.activeStatus = activeStatus;
        this.comments = comments;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
        this.dataFlag = dataFlag;
        this.txnMark = txnMark;
        this.syncTime = syncTime;
    }
   
    @Id 

    
    @Column(name="Id", unique=true, nullable=false, length=32)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    @Version
    @Column(name="Version", scale=0)
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }

    
    @Column(name="CodeName", unique=true, length=4)
    public String getCodeName() {
        return this.codeName;
    }
    
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    
    @Column(name="CodeNameDesc", length=512)
    public String getCodeNameDesc() {
        return this.codeNameDesc;
    }
    
    public void setCodeNameDesc(String codeNameDesc) {
        this.codeNameDesc = codeNameDesc;
    }

    
    @Column(name="ParentCodeId", length=32)
    public String getParentCodeId() {
        return this.parentCodeId;
    }
    
    public void setParentCodeId(String parentCodeId) {
        this.parentCodeId = parentCodeId;
    }

    
    @Column(name="ActiveStatus", length=1)
    public String getActiveStatus() {
        return this.activeStatus;
    }
    
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    
    @Column(name="Comments", length=512)
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    
    @Column(name="CreateUserId", length=10)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate", length=23)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="MainUserId", length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="MaintainProgramId", length=10)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    
    @Column(name="MaintainHost", length=24)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
    @Column(name="DataFlag", length=1)
    public String getDataFlag() {
        return this.dataFlag;
    }
    
    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    
    @Column(name="TxnMark")
    public Long getTxnMark() {
        return this.txnMark;
    }
    
    public void setTxnMark(Long txnMark) {
        this.txnMark = txnMark;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SyncTime", length=23)
    public Date getSyncTime() {
        return this.syncTime;
    }
    
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }




}


