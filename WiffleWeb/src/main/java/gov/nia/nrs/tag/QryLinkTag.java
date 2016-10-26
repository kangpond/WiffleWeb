/**
 * 
 */
package gov.nia.nrs.tag;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.Functions;

import java.io.File;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Yang
 *
 */
public class QryLinkTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(QryLinkTag.class);

	private String firstReceiveNo;
	private String residentIdNo;
	
	/**
	 * @return the firstReceiveNo
	 */
	public String getFirstReceiveNo() {
		return firstReceiveNo;
	}

	/**
	 * @param firstReceiveNo the firstReceiveNo to set
	 */
	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	/**
	 * @return the residentIdNo
	 */
	public String getResidentIdNo() {
		return residentIdNo;
	}

	/**
	 * @param residentIdNo the residentIdNo to set
	 */
	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = residentIdNo;
	}

	

	@Override
	public int doStartTag() throws JspException {
	
		if (StringUtils.isBlank(firstReceiveNo))
			 return SKIP_BODY;
		
		UserProfile userProfile = (UserProfile) this.pageContext.getSession().getAttribute("userProfile");
		
		List<Functions> qrys = userProfile.getOtherFunctions();
		
		if(qrys != null && qrys.size() > 0){
			StringBuffer links = new StringBuffer();
			for(Functions f: qrys){
				links.append("<li>")
					 .append("<a href=")
					 .append(this.pageContext.getServletContext().getContextPath())
					 .append(f.getLinkUrl())
					 .append("?firstReceiveNo="+firstReceiveNo);
					 
					 if(StringUtils.isNotEmpty(residentIdNo)){
						 links.append("&residentIdNo="+residentIdNo);
					 }
				links.append(">");
					 
				links.append("<label>").append(f.getFunctionName())
					 .append("</label></a></li>");
			}
			showBody(links.toString());
		}
		return SKIP_BODY;
	}
	
	
	private void showBody(String desc){
		try {
			this.pageContext.getOut().print(desc);
		} catch (Exception e) {
			log.error("QryLinkTag 執行錯誤",e);
		}
	}
}
