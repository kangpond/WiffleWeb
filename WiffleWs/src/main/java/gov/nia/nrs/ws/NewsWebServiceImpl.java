package gov.nia.nrs.ws;

import gov.nia.nrs.bean.NewsForm;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.NewsDao;
import gov.nia.nrs.domain.News;
import gov.nia.nrs.domain.NewsDoc;
import gov.nia.nrs.utils.DateUtils;



















import java.util.Date;
import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class NewsWebServiceImpl implements NewsWebService {
    @Autowired NewsDao newsDao;

    private static final Logger logger = LoggerFactory.getLogger(NewsWebServiceImpl.class);
    @Override
    public List<News> getNewsList(UserProfile up,String startDate, String endDate, String userId, String title) throws Exception {
        return newsDao.getNewsList(startDate, endDate, userId, title);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public  List<String> savePublicNews(NewsForm request) throws Exception {

        News news = request.getNews();
        List<NewsDoc> newsDocList = request.getNewsDocList();
        List<String> existUuids = request.getExistUuids();
        UserProfile userProfile = request.getUserProfile();



        News srcma = newsDao.findNews(news.getNewsSeq());
        News before =null;
        int seq = 0;
        String actionType="Add";
        try {


            if (srcma == null) //查無資料 ,新增
            {
                srcma=new News();
                BeanUtils.copyProperties(news, srcma);

            }
            else //update
            {
                before =new News();
                BeanUtils.copyProperties(srcma, before);
                String[] ignore = new String[6];
                ignore[0] = "createDate";
                ignore[1] = "createTime";
                ignore[2] = "createUserId";
                ignore[3] = "createProgramId";
                ignore[4] = "deleteFlag";
                ignore[5] = "newsSeq";
                BeanUtils.copyProperties(news, srcma,ignore);

                actionType = "Update";

            }


            createCommonField(userProfile.getUserId(), srcma, actionType);

            newsDao.saveUpdateNews(srcma);

            seq = srcma.getNewsSeq();

            //新增至NewsDoc , existUuids 已存在之附件 不刪除
            //若uuidList之附件內容比DB少 刪除該筆DB data
             List<String> delUuidList=newsDao.deleteNewsDocByUuId(seq,existUuids);

             newsDao.saveNewsDoc(newsDocList,seq);//需將Seq Set


             return delUuidList;

        } catch (Exception e) {

            logger.error("失敗 : " , e);
            throw e;

        }

    }

    private void createCommonField(String createUserId, News srcma,String actionType) {

        if(actionType.equalsIgnoreCase("Add"))
        {
            srcma.setCreateDate(DateUtils.getSysDate());
            srcma.setCreateProgramId("NRS");
            srcma.setCreateTime(new Date());
            srcma.setCreateUserId(createUserId);
            srcma.setDeleteFlag("N");

            //int math=(int) (Math.random()*9999+1);
            int maxSeq= newsDao.findMaxNewsSeq()+1;

            srcma.setNewsSeq(maxSeq);
        }


        srcma.setLastUpdateTime(new Date());
        srcma.setMaintainHost("C2");
        srcma.setMaintainProgramId("NRS");
        srcma.setMainUserId(createUserId);

    }
    @Override
    public News findNews(Integer newsSeq) throws Exception {

        return newsDao.findNews(newsSeq);
    }
    @Override
    public List<NewsDoc> getExistUuids(Integer newsSeq) throws Exception {

        return newsDao.getExistUuids(newsSeq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteNews(NewsForm request) throws Exception {

        Integer seq = request.getNewsSeq();
        boolean isDel = false;

        isDel= newsDao.deleteNewsByFlag(seq);
        if(isDel)
            newsDao.deleteNewsDocByUuId(seq, null);

        return isDel;
    }

    @Override
    public List<News> getHomeNewsList(int resultCnt, String sysDate) {

        return newsDao.getHomeNewsList(resultCnt,sysDate);
    }

}
