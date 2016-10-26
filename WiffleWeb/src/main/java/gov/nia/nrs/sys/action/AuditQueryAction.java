package gov.nia.nrs.sys.action;

import java.util.ArrayList;
import java.util.List;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.ws.AuditQueryWebSevice;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;


public class AuditQueryAction extends BaseAction implements ModelDriven<AuditQueryBean> {

    private static final Logger log = Logger.getLogger(AuditQueryAction.class);

	private static final long serialVersionUID = 1L;

//	@Resource AuditQuerySevice auditQuerySevice;
//	@Resource ReportMgmtDao reportMgmtDao;
	
	@Resource AuditQueryWebSevice auditQueryWebSevice;
	
	private AuditQueryBean aqb; 
	
	private UserProfile up = getUserProfile();
	
	@Override
	public AuditQueryBean getModel() {
		// TODO Auto-generated method stub
		if(aqb == null)
		   aqb = new AuditQueryBean();
		return aqb;
	}

	
	/**
	 * 稽核查詢紀錄
	 * @return
	 */
	@Action(value = "/searchAuditQuery", results = {
			@Result(name = "success", location = "audit.query", type = "tiles")
	})
	public String searchAuditQuery(){
		return SUCCESS;
	}
	
	
	@Action(value = "/searchSummary", results = {
			@Result(name = "success", location = "audit.summary", type = "tiles")
	})
	public String searchSummary(){
		return SUCCESS;
	}
	
	@Action(value = "/searchQuery", results = {
			@Result(name = "success", location = "/reportMgmt/getReportMgmts.action", type = "redirect"),
	})
	public String searchQuery(){
		Thread t = new Thread(
		  new Runnable() {
			@Override
			public void run() {
				List<Attachment> attachments = new ArrayList<Attachment>();
		        attachments.add(new Attachment("userProfile", "application/json", up));
		        attachments.add(new Attachment("auditQueryBean", "application/json", aqb));
				
				auditQueryWebSevice.searchAuditQuery(attachments);
			}
		});
		t.start();
		
		return SUCCESS;
	}
	
	
}
