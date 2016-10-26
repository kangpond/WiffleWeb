package gov.nia.nrs.report.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.report.bean.ImageBean;
import gov.nia.nrs.report.bean.ReportQuery;
import gov.nia.nrs.report.map.ReportMapping;
import gov.nia.ssrs.url.SSrsParamVal;
import gov.nia.ssrs.url.SsrsUrlMain;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

/**
 * ReportMainAction
 * @author Fray
 *
 */
@Namespace("/report")
public class ReportMainAction extends BaseAction {

    private static final long serialVersionUID = -7188857715055643276L;
    private static final Logger logger = LoggerFactory.getLogger(ReportMainAction.class);

    private static final String QUERY = "query";
    private static final String VIEW = "view";
    private static final String REPORT = "report";

    private ReportMapping reportSSRS = new ReportMapping();

    private ReportQuery reportQuery = new ReportQuery();
    private ReportQuery reportQueryView = new ReportQuery();

    private String maintainFunctionId;
    private List<ImageBean> picViewList;

    private InputStream is;
    private String fileName;

    public List<ImageBean> getPicViewList() {
        return picViewList;
    }

    public void setPicViewList(List<ImageBean> picViewList) {
        this.picViewList = picViewList;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMaintainFunctionId() {
        return maintainFunctionId;
    }

    public void setMaintainFunctionId(String maintainFunctionId) {
        this.maintainFunctionId = maintainFunctionId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ReportQuery getReportQuery() {
        return reportQuery;
    }

    public void setReportQuery(ReportQuery reportQuery) {
        this.reportQuery = reportQuery;
    }

    public ReportQuery getReportQueryView() {
        return reportQueryView;
    }

    public void setReportQueryView(ReportQuery reportQueryView) {
        this.reportQueryView = reportQueryView;
    }

    @Action(value = "query", results = {@Result(name = QUERY, location = "reportMainQuery", type = "tiles")})
    @SkipValidation
    public String query() {
        logger.info("---query---");
        logger.debug("maintainFunctionId:{}",maintainFunctionId);
        return QUERY;
    }

    @Action(value = "view", results = {@Result(name = VIEW, location = "reportMainView", type = "tiles"),
            @Result(name = QUERY, location = "reportMainQuery", type = "tiles")})
    @SkipValidation
    public String view() throws UnsupportedEncodingException
    {
        logger.info("---view---");
        logger.debug("reportQuery:{}",reportQuery);
        try
        {
            String year = reportQuery.getReportYear();
            String month = reportQuery.getReportMonth();
            String reportId = reportQuery.getReportId();
            String reportName = reportSSRS.getReportName(reportId);
            String param = convRpt( reportId, reportName, year, month);
            logger.debug("reportName:{},param:{}",reportName,param);
            picViewList = new ArrayList<ImageBean>();
            String picView1 = main.callSSRSMain(reportName, SSrsParamVal.IMAGE, param+"&rc:StartPage=1");
            //String picView2 = main.callSSRSMain(reportName, SSrsParamVal.IMAGE, param+"&rc:StartPage="+getPageNo(reportId));
            picViewList.add(convBean("預覽",picView1));
            //picViewList.add(convBean("核准",picView2));
            return VIEW;
        }catch(Exception e)
        {
            logger.error("view error",e);
            this.message = "檢視報表異常";
            return QUERY;
        }
    }

    @Action(value = "getReport", results = { @Result(name = REPORT, type = "stream"
            ,params={"contentType","application","inputName","is",
            "contentDisposition","attachment;filename=\"${fileName}\"" } )})
    @SkipValidation
    public String getReport() throws UnsupportedEncodingException
    {
        logger.info("---getReport---");
        logger.debug("reportQueryView:{}",reportQueryView);
        gov.nia.ssrs.url.SsrsUrlMain main = new SsrsUrlMain();
        SSrsParamVal paramVal = new SSrsParamVal();

        BASE64Decoder de = new BASE64Decoder();
        try {
            String year = reportQueryView.getReportYear();
            String month = reportQueryView.getReportMonth();
            String reportId = reportQueryView.getReportId();
            String reportName = reportSSRS.getReportName(reportId);
            String param = convRpt( reportId, reportName, year, month);
            String result = main.callSSRSMain(reportName, paramVal.EXCEL, param);
            fileName = new StringBuffer().append(reportName).append(".xls").toString();
            is = new ByteArrayInputStream(de.decodeBuffer(result));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("getReport error:", e);
            e.printStackTrace();
            this.message = "下載報表錯誤";
        }

        return REPORT;
    }

    /**
     * convRpt
     * @param reportId
     * @param reportName
     * @param year
     * @param month
     * @return
     * @throws UnsupportedEncodingException
     */
    public String convRpt(String reportId,String reportName,String year,String month) throws UnsupportedEncodingException
    {
        String param = "";
        if ("ReportDemoQuery001_1".equalsIgnoreCase(reportId)) {
            param = reportSSRS.getReportDemoQuery001(reportName, year, month, reportSSRS.RptType_APPLY, reportSSRS.Location_CITY);
        }
        if ("ReportDemoQuery001_2".equalsIgnoreCase(reportId)) {
            param = reportSSRS.getReportDemoQuery001(reportName, year, month, reportSSRS.RptType_DECIDE, reportSSRS.Location_TOWN);
        }
        if ("ReportDemoQuery002_1".equalsIgnoreCase(reportId)) {
            param = reportSSRS.getReportDemoQuery002(reportName, year, month);
        }
        return param;
    }

    public String getPageNo(String reportId)
    {
        String secondPage = "2";
        if ("ReportDemoQuery001_2".equalsIgnoreCase(reportId)) {
            secondPage = "12";
        }

        return secondPage;
    }

    /**
     * convBean
     * @param imageDesc
     * @param imageStr
     * @return
     */
    public ImageBean convBean(String imageDesc,String imageStr)
    {
        ImageBean bean = new ImageBean();
        bean.setImageDesc(imageDesc);
        bean.setImageStr(imageStr);;
        return bean;
    }
}
