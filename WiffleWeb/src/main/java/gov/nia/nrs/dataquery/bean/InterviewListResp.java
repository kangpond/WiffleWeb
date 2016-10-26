/**
 *
 */
package gov.nia.nrs.dataquery.bean;

/**
 * @author Jay Lin
 *
 */
public class InterviewListResp {
    private String receiveNo;
    private String f2fPerson;
    private String startF2fTalkDate;
    private String talkPlace;
    private String f2fResult;
    private String seq;

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
     * @return the f2fPerson
     */
    public String getF2fPerson() {
        return f2fPerson;
    }

    /**
     * @param f2fPerson the f2fPerson to set
     */
    public void setF2fPerson(String f2fPerson) {
        this.f2fPerson = f2fPerson;
    }

    /**
     * @return the startF2fTalkDate
     */
    public String getStartF2fTalkDate() {
        return startF2fTalkDate;
    }

    /**
     * @param startF2fTalkDate the startF2fTalkDate to set
     */
    public void setStartF2fTalkDate(String startF2fTalkDate) {
        this.startF2fTalkDate = startF2fTalkDate;
    }

    /**
     * @return the talkPlace
     */
    public String getTalkPlace() {
        return talkPlace;
    }

    /**
     * @param talkPlace the talkPlace to set
     */
    public void setTalkPlace(String talkPlace) {
        this.talkPlace = talkPlace;
    }

    /**
     * @return the f2fResult
     */
    public String getF2fResult() {
        return f2fResult;
    }

    /**
     * @param f2fResult the f2fResult to set
     */
    public void setF2fResult(String f2fResult) {
        this.f2fResult = f2fResult;
    }

    /**
     * @return the seq
     */
    public String getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "InterviewListResp [receiveNo=" + receiveNo + ", f2fPerson=" + f2fPerson + ", startF2fTalkDate=" + startF2fTalkDate + ", talkPlace=" + talkPlace
                + ", f2fResult=" + f2fResult + ", seq=" + seq + "]";
    }

}
