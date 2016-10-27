package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.ReportMgmt;
import gov.nia.nrs.service.ReportMgmtService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

public class ReportMgmtWebServiceImpl implements ReportMgmtWebService {

	
	@Resource ReportMgmtService reportMgmtService;
	
	@Override
	public ReportMgmt getQueryConditions(String reportId,UserProfile userProfile) {
		return reportMgmtService.getQueryConditions(reportId, userProfile);
	}

	@Override
	public Map<String, Object> getReportMgmtList(List<Attachment> attachments) {
		UserProfile up = attachments.get(0).getObject(UserProfile.class);
		ReportMgmt mgnt = attachments.get(1).getObject(ReportMgmt.class);
		Integer offset = attachments.get(2).getObject(Integer.class);
		
		// TODO Auto-generated method stub
		return reportMgmtService.getReportMgmtList(mgnt, up, offset);
	}

}
