package gov.nia.nrs.ws;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import net.sf.jasperreports.engine.JRException;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.service.ReportService;

public class ReportWebServiceImpl implements ReportWebService {

	@Resource ReportService  reportService;
	
	@Override
	public String exportSummaryByDay(UserProfile userProfile, String startDate,
			String endDate, String userId) throws Exception {
		return reportService.exportSummaryByDay(userProfile, startDate,endDate,userId);
	}
	
	@Override
	public String downloadApplyFrom(String uuid) throws Exception {
		return reportService.downloadApplyFrom(uuid);
	}

}
