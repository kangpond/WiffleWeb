package gov.nia.ssrs.url;

import gov.nia.nrs.utils.LoadProperties;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SsrsUrlMain
 * @author nis_dev_pc1
 *
 */
public class SsrsUrlMain {

    private static final Logger logger = LoggerFactory.getLogger(SsrsUrlMain.class);

    /**
     * callSSRSMain
     * @param report
     * @param formateType
     * @param ssrsParam
     * @return
     */
    public String callSSRSMain(String report,String formateType,String ssrsParam)
    {
        logger.debug("-- callSSRSMain: report{},formateType:{},ssrsParam:{}",report,formateType,ssrsParam);
        SSrsParamVal ssrsPamVal = new SSrsParamVal();
        SSrsResultVal ssrsResVal = new SSrsResultVal();

        StringBuffer myURL = new StringBuffer().append(LoadProperties.getSsrsUrl()).append("?/NrsReportServer/").append(report);
        String rsFormat = ssrsPamVal.getRsFormat(formateType);
        if(!StringUtils.isEmpty(rsFormat))
            myURL.append(rsFormat).toString();
        if(!StringUtils.isEmpty(ssrsParam))
            myURL.append(ssrsParam).toString();

        String ssrsUrl = myURL.toString();
        logger.info("ssrsUrl:{}",ssrsUrl);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(ssrsUrl);

            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(
                          LoadProperties.getSsrsPid(),
                          LoadProperties.getSsrsPwd().toCharArray());
                }
               });

            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
            //String fileStr = sb.toString();
            //FileUtils.writeByteArrayToFile(new File("/Report"), fileStr.getBytes());

            return ssrsResVal.getSsrsResult(url, formateType);

        } catch (Exception e) {
            logger.error("callSSRSMain error:",e);
            throw new RuntimeException("Exception while calling Reporting Server:" + ssrsUrl, e);
        }
    }


}
