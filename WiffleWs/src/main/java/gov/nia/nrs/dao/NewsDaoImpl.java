package gov.nia.nrs.dao;



import gov.nia.nrs.domain.News;



import gov.nia.nrs.domain.NewsDoc;
import gov.nia.nrs.utils.DateUtils;
import gov.nia.nrs.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News, String> implements NewsDao {


    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public List<News> getNewsList(String startDate, String endDate, String userId ,String title)  {
            List<News> retList = new ArrayList<News>();

            Map<String, Object> condition = new HashMap<String, Object>();
            StringBuffer hql=new StringBuffer(" select * from News where 1=1 ");

            if (DateUtils.isValidDate(startDate))
            {
                hql.append(" and StartDate >= :startDate  ");
                condition.put("startDate", startDate);
            }
            if (DateUtils.isValidDate(endDate))
            {
                hql.append(" and StartDate <= :endDate ");

                condition.put("endDate", endDate);

            }
            if(!StringUtil.isEmptyOrBlank(userId))
            {
                hql.append(" and UserId = :userId ");

                condition.put("userId", userId);
            }
            if(!StringUtil.isEmptyOrBlank(title))
            {
                hql.append(" and Title like :title ");

                condition.put("title", "%"+title+"%");
            }

            hql.append(" and DeleteFlag<>'Y' ");
            hql.append(" order by StartDate desc  ");

            String sql =hql.toString();


            Query query =
                    getSession().createSQLQuery(sql).addEntity(News.class);

            for (String key : condition.keySet()) {
                query.setParameter(key, condition.get(key));

            }

            retList=query.list();

            return retList;
    }

    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public News findNews(Integer newsSeq) {
        Query query =
                getSession().createSQLQuery("select * from News where NewsSeq=:newsSeq")
                .addEntity(News.class).setParameter("newsSeq", newsSeq,StandardBasicTypes.INTEGER);

        return (News) query.uniqueResult();
    }

    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public int findMaxNewsSeq() {
        StringBuffer hql = new StringBuffer();
        hql.append("select max(NewsSeq) as maxSeq from News ");


        Query query = getSession().createSQLQuery(hql.toString())
                .addScalar("maxSeq",StandardBasicTypes.INTEGER);

        Integer maxSeq=(Integer) query.uniqueResult();
        return maxSeq==null ? 0:maxSeq;
    }
    @Override
    public void saveUpdateNews(News srcma) throws Exception {
        try {
            getSession().saveOrUpdate(srcma);
            getSession().flush();

        } catch (Exception e) {
           throw e;
        }
    }



    @Override
    public List<String> deleteNewsDocByUuId(Integer newsSeq, List<String> existUuids) throws Exception {
        List<String> delList = new ArrayList<String>();
        try {
            Criteria criteria = getSession().createCriteria(NewsDoc.class);
            criteria.add(Restrictions.eq("id.newsSeq", newsSeq));
            if (existUuids != null && existUuids.size() > 0) {
                criteria.add(Restrictions.not(Restrictions.in("id.uuid", existUuids)));
            }
            List<NewsDoc> list = criteria.list();

            if (list != null) {
                for (NewsDoc doc : list) {
                    delList.add(doc.getId().getUuid());
                    getSession().delete(doc);
                    getSession().flush();

                }
            }

            return delList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    }

    @Override
    public News find(String arg0) {

        return null;
    }

    @Override
    public News[] find(String... arg0) {

        return null;
    }

    @Override
    public News getReference(String arg0) {

        return null;
    }

    @Override
    public News[] getReferences(String... arg0) {

        return null;
    }

    @Override
    public boolean removeById(String arg0) {

        return false;
    }

    @Override
    public void removeByIds(String... arg0) {


    }

    @Override
    public void saveNewsDoc(List<NewsDoc> newsDocList, int seq) throws Exception {

        if(newsDocList!=null && newsDocList.size()>0)
        {
            for(NewsDoc doc : newsDocList)
            {
                doc.getId().setNewsSeq(seq);
                getSession().saveOrUpdate(doc);
                getSession().flush();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public List<NewsDoc> getExistUuids(Integer newsSeq) {
        StringBuffer hql = new StringBuffer();
        hql.append("select * from NewsDoc where ");
        hql.append(" NewsSeq= :newsSeq and DeleteFlag<>'Y' ");

        Query query = getSession().createSQLQuery(hql.toString()).addEntity(NewsDoc.class)
                .setParameter("newsSeq", newsSeq,StandardBasicTypes.INTEGER);


        return query.list();
    }

    @Override
    public boolean deleteNewsByFlag(Integer seq) throws Exception {
        try {
            News delObj = findNews(seq);
            if(delObj!=null)
            {
                delObj.setDeleteFlag("Y");
                delObj.setLastUpdateTime(new Date());
                getSession().update(delObj);
                getSession().flush();
                return true ;
            }
        } catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public List<News> getHomeNewsList(int resultCnt, String sysDate) {
        List<News> retList = new ArrayList<News>();

        Map<String, Object> condition = new HashMap<String, Object>();
        StringBuffer hql=new StringBuffer(" select * from News where 1=1 ");

        if (DateUtils.isValidDate(sysDate))
        {
            hql.append(" and EndDate >= :sysDate  ");
            condition.put("sysDate", sysDate);
        }


        hql.append(" and DeleteFlag<>'Y' ");
        hql.append(" order by StartDate desc  ");

        String sql =hql.toString();


        Query query =
                getSession().createSQLQuery(sql).addEntity(News.class);

        for (String key : condition.keySet()) {
            query.setParameter(key, condition.get(key));

        }
        query.setMaxResults(resultCnt);
        retList=query.list();

        return retList;
    }
}
