package gov.nia.nrs.service;

import gov.nia.nrs.dao.UserApplyFunctionDao;
import gov.nia.nrs.domain.UserApplyFunction;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("userApplyFunctionService")
@Transactional
public class UserApplyFunctionServiceImpl implements UserApplyFunctionService {

    private static final Logger log = Logger.getLogger(UserApplyFunctionServiceImpl.class);

    
	@Resource UserApplyFunctionDao userApplyFunctionDao;
	
	@Override
	public List<String> getApplyFunctionList(String uuid) {
		return userApplyFunctionDao.getApplyFunctionList(uuid);
	}

	@Override
	public void deleteUserApplyFunctions(String uuid) {
		// TODO Auto-generated method stub
		userApplyFunctionDao.deleteUserApplyFunctions(uuid);
	}

	@Override
	public boolean saveUserApplyFunctions(UserApplyFunction uaf) {
		boolean b = false;
		try {
			userApplyFunctionDao.save(uaf);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Saving UserFunction has error occurred !"+ e);
		}
		return b;
	}

	
}
