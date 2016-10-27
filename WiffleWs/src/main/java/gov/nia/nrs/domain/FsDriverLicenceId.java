package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FsDriverLicenceId
 */
@Embeddable
public class FsDriverLicenceId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String residentIdNo;
    private String personId;
    private String licenceType;

    public FsDriverLicenceId() {}

    public FsDriverLicenceId(String residentIdNo, String personId, String licenceType) {
        this.residentIdNo = residentIdNo;
        this.personId = personId;
        this.licenceType = licenceType;
    }
   


    @Column(name="ResidentIdNo", nullable=false, length=10)
    public String getResidentIdNo() {
        return this.residentIdNo;
    }
    
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }


    @Column(name="PersonId", nullable=false, length=10)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }


    @Column(name="LicenceType", nullable=false, length=1)
    public String getLicenceType() {
        return this.licenceType;
    }
    
    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof FsDriverLicenceId) ) return false;
		FsDriverLicenceId castOther = ( FsDriverLicenceId ) other; 
         
		return ( (this.getResidentIdNo()==castOther.getResidentIdNo()) || ( this.getResidentIdNo()!=null && castOther.getResidentIdNo()!=null && this.getResidentIdNo().equals(castOther.getResidentIdNo()) ) )
 && ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
 && ( (this.getLicenceType()==castOther.getLicenceType()) || ( this.getLicenceType()!=null && castOther.getLicenceType()!=null && this.getLicenceType().equals(castOther.getLicenceType()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getResidentIdNo() == null ? 0 : this.getResidentIdNo().hashCode() );
        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getLicenceType() == null ? 0 : this.getLicenceType().hashCode() );
        return result;
    }   


}


