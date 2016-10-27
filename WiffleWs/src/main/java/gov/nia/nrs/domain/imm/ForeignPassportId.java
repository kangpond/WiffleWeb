package gov.nia.nrs.domain.imm;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ForeignPassportId
 */
@Embeddable
public class ForeignPassportId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String passengerId;
    private String passportNo;
    private Integer nation;

    public ForeignPassportId() {}

    public ForeignPassportId(String passengerId, String passportNo, Integer nation) {
        this.passengerId = passengerId;
        this.passportNo = passportNo;
        this.nation = nation;
    }
   


    @Column(name="PassengerId", nullable=false, length=10)
    public String getPassengerId() {
        return this.passengerId;
    }
    
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }


    @Column(name="PassportNo", nullable=false, length=15)
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }


    @Column(name="Nation", nullable=false, precision=3, scale=0)
    public Integer getNation() {
        return this.nation;
    }
    
    public void setNation(Integer nation) {
        this.nation = nation;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof ForeignPassportId) ) return false;
		ForeignPassportId castOther = ( ForeignPassportId ) other; 
         
		return ( (this.getPassengerId()==castOther.getPassengerId()) || ( this.getPassengerId()!=null && castOther.getPassengerId()!=null && this.getPassengerId().equals(castOther.getPassengerId()) ) )
 && ( (this.getPassportNo()==castOther.getPassportNo()) || ( this.getPassportNo()!=null && castOther.getPassportNo()!=null && this.getPassportNo().equals(castOther.getPassportNo()) ) )
 && ( (this.getNation()==castOther.getNation()) || ( this.getNation()!=null && castOther.getNation()!=null && this.getNation().equals(castOther.getNation()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getPassengerId() == null ? 0 : this.getPassengerId().hashCode() );
        result = 37 * result + ( getPassportNo() == null ? 0 : this.getPassportNo().hashCode() );
        result = 37 * result + ( getNation() == null ? 0 : this.getNation().hashCode() );
        return result;
    }   


}


