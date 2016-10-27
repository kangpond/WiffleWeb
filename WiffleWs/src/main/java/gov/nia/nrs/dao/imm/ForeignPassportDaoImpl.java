/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.imm.ForeignPassport;
import gov.nia.nrs.domain.imm.ForeignPassportId;

import java.util.ArrayList;
import java.util.List;

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
@Repository("foreignPassportDao")
public class ForeignPassportDaoImpl extends BaseIMMDaoImpl<ForeignPassport, ForeignPassportId> implements ForeignPassportDao {

    private static final Logger logger = LoggerFactory.getLogger(ForeignPassportDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.ForeignPassportDao#queryByPassportNoList(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ForeignPassport> queryByPassportNoList(List<PassportVo> passportVoList) {

        if (passportVoList == null || passportVoList.size() < 1) {
            return new ArrayList<ForeignPassport>();
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.* from ForeignPassport a ");
        sql.append(" where a.PassengerId in ( ");
        sql.append(" select PassengerId from ForeignPassport ");
        sql.append(" where 1 = 1 ");
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
        sql.append(" ) ");

        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", ForeignPassport.class);

        int i = 1;
        for (PassportVo passportVo : passportVoList) {
            query.setParameter("passportNo" + i, passportVo.getPassportNo());
            query.setParameter("nation" + i, Integer.valueOf(passportVo.getNation()));
            i++;
        }
        return query.list();
    }

}
