package com.example.base.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

import static com.example.base.config.redis.RedisProperties.REDIS_CACHE_PREFIX;

/**
 * @author peramdy on 2018/10/19.
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = REDIS_CACHE_PREFIX)
public class RedisProperties {

    public static final String REDIS_CACHE_PREFIX = "spring.redis";

    @NotBlank
    private String host;
    private Integer port;
    private Integer timeout;
    private Integer database;
    private String password;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWaitMillis;
    private Boolean testOnCreate;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;
    private Integer timeBetweenEvictionRunsMillis;

}
