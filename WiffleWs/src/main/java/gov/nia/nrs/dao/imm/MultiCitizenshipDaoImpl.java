/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.MultiCitizenshipQueryReq;
import gov.nia.nrs.domain.imm.MultiCitizenship;
import gov.nia.nrs.domain.imm.MultiCitizenshipId;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Repository("multiCitizenshipDao")
public class MultiCitizenshipDaoImpl extends BaseIMMDaoImpl<MultiCitizenship, MultiCitizenshipId> implements MultiCitizenshipDao {

    private static final Logger logger = LoggerFactory.getLogger(MultiCitizenshipDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.MultiCitizenshipDao#query(gov.nia.nrs.dataquery.bean.MultiCitizenshipQueryReq)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MultiCitizenship> query(MultiCitizenshipQueryReq req) {

        if (StringUtils.isBlank(req.getPassportNo())) {
            return new ArrayList<MultiCitizenship>();
        }

        StringBuffer sql = new StringBuffer();
        sql.append(" select a.* from MultiCitizenship a ");
        sql.append(" where a.SerialNo IN ( ");
        sql.append(" select SerialNo ");
        sql.append(" from MultiCitizenship ");
        sql.append(" where 1=1 ");
        sql.append(" and ( PassportNo = :passportNo ");
        if (!StringUtils.isBlank(req.getNation())) {
            if ("35".equals(req.getNation())) {
                sql.append(" and (Nation = :nation or Nation = 0)");
            } else {
                sql.append(" and Nation = :nation ");
            }
        }
        if (!StringUtils.isBlank(req.getBirthDate())) {
            sql.append(" and BirthDate = :birthDate ");
        }
        sql.append(" )) ");
        sql.append(" and (DeleteFlag !='Y' OR DeleteFlag IS NULL) ");
        sql.append(" ORDER BY SerialNo DESC, PassportNo DESC ");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", MultiCitizenship.class);
        query.setParameter("passportNo", req.getPassportNo());
        if (!StringUtils.isBlank(req.getNation())) {
            query.setParameter("nation", req.getNation());
        }
        if (!StringUtils.isBlank(req.getBirthDate())) {
            query.setParameter("birthDate", req.getBirthDate());
        }
        return query.list();
    }

}
