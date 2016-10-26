package gov.nia.nrs.dataquery.bean;

/**
 *
 * @author Jay Lin
 *
 */
public class ApplyCaseListResp {
    private String applyDate;
    private String receiveNo;
    private String applyType;
    private String reason;
    private String receiveBureau;
    private String decideMark;
    private String decideDate;
    private String exitExpiryDate;
    private String rcEndDate;
    private String residenceStatus;
    private String foreignPassportNo;
    private String passportNo;

    /**
     * @return the applyDate
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate the applyDate to set
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * @return the receiveNo
     */
    public String getReceiveNo() {
        return receiveNo;
    }

    /**
     * @param receiveNo the receiveNo to set
     */
    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    /**
     * @return the applyType
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * @param applyType the applyType to set
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the receiveBureau
     */
    public String getReceiveBureau() {
        return receiveBureau;
    }

    /**
     * @param receiveBureau the receiveBureau to set
     */
    public void setReceiveBureau(String receiveBureau) {
        this.receiveBureau = receiveBureau;
    }

    /**
     * @return the decideMark
     */
    public String getDecideMark() {
        return decideMark;
    }

    /**
     * @param decideMark the decideMark to set
     */
    public void setDecideMark(String decideMark) {
        this.decideMark = decideMark;
    }

    /**
     * @return the decideDate
     */
    public String getDecideDate() {
        return decideDate;
    }

    /**
     * @param decideDate the decideDate to set
     */
    public void setDecideDate(String decideDate) {
        this.decideDate = decideDate;
    }

    /**
     * @return the exitExpiryDate
     */
    public String getExitExpiryDate() {
        return exitExpiryDate;
    }

    /**
     * @param exitExpiryDate the exitExpiryDate to set
     */
    public void setExitExpiryDate(String exitExpiryDate) {
        this.exitExpiryDate = exitExpiryDate;
    }

    /**
     * @return the rcEndDate
     */
    public String getRcEndDate() {
        return rcEndDate;
    }

    /**
     * @param rcEndDate the rcEndDate to set
     */
    public void setRcEndDate(String rcEndDate) {
        this.rcEndDate = rcEndDate;
    }

    /**
     * @return the residenceStatus
     */
    public String getResidenceStatus() {
        return residenceStatus;
    }

    /**
     * @param residenceStatus the residenceStatus to set
     */
    public void setResidenceStatus(String residenceStatus) {
        this.residenceStatus = residenceStatus;
    }

    /**
     * @return the foreignPassportNo
     */
    public String getForeignPassportNo() {
        return foreignPassportNo;
    }

    /**
     * @param foreignPassportNo the foreignPassportNo to set
     */
    public void setForeignPassportNo(String foreignPassportNo) {
        this.foreignPassportNo = foreignPassportNo;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ApplyCaseListResp [applyDate=" + applyDate + ", receiveNo=" + receiveNo + ", applyType=" + applyType + ", reason=" + reason
                + ", receiveBureau=" + receiveBureau + ", decideMark=" + decideMark + ", decideDate=" + decideDate + ", exitExpiryDate=" + exitExpiryDate
                + ", rcEndDate=" + rcEndDate + ", residenceStatus=" + residenceStatus + ", foreignPassportNo=" + foreignPassportNo + ", passportNo="
                + passportNo + "]";
    }

}
