package gov.nia.nrs.tag;



import gov.nia.nrs.utils.DateUtils;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Format Date Tag Handler
 *
 */
public class FormatDateTag extends SimpleTagSupport {
    private static final Logger logger = LoggerFactory.getLogger(FormatDateTag.class);

    private String date;

    @Override
    public void doTag() {
        try {
            if (date == null || (date.trim().length() != 8 && date.trim().length() != 12)) {
                this.getJspContext().getOut().print(date);
                return;
            }

            date = date.trim();
            if (date.length() == 8) {
                date = DateUtils.formatStrDate(date);
            } else if (date.length() == 12) {
                if (date.matches("\\d{12}")) {
                    date = new StringBuffer(date).insert(4, "/").insert(7, "/").insert(10, " ").insert(13, ":").toString();
                }
            }
            this.getJspContext().getOut().print(date);
        } catch (Exception e) {
            logger.error("FormatDataTag error", e);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
