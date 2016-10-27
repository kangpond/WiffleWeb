package gov.nia.nrs.domain.imm;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DailyImmigrationsId generated by hbm2java
 */
@Embeddable
public class DailyImmigrationsId  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String edCardNo;
    private Integer port;
    private String immigrateDate;
    private Integer immigrateSeq;

    public DailyImmigrationsId() {}

    public DailyImmigrationsId(String edCardNo, Integer port, String immigrateDate, Integer immigrateSeq) {
        this.edCardNo = edCardNo;
        this.port = port;
        this.immigrateDate = immigrateDate;
        this.immigrateSeq = immigrateSeq;
    }
   


    @Column(name="EdCardNo", nullable=false, length=20)
    public String getEdCardNo() {
        return this.edCardNo;
    }
    
    public void setEdCardNo(String edCardNo) {
        this.edCardNo = edCardNo;
    }


    @Column(name="Port", nullable=false, precision=2, scale=0)
    public Integer getPort() {
        return this.port;
    }
    
    public void setPort(Integer port) {
        this.port = port;
    }


    @Column(name="ImmigrateDate", nullable=false, length=8)
    public String getImmigrateDate() {
        return this.immigrateDate;
    }
    
    public void setImmigrateDate(String immigrateDate) {
        this.immigrateDate = immigrateDate;
    }


    @Column(name="ImmigrateSeq", nullable=false, precision=5, scale=0)
    public Integer getImmigrateSeq() {
        return this.immigrateSeq;
    }
    
    public void setImmigrateSeq(Integer immigrateSeq) {
        this.immigrateSeq = immigrateSeq;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		if ( (other == null ) ) return false;
		if ( !(other instanceof DailyImmigrationsId) ) return false;
		DailyImmigrationsId castOther = ( DailyImmigrationsId ) other; 
         
		return ( (this.getEdCardNo()==castOther.getEdCardNo()) || ( this.getEdCardNo()!=null && castOther.getEdCardNo()!=null && this.getEdCardNo().equals(castOther.getEdCardNo()) ) )
 && ( (this.getPort()==castOther.getPort()) || ( this.getPort()!=null && castOther.getPort()!=null && this.getPort().equals(castOther.getPort()) ) )
 && ( (this.getImmigrateDate()==castOther.getImmigrateDate()) || ( this.getImmigrateDate()!=null && castOther.getImmigrateDate()!=null && this.getImmigrateDate().equals(castOther.getImmigrateDate()) ) )
 && ( (this.getImmigrateSeq()==castOther.getImmigrateSeq()) || ( this.getImmigrateSeq()!=null && castOther.getImmigrateSeq()!=null && this.getImmigrateSeq().equals(castOther.getImmigrateSeq()) ) );
    }
   
    public int hashCode() {
        int result = 17;

        result = 37 * result + ( getEdCardNo() == null ? 0 : this.getEdCardNo().hashCode() );
        result = 37 * result + ( getPort() == null ? 0 : this.getPort().hashCode() );
        result = 37 * result + ( getImmigrateDate() == null ? 0 : this.getImmigrateDate().hashCode() );
        result = 37 * result + ( getImmigrateSeq() == null ? 0 : this.getImmigrateSeq().hashCode() );
        return result;
    }   


}


