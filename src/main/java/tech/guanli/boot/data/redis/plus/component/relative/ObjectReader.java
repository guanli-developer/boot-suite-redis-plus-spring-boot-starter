package tech.guanli.boot.data.redis.plus.component.relative;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import tech.guanli.boot.data.redis.plus.component.core.RelativeReader;

@Slf4j
public abstract class ObjectReader<ColdData, Parameter> extends RelativeReader<ColdData, Parameter> {
	@Override
	public String getAndSetIfAbsent(String key, Parameter parameter) {
		String value = get(key);
		if (Objects.isNull(value)) {
			ColdData coldData = readCodeData(parameter);
			if (Objects.nonNull(coldData)) {
				try {
					value = objectMapper.writeValueAsString(coldData);
					redisTemplate.opsForValue().set(key, value);
				} catch (JsonProcessingException e) {
					log.error("cold data can not be serialized to a json string:", e);
				}
			}
		}
		return value;
	}

	@Override
	public String getAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds) {
		String value = get(key);
		if (Objects.isNull(value)) {
			ColdData coldData = readCodeData(parameter);
			if (Objects.nonNull(coldData)) {
				try {
					value = objectMapper.writeValueAsString(coldData);
					redisTemplate.opsForValue().set(key, value, expiresSeconds, TimeUnit.SECONDS);
				} catch (JsonProcessingException e) {
					log.error("cold data can not be serialized to a json string:", e);
				}
			}
		}
		return value;
	}
}
