package gov.nia.nrs.domain.iis;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DeptSupervisor generated by hbm2java
 */
@Entity
@Table(name="DeptSupervisor"
)
public class DeptSupervisor  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long deptSupervisorSeq;
    private String deptId;
    private String userId;
    private String deleteFlag;
    private String maintainHost;
    private Long txnMark;
    private Date syncTime;

    public DeptSupervisor() {}

	
    public DeptSupervisor(Long deptSupervisorSeq, String deptId, String userId, String deleteFlag) {
        this.deptSupervisorSeq = deptSupervisorSeq;
        this.deptId = deptId;
        this.userId = userId;
        this.deleteFlag = deleteFlag;
    }
    public DeptSupervisor(Long deptSupervisorSeq, String deptId, String userId, String deleteFlag, String maintainHost, Long txnMark, Date syncTime) {
        this.deptSupervisorSeq = deptSupervisorSeq;
        this.deptId = deptId;
        this.userId = userId;
        this.deleteFlag = deleteFlag;
        this.maintainHost = maintainHost;
        this.txnMark = txnMark;
        this.syncTime = syncTime;
    }
   
    @Id 

    
    @Column(name="DeptSupervisorSeq", unique=true, nullable=false, precision=18, scale=0)
    public Long getDeptSupervisorSeq() {
        return this.deptSupervisorSeq;
    }
    
    public void setDeptSupervisorSeq(Long deptSupervisorSeq) {
        this.deptSupervisorSeq = deptSupervisorSeq;
    }

    
    @Column(name="DeptId", nullable=false, length=4)
    public String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    
    @Column(name="UserId", nullable=false, length=10)
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    @Column(name="DeleteFlag", nullable=false, length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    @Column(name="MaintainHost", length=25)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
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


