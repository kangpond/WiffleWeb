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
 * SpouseOccEduAccu
 */
@Entity
@Table(name="SpouseOccEduAccu"
)
public class SpouseOccEduAccu  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private SpouseOccEduAccuId id;
    private Integer occSpCount;
    private Integer eduSpCount;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;

    public SpouseOccEduAccu() {}

	
    public SpouseOccEduAccu(SpouseOccEduAccuId id, Integer occSpCount, Integer eduSpCount) {
        this.id = id;
        this.occSpCount = occSpCount;
        this.eduSpCount = eduSpCount;
    }
    public SpouseOccEduAccu(SpouseOccEduAccuId id, Integer occSpCount, Integer eduSpCount, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.occSpCount = occSpCount;
        this.eduSpCount = eduSpCount;
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
        @AttributeOverride(name="spouseType", column=@Column(name="SpouseType", nullable=false, length=1) ), 
        @AttributeOverride(name="occupation", column=@Column(name="Occupation", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="education", column=@Column(name="Education  ", nullable=false, length=4) ) } )
    public SpouseOccEduAccuId getId() {
        return this.id;
    }
    
    public void setId(SpouseOccEduAccuId id) {
        this.id = id;
    }

    
    @Column(name="OccSpCount", nullable=false, precision=8, scale=0)
    public Integer getOccSpCount() {
        return this.occSpCount;
    }
    
    public void setOccSpCount(Integer occSpCount) {
        this.occSpCount = occSpCount;
    }

    
    @Column(name="EduSpCount", nullable=false, precision=8, scale=0)
    public Integer getEduSpCount() {
        return this.eduSpCount;
    }
    
    public void setEduSpCount(Integer eduSpCount) {
        this.eduSpCount = eduSpCount;
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


