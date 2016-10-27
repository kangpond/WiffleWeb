package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FsForeignHealthIsuranceId
 */
@Embeddable
public class FsForeignHealthIsuranceId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String residentIdNo;
    private String residentIdNo1;
    private String personId;
    private String insurePersonId;

    public FsForeignHealthIsuranceId() {}

    public FsForeignHealthIsuranceId(String residentIdNo, String residentIdNo1, String personId, String insurePersonId) {
        this.residentIdNo = residentIdNo;
        this.residentIdNo1 = residentIdNo1;
        this.personId = personId;
        this.insurePersonId = insurePersonId;
    }
   


    @Column(name="ResidentIdNo", nullable=false, length=10)
    public String getResidentIdNo() {
        return this.residentIdNo;
    }
    
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }


    @Column(name="ResidentIdNo1", nullable=false, length=10)
    public String getResidentIdNo1() {
        return this.residentIdNo1;
    }
    
    public void setResidentIdNo1(String residentIdNo1) {
        this.residentIdNo1 = residentIdNo1;
    }


    @Column(name="PersonId", nullable=false, length=10)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }


    @Column(name="InsurePersonId", nullable=false, length=10)
    public String getInsurePersonId() {
        return this.insurePersonId;
    }
    
    public void setInsurePersonId(String insurePersonId) {
        this.insurePersonId = insurePersonId;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof FsForeignHealthIsuranceId) ) return false;
		FsForeignHealthIsuranceId castOther = ( FsForeignHealthIsuranceId ) other; 
         
		return ( (this.getResidentIdNo()==castOther.getResidentIdNo()) || ( this.getResidentIdNo()!=null && castOther.getResidentIdNo()!=null && this.getResidentIdNo().equals(castOther.getResidentIdNo()) ) )
 && ( (this.getResidentIdNo1()==castOther.getResidentIdNo1()) || ( this.getResidentIdNo1()!=null && castOther.getResidentIdNo1()!=null && this.getResidentIdNo1().equals(castOther.getResidentIdNo1()) ) )
 && ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
 && ( (this.getInsurePersonId()==castOther.getInsurePersonId()) || ( this.getInsurePersonId()!=null && castOther.getInsurePersonId()!=null && this.getInsurePersonId().equals(castOther.getInsurePersonId()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getResidentIdNo() == null ? 0 : this.getResidentIdNo().hashCode() );
        result = 37 * result + ( getResidentIdNo1() == null ? 0 : this.getResidentIdNo1().hashCode() );
        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getInsurePersonId() == null ? 0 : this.getInsurePersonId().hashCode() );
        return result;
    }   


}


