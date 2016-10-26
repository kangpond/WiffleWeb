package gov.nia.nrs.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public void destroy() {}

    @Override
    public void init() {
        logger.debug("Interceptor init...");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();

//        String actionName = getActionName(invocation);
//        if (!StringUtils.endsWith(actionName, "LoginAction")
//        		&& !StringUtils.equalsIgnoreCase(actionName, "UserCAApplyAction")
//        		&& !actionName.equals("GovDialogAction")
//        		&& !actionName.equals("ReportAction")) {
//			 UserProfile user = (UserProfile) session.get("userProfile");
//            if (user == null) {
//                logger.debug("return to login...");
//                return "login";
//            }else{
//        		HttpServletRequest request = (HttpServletRequest)invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
//        		String  maintainFunctionId = request.getParameter("maintainFunctionId");
//        		if(StringUtils.isNotBlank(maintainFunctionId)){
//        			user.setMaintainFunctionId(maintainFunctionId);
//        		}
//            }
//        }

        return invocation.invoke();
    }

    public String getActionName(ActionInvocation invocation) {
        String actionName = invocation.getAction().getClass().getName();
        logger.debug("------------目前正在執行:" + actionName + "------------>");
        String[] str = actionName.split("\\.");
        return str.length > 0 ? str[str.length - 1] : "";
    }
}
