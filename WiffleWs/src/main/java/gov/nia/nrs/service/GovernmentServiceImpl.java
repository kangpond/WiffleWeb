/**
 * 
 */
package gov.nia.nrs.service;

import gov.nia.nrs.dao.GovernmentDao;
import gov.nia.nrs.domain.Government;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A0017
 *
 */
@Service("governmentService")
@Transactional
public class GovernmentServiceImpl implements GovernmentService {

    private static final Logger log = Logger.getLogger(GovernmentServiceImpl.class);

    @Resource GovernmentDao governmentDao;
    
    @Override
    public String getGovDesc(String deptId){
    	return governmentDao.getGovDesc(deptId);
    }

	@Override
	public List<Government> getGovList() {
		return governmentDao.getGovList();
	}

	@Override
	public Map<String, Government> getGovernmentMap() {
		Map<String, Government> map = new HashMap<String, Government>();
	    for (Government gov : getGovList()) {
	      map.put(gov.getDeptId(), gov);
	    }
	    return map;
	}
}
