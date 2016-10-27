package gov.nia.nrs.dept.ws;

import gov.nia.nrs.dao.GovernmentDao;
import gov.nia.nrs.dept.bean.DeptData;
import gov.nia.nrs.domain.Government;
import gov.nia.nrs.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DeptWebServiceImpl implements DeptWebService
{
	private static final Logger logger = Logger.getLogger(DeptWebServiceImpl.class);

	@Resource
	GovernmentDao governmentDao;

	@Override
	public List<DeptData> queryList100() throws Exception
	{
		logger.debug("queryList100");
		try
		{
			List<DeptData> deptList = new ArrayList<DeptData>();
			List<Government> govList = governmentDao.queryList100();
			if (govList != null && govList.size() > 0)
			{
				for (Government gov : govList)
				{
					DeptData data = new DeptData();
					BeanUtils.copyProperties(gov, data);
					deptList.add(data);
				}
				return deptList;
			}
		}
		catch (Exception e)
		{
			logger.error("queryList100 error", e);
			throw e;
		}
		return null;
	}

	@Override
	public DeptData queryById(String deptId) throws Exception
	{
		logger.debug("queryById, deptId=" + deptId);
		if (StringUtil.isEmpty(deptId))
		{
			logger.error("queryById format error");
			throw new Exception("format error");
		}

		try
		{
			DeptData data = new DeptData();
			Government gov = governmentDao.getGov(deptId);
			if (gov != null && !"Y".equals(gov.getDeleteFlag()))
			{
				BeanUtils.copyProperties(gov, data);
				return data;
			}
		}
		catch (Exception e)
		{
			logger.error("queryById error", e);
			throw e;
		}
		return null;
	}

	@Override
	public List<DeptData> queryByName(String deptName) throws Exception
	{
		logger.debug("queryByName, deptName=" + deptName);
		if (StringUtil.isEmpty(deptName))
		{
			logger.error("queryByName format error");
			throw new Exception("format error");
		}

		try
		{
			List<DeptData> deptList = new ArrayList<DeptData>();
			List<Government> govList = governmentDao.queryGovLikeName(deptName);
			if (govList != null && govList.size() > 0)
			{
				for (Government gov : govList)
				{
					DeptData data = new DeptData();
					BeanUtils.copyProperties(gov, data);
					deptList.add(data);
				}
				return deptList;
			}
		}
		catch (Exception e)
		{
			logger.error("queryByName error", e);
			throw e;
		}
		return null;
	}

	@Override
	public void delete(String deptId) throws Exception
	{
		logger.debug("delete, deptId=" + deptId);
		if (StringUtil.isEmpty(deptId))
		{
			logger.error("delete format error");
			throw new Exception("format error");
		}

		try
		{
			Government preGov = governmentDao.getGov(deptId);
			Government updateGov = new Government();
			BeanUtils.copyProperties(preGov, updateGov);

			updateGov.setDeleteFlag("Y");
			updateGov.setMaintainFunctionId("");//TODO
			updateGov.setMainUserId("");
			updateGov.setLastUpdateTime(new Date());
			governmentDao.update(updateGov);
		}
		catch (Exception e)
		{
			logger.error("delete error", e);
			throw e;
		}
	}

	@Override
	public void update(DeptData deptData) throws Exception
	{
		logger.debug("update, deptData=" + deptData);
		if (deptData == null || StringUtil.isEmpty(deptData.getDeptId()))
		{
			logger.error("update format error");
			throw new Exception("update format error");
		}

		try
		{
			Government preGov = governmentDao.getGov(deptData.getDeptId());
			Government updateGov = new Government();
			BeanUtils.copyProperties(preGov, updateGov);

			updateGov.setDeptName(deptData.getDeptName());
			updateGov.setMaintainFunctionId("");//TODO
			updateGov.setMainUserId("");
			updateGov.setLastUpdateTime(new Date());
			governmentDao.update(updateGov);
		}
		catch (Exception e)
		{
			logger.error("update error", e);
			throw e;
		}
	}
}
