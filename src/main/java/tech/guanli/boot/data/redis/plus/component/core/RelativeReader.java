package tech.guanli.boot.data.redis.plus.component.core;

public abstract class RelativeReader<ColdData, Parameter> extends RedisReader<ColdData, Parameter> {

	@Override
	public String get(String key) {
		return super.get(property.getKeyPrefix() + key);
	}

	@Override
	public void set(String key, String value, Long expiresSeconds) {
		super.set(property.getKeyPrefix() + key, value, expiresSeconds);
	}

	@Override
	public void set(String key, String value) {
		super.set(property.getKeyPrefix() + key, value);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(property.getKeyPrefix() + key);
	}

	@Override
	public String getAndExpire(String key, Long expiresSeconds) {
		return super.getAndExpire(property.getKeyPrefix() + key, expiresSeconds);
	}

}
