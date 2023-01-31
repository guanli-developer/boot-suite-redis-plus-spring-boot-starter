package tech.guanli.boot.data.redis.plus.component.relative;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SerializableObjectReader<ColdData, Parameter> extends ObjectReader<ColdData, Parameter> {

	protected abstract Class<ColdData> getColdDataClass();

	public ColdData getObjectAndSetIfAbsent(String key, Parameter parameter) {
		String value = getAndSetIfAbsent(key, parameter);
		try {
			return objectMapper.readValue(value, getColdDataClass());
		} catch (JsonProcessingException e) {
			log.error("can not serialize cache to object: ", e);
			return null;
		}
	}

	public ColdData getObjectAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds) {
		String value = getAndSetIfAbsent(key, parameter, expiresSeconds);
		try {
			return objectMapper.readValue(value, getColdDataClass());
		} catch (JsonProcessingException e) {
			log.error("can not serialize cache to object: ", e);
			return null;
		}
	}

}
