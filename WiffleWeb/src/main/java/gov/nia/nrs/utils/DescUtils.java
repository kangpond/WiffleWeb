package gov.nia.nrs.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class DescUtils {

	public static final Map<String, String> Occupation;
	public static final Map<String, String> YESORNO;
	public static final Map<String, String> BIRTHCONTROL;
	public static final Map<String, String> Cases;
	public static final Map<String, String> ISALIVE;
	public static final Map<String, String> HealthType;
	public static final Map<String, String> StuntType;
	public static final Map<String, String> HandiCapType;
	public static final Map<String, String> Disability;
	
	static {
		Occupation = new LinkedHashMap<String, String>();
		Occupation.put("1","軍公教");
		Occupation.put("2","農");
		Occupation.put("3","工");
		Occupation.put("4", "商");
		Occupation.put("5", "金融業");
		Occupation.put("6", "服務業");
		Occupation.put("7", "自由業");
		Occupation.put("8", "家管");
		Occupation.put("9", "學生");
		Occupation.put("99", "金融業");
		
		YESORNO = new LinkedHashMap<String, String>();
		YESORNO.put("1","有");
		YESORNO.put("0","無");
		
		ISALIVE = new LinkedHashMap<String, String>();
		ISALIVE.put("1","存");
		ISALIVE.put("2","歿");
		
		BIRTHCONTROL = new LinkedHashMap<String, String>();
		BIRTHCONTROL.put("11", "不避孕");
		BIRTHCONTROL.put("12", "欲考慮使用避孕方法");
		BIRTHCONTROL.put("21", "體外射精");
		BIRTHCONTROL.put("22", "安全期");
		BIRTHCONTROL.put("23", "保險套");
		BIRTHCONTROL.put("24", "避孕藥");
		BIRTHCONTROL.put("25", "避孕器");
		BIRTHCONTROL.put("26", "女結紮");
		BIRTHCONTROL.put("27", "男結紮");
		
		Cases = new LinkedHashMap<String, String>();
		Cases.put("3","死亡");
		Cases.put("4", "遷出");
		Cases.put("5", "結紮");
		Cases.put("6", "人在國外");
		Cases.put("7", "離婚");
		Cases.put("8", "空寄戶、無此人");
		Cases.put("9", "逾齡(45歲以上)");
		Cases.put("10", "失蹤、行方不明");
		Cases.put("12", "遷址不詳");
		Cases.put("14", "結案");
		
		HealthType = new LinkedHashMap<String, String>();
		HealthType.put("0", "正常");
		HealthType.put("1", "低體重");
		HealthType.put("2", "早產");
		HealthType.put("3", "缺陷兒");
		HealthType.put("4", "死亡");
		HealthType.put("5", "其他");
		
		StuntType = new LinkedHashMap<String, String>();
		StuntType.put("0", "無篩檢");
		StuntType.put("1", "正常");
		StuntType.put("2", "疑似異常個案");
		
		
		HandiCapType = new LinkedHashMap<String, String>();
		HandiCapType.put("1", "視障");
		HandiCapType.put("2", "聽障");
		HandiCapType.put("3", "聲障");
		HandiCapType.put("4", "肢障");
		HandiCapType.put("5", "智障");
		HandiCapType.put("6", "多障");
		HandiCapType.put("7", "重器障");
		HandiCapType.put("8", "顏殘");
		HandiCapType.put("9", "植物人");
		HandiCapType.put("10", "失智症");
		HandiCapType.put("11", "自閉症");
		HandiCapType.put("12", "染異");
		HandiCapType.put("13", "代異");
		HandiCapType.put("14", "先缺");
		HandiCapType.put("15", "精神病");
		HandiCapType.put("16", "平衡障");
		HandiCapType.put("17", "頑性癲癇症");
		HandiCapType.put("18", "罕見疾病");
		
		
		Disability = new LinkedHashMap<String, String>();
		Disability.put("1", "極重度");
		Disability.put("2", "重度");
		Disability.put("3", "中度");
		Disability.put("4", "輕度");
	}
	
	
	
	public static String getOccupationDesc(String num) {
        return Occupation.get(num);
    }
	
	public static String getYesOrNot(String num) {
        return YESORNO.get(num);
    }
	
	public static String getCONTROL(String num) {
        return BIRTHCONTROL.get(num);
    }
	public static String getCaseStudy(String num) {
        return Cases.get(num);
    }
	
	public static String getDeadOrAlive(String num) {
        return ISALIVE.get(num);
    }
	
	public static String getHealthType(String num) {
        return HealthType.get(num);
    }
	public static String getStuntType(String num) {
        return StuntType.get(num);
    }
	
	public static String getHandiCapType(String num) {
        return HandiCapType.get(num);
    }
	
	public static String getDisabilityClass(String num){
		return Disability.get(num);
	}
	
}
