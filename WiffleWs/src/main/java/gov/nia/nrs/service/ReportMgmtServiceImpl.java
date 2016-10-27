package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.ReportMgmtDao;
import gov.nia.nrs.domain.ReportMgmt;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reportMgmtService")
@Transactional
public class ReportMgmtServiceImpl implements ReportMgmtService {

    private static final Logger log = Logger.getLogger(ReportMgmtServiceImpl.class);

    @Resource ReportMgmtDao reportMgmtDao;
//    @Resource AuditCreateDao auditCreateDao;
    

	@Override
	public Map<String,Object> getReportMgmtList(ReportMgmt mgnt,UserProfile up,int offset) {
//		if(StringUtils.equals(up.getOperationType(), FunctionEnum.F3.getOperationType())){
//			auditCreateDao.createQueryAudit(mgnt, up);
//		}
		return reportMgmtDao.getReportMgmtList(mgnt,up,offset);
	}



	@Override
	public ReportMgmt getQueryConditions(String reportId,UserProfile up) {
		ReportMgmt mgnt = reportMgmtDao.find(reportId);
//		auditCreateDao.createQueryAudit(mgnt, up);
		return mgnt;
	}



	@Override
	public String createReportMgmt(AuditQueryBean aqb, UserProfile up) {
		return reportMgmtDao.createReportMgmt(aqb, up);
	}



	@Override
	public void updateReportMgmt(String reportId, String filePath, String state) {
		reportMgmtDao.updateReportMgmt(reportId, filePath, state);
	}
}
