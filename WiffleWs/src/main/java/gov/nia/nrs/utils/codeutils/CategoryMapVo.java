/**
 *
 */
package gov.nia.nrs.utils.codeutils;

import java.io.Serializable;
import java.util.Map;

/**
 * 代碼map vo
 *
 * @author Allen
 * @since 2015年4月9日 上午11:54:17
 */
public class CategoryMapVo implements Serializable {
    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    Map<String, CategoryVo> map;

    public Map<String, CategoryVo> getMap() {
        return map;
    }

    public void setMap(Map<String, CategoryVo> map) {
        this.map = map;
    }
}
