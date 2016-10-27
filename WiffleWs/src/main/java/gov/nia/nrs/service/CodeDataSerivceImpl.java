/**
 * 
 */
package gov.nia.nrs.service;

import gov.nia.nrs.dao.iis.CodeDataDao;
import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.utils.StringUtil;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A0017
 *
 */
@Service("codeDataSerivce")
@Transactional
public class CodeDataSerivceImpl implements CodeDataSerivce {

    private static final Logger log = Logger.getLogger(CodeDataSerivceImpl.class);

    @Resource CodeDataDao codeDataDao;
    
    /**
     * 出生地代碼類別
     */
    private static String birthPlaceCodeCategory = "2";
    
    /**
     * 出生地省市類別
     */
    private static String birthPlaceProvinceCityCategory = "3";
    
    /**
     * 出生地國籍類別
     */
    private static String birthPlaceNationalityCategory = "15";
    
    /**
     * 出生地國籍代碼
     */
    private static String birthPlaceNationalityCode = "5";
    
    @Override
    public List<DataSetting> getDataSettingList(String codeId,String codeDataValue){
    	return codeDataDao.getDataSettingList(codeId, codeDataValue);
    }
    
    @Override
    public String getDataValueDescs(String codeId,String codeDataValue){
		return codeDataDao.getDataValue(codeId, codeDataValue);
    }
    
    @Override
    public String getBirthPlace(String birthPlaceCode, String birthPlace1, String birthPlace2) {
        int birthPlaceCodeInt = 0;
        String birthPlace = null;
        String birthPlaceCodeName = null;
        String birthPlace1Name = null;

        if (StringUtil.isEmptyOrBlank(birthPlaceCode)) {
            return StringUtils.EMPTY;
        }

        try {
            birthPlaceCodeName = getDataValueDescs(birthPlaceCodeCategory, birthPlaceCode);
            birthPlace1Name = getDataValueDescs(birthPlaceNationalityCode.equals(birthPlaceCode) ? birthPlaceNationalityCategory : birthPlaceProvinceCityCategory, birthPlace1);
            birthPlaceCodeInt = Integer.parseInt(birthPlaceCode);
            
            switch (birthPlaceCodeInt) {
            case 1:
            case 2:
                birthPlace = new StringBuilder(birthPlaceCodeName)
                        .insert(0, birthPlace1Name)
                        .insert(birthPlace1Name.length() + 1, birthPlace2)
                        .toString();
                break;
            case 3:
            case 4:
                birthPlace = birthPlace1Name + birthPlaceCodeName;
                break;
            case 5:
                birthPlace = birthPlace1Name;
                break;
            default:
                birthPlace = birthPlaceCodeName + birthPlace1Name + birthPlace2;
                break;
            }
        } catch (Exception e) {
            String msg = "BirthPlace 組合錯誤";
            log.error(msg, e);
            birthPlace = e.getMessage() == null ? msg : e.getMessage();
        }

        return birthPlace;
    }

	@Override
	public List<DataSetting> getDataSettingList(String codeId) {
		return codeDataDao.getDataSettingList(codeId);
	}
    
	
	
	/**
	 * 取得合併後的地址字串
	 * 
	 * @param zipCode 郵遞區號
	 * @param city 縣市代碼
	 * @param township 鄉鎮市區代碼
	 * @param village 村里名
	 * @param neighborhood 鄰別
	 * @param road 街、路段
	 * @param lane 巷
	 * @param alley 弄
	 * @param number 門牌號
	 * @return 合併後的地址字串
	 * @author Allen 2014/01/07
	 */
	@Override
	public String getDisplayAddress(String zipCode, String city, String township, String village, String neighborhood, String road, String lane, String alley, String number) {
		
		boolean result = false;
		
		DataSetting data = null;
		city = StringUtil.chkNull2empty(city).trim(); // 資料面City有2個空白的，user要求不show，因此於此trim掉 -- allen 2014/01/07
		if(!city.isEmpty()){
			try {
				data = codeDataDao.getDataSetting("612", city);
				city = data.getCodeDataValueDesc();
				result = true;
			} catch (Exception e) {
				log.error("codeService.getCode fail", e);
				log.error("category {} code {} 612"+ city);
				city = e.getMessage();
				township = e.getMessage();
			}
		}
		
		township = StringUtil.chkNull2empty(township).trim(); //  -- allen 2014/01/07
		if (!township.isEmpty() && result) {
			try {
				township = getDataValueDescs(data.getCodeDataValueDesc2(), township);
			} catch (Exception e) {
				log.error("codeService.getCode fail", e);
				township = e.getMessage();
			}
		}else{
			township = StringUtils.EMPTY;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(StringUtil.chkNull2empty(zipCode).trim());
		sb.append(city);
		sb.append(township);
		// 2013/01/16 Terry Lee
		// 根據戶役政規範，村(里)由使用者登打
		sb.append(StringUtil.chkNull2empty(village).trim())/*.append(StringUtils.isBlank(village) ? StringUtils.EMPTY : "村(里)")*/;
		sb.append(StringUtil.chkNull2empty(neighborhood).trim()).append(StringUtils.isBlank(neighborhood) ? StringUtils.EMPTY : "鄰");
		sb.append(StringUtil.chkNull2empty(road).trim());
		sb.append(StringUtil.chkNull2empty(lane).trim()).append(StringUtils.isBlank(lane) ? StringUtils.EMPTY : "巷");
		sb.append(StringUtil.chkNull2empty(alley).trim()).append(StringUtils.isBlank(alley) ? StringUtils.EMPTY : "弄");
		sb.append(StringUtil.chkNull2empty(number).trim());
		
		return sb.toString();
	}
}
