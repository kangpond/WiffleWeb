package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TwSpouseCityAccuId
 */
@Embeddable
public class TwSpouseCityAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String spouseType;
    private String twSpPosition;
    private String marryStatus;
    private String twSpCity;

    public TwSpouseCityAccuId() {}

    public TwSpouseCityAccuId(String year, String month, String gender, String spouseType, String twSpPosition, String marryStatus, String twSpCity) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.spouseType = spouseType;
        this.twSpPosition = twSpPosition;
        this.marryStatus = marryStatus;
        this.twSpCity = twSpCity;
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


    @Column(name="TwSpPosition", nullable=false, length=4)
    public String getTwSpPosition() {
        return this.twSpPosition;
    }
    
    public void setTwSpPosition(String twSpPosition) {
        this.twSpPosition = twSpPosition;
    }


    @Column(name="MarryStatus", nullable=false, length=1)
    public String getMarryStatus() {
        return this.marryStatus;
    }
    
    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }


    @Column(name="TwSpCity", nullable=false, length=5)
    public String getTwSpCity() {
        return this.twSpCity;
    }
    
    public void setTwSpCity(String twSpCity) {
        this.twSpCity = twSpCity;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof TwSpouseCityAccuId) ) return false;
		TwSpouseCityAccuId castOther = ( TwSpouseCityAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) )
 && ( (this.getTwSpPosition()==castOther.getTwSpPosition()) || ( this.getTwSpPosition()!=null && castOther.getTwSpPosition()!=null && this.getTwSpPosition().equals(castOther.getTwSpPosition()) ) )
 && ( (this.getMarryStatus()==castOther.getMarryStatus()) || ( this.getMarryStatus()!=null && castOther.getMarryStatus()!=null && this.getMarryStatus().equals(castOther.getMarryStatus()) ) )
 && ( (this.getTwSpCity()==castOther.getTwSpCity()) || ( this.getTwSpCity()!=null && castOther.getTwSpCity()!=null && this.getTwSpCity().equals(castOther.getTwSpCity()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        result = 37 * result + ( getTwSpPosition() == null ? 0 : this.getTwSpPosition().hashCode() );
        result = 37 * result + ( getMarryStatus() == null ? 0 : this.getMarryStatus().hashCode() );
        result = 37 * result + ( getTwSpCity() == null ? 0 : this.getTwSpCity().hashCode() );
        return result;
    }   


}


