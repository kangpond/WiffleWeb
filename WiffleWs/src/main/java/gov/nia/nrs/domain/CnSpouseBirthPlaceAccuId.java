package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CnSpouseBirthPlaceAccuId
 */
@Embeddable
public class CnSpouseBirthPlaceAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String birthPlace;
    private String marryStatus;

    public CnSpouseBirthPlaceAccuId() {}

    public CnSpouseBirthPlaceAccuId(String year, String month, String gender, String birthPlace, String marryStatus) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.birthPlace = birthPlace;
        this.marryStatus = marryStatus;
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


    @Column(name="BirthPlace", nullable=false, length=4)
    public String getBirthPlace() {
        return this.birthPlace;
    }
    
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }


    @Column(name="MarryStatus", nullable=false, length=1)
    public String getMarryStatus() {
        return this.marryStatus;
    }
    
    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof CnSpouseBirthPlaceAccuId) ) return false;
		CnSpouseBirthPlaceAccuId castOther = ( CnSpouseBirthPlaceAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getBirthPlace()==castOther.getBirthPlace()) || ( this.getBirthPlace()!=null && castOther.getBirthPlace()!=null && this.getBirthPlace().equals(castOther.getBirthPlace()) ) )
 && ( (this.getMarryStatus()==castOther.getMarryStatus()) || ( this.getMarryStatus()!=null && castOther.getMarryStatus()!=null && this.getMarryStatus().equals(castOther.getMarryStatus()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getBirthPlace() == null ? 0 : this.getBirthPlace().hashCode() );
        result = 37 * result + ( getMarryStatus() == null ? 0 : this.getMarryStatus().hashCode() );
        return result;
    }   


}


