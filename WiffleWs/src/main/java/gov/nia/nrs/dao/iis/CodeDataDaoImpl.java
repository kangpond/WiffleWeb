package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.CodeSetting;
import gov.nia.nrs.domain.iis.DataSetting;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("codeDataDao")
public class CodeDataDaoImpl extends BaseIISDaoImpl<DataSetting, String> implements CodeDataDao {

    private static final Logger logger = LoggerFactory.getLogger(CodeDataDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<DataSetting> getDataSettingList(String codeId) {
        logger.debug("DataSetting is Searching whith...." + codeId);
        return getSession().createQuery(" from DataSetting where codeId =:codeId order by codeDataValue ").setParameter("codeId", codeId).list();
    }

    @Override
    @Cacheable(value = "codeMap")
    public String getDataValue(String codeId, String codeDataValue) {
        Map<String, String> map = new HashMap<String, String>();
        String codeDataValueDesc = map.get(codeDataValue);
        if (StringUtils.isNotEmpty(codeDataValueDesc)) {
            return codeDataValueDesc;
        } else {
            DataSetting data = getDataSetting(codeId, codeDataValue);
            if (data != null) {
                map.put(data.getCodeId() + "_" + data.getCodeDataValue(), data.getCodeDataValueDesc());
                return data.getCodeDataValueDesc();
            }
        }
        return codeDataValue;
    }

    @Override
    public DataSetting getDataSetting(String codeId, String codeDataValue) {
        List<DataSetting> _list = getDataSettingList(codeId, codeDataValue);
        DataSetting ds = null;
        if (_list.size() > 0) {
            ds = _list.get(0);
        }
        return ds;
    }

    @Override
    public List<DataSetting> getDataSettingList(String codeId, String codeDataValue) {
        Map<String, Object> conditions = new HashMap<String, Object>();

        StringBuffer hql = new StringBuffer("from DataSetting ");
        if (StringUtils.isNotEmpty(codeId)) {
            hql.append("and codeId =:codeId ");
            conditions.put("codeId", codeId);
        }

        if (StringUtils.isNotEmpty(codeDataValue)) {
            hql.append("and codeDataValue =:codeDataValue ");
            conditions.put("codeDataValue", codeDataValue);
        }

        hql.append("order by codeDataValue ");

        String _hql = hql.toString();
        if (_hql.contains("and")) {
            _hql = _hql.replaceFirst("and", "where");
        }

        Query datas = getSession().createQuery(_hql);
        for (String key : conditions.keySet()) {
            if (conditions.get(key) instanceof Collection) {
                datas.setParameterList(key, (Collection) conditions.get(key));
            } else
                datas.setParameter(key, conditions.get(key));
        }

        return datas.list();
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.dao.CodeSettingDao#getAllCodeSettings()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<CodeSetting> getAllCodeSettings() {
        return getSession().createQuery("from CodeSetting").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CodeSetting> getCodeSettingsByCodeName(String codeName) {
        return getSession().createQuery("from CodeSetting where codeName = :codeName").setParameter("codeName", codeName).list();
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.dao.DataSettingDao#getDataSettingByCodeId(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DataSetting> getDataSettingByCodeId(String codeId) {
        return getSession().createQuery("from DataSetting where codeId=:codeId and (flag is null or flag != 'Y'))").setParameter("codeId", codeId).list();
    }

    /**
     * 20150825改為CodeId=482
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DataSetting> getDataSettingList656(String codeDataValueDesc) {
        return getSession().createQuery(" from DataSetting where codeId=:codeId and codeDataValueDesc like :codeDataValueDesc  ")
                .setParameter("codeDataValueDesc", "%" + codeDataValueDesc + "%").setParameter("codeId", "482").list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getCodeDataValueDescByCodeData(String codeDataValue) {
        Query query =
                (Query) getSession().createSQLQuery("select * from DataSetting where CodeId=:codeId and CodeDataValue = :codeDataValue ")
                        .addEntity(DataSetting.class).setParameter("codeDataValue", codeDataValue).setParameter("codeId", "482");

        List<DataSetting> tmpList = query.list();
        return (tmpList != null && tmpList.size() > 0) ? tmpList.get(0).getCodeDataValueDesc() : null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DataSetting> getDataSettingByCodeIdList(List<String> codeIdList) {
        if (codeIdList == null || codeIdList.size() < 1)
            return null;
        return getSession().createQuery("from DataSetting where CodeId in (:codeIdList) ").setParameterList("codeIdList", codeIdList).list();
    }

}
