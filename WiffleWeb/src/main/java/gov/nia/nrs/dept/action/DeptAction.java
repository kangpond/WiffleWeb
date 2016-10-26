package gov.nia.nrs.dept.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.dept.bean.DeptData;
import gov.nia.nrs.dept.ws.DeptWebService;
import gov.nia.nrs.utils.CommonUtils;
import gov.nia.nrs.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/dept")
public class DeptAction extends BaseAction
{
	private static final long serialVersionUID = -612882331281511746L;

	private static final Logger logger = Logger.getLogger(DeptAction.class);

	@Resource
	private DeptWebService deptWebService;

	/** 查詢頁:輸入的機關代碼 */
	private String deptId;
	/** 查詢頁:輸入的機關名稱 */
	private String deptName;

	/** 列表頁:機關table */
	private List<DeptData> deptList;
	/** 列表頁:機關table size */
	private int deptListSize;
	/** 列表頁:選取的機關代碼 */
	private String selectedDeptId;

	/** 詳細頁:機關資料 */
	private DeptData deptData;

	@Action(value = "query", results = { @Result(name = SUCCESS, location = "deptQuery", type = "tiles") })
	public String query() throws Exception
	{
		logger.debug("query");
		message = "";
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = SUCCESS, location = "deptList", type = "tiles"),
			@Result(name = INPUT, location = "deptQuery", type = "tiles") })
	public String list() throws Exception
	{
		logger.debug("list, deptId=" + deptId + ", deptName=" + deptName);

		message = "";
		deptList = new ArrayList<DeptData>();
		try
		{
//			deptWebService = getRestService(DeptWebService.class);
			if (!CommonUtils.isEmpty(deptId))
			{
				DeptData data = deptWebService.queryById(deptId);
				if (data != null)
				{
					deptList.add(data);
				}
			}
			else if (!CommonUtils.isEmpty(deptName))
			{
				deptList = deptWebService.queryByName(deptName);
			}
			else
			{
				deptList = deptWebService.queryList100();
			}
			deptListSize = (deptList != null) ? deptList.size() : 0;
		}
		catch (Exception e)
		{
			message = "執行失敗！";
			logger.error("list error", e);
			return INPUT;
		}
		return SUCCESS;
	}

	@Action(value = "deptEdit", results = { @Result(name = SUCCESS, location = "deptDetailEdit", type = "tiles"),
			@Result(name = INPUT, location = "deptList", type = "tiles") })
	public String deptEdit() throws Exception
	{
		logger.debug("deptEdit, selectedDeptId=" + selectedDeptId);

		message = "";
		if (CommonUtils.isEmpty(selectedDeptId))
		{
			message = "請選擇一筆資料！";
			return INPUT;
		}

		try
		{
			deptData = deptWebService.queryById(selectedDeptId);
		}
		catch (Exception e)
		{
			message = "執行失敗！";
			logger.error("deptEdit error", e);
			return INPUT;
		}
		return SUCCESS;
	}

	@Action(value = "motify", results = { @Result(name = SUCCESS, location = "deptQuery", type = "tiles"),
			@Result(name = INPUT, location = "deptDetailEdit", type = "tiles") })
	public String motify() throws Exception
	{
		logger.debug("motify, deptData=" + deptData);

		message = "";
		if (deptData == null || StringUtil.isEmpty(deptData.getDeptId()))
		{
			logger.warn("motify format error");
			message = "更新的資料異常，請重新查詢一次";
			return SUCCESS;
		}

		try
		{
			deptWebService.update(deptData);
			message = "修改成功！";
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("motify error", e);
			message = "執行失敗！";
			return INPUT;
		}
	}

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "deptQuery", type = "tiles"),
			@Result(name = INPUT, location = "deptDetailEdit", type = "tiles") })
	public String delete() throws Exception
	{
		logger.debug("delete, selectedDeptId=" + selectedDeptId);

		message = "";
		if (StringUtil.isEmpty(selectedDeptId))
		{
			logger.warn("delete format error");
			message = "刪除的資料異常，請重新查詢一次";
			return SUCCESS;
		}

		try
		{
			deptWebService.delete(selectedDeptId);
			message = "刪除成功！";
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("delete error", e);
			message = "執行失敗！";
			return SUCCESS;
		}
	}

	public String getDeptId()
	{
		return deptId;
	}

	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public List<DeptData> getDeptList()
	{
		return deptList;
	}

	public void setDeptList(List<DeptData> deptList)
	{
		this.deptList = deptList;
	}

	public int getDeptListSize()
	{
		return deptListSize;
	}

	public void setDeptListSize(int deptListSize)
	{
		this.deptListSize = deptListSize;
	}

	public String getSelectedDeptId()
	{
		return selectedDeptId;
	}

	public void setSelectedDeptId(String selectedDeptId)
	{
		this.selectedDeptId = selectedDeptId;
	}

	public DeptData getDeptData()
	{
		return deptData;
	}

	public void setDeptData(DeptData deptData)
	{
		this.deptData = deptData;
	}

}
