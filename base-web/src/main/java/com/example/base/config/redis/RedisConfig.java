package com.example.base.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author demo
 */
@Configuration
public class RedisConfig /*extends CachingConfigurerSupport*/ {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        jedisPoolConfig.setTestOnCreate(redisProperties.getTestOnCreate());
        jedisPoolConfig.setTestOnReturn(redisProperties.getTestOnReturn());
        jedisPoolConfig.setTestWhileIdle(redisProperties.getTestWhileIdle());
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(redisProperties.getTimeBetweenEvictionRunsMillis());
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,
                redisProperties.getHost(),
                redisProperties.getPort(),
                redisProperties.getTimeout(),
                null,
                redisProperties.getDatabase());
        return jedisPool;
    }
}
