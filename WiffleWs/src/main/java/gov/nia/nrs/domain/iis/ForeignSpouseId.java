package gov.nia.nrs.domain.iis;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignSpouseId
 */
@Embeddable
public class ForeignSpouseId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String firstReceiveNo;
    private String residentIdNo;

    public ForeignSpouseId() {}

    public ForeignSpouseId(String firstReceiveNo, String residentIdNo) {
        this.firstReceiveNo = firstReceiveNo;
        this.residentIdNo = residentIdNo;
    }
   


    @Column(name="FirstReceiveNo", nullable=false, length=12)
    public String getFirstReceiveNo() {
        return this.firstReceiveNo;
    }
    
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }


    @Column(name="ResidentIdNo", nullable=false, length=10)
    public String getResidentIdNo() {
        return this.residentIdNo;
    }
    
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ForeignSpouseId) ) return false;
		ForeignSpouseId castOther = ( ForeignSpouseId ) other; 
         
		return ( (this.getFirstReceiveNo()==castOther.getFirstReceiveNo()) || ( this.getFirstReceiveNo()!=null && castOther.getFirstReceiveNo()!=null && this.getFirstReceiveNo().equals(castOther.getFirstReceiveNo()) ) )
 && ( (this.getResidentIdNo()==castOther.getResidentIdNo()) || ( this.getResidentIdNo()!=null && castOther.getResidentIdNo()!=null && this.getResidentIdNo().equals(castOther.getResidentIdNo()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getFirstReceiveNo() == null ? 0 : this.getFirstReceiveNo().hashCode() );
        result = 37 * result + ( getResidentIdNo() == null ? 0 : this.getResidentIdNo().hashCode() );
        return result;
    }   


}


