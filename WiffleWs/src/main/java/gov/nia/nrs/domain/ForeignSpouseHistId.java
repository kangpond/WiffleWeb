package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignSpouseHistId
 */
@Embeddable
public class ForeignSpouseHistId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String year;
    private String month;
    private String firstReceiveNo;
    private String residentIdNo;

    public ForeignSpouseHistId() {}

    public ForeignSpouseHistId(String year, String month, String firstReceiveNo, String residentIdNo) {
        this.year = year;
        this.month = month;
        this.firstReceiveNo = firstReceiveNo;
        this.residentIdNo = residentIdNo;
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
		if ( !(other instanceof ForeignSpouseHistId) ) return false;
		ForeignSpouseHistId castOther = ( ForeignSpouseHistId ) other; 
         
		return ( (this.getYear()==castOther.getYear()) || ( this.getYear()!=null && castOther.getYear()!=null && this.getYear().equals(castOther.getYear()) ) )
 && ( (this.getMonth()==castOther.getMonth()) || ( this.getMonth()!=null && castOther.getMonth()!=null && this.getMonth().equals(castOther.getMonth()) ) )
 && ( (this.getFirstReceiveNo()==castOther.getFirstReceiveNo()) || ( this.getFirstReceiveNo()!=null && castOther.getFirstReceiveNo()!=null && this.getFirstReceiveNo().equals(castOther.getFirstReceiveNo()) ) )
 && ( (this.getResidentIdNo()==castOther.getResidentIdNo()) || ( this.getResidentIdNo()!=null && castOther.getResidentIdNo()!=null && this.getResidentIdNo().equals(castOther.getResidentIdNo()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getYear() == null ? 0 : this.getYear().hashCode() );
        result = 37 * result + ( getMonth() == null ? 0 : this.getMonth().hashCode() );
        result = 37 * result + ( getFirstReceiveNo() == null ? 0 : this.getFirstReceiveNo().hashCode() );
        result = 37 * result + ( getResidentIdNo() == null ? 0 : this.getResidentIdNo().hashCode() );
        return result;
    }   


}


