package gov.nia.nrs.domain.imm;



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
 * ForeignPassport
 */
@Entity
@Table(name="ForeignPassport"
)
public class ForeignPassport  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ForeignPassportId id;
    private String birthDate;
    private String firstRecvNo;
    private String recvNo;
    private String mainUserId;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public ForeignPassport() {}

	
    public ForeignPassport(ForeignPassportId id, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
    }
    public ForeignPassport(ForeignPassportId id, String birthDate, String firstRecvNo, String recvNo, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.birthDate = birthDate;
        this.firstRecvNo = firstRecvNo;
        this.recvNo = recvNo;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="passengerId", column=@Column(name="PassengerId", nullable=false, length=10) ), 
        @AttributeOverride(name="passportNo", column=@Column(name="PassportNo", nullable=false, length=15) ), 
        @AttributeOverride(name="nation", column=@Column(name="Nation", nullable=false, precision=3, scale=0) ) } )
    public ForeignPassportId getId() {
        return this.id;
    }
    
    public void setId(ForeignPassportId id) {
        this.id = id;
    }

    
    @Column(name="BirthDate", length=8)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="FirstRecvNo", length=12)
    public String getFirstRecvNo() {
        return this.firstRecvNo;
    }
    
    public void setFirstRecvNo(String firstRecvNo) {
        this.firstRecvNo = firstRecvNo;
    }

    
    @Column(name="RecvNo", length=12)
    public String getRecvNo() {
        return this.recvNo;
    }
    
    public void setRecvNo(String recvNo) {
        this.recvNo = recvNo;
    }

    
    @Column(name="MainUserId", nullable=false, length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="MaintainProgramId", nullable=false, length=10)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    
    @Column(name="MaintainHost", nullable=false, length=2)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
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


