package gov.nia.nrs.utils;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * LoadProperties
 * @author Fray
 *
 */
public class LoadProperties {

    private static Logger logger = LoggerFactory.getLogger(LoadProperties.class);

    private static Map<String, String> constMap;
    private static String ssrsUrl;
    private static String ssrsPid;
    private static String ssrsPwd;
    private static String newsDocDir;
    public static Map<String, String> getConstMap() {
        return constMap;
    }

    public static void setConstMap(Map<String, String> constMap) {
        LoadProperties.constMap = constMap;
    }

    public static String getSsrsUrl() {
        return ssrsUrl;
    }

    public static void setSsrsUrl(String ssrsUrl) {
        LoadProperties.ssrsUrl = ssrsUrl;
    }

    public static String getSsrsPid() {
        return ssrsPid;
    }

    public static void setSsrsPid(String ssrsPid) {
        LoadProperties.ssrsPid = ssrsPid;
    }

    public static String getSsrsPwd() {
        return ssrsPwd;
    }

    public static void setSsrsPwd(String ssrsPwd) {
        LoadProperties.ssrsPwd = ssrsPwd;
    }

    public static String getNewsDocDir() {
        return newsDocDir;
    }

    public static void setNewsDocDir(String newsDocDir) {
        LoadProperties.newsDocDir = newsDocDir;
    }

    public final static Map<String, String> loadProperties(String fileName) {
        Map<String, String> propMap = new HashMap<String, String>();
        InputStream is = null;
        try {
            is = new ClassPathResource(fileName).getInputStream();
            ResourceBundle b = new PropertyResourceBundle(is);
            Enumeration<String> enums = b.getKeys();
            while (enums.hasMoreElements()) {
                String key = enums.nextElement();
                String value = encodeString(b.getString(key));
                propMap.put(key, value);
            }
        } catch (IOException e) {
            logger.error("取得properties發生錯誤 : ", e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return propMap;
    }

    public static String encodeString(String text) {
        return encodeString(text, "UTF-8", "UTF-8");
    }

    private static String encodeString(String text, String from, String to) {
        if (StringUtils.isBlank(text)) {
            return "";
        }

        try {
            return new String(text.getBytes(from), to);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return "";
    }

}
