package tech.guanli.boot.data.redis.plus.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import tech.guanli.boot.data.redis.plus.Package;

@AutoConfiguration
@ComponentScan(basePackageClasses = { Package.class })
@EnableConfigurationProperties({ RedisPlusAutoConfigurationProperty.class })
public class RedisPlusAutoConfiguration {

}
