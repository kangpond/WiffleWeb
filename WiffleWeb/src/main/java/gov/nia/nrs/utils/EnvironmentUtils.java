package gov.nia.nrs.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class EnvironmentUtils {

	private final static Log log = LogFactory.getLog(EnvironmentUtils.class);

	
	private static String environment;
	
	public static String getEnvironment() {
		 return environment;
	}

	public static void setEnvironment(String environment) {
		log.debug("NRSUI-Environment has been turned to: "+ environment);
		EnvironmentUtils.environment = environment;
	}
	
	
	public static boolean isDevEnvironment(){
		return StringUtils.equalsIgnoreCase(environment, "development");
	}
}
