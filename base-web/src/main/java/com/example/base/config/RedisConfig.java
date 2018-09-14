package com.example.base.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author demo
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

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
}
