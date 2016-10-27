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
 * TwSpouseCityAccu
 */
@Entity
@Table(name="TwSpouseCityAccu"
)
public class TwSpouseCityAccu  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private TwSpouseCityAccuId id;
    private Integer foreignSpCount;
    private Integer twSpCount;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public TwSpouseCityAccu() {}

	
    public TwSpouseCityAccu(TwSpouseCityAccuId id, Integer foreignSpCount, Integer twSpCount) {
        this.id = id;
        this.foreignSpCount = foreignSpCount;
        this.twSpCount = twSpCount;
    }
    public TwSpouseCityAccu(TwSpouseCityAccuId id, Integer foreignSpCount, Integer twSpCount, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.foreignSpCount = foreignSpCount;
        this.twSpCount = twSpCount;
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
        @AttributeOverride(name="twSpPosition", column=@Column(name="TwSpPosition", nullable=false, length=4) ), 
        @AttributeOverride(name="marryStatus", column=@Column(name="MarryStatus", nullable=false, length=1) ), 
        @AttributeOverride(name="twSpCity", column=@Column(name="TwSpCity", nullable=false, length=5) ) } )
    public TwSpouseCityAccuId getId() {
        return this.id;
    }
    
    public void setId(TwSpouseCityAccuId id) {
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


