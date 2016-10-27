package gov.nia.nrs.domain.iis;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TwSpouseId
 */
@Embeddable
public class TwSpouseId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String personId;
    private String spFirstReceiveNo;

    public TwSpouseId() {}

    public TwSpouseId(String personId, String spFirstReceiveNo) {
        this.personId = personId;
        this.spFirstReceiveNo = spFirstReceiveNo;
    }
   


    @Column(name="PersonId", nullable=false, length=15)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }


    @Column(name="SpFirstReceiveNo", nullable=false, length=12)
    public String getSpFirstReceiveNo() {
        return this.spFirstReceiveNo;
    }
    
    public void setSpFirstReceiveNo(String spFirstReceiveNo) {
        this.spFirstReceiveNo = spFirstReceiveNo;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof TwSpouseId) ) return false;
		TwSpouseId castOther = ( TwSpouseId ) other; 
         
		return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
 && ( (this.getSpFirstReceiveNo()==castOther.getSpFirstReceiveNo()) || ( this.getSpFirstReceiveNo()!=null && castOther.getSpFirstReceiveNo()!=null && this.getSpFirstReceiveNo().equals(castOther.getSpFirstReceiveNo()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
        result = 37 * result + ( getSpFirstReceiveNo() == null ? 0 : this.getSpFirstReceiveNo().hashCode() );
        return result;
    }   


}


