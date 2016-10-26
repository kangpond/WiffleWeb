package gov.nia.nrs.tag;

import gov.nia.nrs.eums.ProcessStateEnum;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;

public class ProcessStateTag extends SimpleTagSupport {

	
	private String state;

	public void setState(String state) {
		this.state = state;
	}
	
	 /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().println(getProcessStateDesc(state));
    }

    /**
     * processState 1 = 執行中, 2 = 執行完成, 3 = 執行異常
     */
    private String getProcessStateDesc(String state){
    	String desc = "";
    	if(StringUtils.isNotEmpty(state)){
    		desc = ProcessStateEnum.fromState(state).getDescription();
    	}
    	return desc;
    }
    
}
