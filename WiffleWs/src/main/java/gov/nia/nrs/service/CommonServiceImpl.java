/**
 *
 */
package gov.nia.nrs.service;

import gov.nia.nrs.domain.iis.CodeSetting;
import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.codeutils.CategoryMapVo;
import gov.nia.nrs.utils.codeutils.CategoryVo;
import gov.nia.nrs.utils.codeutils.CodeSettingDo;
import gov.nia.nrs.utils.codeutils.DataSettingDo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Resource
    CodeMappingService codeMappingService;

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.service.CommonService#getCodeCategoryMapping()
     */
    @Override
    public CategoryMapVo getCodeCategoryMapping() {
        CategoryMapVo categoryMapVo = null;
        try {
            Map<String, CategoryVo> map = codeMappingService.getCodeCategoryList();
            if (map != null) {
                categoryMapVo = new CategoryMapVo();
                categoryMapVo.setMap(map);
            }
        } catch (Exception e) {
            logger.error("getCodeCategoryList error", e);
        }
        return categoryMapVo;
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.service.CommonService#getCodeIdOfCodeSetting(java.lang.String)
     */
    @Override
    public String getCodeIdOfCodeSetting(String category) {
        List<CodeSettingDo> list = null;
        String codeId = "";
        try {
            List<CodeSetting> tmplist = codeMappingService.getCodeSettingList(category);
            if (tmplist != null) {
                list = new LinkedList<CodeSettingDo>();
                for (CodeSetting codeSetting : tmplist) {
                    CodeSettingDo csDo = new CodeSettingDo();
                    BeanClone.clone(codeSetting, csDo);
                    list.add(csDo);
                }
            }

            if (tmplist != null) {
                if (!tmplist.isEmpty()) {
                    codeId = tmplist.get(0).getId();
                }
            }
        } catch (Exception e) {
            logger.error("getCodeSettingList error", e);
        }
        return codeId;
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.service.CommonService#getDataSettingList(java.lang.String)
     */
    @Override
    public List<DataSettingDo> getDataSettingList(String codeId) {
        List<DataSettingDo> list = null;
        try {
            List<DataSetting> tmplist = codeMappingService.getDataSettingList(codeId);
            if (tmplist != null) {
                list = new LinkedList<DataSettingDo>();
                for (DataSetting dataSetting : tmplist) {
                    DataSettingDo dsDo = new DataSettingDo();
                    BeanClone.clone(dataSetting, dsDo);
                    list.add(dsDo);
                }
            }
        } catch (Exception e) {
            logger.error("getDataSettingList error", e);
        }
        return list;
    }

}
