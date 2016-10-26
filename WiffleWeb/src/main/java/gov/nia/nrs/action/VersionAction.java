package gov.nia.nrs.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Namespace("/")
public class VersionAction extends BaseAction {
    private static final long serialVersionUID = 1747119802874743086L;

    private static final Logger logger = LoggerFactory.getLogger(VersionAction.class);
    
    @Action(value = "Version", results = {@Result(name = SUCCESS, location = "version", type = "tiles")})
    public String version() throws Exception {
        logger.debug(Thread.currentThread().getStackTrace()[1].getMethodName());
        return SUCCESS;
    }

}
