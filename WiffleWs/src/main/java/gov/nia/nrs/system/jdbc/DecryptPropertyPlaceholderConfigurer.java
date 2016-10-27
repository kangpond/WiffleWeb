package gov.nia.nrs.system.jdbc;

import gov.nia.nrs.utils.CommonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private final static Logger logger = LoggerFactory.getLogger(DecryptPropertyPlaceholderConfigurer.class);
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
	    logger.debug("propertyName=propertyValue:  "+propertyName +"="+propertyValue);
		if(propertyName.endsWith("pawd")){
//			log.debug("modified password:"+decrypt(propertyValue));
			return super.convertProperty(propertyName, CommonUtils.decryptFtpPwdStr(propertyValue));
		}
		return super.convertProperty(propertyName, propertyValue);
	}
}
