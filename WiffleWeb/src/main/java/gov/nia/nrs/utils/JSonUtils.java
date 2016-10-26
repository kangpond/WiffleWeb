package gov.nia.nrs.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonUtils
{
	private static Logger logger = Logger.getLogger(JSonUtils.class);

	private static ObjectMapper createQuoteFieldNameMapper()
	{
		return new ObjectMapper().configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
	}

//	private static ObjectMapper createAllowQuoteFieldNameMapper()
//	{
//		return new ObjectMapper().configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);
//	}

	/**
	 * 將物件轉成JSon String
	 * @param value
	 * @return
	 */
	public static String toJSONString(Object value)
	{
		try
		{
			ObjectMapper mapper = JSonUtils.createQuoteFieldNameMapper();
			return mapper.writeValueAsString(value);
		}
		catch (Exception e)
		{
			logger.warn("toJSONString fail, Object=" + value, e);
			return null;
		}
	}

	/**
	 * 將JSon String轉成物件
	 * @param jsonString
	 * @param object
	 * @return
	 */
	public static <T> T fromJSONString(String jsonString, Class<T> object)
	{
		if (jsonString == null || object == null)
		{
			logger.warn("fromJSONString format error");
			return null;
		}

		try
		{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString, object);
		}
		catch (Exception e)
		{
			logger.warn("fromJSONString fail, jsonString=" + jsonString + ", object=" + object, e);
			return null;
		}
	}

	/**
	 * 將JSon String轉成Map<String, Object>
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> readJSONtoMap(String jsonString)
	{
		if (jsonString == null)
		{
			logger.warn("fromJSONString format error");
			return null;
		}

		try
		{
			ObjectMapper mapper = new ObjectMapper();
//			mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>()
			{};
			return mapper.readValue(jsonString, typeRef);
		}
		catch (Exception e)
		{
			logger.warn("readJSONtoMap fail, jsonString=" + jsonString, e);
			return null;
		}
	}


	public static void main(String[] args)
	{

	}

}
