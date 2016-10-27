/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.NewResidenceChild;

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
@Repository("newResidenceChildDao")
public class NewResidenceChildDaoImpl extends BaseIISDaoImpl<NewResidenceChild, String> implements NewResidenceChildDao {

    private static final Logger logger = LoggerFactory.getLogger(NewResidenceChildDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.NewResidenceChildDao#query(java.lang.String, java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<NewResidenceChild> query(String personId, String chineseName, String birthDate) {
        StringBuffer sql = new StringBuffer();
        sql.append(" from NewResidenceChild where 1 = 1");
        if (!StringUtils.isBlank(personId)) {
            sql.append(" and personId = :personId ");
        }
        if (!StringUtils.isBlank(chineseName)) {
            sql.append(" and chineseName = :chineseName ");
        }
        if (!StringUtils.isBlank(birthDate)) {
            sql.append(" and birthDate = :birthDate ");
        }
        sql.append("order by relFirstReceiveNo desc ");

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

}
