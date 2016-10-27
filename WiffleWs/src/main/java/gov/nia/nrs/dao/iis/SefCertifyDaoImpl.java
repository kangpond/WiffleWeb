/**
 * 
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.iis.SefCertify;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */
@Repository("sefCertifyDao")
@Transactional
public class SefCertifyDaoImpl extends BaseIISDaoImpl<SefCertify, String> implements SefCertifyDao {

    private static final Logger logger = LoggerFactory.getLogger(SefCertifyDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
	public List<SefCertify> getSefCertifyList(String personId){
    	return getSession().createQuery(" from SefCertify where personId =:personId order by applyDate desc ")
    					   .setParameter("personId", personId).list();
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public SefCertify getSefCertifyInfo(UserProfile userProfile, String documentNo){
    	return find(documentNo);
    }
}
