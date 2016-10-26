package gov.nia.nrs.tag;


import gov.nia.nrs.utils.BirthPlaceUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 標題： 出生地標籤<br/>
 * 說明： 出生地標籤
 */
public class BirthPlaceTag extends TagSupport {

    /**
     * 序列版本流水號
     */
    private static final long serialVersionUID = System.currentTimeMillis();

    /**
     * 錯誤樣版
     */
    private String errorTemplate = "<span class='error'>Data Not Found! cat: %s code: %s</span>";

    /**
     * 日誌紀錄器
     */
    private Logger logger = LoggerFactory.getLogger(super.getClass());

    /**
     * 省市國籍代碼
     */
    private String birthPlaceCode;

    /**
     * 出生地-1
     */
    private String birthPlace1;

    /**
     * 出生地-2
     */
    private String birthPlace2;

    private BirthPlaceUtils birthPlaceUtils;

    /**
     * 處理開始標籤，回傳 SKIP_BODY。
     *
     * @return SKIP_BODY
     * @throws JspException 如果在處理這個標籤時發生錯誤
     */
    @Override
    public int doStartTag() {
        Integer result = null;
        try {
            if (birthPlaceUtils == null) {
                logger.debug("get birthPlaceUtils bean.");
                WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
                birthPlaceUtils = (BirthPlaceUtils) webApplicationContext.getBean("birthPlaceUtils");
                if (birthPlaceUtils == null) {
                    logger.debug("birthPlaceUtils is still null..  SKIP_BODY");
                    return SKIP_BODY;
                }
            }
            String birthPlace = birthPlaceUtils.getBirthPlace(birthPlaceCode, birthPlace1, birthPlace2, errorTemplate);
            super.pageContext.getOut().print(birthPlace);
        } catch (Exception e) {
            String msg = "BirthPlaceTag 寫出錯誤";
            logger.error(msg, e);
        }

        try {
            result = super.doStartTag();
        } catch (JspException e) {
            logger.error("BirthPlaceTag 發生錯誤", e);
        }
        return result;
    }

    /**
     * 取得省市國籍代碼屬性
     *
     * @return 該省市國籍代碼屬性內容 the birthPlaceCode
     */
    public String getBirthPlaceCode() {
        return birthPlaceCode;
    }

    /**
     * 設定省市國籍代碼屬性
     *
     * @param 傳入省市國籍代碼參數 birthPlaceCode the birthPlaceCode to set
     */
    public void setBirthPlaceCode(String birthPlaceCode) {
        this.birthPlaceCode = StringUtils.trimToEmpty(birthPlaceCode);
    }

    /**
     * 取得出生地-1屬性
     *
     * @return 該出生地-1屬性內容 the birthPlace1
     */
    public String getBirthPlace1() {
        return birthPlace1;
    }

    /**
     * 設定出生地-1屬性
     *
     * @param 傳入出生地-1參數 birthPlace1 the birthPlace1 to set
     */
    public void setBirthPlace1(String birthPlace1) {
        this.birthPlace1 = StringUtils.trimToEmpty(birthPlace1);
    }

    /**
     * 取得出生地-2屬性
     *
     * @return 該出生地-2屬性內容 the birthPlace2
     */
    public String getBirthPlace2() {
        return birthPlace2;
    }

    /**
     * 設定出生地-2屬性
     *
     * @param 傳入出生地-2參數 birthPlace2 the birthPlace2 to set
     */
    public void setBirthPlace2(String birthPlace2) {
        this.birthPlace2 = StringUtils.trimToEmpty(birthPlace2);
    }

}
