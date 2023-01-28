package tech.guanli.boot.data.redis.plus.component.core;

public abstract class RelativeReader<CodeData, Parameter> extends RedisReader<CodeData, Parameter> {

	@Override
	protected String get(String key) {
		return super.get(property.getKeyPrefix() + key);
	}

	@Override
	protected void set(String key, String value, Long expiresSeconds) {
		super.set(property.getKeyPrefix() + key, value, expiresSeconds);
	}

	@Override
	protected void set(String key, String value) {
		super.set(property.getKeyPrefix() + key, value);
	}

	@Override
	protected void delete(String key) {
		redisTemplate.delete(property.getKeyPrefix() + key);
	}

	@Override
	protected String getAndExpire(String key, Long expiresSeconds) {
		return super.getAndExpire(property.getKeyPrefix() + key, expiresSeconds);
	}

}
