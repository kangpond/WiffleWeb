package gov.nia.nrs.utils;


import gov.nia.nrs.utils.codeutils.CodeMappingService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 標題： 出生地工具類別<br/>
 * 說明： 出生地工具類別
 */
@Repository("birthPlaceUtils")
public class BirthPlaceUtils {

    /**
     * 日誌
     */
    private static Logger logger = LoggerFactory.getLogger(BirthPlaceUtils.class);

    /**
     * 出生地代碼類別
     */
    private static String birthPlaceCodeCategory = "2";

    /**
     * 出生地省市類別
     */
    private static String birthPlaceProvinceCityCategory = "3";

    /**
     * 出生地國籍類別
     */
    private static String birthPlaceNationalityCategory = "15";

    /**
     * 出生地國籍代碼
     */
    private static String birthPlaceNationalityCode = "5";

    /**
     * 錯誤樣版
     */
    private static String errorTemplate = "Data Not Found! cate: %s code: %s";

    /**
     * 代碼服務介面
     */
    @Autowired
    private CodeMappingService codeMappingService;


    public String getBirthPlace(String birthPlaceCode, String birthPlace1, String birthPlace2, String errorTemplate) {
        int birthPlaceCodeInt = 0;
        String birthPlace = null;
        String birthPlaceCodeName = null;
        String birthPlace1Name = null;

        if (StringUtils.isBlank(birthPlaceCode)) {
            return StringUtils.EMPTY;
        }

        try {
            birthPlaceCodeName = getCodeName(birthPlaceCodeCategory, birthPlaceCode, errorTemplate);
            birthPlace1Name =
                    getCodeName(birthPlaceNationalityCode.equals(birthPlaceCode) ? birthPlaceNationalityCategory : birthPlaceProvinceCityCategory, birthPlace1,
                            errorTemplate);
            birthPlaceCodeInt = Integer.parseInt(birthPlaceCode);

            switch (birthPlaceCodeInt) {
                case 1:
                case 2:
                    birthPlace = new StringBuilder(birthPlaceCodeName).insert(0, birthPlace1Name).insert(birthPlace1Name.length() + 1, birthPlace2).toString();
                    break;
                case 3:
                case 4:
                    birthPlace = birthPlace1Name + birthPlaceCodeName;
                    break;
                case 5:
                    birthPlace = birthPlace1Name;
                    break;
                default:
                    birthPlace = birthPlaceCodeName + birthPlace1Name + birthPlace2;
                    break;
            }
        } catch (Exception e) {
            String msg = "BirthPlaceUtils 組合錯誤";
            logger.error(msg, e);
            birthPlace = e.getMessage() == null ? msg : e.getMessage();
        }

        return birthPlace;
    }

    public String getBirthPlace(String birthPlaceCode, String birthPlace1, String birthPlace2) {
        return getBirthPlace(birthPlaceCode, birthPlace1, birthPlace2, errorTemplate);
    }

    /**
     * 取得代碼名稱
     *
     * @param category 類別
     * @param code 代碼
     * @return 代碼名稱
     * @author Terry Lee
     */
    private String getCodeName(String category, String code, String errorTemplate) throws Exception {
        String codeName = null;

        if (StringUtils.isBlank(code)) {
            codeName = StringUtils.EMPTY;
            return codeName;
        }

        try {
            codeName = codeMappingService.getCodeName(category, code);
        } catch (Exception e) {
            logger.debug("codeMappingService.getCodeName error", e);
            codeName = String.format(errorTemplate, category, code);
            throw new Exception(codeName);
        }

        return codeName;
    }

    public CodeMappingService getCodeMappingService() {
        return codeMappingService;
    }

    public void setCodeMappingService(CodeMappingService codeMappingService) {
        this.codeMappingService = codeMappingService;
    }


}
