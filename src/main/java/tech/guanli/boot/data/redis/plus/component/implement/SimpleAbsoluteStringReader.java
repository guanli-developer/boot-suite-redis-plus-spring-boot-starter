package tech.guanli.boot.data.redis.plus.component.implement;

import org.springframework.stereotype.Component;

import tech.guanli.boot.data.redis.plus.component.absolute.StringReader;

@Component
public class SimpleAbsoluteStringReader extends StringReader<Void> {

	@Override
	protected String readCodeData(Void parameter) {
		return null;
	}

	@Override
	public String getAndSetIfAbsent(String key, Void parameter) {
		return super.get(key);
	}

	@Override
	public String getAndSetIfAbsent(String key, Void parameter, Long expiresSeconds) {
		return super.get(key);
	}

}
