package gov.nia.nrs.system.jdbc;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class SqlStore {
	
	private static final ThreadLocal<Map<String, List<String>>> threadLocal = new ThreadLocal<Map<String, List<String>>>();
	public static final String SQL_KEY = "sql";

	public static void set(Map<String, List<String>> map) {
		threadLocal.set(map);
	}

	public static void unset() {
		threadLocal.remove();
	}

	public static Map<String, List<String>> get() {
		return (Map<String, List<String>>) threadLocal.get();
	}

	public static void addSql(String sql) {
		Map<String, List<String>> map = (Map<String, List<String>>) threadLocal.get();
		((List<String>) map.get(SQL_KEY)).add(sql);
	}

	/**
	 * @return 所有SQL歷程
	 */
	public static String getSqlHistory() {
		Map<String, List<String>> map = (Map<String, List<String>>) threadLocal.get();
		List<String> list = (List<String>) map.get(SQL_KEY);
		return CollectionUtils.isEmpty(list) ? "" : StringUtils.join(list, ';');
	}

	/**
	 * @return 最近一筆SQL
	 */
	public static String getLatestSql() {
		Map<String, List<String>> map = (Map<String, List<String>>) threadLocal.get();
		List<String> list = (List<String>) map.get(SQL_KEY);
		if (list!=null && list.size()>=1){
			return (String) list.get(list.size() - 1);
		}
		return "";
	}
}