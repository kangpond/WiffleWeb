package gov.nia.nrs.news.bean;

import gov.nia.nrs.domain.News;



public class NewsVo extends News {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String deptName;
    private String searchType;
    private String keyWordContent;
    public String getSearchType() {
        return searchType;
    }
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    public String getKeyWordContent() {
        return keyWordContent;
    }
    public void setKeyWordContent(String keyWordContent) {
        this.keyWordContent = keyWordContent;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
