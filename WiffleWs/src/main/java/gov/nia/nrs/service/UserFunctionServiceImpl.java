package gov.nia.nrs.service;

import gov.nia.nrs.dao.UserFunctionDao;
import gov.nia.nrs.domain.UserFunction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userFunctionService")
@Transactional
public class UserFunctionServiceImpl implements UserFunctionService {

    private static final Logger log = Logger.getLogger(UserFunctionServiceImpl.class);

    @Resource UserFunctionDao userFunctionDao;
    
	@Override
	public List<String> getUserFunctionList(String userId) {
		return userFunctionDao.getUserFunctionList(userId);
	}

	@Override
	public void deleteUserFunctions(String userId) {
		userFunctionDao.deleteUserFunctions(userId);
	}

	@Override
	public boolean saveUserFunctions(UserFunction uf) {
		boolean b = false;
		try {
			userFunctionDao.save(uf);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Saving UserFunction has error occurred !"+ e);
		}
		return b;
	}

}
