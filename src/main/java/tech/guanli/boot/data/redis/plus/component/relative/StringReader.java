package tech.guanli.boot.data.redis.plus.component.relative;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import tech.guanli.boot.data.redis.plus.component.core.RelativeReader;

public abstract class StringReader<Parameter> extends RelativeReader<String, Parameter> {
	@Override
	public String getAndSetIfAbsent(String key, Parameter parameter) {
		String value = get(key);
		if (Objects.isNull(value)) {
			value = readCodeData(parameter);
			if (Objects.nonNull(value)) {
				redisTemplate.opsForValue().set(key, value);
			}
		}
		return value;
	}

	@Override
	public String getAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds) {
		String value = get(key);
		if (Objects.isNull(value)) {
			value = readCodeData(parameter);
			if (Objects.nonNull(value)) {
				redisTemplate.opsForValue().set(key, value, expiresSeconds, TimeUnit.SECONDS);
			}
		}
		return value;
	}
}
