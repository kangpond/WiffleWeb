package gov.nia.nrs.ws;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.eums.ProcessStateEnum;
import gov.nia.nrs.service.AuditQuerySevice;
import gov.nia.nrs.service.ReportMgmtService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;

public class AuditQueryWebSeviceImpl implements AuditQueryWebSevice {
	
    private static final Logger log = Logger.getLogger(AuditQueryWebSeviceImpl.class);

    @Resource AuditQuerySevice auditQuerySevice;
    @Resource ReportMgmtService reportMgmtService;
    
    
	@Override
	public void searchAuditQuery(List<Attachment> attachments) {
		// TODO Auto-generated method stub
		String reportId = "";
		try{
			UserProfile up = attachments.get(0).getObject(UserProfile.class);
			AuditQueryBean aqb = attachments.get(1).getObject(AuditQueryBean.class);
			String filePath = "";
			reportId = reportMgmtService.createReportMgmt(aqb, up);
			filePath = auditQuerySevice.searchAuditQuery(aqb,up,reportId);   //稽核查詢
			
			if (StringUtils.isNotBlank(filePath) && StringUtils.isNotEmpty(filePath)) {
				//成功
				if(StringUtils.isNotEmpty(reportId))
					reportMgmtService.updateReportMgmt(reportId, filePath,ProcessStateEnum.completed.getState());
		    }
		}catch(Exception e){
			log.error("AuditQueryAction SearchQuery Exception occurred:", e);;
			e.printStackTrace();
			//Exception
			if(StringUtils.isNotEmpty(reportId))
				reportMgmtService.updateReportMgmt(reportId, null, ProcessStateEnum.exception.getState());
		}
	}

}
