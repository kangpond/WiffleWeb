/**
 *
 */
package gov.nia.nrs.dataquery.bean;

/**
 * @author Jay Lin
 *
 */
public class ImmiListResp {
    private String immigrateType;
    private String immigrateDate;
    private String port;
    private String flightNo;
    private String fromTo;
    private String immigWay;
    private String permitNo;
    private String passportNo;
    private String fromDaily;

    /**
     * @return the immigrateType
     */
    public String getImmigrateType() {
        return immigrateType;
    }

    /**
     * @param immigrateType the immigrateType to set
     */
    public void setImmigrateType(String immigrateType) {
        this.immigrateType = immigrateType;
    }

    /**
     * @return the immigrateDate
     */
    public String getImmigrateDate() {
        return immigrateDate;
    }

    /**
     * @param immigrateDate the immigrateDate to set
     */
    public void setImmigrateDate(String immigrateDate) {
        this.immigrateDate = immigrateDate;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the flightNo
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * @param flightNo the flightNo to set
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    /**
     * @return the fromTo
     */
    public String getFromTo() {
        return fromTo;
    }

    /**
     * @param fromTo the fromTo to set
     */
    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    /**
     * @return the immigWay
     */
    public String getImmigWay() {
        return immigWay;
    }

    /**
     * @param immigWay the immigWay to set
     */
    public void setImmigWay(String immigWay) {
        this.immigWay = immigWay;
    }

    /**
     * @return the permitNo
     */
    public String getPermitNo() {
        return permitNo;
    }

    /**
     * @param permitNo the permitNo to set
     */
    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
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
     * @return the fromDaily
     */
    public String getFromDaily() {
        return fromDaily;
    }

    /**
     * @param fromDaily the fromDaily to set
     */
    public void setFromDaily(String fromDaily) {
        this.fromDaily = fromDaily;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ImmiListResp [immigrateType=" + immigrateType + ", immigrateDate=" + immigrateDate + ", port=" + port + ", flightNo=" + flightNo + ", fromTo="
                + fromTo + ", immigWay=" + immigWay + ", permitNo=" + permitNo + ", passportNo=" + passportNo + ", fromDaily=" + fromDaily + "]";
    }


}
