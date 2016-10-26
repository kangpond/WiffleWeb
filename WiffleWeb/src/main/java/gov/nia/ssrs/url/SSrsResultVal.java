package gov.nia.ssrs.url;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * SSrsResultVal
 * @author nis_dev_pc1
 *
 */
public class SSrsResultVal {

    private static final Logger logger = LoggerFactory.getLogger(SSrsResultVal.class);

    public SSrsResultVal() {
        // TODO Auto-generated constructor stub
    }

    /**
     * getSsrsResult
     * @param url
     * @param formateType
     * @param returnStr
     * @return
     * @throws IOException
     */
    public String getSsrsResult(URL url,String formateType) throws IOException
    {
        byte[] ba = IOUtils.toByteArray(url.openStream());
        String picture = Base64.encodeBase64String(ba);

        if("Image".equalsIgnoreCase(formateType))
        {
            StringBuffer sn = new StringBuffer();
            sn.append("data:image/jpeg;base64,");
            sn.append(picture);
            String pic = sn.toString();
            return pic;
        }

        return picture;
    }

    /**
     * convertPicture2Base64ByUrl
     * @param url
     * @return
     * @throws Exception
     */
    public static String convertPicture2Base64ByUrl(String url) throws Exception {

        if (StringUtils.isBlank(url)) {
            logger.error("{} is blank -> '{}'", "pictureUrl", url);
            throw new Exception("pictureUrl is blank -> " + url);
        }
        String picture = null;
        try {
            // Convert binary image file to byte array to base64 encoded string
            byte[] ba = IOUtils.toByteArray(new URL(url).openStream());
            picture = Base64.encodeBase64String(ba);
        } catch (Exception e) {
            logger.error("convertPicture2Base64ByUrl_讀照片檔失敗", e);
            // 2015/03/12_當照片轉換成Base64過程中,發生異常,當作沒資料
            picture = null;
        }
        return picture;
    }
}
