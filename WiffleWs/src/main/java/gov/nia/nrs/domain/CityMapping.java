package gov.nia.nrs.domain;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CityMapping
 */
@Entity
@Table(name="CityMapping"
)
public class CityMapping  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String postNo;
    private String cityId;
    private String cityCode;
    private String cityName;
    private String postName;
    private String createDeptId;
    private String maintainDeptId;
    private String deleteFlag;
    private String createUserId;
    private String createProgramId;
    private Date createTime;
    private String maintainHost;
    private String mainUserId;
    private String maintainProgramId;
    private Date lastUpdateTime;

    public CityMapping() {}

	
    public CityMapping(String postNo, String cityId, String cityCode, String cityName, String postName, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.postNo = postNo;
        this.cityId = cityId;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.postName = postName;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
    public CityMapping(String postNo, String cityId, String cityCode, String cityName, String postName, String createDeptId, String maintainDeptId, String deleteFlag, String createUserId, String createProgramId, Date createTime, String maintainHost, String mainUserId, String maintainProgramId, Date lastUpdateTime) {
        this.postNo = postNo;
        this.cityId = cityId;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.postName = postName;
        this.createDeptId = createDeptId;
        this.maintainDeptId = maintainDeptId;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createProgramId = createProgramId;
        this.createTime = createTime;
        this.maintainHost = maintainHost;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.lastUpdateTime = lastUpdateTime;
    }
   
    @Id 

    
    @Column(name="PostNo", unique=true, nullable=false, length=3)
    public String getPostNo() {
        return this.postNo;
    }
    
    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    
    @Column(name="CityId", nullable=false, length=1)
    public String getCityId() {
        return this.cityId;
    }
    
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    
    @Column(name="CityCode", nullable=false, length=5)
    public String getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    
    @Column(name="CityName", nullable=false)
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    
    @Column(name="PostName", nullable=false)
    public String getPostName() {
        return this.postName;
    }
    
    public void setPostName(String postName) {
        this.postName = postName;
    }

    
    @Column(name="CreateDeptId", length=4)
    public String getCreateDeptId() {
        return this.createDeptId;
    }
    
    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    
    @Column(name="MaintainDeptId", length=4)
    public String getMaintainDeptId() {
        return this.maintainDeptId;
    }
    
    public void setMaintainDeptId(String maintainDeptId) {
        this.maintainDeptId = maintainDeptId;
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


