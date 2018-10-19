package com.example.base.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.lang.Nullable;

import java.util.Collection;

/**
 * @author peramdy on 2018/10/19.
 */
public class RedisCache implements CacheManager {

    @Nullable
    @Override
    public Cache getCache(String s) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        
        return null;
    }
}
