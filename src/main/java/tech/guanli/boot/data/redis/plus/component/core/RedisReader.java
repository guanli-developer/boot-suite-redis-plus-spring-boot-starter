package tech.guanli.boot.data.redis.plus.component.core;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tech.guanli.boot.data.redis.plus.configuration.RedisPlusAutoConfigurationProperty;

public abstract class RedisReader<CodeData, Parameter> {
	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected RedisTemplate<String, String> redisTemplate;

	@Autowired
	protected RedisPlusAutoConfigurationProperty property;

	protected abstract CodeData readCodeData(Parameter parameter);

	protected String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	protected abstract String getAndSetIfAbsent(String key, Parameter parameter);

	protected abstract String getAndSetIfAbsent(String key, Parameter parameter, Long expiresSeconds);

	protected String getAndExpire(String key, Long expiresSeconds) {
		return redisTemplate.opsForValue().getAndExpire(key, expiresSeconds, TimeUnit.SECONDS);
	}

	protected void set(String key, String value, Long expiresSeconds) {
		redisTemplate.opsForValue().set(key, value, expiresSeconds, TimeUnit.SECONDS);
	}

	protected void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	protected void delete(String key) {
		redisTemplate.delete(key);
	}

}
