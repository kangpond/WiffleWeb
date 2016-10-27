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
 * ForeignSpouseNaCityAccu
 */
@Entity
@Table(name="ForeignSpouseNaCityAccu"
)
public class ForeignSpouseNaCityAccu  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ForeignSpouseNaCityAccuId id;
    private Integer spCount;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public ForeignSpouseNaCityAccu() {}

	
    public ForeignSpouseNaCityAccu(ForeignSpouseNaCityAccuId id, Integer spCount) {
        this.id = id;
        this.spCount = spCount;
    }
    public ForeignSpouseNaCityAccu(ForeignSpouseNaCityAccuId id, Integer spCount, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.spCount = spCount;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="year", column=@Column(name="Year", nullable=false, length=4) ), 
        @AttributeOverride(name="month", column=@Column(name="Month", nullable=false, length=2) ), 
        @AttributeOverride(name="gender", column=@Column(name="Gender", nullable=false, length=1) ), 
        @AttributeOverride(name="city", column=@Column(name="City", nullable=false, length=5) ), 
        @AttributeOverride(name="spouseType", column=@Column(name="SpouseType", nullable=false, length=1) ) } )
    public ForeignSpouseNaCityAccuId getId() {
        return this.id;
    }
    
    public void setId(ForeignSpouseNaCityAccuId id) {
        this.id = id;
    }

    
    @Column(name="SpCount", nullable=false, precision=8, scale=0)
    public Integer getSpCount() {
        return this.spCount;
    }
    
    public void setSpCount(Integer spCount) {
        this.spCount = spCount;
    }

    
    @Column(name="MaintainProgramId", length=10)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    
    @Column(name="MaintainHost", length=2)
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




}


