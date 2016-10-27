/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.iis.HouseholdMarriage;
import gov.nia.nrs.domain.iis.TwSpouse;
import gov.nia.nrs.domain.iis.TwSpouseId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Repository("twSpouseDao")
public class TwSpouseDaoImpl extends BaseIISDaoImpl<TwSpouse, TwSpouseId> implements TwSpouseDao {

    private static final Logger logger = LoggerFactory.getLogger(TwSpouseDaoImpl.class);

    
    @Resource HouseholdMarriageDao householdMarriageDao;
    
    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.TwSpouseDao#query(java.lang.String, java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<TwSpouse> query(String personId, String chineseName, String birthDate) {
        StringBuffer sql = new StringBuffer();
        sql.append(" from TwSpouse where 1 = 1");
        if (!StringUtils.isBlank(personId)) {
            sql.append(" and id.personId = :personId ");
        }
        if (!StringUtils.isBlank(chineseName)) {
            sql.append(" and chineseName = :chineseName ");
        }
        if (!StringUtils.isBlank(birthDate)) {
            sql.append(" and birthDate = :birthDate ");
        }
        sql.append("order by id.spFirstReceiveNo desc ");

        Query query = getSession().createQuery(sql.toString());

        if (!StringUtils.isBlank(personId)) {
            query.setParameter("personId", personId);
        }
        if (!StringUtils.isBlank(chineseName)) {
            query.setParameter("chineseName", chineseName);
        }
        if (!StringUtils.isBlank(birthDate)) {
            query.setParameter("birthDate", birthDate);
        }
        return query.list();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, String>> getMarriageCondition(UserProfile userProfile,String firstReceiveNo){
    	List<TwSpouse> _list = getSession().createQuery("from TwSpouse where id.spFirstReceiveNo =:firstReceiveNo order by marryDate desc ")
    							   .setParameter("firstReceiveNo", firstReceiveNo).list();
        
        List<Map<String,String>> aList = new ArrayList<Map<String,String>>();
        if(_list.size() > 0){
        	for(TwSpouse t: _list){
        		Map<String,String> dataMap = new HashMap<String,String>();
        		dataMap.put("chineseName", t.getChineseName());
        		dataMap.put("personId", t.getId().getPersonId());
        		dataMap.put("marry", t.getMarry());
        		HouseholdMarriage hm = householdMarriageDao.getHouseholdMarriage(t.getId().getPersonId(), t.getMarryDate());
        		if(hm != null){
        			dataMap.put("marrageDate", hm.getMarrageDate());
        			dataMap.put("divorceDate", hm.getDivorceDate());
        		}else{
        			dataMap.put("marrageDate", t.getMarryDate());
        			dataMap.put("hm","true");
        		}
        		aList.add(dataMap);
        	}
        }
        return aList;
    }
    
    @Override
	public TwSpouse getTwSpouse(String twSpousePersonId, String firstReceiveNo){
		return find(new TwSpouseId(twSpousePersonId, firstReceiveNo));
	}

}
