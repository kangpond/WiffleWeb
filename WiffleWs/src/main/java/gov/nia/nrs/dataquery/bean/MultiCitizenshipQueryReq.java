/**
 *
 */
package gov.nia.nrs.dataquery.bean;

/**
 * @author Jay Lin
 *
 */
public class MultiCitizenshipQueryReq {
    private String passportNo;
    private String birthDate;
    private String nation;

    /**
     * @return the passportNo
     */
    public String getPassportNo() {
        return passportNo;
    }

    /**
     * @param passportNo the passportNo to set
     */
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation the nation to set
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MultiCitizenshipQueryReq [passportNo=" + passportNo + ", birthDate=" + birthDate + ", nation=" + nation + "]";
    }

}
