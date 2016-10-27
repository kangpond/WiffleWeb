/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.dataquery.bean.DataQueryReq;
import gov.nia.nrs.domain.iis.ForeignSpouse;
import gov.nia.nrs.domain.iis.ForeignSpouseId;

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
@Repository("DataQueryDao")
public class DataQueryDaoImp extends BaseIISDaoImpl<ForeignSpouse, ForeignSpouseId> implements DataQueryDao {

    private static final Logger logger = LoggerFactory.getLogger(DataQueryDaoImp.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.DataQueryDao#queryForList(gov.nia.nrs.dataquery.bean.DataQueryReq)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ForeignSpouse> queryForList(DataQueryReq req) {

        StringBuffer sql = new StringBuffer();
        sql.append("select a.* from ForeignSpouse a");
        sql.append(" left join TwSpouse b on a.FirstReceiveNo = b.SpFirstReceiveNo");
        sql.append(" left join NewResidenceChild c on a.FirstReceiveNo = c.RelFirstReceiveNo");
        sql.append(" where 1 = 1 ");

        // ForeignSpouse
        if (!StringUtils.isBlank(req.getResidentIdNo())) {
            sql.append(" and a.ResidentIdNo = :residentIdNo ");
        }
        if (!StringUtils.isBlank(req.getPersonId())) {
            sql.append(" and a.PersonId = :personId ");
        }
        if (!StringUtils.isBlank(req.getPassportNo())) {
            sql.append(" and (a.ForeignPassportNo = :passportNo or a.PassportNo = :passportNo) ");
        }
        if (!StringUtils.isBlank(req.getReceiveNo())) {
            sql.append(" and a.LatestReceiveNo = :latestReceiveNo ");
        }
        if (!StringUtils.isBlank(req.getChineseName())) {
            sql.append(" and a.ChineseName = :chineseName ");
        }
        if (!StringUtils.isBlank(req.getEnglishName())) {
            sql.append(" and a.EnglishName = :englishName ");
        }
        if (!StringUtils.isBlank(req.getBirthDate())) {
            sql.append(" and a.BirthDate = :birthDate ");
        }
        // TwSpouse
        if (!StringUtils.isBlank(req.getPersonId2())) {
            sql.append(" and b.PersonId = :personId2 ");
        }
        if (!StringUtils.isBlank(req.getChineseName2())) {
            sql.append(" and b.ChineseName = :chineseName2 ");
        }
        if (!StringUtils.isBlank(req.getBirthDate2())) {
            sql.append(" and b.BirthDate = :birthDate2 ");
        }
        // NewResidenceChild
        if (!StringUtils.isBlank(req.getPersonId3())) {
            sql.append(" and c.PersonId = :personId3 ");
        }
        if (!StringUtils.isBlank(req.getChineseName3())) {
            sql.append(" and c.ChineseName = :chineseName3 ");
        }
        if (!StringUtils.isBlank(req.getBirthDate3())) {
            sql.append(" and c.BirthDate = :birthDate3 ");
        }
        sql.append("order by a.FirstReceiveNo Desc");

        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.addEntity("a", ForeignSpouse.class);

        // ForeignSpouse
        if (!StringUtils.isBlank(req.getResidentIdNo())) {
            query.setParameter("residentIdNo", req.getResidentIdNo());
        }
        if (!StringUtils.isBlank(req.getPersonId())) {
            query.setParameter("personId", req.getPersonId());
        }
        if (!StringUtils.isBlank(req.getPassportNo())) {
            query.setParameter("passportNo", req.getPassportNo());
        }
        if (!StringUtils.isBlank(req.getReceiveNo())) {
            query.setParameter("latestReceiveNo", req.getReceiveNo());
        }
        if (!StringUtils.isBlank(req.getChineseName())) {
            query.setParameter("chineseName", req.getChineseName());
        }
        if (!StringUtils.isBlank(req.getEnglishName())) {
            query.setParameter("englishName", req.getEnglishName());
        }
        if (!StringUtils.isBlank(req.getBirthDate())) {
            query.setParameter("birthDate", req.getBirthDate());
        }
        // TwSpouse
        if (!StringUtils.isBlank(req.getPersonId2())) {
            query.setParameter("personId2", req.getPersonId2());
        }
        if (!StringUtils.isBlank(req.getChineseName2())) {
            query.setParameter("chineseName2", req.getChineseName2());
        }
        if (!StringUtils.isBlank(req.getBirthDate2())) {
            query.setParameter("birthDate2", req.getBirthDate2());
        }
        // NewResidenceChild
        if (!StringUtils.isBlank(req.getPersonId3())) {
            query.setParameter("personId3", req.getPersonId3());
        }
        if (!StringUtils.isBlank(req.getChineseName3())) {
            query.setParameter("chineseName3", req.getChineseName3());
        }
        if (!StringUtils.isBlank(req.getBirthDate3())) {
            query.setParameter("birthDate3", req.getBirthDate3());
        }
        return query.list();
    }
}
