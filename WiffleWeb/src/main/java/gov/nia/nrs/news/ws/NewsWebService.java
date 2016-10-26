package gov.nia.nrs.news.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.News;





import gov.nia.nrs.domain.NewsDoc;
import gov.nia.nrs.news.bean.NewsForm;

import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;


/**
 * @author Lance
 *
 */

@Produces("application/json")
@Consumes("application/json")
public interface NewsWebService {


    @GET
    @Path("/getNewsList")
    public List<News> getNewsList(UserProfile up,@QueryParam("startDate")
    String startDate,@QueryParam("endDate") String endDate,@QueryParam("userId") String userId,@QueryParam("title") String title) throws Exception;


    @POST
    @Path("/savePublicNews")
    public  List<String>  savePublicNews(NewsForm request) throws Exception;

    @GET
    @Path("/findNews")
    public News findNews(@QueryParam("newsSeq") Integer newsSeq) throws Exception;

    @GET
    @Path("/getExistUuids")
    public List<NewsDoc> getExistUuids(@QueryParam("newsSeq") Integer newsSeq) throws Exception;

    @POST
    @Path("/deleteNews")
    public boolean deleteNews(NewsForm request) throws Exception;

    @GET
    @Path("/getHomeNewsList")
    public List<News> getHomeNewsList(@QueryParam("resultCnt") int resultCnt,@QueryParam("sysDate") String sysDate);


}
