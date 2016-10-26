/**
 * 
 */
package gov.nia.nrs.tag;

import gov.nia.nrs.utils.StringUtil;
import gov.nia.nrs.ws.GovernmentWebService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author A0017
 *
 */
public class GovTag extends TagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GovTag.class);

    public String deptId;

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
    
    @Override
    public int doStartTag() throws JspException {
    	
    	if (StringUtils.isBlank(deptId))
			return SKIP_BODY;
    	
    	try{
    		GovernmentWebService governmentService =
	                (GovernmentWebService) WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext()).getBean(
	                        "governmentWebService");
			String desc = governmentService.getGovDesc(deptId);
			if(!StringUtil.isEmptyOrBlank(desc))
				showBody(desc);
		}catch (Exception e){
			log.error(e);
			showBody(e.getMessage());
		}
		return SKIP_BODY;
    }
    
    
    private void showBody(String desc){
		try {
			this.pageContext.getOut().print(desc);
		} catch (Exception e) {
			log.error("DeptTag 執行錯誤",e);
		}
	}
}
