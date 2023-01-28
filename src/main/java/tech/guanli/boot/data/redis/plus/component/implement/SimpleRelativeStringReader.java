package tech.guanli.boot.data.redis.plus.component.implement;

import org.springframework.stereotype.Component;

import tech.guanli.boot.data.redis.plus.component.relative.StringReader;

@Component
public class SimpleRelativeStringReader extends StringReader<Void> {

	@Override
	protected String readCodeData(Void parameter) {
		return null;
	}

	@Override
	protected String getAndSetIfAbsent(String key, Void parameter) {
		return super.get(key);
	}

	@Override
	protected String getAndSetIfAbsent(String key, Void parameter, Long expiresSeconds) {
		return super.get(key);
	}

}
