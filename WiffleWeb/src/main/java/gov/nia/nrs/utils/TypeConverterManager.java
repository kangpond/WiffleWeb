package gov.nia.nrs.utils;


import java.util.HashMap;
import java.util.Map;

public class TypeConverterManager
{
	public final static TypeConverterManager INSTANCE = new TypeConverterManager();
	public final static String UNKNOWN_VALUE = "未知";

	private Map<String, ITypeConverter> typeConverters = new HashMap<String, ITypeConverter>();

	private TypeConverterManager(){
	}

	public void registerTypeConverter(Class<?> type, ITypeConverter typeConverter)
	{
		registerTypeConverter(type.getName(), typeConverter);
	}
	
	public void registerTypeConverter(ITypeConverter typeConverter) {
		registerTypeConverter(typeConverter.getClass().getName(), typeConverter);
		registerTypeConverter(typeConverter.getClass().getSimpleName(), typeConverter);
	}

	public void registerTypeConverter(String className, ITypeConverter typeConverter)
	{
		if (typeConverters.containsKey(className))
			typeConverters.remove(className);
		typeConverters.put(className, typeConverter);
	}

	public ITypeConverter getTypeConverter(Class<?> type)
	{
		return getTypeConverter(type.getName());
	}

	public ITypeConverter getTypeConverter(String className)
	{
		if (!typeConverters.containsKey(className))
			return DefaultTypeConverter.INSTANCE;
		return typeConverters.get(className);
	}

	public static String convertToString(Object value) {
		if (value == null)
			return "";

		return INSTANCE.getTypeConverter(value.getClass()).convertToString(value);
	}

	public static String convertToString(String converterName, Object value) {
		if (value == null)
			return "";

		return INSTANCE.getTypeConverter(converterName).convertToString(value);
	}

	public static String convertToString(Class<?> type, Object value) {
		return convertToString(type.getName(), value);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T convertTo(String converterName, Object value) {
		if (value == null)
			return null;

		return (T)INSTANCE.getTypeConverter(converterName).convertTo(value);
	}
	
//	public static <T> T convertTo(Class<?> type, Object value) {
//		return convertTo(type.getName(), value);
//	}

	public static Object convertFromString(String value) {
		if (value == null)
			return "";

		return INSTANCE.getTypeConverter(value.getClass()).convertFromString(value);
	}
	
	public static Object convertFromString(String converterName, String value) {
		return INSTANCE.getTypeConverter(converterName).convertFromString(value);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T convertFromString(Class<?> type, String value) {
		if (value == null)
			return (T)"";

		return (T)INSTANCE.getTypeConverter(type).convertFromString(value);
	}
}
