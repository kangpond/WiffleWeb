/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.dataquery.bean.DataQueryReq;
import gov.nia.nrs.domain.iis.ForeignSpouse;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface DataQueryDao {
    public List<ForeignSpouse> queryForList(DataQueryReq req);
}
