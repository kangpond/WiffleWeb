/**
 * 
 */
package gov.nia.nrs.sys.action;

import gov.nia.nrs.domain.Government;
import gov.nia.nrs.ws.GovernmentWebService;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yang
 *
 */
public class GovDialogAction extends DialogAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired GovernmentWebService governmentWebService;
	private Collection<Government> dialogs;
	private String deptId;
	private String deptName;
	
	/**
	 * @return the dialogs
	 */
	public Collection<Government> getDialogs() {
		return dialogs;
	}

	/**
	 * @param dialogs the dialogs to set
	 */
	public void setDialogs(Collection<Government> dialogs) {
		this.dialogs = dialogs;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	/* (non-Javadoc)
	 * @see gov.nia.nrs.sys.action.DialogAction#getLists()
	 */
	@Override
	@Action(value = "lists", results = {@Result(name = "success", type = "json")})
	public String getLists() {
		if (StringUtils.isBlank(keyword)) {
			dialogs = governmentWebService.getGovernmentMap().values();
	    } else {
	    	dialogs = new ArrayList<Government>();
	    	
	      for (Government gov : governmentWebService.getGovernmentMap().values()) {
	        if (StringUtils.contains(gov.getDeptName(), keyword)) {
	        	dialogs.add(gov);
	        }
	      }
	    }

	    return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see gov.nia.nrs.sys.action.DialogAction#getDescs()
	 */
	@Override
	@Action(value = "descs", results = {@Result(name = "success", type = "json")})
	public String getDescs() {
		// TODO Auto-generated method stub
	    setDeptName(governmentWebService.getGovDesc(deptId));
		return SUCCESS;
	}

}
