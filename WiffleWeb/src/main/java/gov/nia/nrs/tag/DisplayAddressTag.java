package gov.nia.nrs.tag;


import gov.nia.nrs.utils.AddressUtils;
import gov.nia.nrs.utils.vo.NiiAddressVo;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 組合地址(new address format in Nii) tag
 */
public class DisplayAddressTag extends TagSupport {

    private static final long serialVersionUID = System.currentTimeMillis();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /** HTML Error Template */
    private String errorTemplate = "<span class='error'>{}</span>";

    /**
     * niiAddress
     */
    private NiiAddressVo niiAddress;

    private AddressUtils addressUtils;

    @Override
    public int doStartTag() {
        if (null == niiAddress)
            return SKIP_BODY;

        String addressAllStr = "";

        try {
            if (addressUtils == null) {
                logger.debug("get addressUtils bean..");
                WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
                addressUtils = (AddressUtils) webApplicationContext.getBean("addressUtils");
            }

            if (addressUtils == null) {
                logger.debug("addressUtils is still null..  SKIP_BODY");
                return SKIP_BODY;
            }


            addressAllStr =
                    addressUtils.getDisplayAddress(niiAddress.getZipCode(), niiAddress.getCity(), niiAddress.getTownship(), niiAddress.getVillage(),
                            niiAddress.getNeighborhood(), niiAddress.getRoad(), niiAddress.getLane(), niiAddress.getAlley(), niiAddress.getNumber());
        } catch (Exception e) {
            logger.warn("niiAddress start fail", e);
            addressAllStr = errorTemplate.replace("{}", e.getMessage());
        }

        try {
            if (StringUtils.isNotBlank(addressAllStr))
                this.pageContext.getOut().print(addressAllStr);
        } catch (Exception e) {
            logger.error("DisplayAddressTag 執行錯誤", e);
        }

        return SKIP_BODY;
    }

    public NiiAddressVo getNiiAddress() {
        return niiAddress;
    }

    public void setNiiAddress(NiiAddressVo niiAddress) {
        this.niiAddress = niiAddress;
    }
}
