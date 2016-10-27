/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.imm.Passengers;

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
@Repository("passengersDao")
public class PassengersDaoImpl extends BaseIMMDaoImpl<Passengers, String> implements PassengersDao {


    private static final Logger logger = LoggerFactory.getLogger(PassengersDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.PassengersDao#queryByPassportNoList(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Passengers> queryByPassportNoList(List<PassportVo> passportVoList) {
        if (passportVoList == null || passportVoList.size() < 1) {
            return new ArrayList<Passengers>();
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.* from Passengers a ");
        sql.append(" where 1=1 ");
        for (int i = 1; i <= passportVoList.size(); i++) {
            if (i == 1) {
                sql.append(" and ( ");
            } else {
                sql.append(" or ");
            }

            sql.append(" (PassportNo = :passportNo" + i);
            sql.append(" and Nation = :nation" + i);
            sql.append(")");

            if (i == passportVoList.size()) {
                sql.append(" ) ");
            }
        }
        sql.append(" AND (DeleteFlag IS NULL OR DeleteFlag != 'Y') ");

        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", Passengers.class);

        int i = 1;
        for (PassportVo passportVo : passportVoList) {
            query.setParameter("passportNo" + i, passportVo.getPassportNo());
            query.setParameter("nation" + i, Integer.valueOf(passportVo.getNation()));
            i++;
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Passengers> queryByPersonId(String personId, String birthDate) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.* from Passengers a ");
        sql.append(" where a.PersonId is not null and a.PersonId = :personId ");
        if (!StringUtils.isBlank(birthDate)) {
            sql.append(" and a.BirthDate = :birthDate ");
        }
        sql.append(" and a.Nation = 35 ");
        sql.append(" AND (DeleteFlag IS NULL OR DeleteFlag != 'Y') ");

        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", Passengers.class);

        query.setParameter("personId", personId);
        if (!StringUtils.isBlank(birthDate)) {
            query.setParameter("birthDate", birthDate);
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Passengers> queryByFirstRecvNo(String firstReceiveNo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.* from Passengers a ");
        sql.append(" where a.FirstRecvNo is not null and a.FirstRecvNo = :firstRecvNo ");
        sql.append(" AND (DeleteFlag IS NULL OR DeleteFlag != 'Y') ");

        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", Passengers.class);

        query.setParameter("firstRecvNo", firstReceiveNo);
        return query.list();
    }


}
