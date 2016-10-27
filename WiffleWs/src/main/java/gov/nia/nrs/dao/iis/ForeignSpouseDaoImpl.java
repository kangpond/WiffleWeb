/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ForeignSpouse;
import gov.nia.nrs.domain.iis.ForeignSpouseId;

import java.util.List;

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
@Repository("foreignSpouseDao")
public class ForeignSpouseDaoImpl extends BaseIISDaoImpl<ForeignSpouse, ForeignSpouseId> implements ForeignSpouseDao {

    private static final Logger logger = LoggerFactory.getLogger(ForeignSpouseDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ForeignSpouse> query(String residentIdNo, String personId, String passportNo, String latestReceiveNo, String chineseName, String englishName,
            String birthDate) {

        StringBuffer sql = new StringBuffer();
        sql.append(" from ForeignSpouse where 1 = 1");
        if (!StringUtils.isBlank(residentIdNo)) {
            sql.append(" and id.residentIdNo = :residentIdNo ");
        }
        if (!StringUtils.isBlank(personId)) {
            sql.append(" and personId = :personId ");
        }
        if (!StringUtils.isBlank(passportNo)) {
            sql.append(" and (foreignPassportNo = :passportNo or passportNo = :passportNo) ");
        }
        if (!StringUtils.isBlank(latestReceiveNo)) {
            sql.append(" and latestReceiveNo = :latestReceiveNo ");
        }
        if (!StringUtils.isBlank(chineseName)) {
            sql.append(" and chineseName = :chineseName ");
        }
        if (!StringUtils.isBlank(englishName)) {
            sql.append(" and englishName = :englishName ");
        }
        if (!StringUtils.isBlank(birthDate)) {
            sql.append(" and birthDate = :birthDate ");
        }
        sql.append("order by id.firstReceiveNo desc ");

        Query query = getSession().createQuery(sql.toString());

        if (!StringUtils.isBlank(residentIdNo)) {
            query.setParameter("residentIdNo", residentIdNo);
        }
        if (!StringUtils.isBlank(personId)) {
            query.setParameter("personId", personId);
        }
        if (!StringUtils.isBlank(passportNo)) {
            query.setParameter("passportNo", passportNo);
        }
        if (!StringUtils.isBlank(latestReceiveNo)) {
            query.setParameter("latestReceiveNo", latestReceiveNo);
        }
        if (!StringUtils.isBlank(chineseName)) {
            query.setParameter("chineseName", chineseName);
        }
        if (!StringUtils.isBlank(englishName)) {
            query.setParameter("englishName", englishName);
        }
        if (!StringUtils.isBlank(birthDate)) {
            query.setParameter("birthDate", birthDate);
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ForeignSpouse> queryByFirstReceiveNo(List<String> firstReceiveNoList) {
        return getSession().createQuery("from ForeignSpouse where id.firstReceiveNo in (:firstReceiveNoList) order by id.firstReceiveNo desc ")
                .setParameterList("firstReceiveNoList", firstReceiveNoList).list();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ForeignSpouse query(String residentIdNo, String firstReceiveNo) {
        ForeignSpouseId spouseId = new ForeignSpouseId();
        spouseId.setFirstReceiveNo(firstReceiveNo);
        spouseId.setResidentIdNo(residentIdNo);
        return find(spouseId);
    }
}
