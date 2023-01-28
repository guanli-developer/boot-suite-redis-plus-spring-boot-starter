package tech.guanli.boot.data.redis.plus.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "tech.guanli.boot.redis-plus")
@Data
public class RedisPlusAutoConfigurationProperty {

	private String keyPrefix;

}
