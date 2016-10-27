package gov.nia.nrs.utils;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DomainUtils {

    private static final Logger logger = LoggerFactory.getLogger(DomainUtils.class);
    
    private static final String CreateUserId = "createUserId";
    private static final String MainUserId = "mainUserId";
    private static final String MaintainFunctionId = "maintainFunctionId";
    private static final String CreateDate = "createDate";
    private static final String CreateTime = "createTime";
    private static final String LastUpdateTime = "lastUpdateTime";
    private static final String DeleteFlag = "deleteFlag";
    private static final String MaintainHost = "maintainHost";
    
    /**
     * 設定Table共同欄位資訊內容:CreateUserId、MainUserId、MaintainFunctionId、CreateDate、CreateTime、LastUpdateTime
     * 
     * @param userId
     * @param target
     */
    public static void createField(String userId, Object target) {
        BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
        PropertyUtilsBean property = beanUtils.getPropertyUtils();

        String createUserId = StringUtils.isEmpty(userId) ? "" : userId;
        String mainUserId = StringUtils.isEmpty(userId) ? "" : userId;
        if (property.isWriteable(target, CreateUserId)) {
            try {
                beanUtils.copyProperty(target, CreateUserId, createUserId);
            } catch (Exception e) {
                logger.warn("Set createUserId property Exception! {}", e);
            }
        }

        if (property.isWriteable(target, MainUserId)) {
            try {
                beanUtils.copyProperty(target, MainUserId, mainUserId);
            } catch (Exception e) {
                logger.warn("Set mainUserId property Exception! {}", e);
            }
        }

        if (property.isReadable(target, MaintainFunctionId) && property.isWriteable(target, MaintainFunctionId)) {
            try {
                String maintainFunctionId = beanUtils.getProperty(target, "maintainFunctionId");
                if (maintainFunctionId == null) {
                    beanUtils.copyProperty(target, MaintainFunctionId, "");
                }
            } catch (Exception e) {
                logger.warn("Set maintainFunctionId property Exception {}", e);
            }
        }

        Date now = new Date();
        if (property.isWriteable(target, CreateDate)) {
            try {
                beanUtils.copyProperty(target, CreateDate, DateUtils.getDateToString(now, "yyyyMMdd"));
            } catch (Exception e) {
                logger.warn("Set createDate property Exception {}", e);
            }
        }
        if (property.isWriteable(target, CreateTime)) {
            try {
                beanUtils.copyProperty(target, CreateTime, DateUtils.getDateToString(now, "hhmmss"));
            } catch (Exception e) {
                logger.warn("Set createTime error {} ",e);
            }
        }
        if (property.isWriteable(target, LastUpdateTime)) {
            try {
                beanUtils.copyProperty(target, LastUpdateTime, now);
            } catch (Exception e) {
                logger.warn("Set lastUpdateTime error {} ",e);
            }
        }
        if (property.isWriteable(target, DeleteFlag)) {
            try {
                beanUtils.copyProperty(target, DeleteFlag, "N");
            } catch (Exception e) {
                logger.warn("Set DeleteFlag error {} ",e);
            }
        }
        if (property.isWriteable(target, MaintainHost)) {
            try {
                String maintainHost = beanUtils.getProperty(target, MaintainHost);
                if (maintainHost == null) {
                    beanUtils.copyProperty(target, MaintainHost, "");
                }
            } catch (Exception e) {
                logger.warn("Set MaintainHost error {} ",e);
            }
        }
    }

    /**
     * 設定Table共同欄位資訊內容:CreateUserId、MainUserId、MaintainFunctionId、CreateDate、CreateTime、LastUpdateTime
     * 
     * @param target 
     */
    public static void createField(Object target) {
        createField(null, target);
    }
    
    /**
     * 取得指定欄位內容
     * 
     * @param target
     * @param name
     * @return value 
     */
    public static Object getProperty(Object target, String name){
        BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
        PropertyUtilsBean property = beanUtils.getPropertyUtils();
        Object val=null;
        try {
            val = property.getProperty(target, name);
        } catch (Exception e) {
            logger.warn("get property error {} ",e);
        }
        return val;
    }
}
