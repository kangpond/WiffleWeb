package gov.nia.nrs.utils.vo;

import java.io.Serializable;

public class NiiAddressVo implements Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    /** 郵遞區號 */
    private String zipCode;

    /** 縣市代碼 */
    private String city;

    /** 鄉鎮市區代碼 */
    private String township;

    /** 村里名 */
    private String village;

    /** 鄰別 */
    private String neighborhood;

    /** 街、路段 */
    private String road;

    /** 巷 */
    private String lane;

    /** 弄 */
    private String alley;

    /** 門牌號 */
    private String number;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
