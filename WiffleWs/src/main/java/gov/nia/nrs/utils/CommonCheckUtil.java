/**
 * 
 */
package gov.nia.nrs.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 欄位檢查共通程式
 */
public class CommonCheckUtil {
	private static Logger logger = Logger.getLogger(CommonCheckUtil.class);
	/**
	 * 檢查護照號碼是否有效 (9, 99, 999, 9999, ... 皆非有效之護照號)
	 * @param passport
	 */
	public static boolean isValidPassportNo(String passport)
	{
		if(StringUtils.isNotBlank(passport)){
			char [] cPassport = passport.toCharArray();
			for (char passNo : cPassport) {
				if(passNo != '9'){
					if(!passport.equals("0")){
						return true;
					}
				}
			}
		}
		
//		logger.info("invalid passportNo:"+passport);
		return false;
	}
}
