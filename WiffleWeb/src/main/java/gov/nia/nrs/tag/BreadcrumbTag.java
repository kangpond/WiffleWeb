package gov.nia.nrs.tag;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.Functions;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class BreadcrumbTag extends TagSupport {

	private static final Logger log = Logger.getLogger(BreadcrumbTag.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String functionId;

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	
	@Override
	public int doStartTag() throws JspException {
		if (StringUtils.isBlank(functionId))
			 return SKIP_BODY;
		 
		try {
			StringBuffer crumb = new StringBuffer("<span style='color:gray; font-size: 0.75 em;'>");
			UserProfile userProfile = getUserProfile();
			
			for (Functions function : userProfile.getFunctions()) {
				if(StringUtils.equals(functionId, function.getFunctionId())){
					crumb.append(getFunctionName(userProfile,function.getUpperFunctionId()));
					crumb.append("</span> >> <span style='color:red; font-size: 1 em;'>");
					crumb.append(function.getFunctionName()+"</span>");
					break;
				}
			}
			
			showBody(crumb.toString());
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
			showBody(StringUtils.EMPTY);
		}
		 
		return SKIP_BODY;
	}
	 
	
	private String getFunctionName(UserProfile userProfile, String currentFunctionId){
		String name = "";
		for (Functions function : userProfile.getFunctions()) {
			if(StringUtils.equals(currentFunctionId, function.getFunctionId())){
				name = function.getFunctionName();
				break;
			}
		}
		return name;
	}
	
	private UserProfile getUserProfile(){
		return (UserProfile) pageContext.getSession().getAttribute("userProfile");
	}
	
	private void showBody(String desc){
		try {
			this.pageContext.getOut().print(desc);
		} catch (Exception e) {
			log.error("DeptTag 執行錯誤",e);
		}
	}
	
	
}
