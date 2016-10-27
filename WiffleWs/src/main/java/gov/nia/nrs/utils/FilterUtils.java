package gov.nia.nrs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class FilterUtils {
	public static List<String> ImOfficersFilter(List<String> inPersonIdList,List<String> importantPersonIdList){
		List<String> outPersonIdList = new ArrayList<String>(inPersonIdList);
		for(int i = 0;i < importantPersonIdList.size();i++){
			while(outPersonIdList.contains(importantPersonIdList.get(i))){
				outPersonIdList.remove(importantPersonIdList.get(i));
			}
		}
		return outPersonIdList;
	}
}
