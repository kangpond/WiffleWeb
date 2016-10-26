package gov.nia.nrs.news.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.News;
import gov.nia.nrs.domain.NewsDoc;
import gov.nia.nrs.domain.NewsDocId;
import gov.nia.nrs.domain.UserDef;
import gov.nia.nrs.news.bean.NewsForm;
import gov.nia.nrs.news.bean.NewsVo;
import gov.nia.nrs.news.ws.NewsWebService;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.DateUtils;
import gov.nia.nrs.utils.EscapeUtils;
import gov.nia.nrs.utils.LoadProperties;
import gov.nia.nrs.utils.StringUtil;
import gov.nia.nrs.ws.UserDefWebService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.ArrayList;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;





import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;























































import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






















































import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;



@Namespace("/news")
/*
 */
public class NewsAction extends BaseAction implements ModelDriven<News>{
    private static final Logger logger = LoggerFactory.getLogger(NewsAction.class);
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private News news;
    private List<News> newsList;

    private List<NewsVo> newsVoList;
    private List<File> uploads;
    private List<String> uploadsFileName  = new ArrayList<String>();
    private List<String> uploadsContentType = new ArrayList<String>();
    private String selectedId;

    private String userName;

    private List<String> addUuidList= new ArrayList<String>();
    private List<String> existUuids= new ArrayList<String>();
    private List<String> existFileNameList  = new ArrayList<String>();

    private InputStream is;
    private String exportFileName;
    @Resource
    protected NewsWebService newsWebService;
    @Resource
    protected UserDefWebService userDefWebService;
    @Autowired LoadProperties l;


    public InputStream getIs() {
        return is;
    }


    public void setIs(InputStream is) {
        this.is = is;
    }


    public List<NewsVo> getNewsVoList() {
        return newsVoList;
    }


    public void setNewsVoList(List<NewsVo> newsVoList) {
        this.newsVoList = newsVoList;
    }


    public String getExportFileName() {
        return exportFileName;
    }


    public void setExportFileName(String exportFileName) {
        this.exportFileName = exportFileName;
    }






    @Override
    public News getModel() {
        if (news == null)
            news = new News();
        return news;
    }


    public List<String> getUploadsFileName() {
        return uploadsFileName;
    }


    public void setUploadsFileName(List<String> uploadsFileName) {
        this.uploadsFileName = uploadsFileName;
    }


    public List<String> getUploadsContentType() {
        return uploadsContentType;
    }


    public void setUploadsContentType(List<String> uploadsContentType) {
        this.uploadsContentType = uploadsContentType;
    }


    public List<File> getUploads() {
        return uploads;
    }


    public void setUploads(List<File> uploads) {
        this.uploads = uploads;
    }





    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getSelectedId() {
        return selectedId;
    }


    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }



    @Action(value = "publicNewsList", results = {@Result(name = "success", location = "publicNews.list.tiles", type = "tiles")})
    @SkipValidation
    public String publicNewsList() {

        return SUCCESS;

    }
    @Action(value = "publicNewsSearch", results = {@Result(name = "success", location = "publicNews.list.tiles", type = "tiles")})
    @SkipValidation
    public String publicNewsSearch() throws Exception {

        logger.info(" publicNewsSearch -- startDate:{} ,endDate :{} ,UserId:{} , Title : {}",news.getStartDate(),news.getEndDate(),news.getUserId(),news.getTitle());

        newsList  = newsWebService.getNewsList(getUserProfile(),news.getStartDate(),news.getEndDate(),news.getUserId(),news.getTitle());

        displayList= newsList ;
        totalSize=(displayList != null && displayList.size() > 0 )? displayList.size() : 0;


        if( totalSize == 0)
            addActionMessage("查無資料!!");

        return SUCCESS;
    }


    @Action(value = "publicNewsCreate", results = {@Result(name = "success", location = "publicNews.create.tiles", type = "tiles")})
    @SkipValidation
    //導頁至建立頁 (新增)
    public String publicNewsCreate() {
        getHttpSession().setAttribute("newstitle", "佈告欄 - 新增");

        UserProfile up=getUserProfile();

        news.setUserId(up.getUserId());
        userName = up.getUserName();
        /* Map<String, Object> userMap = userDefWebService.getUserDefInfo(up.getUserId());
        if(userMap!=null)
        {
            UserDef ud = (UserDef) userMap.get("userDef");
            if(ud!=null)
            {
                userName =ud.getUserName();
            }
        }*/

        return SUCCESS;
    }

   /**
     *  導頁至建立頁 (編輯)
     */
      @Action(value = "updatePublicNews", results = {@Result(name = "success", location = "publicNews.create.tiles", type = "tiles")})
    @SkipValidation
    public String updatePublicNews() throws Exception{

        if (StringUtil.isNumeric(selectedId)) {
            news = newsWebService.findNews(Integer.valueOf(selectedId));

            getHttpSession().setAttribute("newstitle", "佈告欄 - 編輯");

            List<NewsDoc> existDocList = newsWebService.getExistUuids(news.getNewsSeq());
            //UserProfile up = getUserProfile();
            if(existDocList!=null)
            {
                for(NewsDoc temp : existDocList)
                {
                    existUuids.add(temp.getId().getUuid());
                    existFileNameList.add(temp.getFileName());
                }

            }
            Map<String, Object> userMap = userDefWebService.getUserDefInfo(news.getUserId());

            if (userMap != null) {

                UserDef userDef = new UserDef();
                BeanClone.cloneSkipBlank(userMap.get("userDef"), userDef);
                userName = userDef != null ? userDef.getUserName() : "";
            }

        }
        return SUCCESS;

    }

    @Action(value = "seePublicNews", results = {@Result(name = "seePublicNews", location = "publicNews.see.tiles", type = "tiles")})
    @SkipValidation
    public String seePublicNews() throws Exception {

        news = newsWebService.findNews(Integer.valueOf(selectedId));
        Map<String, Object> userMap = userDefWebService.getUserDefInfo(news.getUserId());

        if (userMap != null) {

            UserDef userDef = new UserDef();
            BeanClone.cloneSkipBlank(userMap.get("userDef"), userDef);
            userName = userDef != null ? userDef.getUserName() : "";
        }

            StringBuilder dateStr =new StringBuilder(news.getStartDate());

            dateStr.insert(4, "/");
            dateStr.insert(7, "/");
            news.setStartDate(dateStr.toString());
            dateStr.setLength(0);
            dateStr.append(news.getEndDate());
            dateStr.insert(4, "/");
            dateStr.insert(7, "/");
            news.setEndDate(dateStr.toString());
            String escapeTitle=EscapeUtils.escapeHtml(news.getTitle());//防止xss

            StringBuffer htmlsb = new StringBuffer("");
            htmlsb.append("<div class=\"wrapline\">");

            htmlsb.append(escapeTitle);

            htmlsb.append("</div>");
            news.setTitle(htmlsb.toString());

            htmlsb.setLength(0);
            String escapeContent=EscapeUtils.escapeHtml(news.getContent());//防止xss
            htmlsb.append("<div class=\"wrapline\">");

            htmlsb.append(escapeContent);

            htmlsb.append("</div>");

            news.setContent(htmlsb.toString());

            List<NewsDoc> existDocList = newsWebService.getExistUuids(news.getNewsSeq());
            if(existDocList!=null)
            {
                for(NewsDoc temp : existDocList)
                {
                    existUuids.add(temp.getId().getUuid());
                    existFileNameList.add(temp.getFileName());
                }

            }
        return "seePublicNews";

    }

      @Action(value = "savePublicNews", results = {@Result(name = "success", location = "publicNews.list.tiles", type = "tiles"),
              @Result(name = "input", location = "publicNews.create.tiles", type = "tiles")}
      )
      @SkipValidation

      public String savePublicNews()  throws Exception{

          System.out.println(" 前台 existUuids >"+existUuids);

          if(existUuids!=null && existUuids.size()>0)
          {
              Iterator<String> it = existUuids.iterator();

              while(it.hasNext())
              {
                  String uuidString = it.next();
                  //System.out.println("uuidString = "+uuidString);
                  if(uuidString==null)
                      it.remove();
              }
          }

          try {
             List<NewsDoc> newsDocList = createNewsDocList();//建立附件Bean 供DB存取

             NewsForm form = new NewsForm();
             form.setExistUuids(existUuids);
             form.setNews(news);
             form.setNewsDocList(newsDocList);
             form.setUserProfile(getUserProfile());
             //List<String>  delUuidList =newsWebService.savePublicNews(getUserProfile(), news, newsDocList ,existUuids);
             List<String>  delUuidList =newsWebService.savePublicNews(form);
             if(delUuidList!=null && delUuidList.size()>0)
             {
                 deleteNewsFile(delUuidList);

             }

             uploadFile();

             addActionMessage("儲存成功");

           } catch (Exception e) {

                e.printStackTrace();
                logger.error("save news error =",e);
                addActionMessage("儲存失敗 :" +e);

           }

          news = null;
          return SUCCESS;
      }


      @Action(value = "deletePublicNews", results = {@Result(name = "deletePublicNews", location = "publicNews.list.tiles", type = "tiles")})
      @SkipValidation
      public String deletePublicNews() throws Exception{

          try {
             List<NewsDoc> delDocList = newsWebService.getExistUuids(news.getNewsSeq());
             NewsForm form = new NewsForm();
             form.setNewsSeq(news.getNewsSeq());
             form.setUserProfile(getUserProfile());
             boolean result =  newsWebService.deleteNews(form);


              if (result) {
                  addActionMessage("刪除成功!");

                  if(delDocList!=null)
                  { //刪除Ap檔案
                      List<String> delUuids = new ArrayList<String>();
                      for(NewsDoc deleteDoc : delDocList)
                      {
                          delUuids.add(deleteDoc.getId().getUuid());
                      }

                      deleteNewsFile(delUuids);
                  }
              }
              else{
                  addActionMessage("刪除失敗!");
              }
          } catch (Exception e) {

            e.printStackTrace();
            logger.error("err = ",e);
            addActionMessage("刪除失敗 error : "+e);
          }

          news=null;
          return "deletePublicNews";
      }
    @SuppressWarnings("static-access")
    @Action(value = "newsDownload", results = {@Result(name ="success", type = "stream", params = {"contentType",
            "application/octet-stream", "inputName", "is", "contentDisposition",
            "attachment;filename=\"${exportFileName}\"", "bufferSize", "1024"}),
            @Result(name = "input", location = "publicNews.see.tiles", type = "tiles")  })
    @SkipValidation
    public String newsDownload() {

        try {

            logger.info("下載檔 UUID : "+selectedId);
            logger.info("下載檔 exportFileName : "+exportFileName);
            System.out.println("UUID  selectedId = " + selectedId);
            System.out.println("下載檔 exportFileName : "+exportFileName);
            InputStream isf = new FileInputStream(l.getNewsDocDir()+selectedId);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] tmp = new byte[1024];
            int ret = 0;
            while ((ret = isf.read(tmp)) > 0) {
                bos.write(tmp, 0, ret);
            }
            isf.close();

            byte[] bytes = bos.toByteArray();


            is = new ByteArrayInputStream(bytes);


            //exportFileName = filePath.substring(filePath.lastIndexOf("/")+1);

            HttpServletRequest request = ServletActionContext.getRequest();
            String userAgent = request.getHeader("User-Agent");
            if(userAgent.contains("IE")){ //中文檔名給予
                exportFileName = java.net.URLEncoder.encode(exportFileName,"UTF-8");

            }else{
                exportFileName= new String(exportFileName.getBytes("UTF-8"),"ISO-8859-1");
            }

            //response.setHeader("Set-Cookie", "fileDownload=true; path=/");

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            logger.error("下載失敗 ERROR IS " + e);
            message = " 下載失敗 , 發生錯誤 !" ;

            return INPUT ;
        }


    }




    @SuppressWarnings("static-access")
    private void uploadFile() throws Exception {

        if(uploads!=null && uploads.size()>0)
        {
            logger.info("上傳檔案ing.... 檔案數 :" +uploads.size());
            File dir = new File(l.getNewsDocDir());
            if(!dir.exists())
                dir.mkdirs();
            for(int g=0;g<uploads.size();g++)
            {

              //上傳檔案至AP
              FileInputStream fis = new FileInputStream(uploads.get(g));


              FileOutputStream fos = new FileOutputStream(l.getNewsDocDir()+addUuidList.get(g));
              byte[] b = new byte[1024];

              int len = 0;

              while ((len = fis.read(b)) > 0) {

                  fos.write(b, 0, len);

              }


              fos.close();
              fis.close();

            }
        }

    }


    @Action(value = "back", results = {@Result(name = "back", location = "publicNewsList.action", type = "redirect")})
    @SkipValidation
    public String lastStep() {
        return "back";
    }

    private List<NewsDoc> createNewsDocList() {
        List<NewsDoc> newsDocList = new ArrayList<NewsDoc>();

        for (String fileName : uploadsFileName) {
            NewsDoc doc = new NewsDoc();
            NewsDocId docId = new NewsDocId();

            doc.setUploadDeptId(news.getDeptId());
            doc.setUploadUserId(news.getUserId());


            doc.setCreateDate(DateUtils.getSysDate());
            doc.setCreateProgramId("NRS");
            doc.setCreateTime(new Date());
            doc.setCreateUserId(getUserProfile().getUserId());
            doc.setDeleteFlag("N");
            doc.setLastUpdateTime(new Date());
            doc.setMaintainHost("C2");
            doc.setMaintainProgramId("NRS");
            doc.setMainUserId(getUserProfile().getUserId());
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            docId.setUuid(uuid);
            addUuidList.add(uuid);//先產生uuid 讓前台存檔 檔名使用

            System.out.println("fileName :" + fileName);
            doc.setFileName(fileName);
            doc.setId(docId);
            newsDocList.add(doc);

        }
        return newsDocList;

    }

    @SuppressWarnings("static-access")
    private void deleteNewsFile(List<String> delUuids) throws Exception {


        if(delUuids!=null && delUuids.size()>0)
        {

                    for(String delUuid :delUuids)
                    {//刪除該筆DB data後 ,將ap server上檔案刪除
                        System.out.println("delUuid :" +delUuid);
                        logger.info("delUuid = {}",delUuid);
                        File delFile = new File(l.getNewsDocDir()+StringUtil.filterForPath(delUuid));
                        if (delFile.exists() && delFile.isFile())
                        {

                             if(!delFile.delete())
                                throw new Exception("刪除檔案失敗");

                        }
                    }

        }

    }



    public List<String> getExistUuids() {
        return existUuids;
    }


    public void setExistUuids(List<String> existUuids) {
        this.existUuids = existUuids;
    }


    public List<String> getExistFileNameList() {
        return existFileNameList;
    }


    public void setExistFileNameList(List<String> existFileNameList) {
        this.existFileNameList = existFileNameList;
    }




}
