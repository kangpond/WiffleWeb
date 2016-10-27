package gov.nia.nrs.dao;

import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.multiquery.bean.QueryAttrInfo;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("multiQueryDao")
public class MultiQueryDaoImpl implements MultiQueryDao
{
	private static Logger logger = Logger.getLogger(MultiQueryDaoImpl.class);

	@Resource(name = "nrsSessionFactory")
	private SessionFactory nrsSessionFactory;

	@Resource(name = "nrsJdbcTemplate")
	private JdbcTemplate nrsJdbcTemplate;

	@Resource(name = "iisSessionFactory")
	private SessionFactory iisSessionFactory;

	private JdbcTemplate getNrsJdbcTemplate()
	{
		return nrsJdbcTemplate;
	}

	private Session getIisSession()
	{
		return iisSessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DataSetting> queryDataSetting(String codeId) throws Exception
	{
		logger.debug("queryDataSetting, codeId=" + codeId);

		StringBuffer sql = new StringBuffer();
		sql.append("select * from DataSetting");
		sql.append(" where CodeId=:codeId");
		sql.append(" Order by CodeId, CodeDataValue");
		Query query = getIisSession().createSQLQuery(sql.toString()).addEntity(DataSetting.class);
		query.setParameter("codeId", codeId);

		@SuppressWarnings("unchecked")
		List<DataSetting> list = query.list();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DataSetting> queryDataSettingByList(List<String> codeIdList) throws Exception
	{
		logger.debug("queryDataSetting, codeIdList=" + codeIdList);

		StringBuffer sql = new StringBuffer();
		sql.append("select * from DataSetting");
		sql.append(" where CodeId in :codeIdList");
		Query query = getIisSession().createSQLQuery(sql.toString()).addEntity(DataSetting.class);
		query.setParameterList("codeIdList", codeIdList);

		@SuppressWarnings("unchecked")
		List<DataSetting> list = query.list();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DataSetting> queryTownDs(String cityCodeValue) throws Exception
	{
		logger.debug("queryTownDs, cityCodeValue=" + cityCodeValue);
		if (StringUtil.isEmpty(cityCodeValue))
		{
			return null;
		}

		//select * from DataSetting where CodeId in (select CodeDataValueDesc2 from DataSetting where CodeId='612' and CodeDataValue='09007')
		StringBuffer sql = new StringBuffer();
		sql.append("select * from DataSetting");
		sql.append(" where CodeId in ");
		sql.append(" (select CodeDataValueDesc2 from DataSetting where CodeId=:codeId and CodeDataValue=:cityCodeValue)");
		Query query = getIisSession().createSQLQuery(sql.toString()).addEntity(DataSetting.class);
		query.setParameter("codeId", QueryAttrEnum.CityA.getCodeId());
		query.setParameter("cityCodeValue", cityCodeValue);

		@SuppressWarnings("unchecked")
		List<DataSetting> list = query.list();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getRowMapList(String sql) throws Exception
	{
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		try
		{
			Connection conn = getNrsJdbcTemplate().getDataSource().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();
			while (rs.next())
			{
				Map<String, Object> result = new HashMap<String, Object>();
				for (int i = 1; i <= meta.getColumnCount(); ++i)
				{
					//result.put(meta.getColumnName(i).toLowerCase(), rs.getString(meta.getColumnName(i)));
					result.put(meta.getColumnName(i), rs.getString(meta.getColumnName(i)));
				}
				rows.add(result);
			}
		}
		catch (SQLException e)
		{
			logger.error("getRowMapList error, sql=" + sql, e);
		}
		return rows;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Integer> getRowCntDataMap(String sql, Map<Integer, QueryAttrInfo> rowAttrMap
			, Map<Integer, QueryAttrInfo> colAttrMap) throws Exception
	{
		Map<String, Integer> rowCntMap = new HashMap<String, Integer>();
		try
		{
			Connection conn = getNrsJdbcTemplate().getDataSource().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			while (rs.next())
			{
				StringBuffer key = new StringBuffer();
				if (rowAttrMap != null && rowAttrMap.size() > 0)
				{
					Iterator<Entry<Integer, QueryAttrInfo>> rowIter = rowAttrMap.entrySet().iterator();
					while (rowIter.hasNext())
					{
						Entry<Integer, QueryAttrInfo> rowAttrEntry = rowIter.next();
						String columnName = rowAttrEntry.getValue().getAttrColumnName();
						if (!columnName.contains(","))
						{
							// 正常的單一欄位的情況
							key.append(columnName + "_");
							key.append(rs.getString(columnName));
						}
						else
						{
							// 當QueryAttrInfo為組合欄位的情況，例如縣市+鄉鎮
							String[] cols = columnName.split(",");
							for (int i = 0; i < cols.length; i++)
							{
								String col = cols[i];
								key.append(col + "_");
								key.append(rs.getString(col));
								if (i != (cols.length - 1))
								{
									key.append(",");
								}
							}
						}
						if (rowIter.hasNext())
							key.append(",");
					}
				}

				if (colAttrMap != null && colAttrMap.size() > 0)
				{
					if (rowAttrMap != null && rowAttrMap.size() > 0)
					{
						key.append(",");
					}

					Iterator<Entry<Integer, QueryAttrInfo>> colIter = colAttrMap.entrySet().iterator();
					while (colIter.hasNext())
					{
						Entry<Integer, QueryAttrInfo> colAttrEntry = colIter.next();
						String columnName = colAttrEntry.getValue().getAttrColumnName();
						if (!columnName.contains(","))
						{
							// 正常的單一欄位的情況
							key.append(columnName + "_");
							key.append(rs.getString(columnName));
						}
						else
						{
							// 當QueryAttrInfo為組合欄位的情況，例如縣市+鄉鎮
							String[] cols = columnName.split(",");
							for (int i = 0; i < cols.length; i++)
							{
								String col = cols[i];
								key.append(col + "_");
								key.append(rs.getString(col));
								if (i != (cols.length - 1))
								{
									key.append(",");
								}
							}
						}
						if (colIter.hasNext())
							key.append(",");
					}
				}

				if (!StringUtil.isEmpty(key.toString()))
				{
					rowCntMap.put(key.toString(), Integer.parseInt(rs.getString("Cnt")));
				}
				else
				{
					rowCntMap.put("ERROR_KEY", Integer.parseInt(rs.getString("Cnt")));
				}
			}
		}
		catch (SQLException e)
		{
			logger.error("getRowCntDataMap error, sql=" + sql, e);
		}
		return rowCntMap;
	}

//	@Override
//	@Transactional(readOnly = true)
//	public int queryCodeIdCnt(String codeId) throws Exception
//	{
//		if (StringUtil.isEmpty(codeId))
//		{
//			logger.debug("queryCodeIdCnt format error");
//			return 0;
//		}
//
//		if (codeId.startsWith("Z"))
//		{
//			return 3;
//		}
//
//		logger.debug("queryDataSetting, codeId=" + codeId);
//		StringBuffer sql = new StringBuffer();
//		sql.append("select Count(*) from DataSetting");
//		sql.append(" where CodeId=:codeId");
//		Query query = getIisSession().createSQLQuery(sql.toString()).addEntity(DataSetting.class);
//		query.setParameter("codeId", codeId);
//
//		@SuppressWarnings("unchecked")
//		List<Object> list = query.list();
//		int cnt = (list != null && list.size() > 0) ? Integer.parseInt(String.valueOf(list.get(0))) : 0;
//		return cnt;
//	}
}
