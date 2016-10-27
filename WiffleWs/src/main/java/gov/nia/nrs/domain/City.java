package gov.nia.nrs.domain;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * City
 */
@Entity
@Table(name="City"
)
public class City  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String cityCode;
    private String cityName;
    private String createUserId;
    private String mainUserId;
    private Date lastUpdateTime;
    private Date createTime;
    private String deleteFlag;

    public City() {}

	
    public City(String cityCode) {
        this.cityCode = cityCode;
    }
    public City(String cityCode, String cityName, String createUserId, String mainUserId, Date lastUpdateTime, Date createTime, String deleteFlag) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.createUserId = createUserId;
        this.mainUserId = mainUserId;
        this.lastUpdateTime = lastUpdateTime;
        this.createTime = createTime;
        this.deleteFlag = deleteFlag;
    }
   
    @Id 

    
    @Column(name="CityCode", unique=true, nullable=false, length=1)
    public String getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    
    @Column(name="CityName")
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    
    @Column(name="CreateUserId", length=20)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    
    @Column(name="MainUserId", length=20)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateTime", length=23)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    @Column(name="DeleteFlag", length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }




}


