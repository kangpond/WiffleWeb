package gov.nia.nrs.action;

import java.util.List;




import javax.annotation.Resource;






import gov.nia.nrs.domain.News;
import gov.nia.nrs.news.ws.NewsWebService;
import gov.nia.nrs.utils.DateUtils;
import gov.nia.nrs.utils.EscapeUtils;
import gov.nia.ssrs.url.SSrsParamVal;









import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Namespace("/")
public class HomeAction extends BaseAction
{
	private static final long serialVersionUID = 2665696430159326919L;
	private static final Logger logger = LoggerFactory.getLogger(HomeAction.class);

    private String pic1;
    private String pic2;
    private String picCity;
    private String picCityF;
    private String spouseType;

    private String newsListHtmlStr;
    @Resource
    protected NewsWebService newsWebService;

	public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPicCity() {
        return picCity;
    }

    public void setPicCity(String picCity) {
        this.picCity = picCity;
    }

    public String getPicCityF() {
        return picCityF;
    }

    public void setPicCityF(String picCityF) {
        this.picCityF = picCityF;
    }

    public String getSpouseType() {
        return spouseType;
    }

    public void setSpouseType(String spouseType) {
        this.spouseType = spouseType;
    }

    public String getNewsListHtmlStr() {
        return newsListHtmlStr;
    }

    public void setNewsListHtmlStr(String newsListHtmlStr) {
        this.newsListHtmlStr = newsListHtmlStr;
    }


    @Action(value = "home", results = { @Result(name = SUCCESS, location = "home", type = "tiles") })
	public String home() throws Exception
	{
		logger.debug(getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
        pic1 = main.callSSRSMain("DashBoard_01", SSrsParamVal.IMAGE, "");
        pic2 = main.callSSRSMain("DashBoard_02", SSrsParamVal.IMAGE, "");

        getHomeNews();//取得最新公告

		return SUCCESS;
	}

    private void getHomeNews() {
        int resultCnt = 5;
        List<News> newsList = newsWebService.getHomeNewsList( resultCnt , DateUtils.getSysDate());
        //查詢top 5 最新的(StartDate排序取最大者) 且EndDate 大於系統日

        StringBuffer htmlsb = new StringBuffer();
        if(newsList!=null ){

            for (News temp : newsList)
            {

                htmlsb.append("<li><a href=\"javascript:getContent('"+ temp.getNewsSeq() +"')\">");

                String escapeTitle=EscapeUtils.escapeHtml(temp.getTitle());//防止xss

                htmlsb.append("<div class=\"wrapline\">");

                htmlsb.append(escapeTitle);

                htmlsb.append("</div>");

                htmlsb.append("</a>");


                htmlsb.append("<span class=\"date\">");
                StringBuffer dateStr =new StringBuffer(temp.getStartDate());
                dateStr.insert(4, "-");
                dateStr.insert(7, "-");
                htmlsb.append(dateStr.toString());
                htmlsb.append("</span></li>");

            }

            newsListHtmlStr = htmlsb.toString();

        }
    }

    @Action(value = "welcomeCity", results = {@Result(name = "welcomeCity", location = "home.city.tiles", type = "tiles")})
    public String welcomeCity() {
        logger.info("---welcomeCity---{}");
        if("ALL".equalsIgnoreCase(spouseType))
        {
            picCityF = main.callSSRSMain("DashBoard_City_01", SSrsParamVal.IMAGE, "");
        }
        else if(spouseType.startsWith("Town"))
        {
            String townId = spouseType.substring(spouseType.length()-5,spouseType.length());
            picCityF = main.callSSRSMain("Dashboard_City_"+townId, SSrsParamVal.IMAGE, "");
        }
        else
        {
            picCityF = main.callSSRSMain("DashBoard_City_02",SSrsParamVal.IMAGE,"&spouseType="+spouseType);
        }
        //logger.info("picCityF:{}",picCityF);
        return "welcomeCity";
    }


}
