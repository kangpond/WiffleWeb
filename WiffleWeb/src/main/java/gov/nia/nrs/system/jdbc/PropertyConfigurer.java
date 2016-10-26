package gov.nia.nrs.system.jdbc;

import gov.nia.nrs.utils.EnvironmentUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	
	private final static Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
	    logger.debug("propertyName=propertyValue:  "+propertyName +"="+propertyValue);
	    if(propertyName.endsWith("mode")){
			EnvironmentUtils.setEnvironment(propertyValue);
		}
		return super.convertProperty(propertyName, propertyValue);
	}
}
