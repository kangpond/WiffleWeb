/**
 *
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.service.CommonService;
import gov.nia.nrs.utils.codeutils.CategoryMapVo;
import gov.nia.nrs.utils.codeutils.DataSettingDo;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author Jay Lin
 *
 */
public class CommonWebServiceImpl implements CommonWebService {

    @Resource
    CommonService commonService;

    /* (non-Javadoc)
     * @see gov.nia.nrs.ws.CommonWebService#getCodeCategoryMapping()
     */
    @Override
    public CategoryMapVo getCodeCategoryMapping() {
        return commonService.getCodeCategoryMapping();
    }

    /* (non-Javadoc)
     * @see gov.nia.nrs.ws.CommonWebService#getCodeIdOfCodeSetting(java.lang.String)
     */
    @Override
    public String getCodeIdOfCodeSetting(String category) {
        return commonService.getCodeIdOfCodeSetting(category);
    }

    /* (non-Javadoc)
     * @see gov.nia.nrs.ws.CommonWebService#getDataSettingList(java.lang.String)
     */
    @Override
    public List<DataSettingDo> getDataSettingList(String codeId) {
        return commonService.getDataSettingList(codeId);
    }

}
