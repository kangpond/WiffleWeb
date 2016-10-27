package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;

import java.util.List;

public interface AuditQueryDao {

	public List<? extends Object> search(AuditQueryBean queryBean,UserProfile up, Class objectClass,boolean needPager,int offset,int max) throws Exception;
	public int totalCount(AuditQueryBean queryBean,UserProfile up,String tableName);
}
