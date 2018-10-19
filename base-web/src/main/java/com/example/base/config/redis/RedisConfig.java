package com.example.base.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author demo
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 自定义redis key
     *
     * @return
     */
    @Nullable
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer sb = new StringBuffer();
                String clzName = o.getClass().getName();
                sb.append(clzName);
                String methodName = method.getName();
                sb.append(methodName);
                Arrays.stream(objects).forEach(object -> {
                    String parameter = object.toString();
                    sb.append(parameter);
                });
                logger.debug("redis key:" + sb);
                return sb.toString();
            }
        };
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(5000);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxWaitMillis(10000);
        jedisPoolConfig.setTestOnCreate(false);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(5000);
        return jedisPoolConfig;
    }

    @Bean
    @Scope(value = "prototype")
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,
                "192.168.136.130",
                16379,
                10000,
                null,
                1);
        return jedisPool;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        RedisStandaloneConfiguration redisStandaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("192.168.136.130");
        redisStandaloneConfiguration.setPassword("");
        redisStandaloneConfiguration.setPort(16379);
        redisStandaloneConfiguration.setDatabase(1);
        /*JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        builder.poolConfig(jedisPoolConfig);
        jedisConnectionFactory*/
        return jedisConnectionFactory;
    }


    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        SimpleCacheManager simpleCacheManager=new SimpleCacheManager();
        simpleCacheManager.setCaches();
        return simpleCacheManager;
    }


}
