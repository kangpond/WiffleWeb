package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignSpouseNaCityAccuId
 */
@Embeddable
public class ForeignSpouseNaCityAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String city;
    private String spouseType;

    public ForeignSpouseNaCityAccuId() {}

    public ForeignSpouseNaCityAccuId(String year, String month, String gender, String city, String spouseType) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.city = city;
        this.spouseType = spouseType;
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


    @Column(name="City", nullable=false, length=5)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }


    @Column(name="SpouseType", nullable=false, length=1)
    public String getSpouseType() {
        return this.spouseType;
    }
    
    public void setSpouseType(String spouseType) {
        this.spouseType = spouseType;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ForeignSpouseNaCityAccuId) ) return false;
		ForeignSpouseNaCityAccuId castOther = ( ForeignSpouseNaCityAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getCity()==castOther.getCity()) || ( this.getCity()!=null && castOther.getCity()!=null && this.getCity().equals(castOther.getCity()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getCity() == null ? 0 : this.getCity().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        return result;
    }   


}


