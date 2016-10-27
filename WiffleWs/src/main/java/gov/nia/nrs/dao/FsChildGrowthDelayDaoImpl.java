package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.FsChildGrowthDelay;
import gov.nia.nrs.utils.StringUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Yang
 *
 */
@Repository("fsChildGrowthDelayDao")
@Transactional
public class FsChildGrowthDelayDaoImpl extends BaseDaoImpl<FsChildGrowthDelay, String> implements FsChildGrowthDelayDao {

    private static final Logger logger = LoggerFactory.getLogger(FsChildGrowthDelayDaoImpl.class);
    
    @SuppressWarnings("unchecked")
	@Override
    public boolean checkingGrowthDelay(UserProfile userProfile, String personId){
    	if(StringUtil.isEmptyOrBlank(personId))
    		return false;
    	
    	List<FsChildGrowthDelay> _list = getSession().createQuery(" from FsChildGrowthDelay where personId =:personId and (deleteFlag = '' or deleteFlag = 'N') ")
    				.setParameter("personId", personId).list();
    	return _list.size() > 0;
    }

}
