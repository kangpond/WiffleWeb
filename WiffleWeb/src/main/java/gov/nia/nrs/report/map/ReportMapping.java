package gov.nia.nrs.report.map;

import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportMapping {

    private static final Logger logger = LoggerFactory.getLogger(ReportMapping.class);

    public static final String RptType_APPLY="0";
    public static final String RptType_DECIDE="1";
    public static final String Location_CITY="0";
    public static final String Location_TOWN="1";

    public String getReportName(String functionId)
    {
        logger.info("getReportName functionId:{}",functionId);
        if("ReportDemoQuery001_1".equalsIgnoreCase(functionId))
        {
            //臺閩地區各縣市外籍配偶人數按性別及取得證件統計月報
            return "FCSRptSummary001_1";
        }
        else if("ReportDemoQuery001_2".equalsIgnoreCase(functionId))
        {
            //臺閩地區各縣市鄉市鎮外籍配偶人數按性別及取得證件統計月報
            return "FCSRptSummary001_2";
        }
        else if("ReportDemoQuery002_1".equalsIgnoreCase(functionId))
        {
            //臺閩地區各縣市外籍配偶有效證統計月報
            return "FCSRptSummary002_1";
        }

        return "";
    }

    /**
     * getReportDemoQuery001
     * @param reportName
     * @param year
     * @param month
     * @param rptType
     * @param locType
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getReportDemoQuery001(String reportName,String year,String month,String rptType,String locType) throws UnsupportedEncodingException
    {
        /*
        String reportTypeDesc = "";
        if("0".equalsIgnoreCase(rptType))
        {
            reportTypeDesc = "申請";
        }else
        {
            reportTypeDesc = "核准";
        }*/

        StringBuffer sb =new StringBuffer();
        sb.append("&year="+year);
        sb.append("&month="+month);
        //sb.append("&rptType="+rptType);
        sb.append("&locType="+locType);
        sb.append("&rocYear="+String.valueOf(Integer.valueOf(year)-Integer.valueOf(1911)));
        //sb.append("&rptTypeDesc="+URLEncoder.encode(reportTypeDesc,"UTF8"));

        return sb.toString();
    }

    /**
     * getReportDemoQuery002
     * @param reportName
     * @param year
     * @param month
     * @param rptType
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getReportDemoQuery002(String reportName,String year,String month) throws UnsupportedEncodingException
    {
        StringBuffer sb =new StringBuffer();
        sb.append("&year="+year);
        sb.append("&month="+month);
        sb.append("&rocYear="+String.valueOf(Integer.valueOf(year)-Integer.valueOf(1911)));

        return sb.toString();
    }
}
