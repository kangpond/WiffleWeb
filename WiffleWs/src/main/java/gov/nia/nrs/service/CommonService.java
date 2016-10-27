/**
 *
 */
package gov.nia.nrs.service;

import gov.nia.nrs.utils.codeutils.CategoryMapVo;
import gov.nia.nrs.utils.codeutils.DataSettingDo;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface CommonService {

    public CategoryMapVo getCodeCategoryMapping();

    public String getCodeIdOfCodeSetting(String category);

    public List<DataSettingDo> getDataSettingList(String codeId);
}
