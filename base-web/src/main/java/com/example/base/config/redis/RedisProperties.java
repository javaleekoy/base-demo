package com.example.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.example.base.config.RedisProperties.REDIS_CACHE_PREFIX;

/**
 * @author peramdy on 2018/10/19.
 */
@Data
@ConfigurationProperties(prefix = REDIS_CACHE_PREFIX)
public class RedisProperties {

    public static final String REDIS_CACHE_PREFIX = "spring.redis";

    private String host;
    private int port;
    private int timeout;
    private int database;
    private String password;
    private int maxTotal;
    private int maxIdle;
    private int maxWaitMillis;
    private boolean testOnCreate;
    private boolean testOnReturn;
    private boolean testWhileIdle;
    private int timeBetweenEvictionRunsMillis;

}
