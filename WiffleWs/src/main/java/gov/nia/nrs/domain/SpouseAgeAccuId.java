package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpouseAgeAccuId
 */
@Embeddable
public class SpouseAgeAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String spouseType;
    private String marryStatus;
    private String foreignSpAgeInterval;
    private String twSpAgeInterval;
    private String spAgeDiffInterval;

    public SpouseAgeAccuId() {}

    public SpouseAgeAccuId(String year, String month, String gender, String spouseType, String marryStatus, String foreignSpAgeInterval, String twSpAgeInterval, String spAgeDiffInterval) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.spouseType = spouseType;
        this.marryStatus = marryStatus;
        this.foreignSpAgeInterval = foreignSpAgeInterval;
        this.twSpAgeInterval = twSpAgeInterval;
        this.spAgeDiffInterval = spAgeDiffInterval;
    }
   


    @Column(name="Year", nullable=false, length=4)
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }


    @Column(name="Month", nullable=false, length=2)
    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }


    @Column(name="Gender", nullable=false, length=1)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }


    @Column(name="SpouseType", nullable=false, length=1)
    public String getSpouseType() {
        return this.spouseType;
    }
    
    public void setSpouseType(String spouseType) {
        this.spouseType = spouseType;
    }


    @Column(name="MarryStatus", nullable=false, length=1)
    public String getMarryStatus() {
        return this.marryStatus;
    }
    
    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }


    @Column(name="ForeignSpAgeInterval", nullable=false, length=3)
    public String getForeignSpAgeInterval() {
        return this.foreignSpAgeInterval;
    }
    
    public void setForeignSpAgeInterval(String foreignSpAgeInterval) {
        this.foreignSpAgeInterval = foreignSpAgeInterval;
    }


    @Column(name="TwSpAgeInterval", nullable=false, length=3)
    public String getTwSpAgeInterval() {
        return this.twSpAgeInterval;
    }
    
    public void setTwSpAgeInterval(String twSpAgeInterval) {
        this.twSpAgeInterval = twSpAgeInterval;
    }


    @Column(name="SpAgeDiffInterval", nullable=false, length=3)
    public String getSpAgeDiffInterval() {
        return this.spAgeDiffInterval;
    }
    
    public void setSpAgeDiffInterval(String spAgeDiffInterval) {
        this.spAgeDiffInterval = spAgeDiffInterval;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof SpouseAgeAccuId) ) return false;
		SpouseAgeAccuId castOther = ( SpouseAgeAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) )
 && ( (this.getMarryStatus()==castOther.getMarryStatus()) || ( this.getMarryStatus()!=null && castOther.getMarryStatus()!=null && this.getMarryStatus().equals(castOther.getMarryStatus()) ) )
 && ( (this.getForeignSpAgeInterval()==castOther.getForeignSpAgeInterval()) || ( this.getForeignSpAgeInterval()!=null && castOther.getForeignSpAgeInterval()!=null && this.getForeignSpAgeInterval().equals(castOther.getForeignSpAgeInterval()) ) )
 && ( (this.getTwSpAgeInterval()==castOther.getTwSpAgeInterval()) || ( this.getTwSpAgeInterval()!=null && castOther.getTwSpAgeInterval()!=null && this.getTwSpAgeInterval().equals(castOther.getTwSpAgeInterval()) ) )
 && ( (this.getSpAgeDiffInterval()==castOther.getSpAgeDiffInterval()) || ( this.getSpAgeDiffInterval()!=null && castOther.getSpAgeDiffInterval()!=null && this.getSpAgeDiffInterval().equals(castOther.getSpAgeDiffInterval()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        result = 37 * result + ( getMarryStatus() == null ? 0 : this.getMarryStatus().hashCode() );
        result = 37 * result + ( getForeignSpAgeInterval() == null ? 0 : this.getForeignSpAgeInterval().hashCode() );
        result = 37 * result + ( getTwSpAgeInterval() == null ? 0 : this.getTwSpAgeInterval().hashCode() );
        result = 37 * result + ( getSpAgeDiffInterval() == null ? 0 : this.getSpAgeDiffInterval().hashCode() );
        return result;
    }   


}


