package com.oristartech.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * JSON转换工具类
 */
public final class JsonUtil {
	/**
	 * 将对象转换为JSON字符串
	 *
	 * @param source原始对象
	 * @return JSON字符串
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static <T> String objectToJson(T source) throws JsonGenerationException, JsonMappingException, IOException {
		String jsonString = getObjectMapper().writeValueAsString(source);
		return jsonString;
	}

	/**
	 * 将JSON字符串转换为对象，适用于多泛型嵌套
	 *
	 * @param json原始JSON字符串
	 * @param dataType需要转换的对象类型
	 * @param genericityTypes需要转换的对象类型中的泛型类
	 * @return 对象
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> T jsonToObject(String json, Class<?> dataType, Class<?>... genericityTypes)
			throws JsonParseException, JsonMappingException, IOException, InstantiationException,
			IllegalAccessException {
		ObjectMapper objectMapper = getObjectMapper();
		JavaType type = objectMapper.getTypeFactory().constructParametricType(dataType, genericityTypes);
		return getObjectMapper().readValue(json, type);
	}

	/**
	 * 将JSON字符串转换为对象
	 *
	 * @param json原始JSON字符串
	 * @param dataType需要转换的对象类型
	 * @return 对象
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> T jsonToObject(String json, Class<T> dataType) throws JsonParseException, JsonMappingException,
			IOException, InstantiationException, IllegalAccessException {
		return getObjectMapper().readValue(json, dataType);
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		return objectMapper;
	}

}
