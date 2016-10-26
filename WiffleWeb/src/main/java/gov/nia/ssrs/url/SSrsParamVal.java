package gov.nia.ssrs.url;

/**
 * SSrsParamVal
 * @author nis_dev_pc1
 *
 */
public class SSrsParamVal {

    public SSrsParamVal() {
        // TODO Auto-generated constructor stub
    }
    //圖片
    public static String IMAGE ="Image";
    public static String EXCEL = "Excel";
    public static String HTML = "Html";
    public static String PDF = "Pdf";
    public static String MHTML = "Mhtml";

    /**
     * getRsFormat
     * @param formatType
     * @return
     */
    public String getRsFormat(String formatType)
    {
        StringBuffer formatCond = new StringBuffer();
        if(IMAGE.equalsIgnoreCase(formatType))
        {
            formatCond.append("&rs:Format=IMAGE&rc:OutputFormat=PNG");
        }
        else if(EXCEL.equalsIgnoreCase(formatType))
        {
            formatCond.append("&rs:Format=excel");
        }
        else if(HTML.equalsIgnoreCase(formatType))
        {
            formatCond.append("&rs:Format=html4.0");
        }
        else if(PDF.equalsIgnoreCase(formatType))
        {
            formatCond.append("&rs:Format=pdf");
        }
        else if(MHTML.equalsIgnoreCase(formatType))
        {
            formatCond.append("&rs:Format=MFTML");
        }
        return formatCond.toString();
    }

    /**
     *
     * @param reportName
     * @return
     */
    public String getParam(String reportName)
    {
        if("DashBoard_01".equalsIgnoreCase(reportName) || "DashBoard_02".equalsIgnoreCase(reportName))
            return "";
        return "";
    }
}
