package gov.nia.nrs.dao;

import java.util.List;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.FsDriverLicence;
import gov.nia.nrs.domain.FsDriverLicenceId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */
@Repository("fsDriverLicenceDao")
@Transactional
public class FsDriverLicenceDaoImpl extends BaseDaoImpl<FsDriverLicence, FsDriverLicenceId> implements FsDriverLicenceDao {

    private static final Logger logger = LoggerFactory.getLogger(FsDriverLicenceDaoImpl.class);

    @SuppressWarnings("unchecked")
	@Override
    public List<FsDriverLicence> getDriverLicence(UserProfile userProfile,String firstReceiveNo){
    	return getSession().createQuery(" from FsDriverLicence where firstReceiveNo =:firstReceiveNo order by announceDate desc ")
    				.setParameter("firstReceiveNo", firstReceiveNo).list();
    }
}
