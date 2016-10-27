package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignSpouseNationAccuId
 */
@Embeddable
public class ForeignSpouseNationAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String spouseType;
    private Integer nation;
    private String marryStatus;

    public ForeignSpouseNationAccuId() {}

    public ForeignSpouseNationAccuId(String year, String month, String gender, String spouseType, Integer nation, String marryStatus) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.spouseType = spouseType;
        this.nation = nation;
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


    @Column(name="SpouseType", nullable=false, length=1)
    public String getSpouseType() {
        return this.spouseType;
    }
    
    public void setSpouseType(String spouseType) {
        this.spouseType = spouseType;
    }


    @Column(name="Nation", nullable=false, precision=3, scale=0)
    public Integer getNation() {
        return this.nation;
    }
    
    public void setNation(Integer nation) {
        this.nation = nation;
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
		if ( !(other instanceof ForeignSpouseNationAccuId) ) return false;
		ForeignSpouseNationAccuId castOther = ( ForeignSpouseNationAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) )
 && ( (this.getNation()==castOther.getNation()) || ( this.getNation()!=null && castOther.getNation()!=null && this.getNation().equals(castOther.getNation()) ) )
 && ( (this.getMarryStatus()==castOther.getMarryStatus()) || ( this.getMarryStatus()!=null && castOther.getMarryStatus()!=null && this.getMarryStatus().equals(castOther.getMarryStatus()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        result = 37 * result + ( getNation() == null ? 0 : this.getNation().hashCode() );
        result = 37 * result + ( getMarryStatus() == null ? 0 : this.getMarryStatus().hashCode() );
        return result;
    }   


}


