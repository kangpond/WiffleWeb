/**
 *
 */
package gov.nia.nrs.dataquery.bean;

import org.apache.commons.lang.StringUtils;

/**
 * @author Jay Lin
 *
 */
public class PassportVo {

    private String passportNo;
    private String nation;
    private String sourceClassName;

    public PassportVo() {

    }

    public PassportVo(String passportNo, String nation) {
        this.passportNo = passportNo;
        this.nation = nation;
    }

    public PassportVo(String passportNo, String nation, String sourceClassName) {
        this.passportNo = passportNo;
        this.nation = nation;
        this.sourceClassName = sourceClassName;
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
     * @return the sourceClassName
     */
    public String getSourceClassName() {
        return sourceClassName;
    }

    /**
     * @param sourceClassName the sourceClassName to set
     */
    public void setSourceClassName(String sourceClassName) {
        this.sourceClassName = sourceClassName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PassportVo [passportNo=" + passportNo + ", nation=" + nation + ", sourceClassName=" + sourceClassName + "]";
    }

    /**
     * 回傳此物件的雜湊碼
     *
     * @return 雜湊碼
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((StringUtils.isBlank(nation)) ? 0 : nation.hashCode());
        result = prime * result + ((StringUtils.isBlank(passportNo)) ? 0 : passportNo.hashCode());
        return result;
    }

    /**
     * 表明傳入的參數是否等同於此物件
     *
     * @param obj 某一物件
     * @return 是否相等
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PassportVo other = (PassportVo) obj;
        if (StringUtils.isBlank(nation)) {
            if (StringUtils.isBlank(other.nation))
                return false;
        } else if (!nation.equals(other.nation))
            return false;
        if (StringUtils.isBlank(passportNo)) {
            if (StringUtils.isBlank(other.passportNo))
                return false;
        } else if (!passportNo.equals(other.passportNo))
            return false;
        return true;
    }
}
