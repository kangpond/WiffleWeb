package gov.nia.nrs.action;

import gov.nia.nrs.bean.UserProfile;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;

import com.opensymphony.xwork2.ActionSupport;

@InterceptorRef(value = "authStack", params = { "modelDriven.refreshModelBeforeResult", "true" })
public class BaseAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	protected int totalSize = 0; // for displayTag

	/** display 來源資料清單 */
	protected List<? extends Object> displayList; // for displayTag

	protected String message;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return the totalSize
	 */
	public int getTotalSize()
	{
		return totalSize;
	}

	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize)
	{
		this.totalSize = totalSize;
	}

	/**
	 * @return the displayList
	 */
	public List<? extends Object> getDisplayList()
	{
		return displayList;
	}

	/**
	 * @param displayList the displayList to set
	 */
	public void setDisplayList(List<? extends Object> displayList)
	{
		this.displayList = displayList;
	}

	/**
	 * @return
	 */
	protected HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	/**
	 * @return
	 */
	protected HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

	/**
	 * @return
	 */
	protected HttpSession getHttpSession()
	{
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * @return
	 */
	protected ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}

	/**
	 * @return
	 */
	protected UserProfile getUserProfile()
	{
		HttpSession session = getHttpSession();

		if (session != null)
		{
			return (UserProfile) session.getAttribute("userProfile");
		}
		return null;
	}

	// displayTag 取offset
	protected int getPageIndex()
	{
		HttpServletRequest request = getRequest();
		Enumeration enumers = request.getParameterNames();
		int index = 0;
		while (enumers.hasMoreElements())
		{
			String param = (String) enumers.nextElement();
			if (param.matches("d-[0-9]+-p") && request.getParameter(param) != null)
			{
				index = Integer.parseInt(request.getParameter(param)) - 1;
			}
		}
		return index;
	}
}
