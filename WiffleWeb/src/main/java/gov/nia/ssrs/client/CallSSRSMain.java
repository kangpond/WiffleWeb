package gov.nia.ssrs.client;

import gov.nia.ssrs.ws.ArrayOfParameterValue;
import gov.nia.ssrs.ws.ArrayOfString;
import gov.nia.ssrs.ws.ArrayOfWarning;
import gov.nia.ssrs.ws.ExecutionHeader;
import gov.nia.ssrs.ws.ExecutionInfo;
import gov.nia.ssrs.ws.ParameterValue;
import gov.nia.ssrs.ws.ReportExecutionService;
import gov.nia.ssrs.ws.ReportExecutionServiceSoap;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.io.FileUtils;

//import com.sun.xml.ws.developer.WSBindingProvider;


/**
 * WebServices Client
 * @author nis_dev_pc1
 *
 */
public class CallSSRSMain {

    public CallSSRSMain() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try
        {
            String reportPath = "/NRSReport";
            String format = "MHTML"; //HTML4.0
            String historyID = null;
            String devInfo = "<DeviceInfo><Toolbar>False</Toolbar><HTMLFragment>True</HTMLFragment></DeviceInfo>";
            String executionID = null;
            Holder<String> extension = null;
            Holder<String> mimeType = null;
            Holder<String> encoding = null;
            Holder<ArrayOfWarning> warnings = null;
            Holder<ArrayOfString> streamIDs = null;
            Holder<byte[]> result = new Holder<byte[]>();

            ReportExecutionService res = new ReportExecutionService();
            ReportExecutionServiceSoap ress = res.getReportExecutionServiceSoap12();

            BindingProvider bp = (BindingProvider)ress;
            //WSBindingProvider wsbp = (WSBindingProvider)ress;

            Map requestContext = bp.getRequestContext();
            System.out.println("---requestContext:"+requestContext);
            bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "administrator");
            bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "1qaz@WSX");

            // Sessions
            bp.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

            ExecutionInfo execInfo = new ExecutionInfo();

            // Parameterlist
            ArrayOfParameterValue apv = new ArrayOfParameterValue();
            List<ParameterValue> apvList = apv.getParameterValue();

            //ParameterValue param0 = new ParameterValue();
            //param0.setName("Year");
            //param0.setValue("2016");
            //apvList.add(param0);
            //ParameterValue param1 = new ParameterValue();
            //param1.setName("Month");
            //param1.setValue("01");
            //apvList.add(param1);

            // Report
            //ress.logonUser("administrator", "Hyweb123", "true");
            execInfo = ress.loadReport(reportPath, historyID);
            System.out.println("---execInfo:"+execInfo);
            // ExecutionID für den nächsten Aufruf merken
            executionID = execInfo.getExecutionID();
            bp.getRequestContext().put("sessionID", executionID);
            System.out.println("---executionID:"+executionID);

            // ExecutionHeader Element erzeugen und es für den nächsten Aufruf
            // and den WSBindingProvider übergeben
            ExecutionHeader eh = new ExecutionHeader();
            eh.setExecutionID(executionID);
            //wsbp.setOutboundHeaders(eh);

            System.out.println("---setOutboundHeaders:"+eh);

            // Parameter an den Report übergeben
            //ress.setExecutionParameters(apv, "en-us");

            // Report anfordern
            ress.render(format, devInfo, result, extension, mimeType, encoding, warnings, streamIDs);
            // Ergebnis des Aufrufs ausgeben
            System.out.print("Result:"+result);
            String resultString = new String(result.value);
            //System.out.print("resultString:"+resultString);
            if("PDF".equalsIgnoreCase(format))
                FileUtils.writeByteArrayToFile(new File("Report.pdf"), result.value);
            else if("EXCEL".equalsIgnoreCase(format))
                FileUtils.writeByteArrayToFile(new File("Report.xls"), result.value);
            else if("HTML4.0".equalsIgnoreCase(format))
                FileUtils.writeByteArrayToFile(new File("Report.html"), result.value);
            else if("MHTML".equalsIgnoreCase(format))
                FileUtils.writeByteArrayToFile(new File("Report.mhtml"), result.value);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print(e);
        }
    }

}
