package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.domain.ReportMgmt;
import gov.nia.nrs.ws.ReportMgmtWebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;

public class ReportMgmtAction extends BaseAction implements ModelDriven<ReportMgmt>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource ReportMgmtWebService reportMgmtWebService;
	
	public ReportMgmt mgnt;
	public Date sysDate;
	
	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	@Override
	public ReportMgmt getModel() {
		if(mgnt == null)
		   mgnt= new ReportMgmt();
		return mgnt;
	}

	@Action(value = "/searchReportMgmt", results = {
			@Result(name = "success", location = "reportMgmt.query.tiles", type = "tiles")}
	)
	public String searchReportMgmt(){
//		mgnt.setStartDate(DateUtils.getDateStr(new Date()));
//		mgnt.setEndDate(DateUtils.getDateStr(new Date()));
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "/getReportMgmts", results = {
			@Result(name = "success", location = "reportMgmt.list.tiles", type = "tiles")}
	)
	public String getReportMgmts(){
		
		List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userProfile", "application/json", getUserProfile()));
        attachments.add(new Attachment("reportMgmt", "application/json", mgnt));
        attachments.add(new Attachment("offset", "application/json", getPageIndex()));
		
		Map<String,Object> resultMap = reportMgmtWebService.getReportMgmtList(attachments);
	    totalSize = (int) resultMap.get("totalCount");
		displayList = (List<? extends Object>) resultMap.get("reportMgmtList");
		sysDate = new Date();
		return SUCCESS;
	}
	
	
	@Action(value = "/queryinfo", results = {
			@Result(name = "success", location = "reportMgmt.info.tiles", type = "tiles")}
	)
	public String queryinfo(){
		mgnt = reportMgmtWebService.getQueryConditions(mgnt.getReportId(),getUserProfile());
		return SUCCESS;
	}
}
