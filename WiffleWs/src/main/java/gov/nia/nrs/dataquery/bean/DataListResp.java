/**
 *
 */
package gov.nia.nrs.dataquery.bean;

/**
 * @author Jay Lin
 *
 */
public class DataListResp {
    private String residentIdNo;
    private String chineseName;
    private String englishName;
    private String birthDate;
    private String passportNo;
    private String personId;
    private String firstReceiveNo;

    /**
     * @return the residentIdNo
     */
    public String getResidentIdNo() {
        return residentIdNo;
    }

    /**
     * @param residentIdNo the residentIdNo to set
     */
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }

    /**
     * @return the chineseName
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * @param chineseName the chineseName to set
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    /**
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName the englishName to set
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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
     * @return the personId
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return the firstReceiveNo
     */
    public String getFirstReceiveNo() {
        return firstReceiveNo;
    }

    /**
     * @param firstReceiveNo the firstReceiveNo to set
     */
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DataListBean [residentIdNo=" + residentIdNo + ", chineseName=" + chineseName + ", englishName=" + englishName + ", birthDate=" + birthDate
                + ", passportNo=" + passportNo + ", personId=" + personId + ", firstReceiveNo=" + firstReceiveNo + "]";
    }

}
