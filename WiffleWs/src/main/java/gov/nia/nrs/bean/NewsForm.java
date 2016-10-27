package gov.nia.nrs.bean;

import java.util.List;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.News;
import gov.nia.nrs.domain.NewsDoc;

public class NewsForm {

    private UserProfile userProfile ;
    private News news;
    private List<NewsDoc> newsDocList;
    private List<String> existUuids ;
    private Integer newsSeq;

    public UserProfile getUserProfile() {
        return userProfile;
    }
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    public News getNews() {
        return news;
    }
    public void setNews(News news) {
        this.news = news;
    }
    public List<NewsDoc> getNewsDocList() {
        return newsDocList;
    }
    public void setNewsDocList(List<NewsDoc> newsDocList) {
        this.newsDocList = newsDocList;
    }
    public List<String> getExistUuids() {
        return existUuids;
    }
    public void setExistUuids(List<String> existUuids) {
        this.existUuids = existUuids;
    }
    public Integer getNewsSeq() {
        return newsSeq;
    }
    public void setNewsSeq(Integer newsSeq) {
        this.newsSeq = newsSeq;
    }



}
