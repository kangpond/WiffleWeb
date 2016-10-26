package gov.nia.nrs.utils;



import gov.nia.nrs.utils.codeutils.CodeMappingService;
import gov.nia.nrs.utils.codeutils.CodeVo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 * 地址工具類別
 *
 * @author <a href="mailto:terry.lee@hyweb.com.tw">Terry Lee</a>
 * @version Revision: 1 Date: 2012/10/19 下午9:15:25
 * @see $Author: 95050 $ $Revision: 38606 $ $Date: 2014-01-08 17:42:47 +0800 (Wed, 08 Jan 2014) $
 */
@Repository("addressUtils")
public class AddressUtils {
    private static Logger logger = LoggerFactory.getLogger(AddressUtils.class);

    @Autowired
    private CodeMappingService codeMappingService;

    private static final String ZIP_CODE = "zipCode";
    private static final String CITY = "city";
    private static final String TOWNSHIP = "township";
    private static final String VILLAGE = "village";
    private static final String NEIGHBORHOOD = "neighborhood";
    private static final String ROAD = "road";
    private static final String LANE = "lane";
    private static final String ALLEY = "alley";
    private static final String NUMBER = "number";


    /**
     * 取得合併後的地址字串
     *
     * @param zipCode 郵遞區號
     * @param city 縣市代碼
     * @param township 鄉鎮市區代碼
     * @param village 村里名
     * @param neighborhood 鄰別
     * @param road 街、路段
     * @param lane 巷
     * @param alley 弄
     * @param number 門牌號
     * @return 合併後的地址字串
     * @author Allen 2014/01/07
     */
    public String getDisplayAddress(String zipCode, String city, String township, String village, String neighborhood, String road, String lane, String alley,
            String number) {

        CodeVo codeVo = null;
        boolean result = false;

        city = StringUtil.chkNull2empty(city).trim(); // 資料面City有2個空白的，user要求不show，因此於此trim掉 -- allen 2014/01/07
        if (!city.isEmpty()) {
            try {
                codeVo = codeMappingService.getCode("612", city);
                city = codeVo.getCodeName();
                result = true;
            } catch (Exception e) {
                logger.error("codeService.getCode fail", e);
                logger.error("category {} code {}", "612", city);
                city = e.getMessage();
                township = e.getMessage();
            }
        }

        township = StringUtil.chkNull2empty(township).trim(); // -- allen 2014/01/07
        if (!township.isEmpty() && result) {
            try {
                codeVo = codeMappingService.getCode(codeVo.getComment(), township);
                township = codeVo.getCodeName();
            } catch (Exception e) {
                logger.error("codeService.getCode fail", e);
                logger.error("category {} code {}", codeVo.getComment(), township);
                township = e.getMessage();
            }
        } else {
            township = StringUtils.EMPTY;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.trimToEmpty(zipCode));
        sb.append(city);
        sb.append(township);
        // 2013/01/16 Terry Lee
        // 根據戶役政規範，村(里)由使用者登打
        sb.append(StringUtils.trimToEmpty(village))/* .append(StringUtils.isBlank(village) ? StringUtils.EMPTY : "村(里)") */;
        sb.append(StringUtils.trimToEmpty(neighborhood)).append(StringUtils.isBlank(neighborhood) ? StringUtils.EMPTY : "鄰");
        sb.append(StringUtils.trimToEmpty(road));
        sb.append(StringUtils.trimToEmpty(lane)).append(StringUtils.isBlank(lane) ? StringUtils.EMPTY : "巷");
        sb.append(StringUtils.trimToEmpty(alley)).append(StringUtils.isBlank(alley) ? StringUtils.EMPTY : "弄");
        sb.append(StringUtils.trimToEmpty(number));

        return sb.toString();
    }

    /**
     *
     * 取得物件裡地址的資訊
     *
     * @param addrObj
     * @param prefix
     * @param suffix
     * @return 地址資訊
     * @author Eric Shih
     * @version 2013/4/30 下午4:49:44
     */
    public String getPOJOAddress(Object addrObj, String prefix, String suffix) {
        if (addrObj == null) {
            return null;
        }
        String[] names = new String[] {ZIP_CODE, CITY, TOWNSHIP, VILLAGE, NEIGHBORHOOD, ROAD, LANE, ALLEY, NUMBER};

        // 改變的地址的前綴字、後綴字
        String name = null;
        for (int i = 0; i < names.length; i++) {
            name = names[i];

            if (StringUtils.isNotBlank(prefix)) {
                name = prefix + name.substring(0, 1).toUpperCase() + name.substring(1);
            }

            if (StringUtils.isNotBlank(suffix)) {
                name += suffix;
            }

            names[i] = name;
        }

        // 取得地址
        String address = null;
        try {
            Object zipCode = PropertyUtils.getSimpleProperty(addrObj, names[0]);

            address =
                    getDisplayAddress(zipCode == null ? null : zipCode.toString(), (String) PropertyUtils.getSimpleProperty(addrObj, names[1]),
                            (String) PropertyUtils.getSimpleProperty(addrObj, names[2]), (String) PropertyUtils.getSimpleProperty(addrObj, names[3]),
                            (String) PropertyUtils.getSimpleProperty(addrObj, names[4]), (String) PropertyUtils.getSimpleProperty(addrObj, names[5]),
                            (String) PropertyUtils.getSimpleProperty(addrObj, names[6]), (String) PropertyUtils.getSimpleProperty(addrObj, names[7]),
                            (String) PropertyUtils.getSimpleProperty(addrObj, names[8]));
        } catch (Exception e) {
            return null;
        }

        return address;
    }

    public CodeMappingService getCodeMappingService() {
        return codeMappingService;
    }

    public void setCodeMappingService(CodeMappingService codeMappingService) {
        this.codeMappingService = codeMappingService;
    }


}
