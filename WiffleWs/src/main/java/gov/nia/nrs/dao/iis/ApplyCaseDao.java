/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ApplyCase;

import java.util.List;
import java.util.Map;

/**
 * @author Clare
 *
 */
public interface ApplyCaseDao {

    public List<ApplyCase> getApplyCaseByFirstReceiveNo(String firstReceiveNo);

    public List<ApplyCase> getApplyCaseFL(String firstReceiveNo);

	List<Map<String, String>> getPassportInfoList(String firstReceiveNo, String residentIdNo);

}
