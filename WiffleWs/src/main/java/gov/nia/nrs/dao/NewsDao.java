package gov.nia.nrs.dao;


import gov.nia.nrs.domain.News;
import gov.nia.nrs.domain.NewsDoc;

import java.util.List;

public interface NewsDao {

    List<News> getNewsList(String startDate, String endDate, String userId, String title);

    News findNews(Integer newsSeq);

    int findMaxNewsSeq();

    void saveUpdateNews(News srcma) throws Exception;

    List<String> deleteNewsDocByUuId(Integer newsSeq, List<String> existUuids) throws Exception;

    void saveNewsDoc(List<NewsDoc> newsDocList, int seq) throws Exception;

    List<NewsDoc> getExistUuids(Integer newsSeq);

    boolean deleteNewsByFlag(Integer seq) throws Exception;

    List<News> getHomeNewsList(int resultCnt, String sysDate);

}
