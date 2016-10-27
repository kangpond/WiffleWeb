/**
 * 
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.domain.Government;
import gov.nia.nrs.service.GovernmentService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @author Yang
 *
 */
public class GovernmentWebServiceImpl implements GovernmentWebService {

	@Resource GovernmentService governmentService;
	
	/* (non-Javadoc)
	 * @see gov.nia.nrs.ws.GovernmentWebService#getGovDesc(java.lang.String)
	 */
	@Override
	public String getGovDesc(String deptId) {
		// TODO Auto-generated method stub
		return governmentService.getGovDesc(deptId);
	}

	@Override
	public Map<String, Government> getGovernmentMap() {
		return governmentService.getGovernmentMap();
	}

}
