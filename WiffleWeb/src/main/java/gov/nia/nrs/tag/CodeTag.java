package gov.nia.nrs.tag;

import gov.nia.nrs.utils.codeutils.CodeMappingService;
import gov.nia.nrs.utils.codeutils.CodeVo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Code Tag Handler
 *
 */
public class CodeTag extends TagSupport {
    private static final long serialVersionUID = System.currentTimeMillis();
    private Logger logger = LoggerFactory.getLogger(getClass());

    /** 代碼種類 */
    private String category;

    /** 代碼 */
    private String code;

    /** HTML Error Template */
    private String errorTemplate = "<span class='error'>{}</span>";

    /**
     * 返回的中文代碼說明類別 2:desc2 3: desc + desc2 4: codeName且會將傳入值前面的0清除
     */
    private String categoryType;

    private CodeMappingService codeService;

    /**
     * 執行起始標籤所要做的邏輯
     *
     * @return javax.servlet.jsp.tagext.Tag.SKIP_BODY
     * @author HyWeb A1002
     * @since
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    @Override
    public int doStartTag() {
        if (StringUtils.isBlank(category))
            return SKIP_BODY;

        if (StringUtils.isBlank(code))
            return SKIP_BODY;

        try {
            String desc = null;
            logger.debug("category = {}", category);
            logger.debug("code = {}", code);
            logger.debug("categoryType = {}", categoryType);

            if ("4".equals(categoryType)) {
                Integer id = Integer.valueOf(code);
                code = id.toString();
            }

            if (codeService == null) {
                logger.debug("start get codeMappingService bean");
                WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
                codeService = (CodeMappingService) webApplicationContext.getBean("codeMappingService");
            }

            CodeVo codeVo = codeService.getCode(category, code);
            if (codeVo != null) {
                if ("2".equals(categoryType)) {
                    desc = codeVo.getComment();
                } else if ("3".equals(categoryType)) {
                    desc = codeVo.getCodeName() + ((codeVo.getComment() == null) ? "" : codeVo.getComment());
                } else if ("4".equals(categoryType)) {
                    desc = codeVo.getCodeName();
                } else {
                    desc = codeService.getCodeName(category, code);
                }
            }
            if (StringUtils.isNotBlank(desc))
                this.pageContext.getOut().print(desc);
        } catch (Exception e) {
            String desc = errorTemplate.replace("{}", e.toString());
            logger.error(desc, e);
            this.print(desc);
        }

        return SKIP_BODY;
    }

    /**
     * 將訊息秀在頁面
     *
     * @param msg
     * @throws JspException
     * @author Ivan Chen
     */
    private void print(String msg) {
        try {
            this.pageContext.getOut().print(msg);
        } catch (Exception e) {
            logger.error("CodeTag 執行錯誤", e);
        }
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = (null == category) ? category : category.trim();
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = (null == code) ? code : code.trim();
    }

    /**
     * @return the categoryType
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType the categoryType to set
     */
    public void setCategoryType(String categoryType) {
        this.categoryType = (null == categoryType) ? categoryType : categoryType.trim();;
    }
}
