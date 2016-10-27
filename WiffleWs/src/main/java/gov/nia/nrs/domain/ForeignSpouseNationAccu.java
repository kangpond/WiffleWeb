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
 * ForeignSpouseNationAccu
 */
@Entity
@Table(name="ForeignSpouseNationAccu"
)
public class ForeignSpouseNationAccu  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ForeignSpouseNationAccuId id;
    private Integer spCount;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public ForeignSpouseNationAccu() {}

	
    public ForeignSpouseNationAccu(ForeignSpouseNationAccuId id, Integer spCount) {
        this.id = id;
        this.spCount = spCount;
    }
    public ForeignSpouseNationAccu(ForeignSpouseNationAccuId id, Integer spCount, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
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
        @AttributeOverride(name="spouseType", column=@Column(name="SpouseType", nullable=false, length=1) ), 
        @AttributeOverride(name="nation", column=@Column(name="Nation", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="marryStatus", column=@Column(name="MarryStatus", nullable=false, length=1) ) } )
    public ForeignSpouseNationAccuId getId() {
        return this.id;
    }
    
    public void setId(ForeignSpouseNationAccuId id) {
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


