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
 * SpouseAgeAccu
 */
@Entity
@Table(name="SpouseAgeAccu"
)
public class SpouseAgeAccu  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private SpouseAgeAccuId id;
    private Integer foreignSpCount;
    private Integer twSpCount;
    private Integer spAgeDiffCount;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public SpouseAgeAccu() {}

	
    public SpouseAgeAccu(SpouseAgeAccuId id, Integer foreignSpCount, Integer twSpCount, Integer spAgeDiffCount) {
        this.id = id;
        this.foreignSpCount = foreignSpCount;
        this.twSpCount = twSpCount;
        this.spAgeDiffCount = spAgeDiffCount;
    }
    public SpouseAgeAccu(SpouseAgeAccuId id, Integer foreignSpCount, Integer twSpCount, Integer spAgeDiffCount, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.foreignSpCount = foreignSpCount;
        this.twSpCount = twSpCount;
        this.spAgeDiffCount = spAgeDiffCount;
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
        @AttributeOverride(name="marryStatus", column=@Column(name="MarryStatus", nullable=false, length=1) ), 
        @AttributeOverride(name="foreignSpAgeInterval", column=@Column(name="ForeignSpAgeInterval", nullable=false, length=3) ), 
        @AttributeOverride(name="twSpAgeInterval", column=@Column(name="TwSpAgeInterval", nullable=false, length=3) ), 
        @AttributeOverride(name="spAgeDiffInterval", column=@Column(name="SpAgeDiffInterval", nullable=false, length=3) ) } )
    public SpouseAgeAccuId getId() {
        return this.id;
    }
    
    public void setId(SpouseAgeAccuId id) {
        this.id = id;
    }

    
    @Column(name="ForeignSpCount", nullable=false, precision=8, scale=0)
    public Integer getForeignSpCount() {
        return this.foreignSpCount;
    }
    
    public void setForeignSpCount(Integer foreignSpCount) {
        this.foreignSpCount = foreignSpCount;
    }

    
    @Column(name="TwSpCount", nullable=false, precision=8, scale=0)
    public Integer getTwSpCount() {
        return this.twSpCount;
    }
    
    public void setTwSpCount(Integer twSpCount) {
        this.twSpCount = twSpCount;
    }

    
    @Column(name="SpAgeDiffCount", nullable=false, precision=8, scale=0)
    public Integer getSpAgeDiffCount() {
        return this.spAgeDiffCount;
    }
    
    public void setSpAgeDiffCount(Integer spAgeDiffCount) {
        this.spAgeDiffCount = spAgeDiffCount;
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


