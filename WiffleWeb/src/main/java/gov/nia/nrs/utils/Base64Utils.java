package gov.nia.nrs.utils;

import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Utils {
    private static final Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    public static final String encode(String toEncodeStr) {
        String encodedStr = new String(Base64.encodeBase64(toEncodeStr.getBytes()));
        logger.debug("'{}' is encoded to '{}'.",toEncodeStr, encodedStr);

        return encodedStr;
    }

    public static final String decode(String toDecodeStr) {
        String decodeStr = new String(Base64.decodeBase64(toDecodeStr.getBytes()));
        logger.debug("'{}' is decoded to '{}'.",toDecodeStr, decodeStr);

        return decodeStr;
    }

    /**
     * 依傳入的照片URL,下載下來後轉換成BASE64再轉成字串回傳
     *
     * @param pictureUrl
     * @return String BASE64的字串
     * @throws NiiCommonException
     */
    public static String convertPicture2Base64ByUrl(String pictureUrl) throws Exception {
        if (StringUtils.isBlank(pictureUrl)) {
            logger.error("pictureUrl is blank->{}", pictureUrl);
            throw new Exception("pictureUrl" + " is blank -> " + pictureUrl);
        }

        String picture = null;
        try {
            // Convert binary image file to byte array to base64 encoded string
            byte[] ba = IOUtils.toByteArray(new URL(pictureUrl).openStream());
            picture = Base64.encodeBase64String(ba);
        } catch (Exception e) {
            logger.error("convertPicture2Base64ByUrl_讀照片檔失敗", e);
            throw new Exception("Get File Fail", e);
        }
        return picture;
    }
}
