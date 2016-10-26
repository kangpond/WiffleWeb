package gov.nia.ssrs.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.ssrs.url.SSrsParamVal;
import gov.nia.ssrs.url.SsrsUrlMain;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * SsrsAction
 * @author nis_dev_pc1
 *
 */
@Namespace("/ssrsAction")
public class SsrsAction extends BaseAction{

    private static final Logger logger = LoggerFactory.getLogger(SsrsAction.class);

    private static final long serialVersionUID = 1L;
    public static final String REPORT = "report";

    /* 下載檔名*/
    private String fileName;
    /* 下載類別 */
    private String fileType;
    /* 下載InputStream */
    private InputStream is;
    /* SSRS 報表名稱 */
    private String reportName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public SsrsAction() {
        // TODO Auto-generated constructor stub
    }

    @Action(value = "getReport", results = { @Result(name = REPORT, type = "stream"
            ,params={"contentType","application","inputName","is",
            "contentDisposition","attachment;filename=\"${fileName}\"" } )})
    public String getReport() throws IOException
    {
        logger.info("---getReport---");
        try
        {
            logger.info("reportName:{},fileType:{}",reportName,fileType);
            fileName = "SSRSReport";
            if("EXCEL".equalsIgnoreCase(fileType))
                fileName = new StringBuffer().append(fileName).append(".xls").toString();
            if("PDF".equalsIgnoreCase(fileType))
                fileName = new StringBuffer().append(fileName).append(".pdf").toString();
            if("WORD".equalsIgnoreCase(fileType))
                fileName = new StringBuffer().append(fileName).append(".doc").toString();
            if("MHTML".equalsIgnoreCase(fileType))
                fileName = new StringBuffer().append(fileName).append(".mhtml").toString();
            if("HTML".equalsIgnoreCase(fileType))
                fileName = new StringBuffer().append(fileName).append(".html").toString();

            gov.nia.ssrs.url.SsrsUrlMain main = new SsrsUrlMain();
            SSrsParamVal paramVal = new SSrsParamVal();
            String result = main.callSSRSMain(reportName, fileType,paramVal.getParam(reportName));

            BASE64Decoder de = new BASE64Decoder();
            if (StringUtils.isNotBlank(result)) {
                is = new ByteArrayInputStream(de.decodeBuffer(result));
            } else {
                is = new ByteArrayInputStream(new byte[0]);
            }
        }catch(Exception e)
        {
            logger.error("getReport error:",e);
        }
        return REPORT;
    }

}
