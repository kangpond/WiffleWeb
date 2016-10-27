package gov.nia.nrs.dao.iis;

import java.util.List;
import java.util.Map;

public interface ApplyCaseForeignDao {

	List<Map<String, String>> getAddressList(String firstReceiveNo,String addressType);

	List<Map<String, String>> getWorkInfoList(String firstReceiveNo);

}
