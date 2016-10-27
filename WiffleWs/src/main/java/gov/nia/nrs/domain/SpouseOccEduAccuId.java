package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpouseOccEduAccuId
 */
@Embeddable
public class SpouseOccEduAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String city;
    private String spouseType;
    private Integer occupation;
    private String education;

    public SpouseOccEduAccuId() {}

    public SpouseOccEduAccuId(String year, String month, String gender, String city, String spouseType, Integer occupation, String education) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.city = city;
        this.spouseType = spouseType;
        this.occupation = occupation;
        this.education = education;
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


    @Column(name="Occupation", nullable=false, precision=4, scale=0)
    public Integer getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }


    @Column(name="Education  ", nullable=false, length=4)
    public String getEducation() {
        return this.education;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof SpouseOccEduAccuId) ) return false;
		SpouseOccEduAccuId castOther = ( SpouseOccEduAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getCity()==castOther.getCity()) || ( this.getCity()!=null && castOther.getCity()!=null && this.getCity().equals(castOther.getCity()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) )
 && ( (this.getOccupation()==castOther.getOccupation()) || ( this.getOccupation()!=null && castOther.getOccupation()!=null && this.getOccupation().equals(castOther.getOccupation()) ) )
 && ( (this.getEducation()==castOther.getEducation()) || ( this.getEducation()!=null && castOther.getEducation()!=null && this.getEducation().equals(castOther.getEducation()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getCity() == null ? 0 : this.getCity().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        result = 37 * result + ( getOccupation() == null ? 0 : this.getOccupation().hashCode() );
        result = 37 * result + ( getEducation() == null ? 0 : this.getEducation().hashCode() );
        return result;
    }   


}


