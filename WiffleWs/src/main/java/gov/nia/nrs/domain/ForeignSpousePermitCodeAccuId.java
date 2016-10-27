package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignSpousePermitCodeAccuId
 */
@Embeddable
public class ForeignSpousePermitCodeAccuId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String gender;
    private String spouseType;
    private String permitNoCode;
    private Integer reason;

    public ForeignSpousePermitCodeAccuId() {}

    public ForeignSpousePermitCodeAccuId(String year, String month, String gender, String spouseType, String permitNoCode, Integer reason) {
        this.year = year;
        this.month = month;
        this.gender = gender;
        this.spouseType = spouseType;
        this.permitNoCode = permitNoCode;
        this.reason = reason;
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


    @Column(name="PermitNoCode", nullable=false, length=4)
    public String getPermitNoCode() {
        return this.permitNoCode;
    }
    
    public void setPermitNoCode(String permitNoCode) {
        this.permitNoCode = permitNoCode;
    }


    @Column(name="Reason", nullable=false, precision=4, scale=0)
    public Integer getReason() {
        return this.reason;
    }
    
    public void setReason(Integer reason) {
        this.reason = reason;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ForeignSpousePermitCodeAccuId) ) return false;
		ForeignSpousePermitCodeAccuId castOther = ( ForeignSpousePermitCodeAccuId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getGender()==castOther.getGender()) || ( this.getGender()!=null && castOther.getGender()!=null && this.getGender().equals(castOther.getGender()) ) )
 && ( (this.getSpouseType()==castOther.getSpouseType()) || ( this.getSpouseType()!=null && castOther.getSpouseType()!=null && this.getSpouseType().equals(castOther.getSpouseType()) ) )
 && ( (this.getPermitNoCode()==castOther.getPermitNoCode()) || ( this.getPermitNoCode()!=null && castOther.getPermitNoCode()!=null && this.getPermitNoCode().equals(castOther.getPermitNoCode()) ) )
 && ( (this.getReason()==castOther.getReason()) || ( this.getReason()!=null && castOther.getReason()!=null && this.getReason().equals(castOther.getReason()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getGender() == null ? 0 : this.getGender().hashCode() );
        result = 37 * result + ( getSpouseType() == null ? 0 : this.getSpouseType().hashCode() );
        result = 37 * result + ( getPermitNoCode() == null ? 0 : this.getPermitNoCode().hashCode() );
        result = 37 * result + ( getReason() == null ? 0 : this.getReason().hashCode() );
        return result;
    }   


}


