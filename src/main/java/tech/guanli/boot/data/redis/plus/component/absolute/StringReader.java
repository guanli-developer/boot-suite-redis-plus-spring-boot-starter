package tech.guanli.boot.data.redis.plus.component.absolute;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import tech.guanli.boot.data.redis.plus.component.core.AbsoluteReader;

public abstract class StringReader<Parameter> extends AbsoluteReader<String, Parameter> {
	@Override
	protected String getAndSetIfAbsent(String key, Parameter parameter) {
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
	protected String getAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds) {
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
