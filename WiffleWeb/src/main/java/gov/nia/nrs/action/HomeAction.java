package gov.nia.nrs.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Namespace("/")
public class HomeAction extends BaseAction
{
	private static final long serialVersionUID = 2665696430159326919L;
	private static final Logger logger = LoggerFactory.getLogger(HomeAction.class);

	@Action(value = "home", results = { @Result(name = SUCCESS, location = "home", type = "tiles") })
	public String home() throws Exception
	{
		logger.debug(getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		return SUCCESS;
	}

}
