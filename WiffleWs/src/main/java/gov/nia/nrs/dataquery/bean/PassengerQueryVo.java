/**
 *
 */
package gov.nia.nrs.dataquery.bean;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public class PassengerQueryVo {
    private String englishName;
    private String nation;
    private String birthDate;
    private List<PassportVo> passportList;
    private String personId;
    private String firstReceiveNo;

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
     * @return the passportList
     */
    public List<PassportVo> getPassportList() {
        return passportList;
    }

    /**
     * @param passportList the passportList to set
     */
    public void setPassportList(List<PassportVo> passportList) {
        this.passportList = passportList;
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
        return "PassengerQueryVo [englishName=" + englishName + ", nation=" + nation + ", birthDate=" + birthDate + ", passportList=" + passportList
                + ", personId=" + personId + ", firstReceiveNo=" + firstReceiveNo + "]";
    }

}
