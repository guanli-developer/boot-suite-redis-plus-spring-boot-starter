package tech.guanli.boot.data.redis.plus.component.absolute;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import tech.guanli.boot.data.redis.plus.component.core.AbsoluteReader;

@Slf4j
public abstract class ObjectReader<CodeData, Parameter> extends AbsoluteReader<CodeData, Parameter> {

	@Override
	protected String getAndSetIfAbsent(String key, Parameter parameter) {
		String value = get(key);
		if (Objects.isNull(value)) {
			CodeData codeData = readCodeData(parameter);
			if (Objects.nonNull(codeData)) {
				try {
					value = objectMapper.writeValueAsString(codeData);
					redisTemplate.opsForValue().set(key, value);
				} catch (JsonProcessingException e) {
					log.error("code data can not be serialized to a json string:", e);
				}
			}
		}
		return value;
	}

	@Override
	protected String getAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds) {
		String value = get(key);
		if (Objects.isNull(value)) {
			CodeData codeData = readCodeData(parameter);
			if (Objects.nonNull(codeData)) {
				try {
					value = objectMapper.writeValueAsString(codeData);
					redisTemplate.opsForValue().set(key, value, expiresSeconds, TimeUnit.SECONDS);
				} catch (JsonProcessingException e) {
					log.error("code data can not be serialized to a json string:", e);
				}
			}
		}
		return value;
	}
}
