package gov.nia.nrs.domain;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FsForeignLaborIsuranceId
 */
@Embeddable
public class FsForeignLaborIsuranceId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String residentIdNo;
    private String insureId;
    private String effectiveDate;
    private String effectiveDate1;

    public FsForeignLaborIsuranceId() {}

    public FsForeignLaborIsuranceId(String residentIdNo, String insureId, String effectiveDate, String effectiveDate1) {
        this.residentIdNo = residentIdNo;
        this.insureId = insureId;
        this.effectiveDate = effectiveDate;
        this.effectiveDate1 = effectiveDate1;
    }
   


    @Column(name="ResidentIdNo", nullable=false, length=10)
    public String getResidentIdNo() {
        return this.residentIdNo;
    }
    
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }


    @Column(name="InsureId", nullable=false, length=8)
    public String getInsureId() {
        return this.insureId;
    }
    
    public void setInsureId(String insureId) {
        this.insureId = insureId;
    }


    @Column(name="EffectiveDate", nullable=false, length=8)
    public String getEffectiveDate() {
        return this.effectiveDate;
    }
    
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    @Column(name="EffectiveDate1", nullable=false, length=8)
    public String getEffectiveDate1() {
        return this.effectiveDate1;
    }
    
    public void setEffectiveDate1(String effectiveDate1) {
        this.effectiveDate1 = effectiveDate1;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof FsForeignLaborIsuranceId) ) return false;
		FsForeignLaborIsuranceId castOther = ( FsForeignLaborIsuranceId ) other; 
         
		return ( (this.getResidentIdNo()==castOther.getResidentIdNo()) || ( this.getResidentIdNo()!=null && castOther.getResidentIdNo()!=null && this.getResidentIdNo().equals(castOther.getResidentIdNo()) ) )
 && ( (this.getInsureId()==castOther.getInsureId()) || ( this.getInsureId()!=null && castOther.getInsureId()!=null && this.getInsureId().equals(castOther.getInsureId()) ) )
 && ( (this.getEffectiveDate()==castOther.getEffectiveDate()) || ( this.getEffectiveDate()!=null && castOther.getEffectiveDate()!=null && this.getEffectiveDate().equals(castOther.getEffectiveDate()) ) )
 && ( (this.getEffectiveDate1()==castOther.getEffectiveDate1()) || ( this.getEffectiveDate1()!=null && castOther.getEffectiveDate1()!=null && this.getEffectiveDate1().equals(castOther.getEffectiveDate1()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getResidentIdNo() == null ? 0 : this.getResidentIdNo().hashCode() );
        result = 37 * result + ( getInsureId() == null ? 0 : this.getInsureId().hashCode() );
        result = 37 * result + ( getEffectiveDate() == null ? 0 : this.getEffectiveDate().hashCode() );
        result = 37 * result + ( getEffectiveDate1() == null ? 0 : this.getEffectiveDate1().hashCode() );
        return result;
    }   


}


