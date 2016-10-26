/**
 * 
 */
package gov.nia.nrs.tag;

import gov.nia.nrs.utils.DescUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Yang
 *
 */
public class DescTag extends TagSupport {

	private static final Logger log = Logger.getLogger(DescTag.class);

	private static final long serialVersionUID = 1L;

	private String value;
	private String type;
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	@Override
	public int doStartTag() throws JspException {
		if (StringUtils.isBlank(type))
			return SKIP_BODY;
		
		if (StringUtils.isBlank(value))
			return SKIP_BODY;
		
		String desc = "";
				
		switch (type) {
			case "1": //顯示 有、無
				desc = DescUtils.getYesOrNot(value);
			break;
			case "2": //職業
				desc = DescUtils.getOccupationDesc(value);
			break;
			case "3":
				desc = DescUtils.getCONTROL(value);
			break;
			case "4":
				desc = DescUtils.getCaseStudy(value);
			break;
			case "5":
				desc = DescUtils.getDeadOrAlive(value);
			break;
			case "6":
				desc = DescUtils.getHealthType(value);
			break;
			case "7":
				desc = DescUtils.getStuntType(value);
			break;
			case "8":
				desc = DescUtils.getHandiCapType(value);
			break;
			case "9":
				desc = DescUtils.getDisabilityClass(value);
			break;
			default:
				break;
		}		
				
		showBody(desc);
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
