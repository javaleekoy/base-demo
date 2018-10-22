package com.example.base.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author peramdy on 2018/10/19.
 */
@Component
public class RedisUtils {

    @Autowired
    private JedisPool jedisPool;


    public String set(String key, String value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String set(byte[] key, byte[] value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String set(String key, String value, String nxxx, String expx, long time) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public String get(String key) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public byte[] get(byte[] key) {
        byte[] result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long exists(String... keys) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.exists(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean exists(String key) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long del(String... keys) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.del(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long del(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String type(String key) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.type(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> keys(String pattern) {
        Set<String> results = null;
        try (Jedis jedis = jedisPool.getResource()) {
            results = jedis.keys(pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


    public String randomKey() {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.randomKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String rename(String oldkey, String newkey) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.rename(oldkey, newkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long renamenx(String oldkey, String newkey) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.renamenx(oldkey, newkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long expire(String key, int seconds) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long expireAt(String key, long unixTime) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.expireAt(key, unixTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long ttl(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.ttl(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long move(String key, int dbIndex) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.move(key, dbIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String getSet(String key, String value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<String> mget(String... keys) {
        List<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.mget(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long setnx(String key, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String setex(String key, int seconds, String value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setex(key, seconds, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String mset(String... keysvalues) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.mset(keysvalues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long msetnx(String... keysvalues) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.msetnx(keysvalues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long decrBy(String key, long integer) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.decrBy(key, integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long decr(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.decr(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long incrBy(String key, long integer) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.incrBy(key, integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Double incrByFloat(String key, double value) {
        Double result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.incrByFloat(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long incr(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.incr(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long append(String key, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.append(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String substr(String key, int start, int end) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.substr(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long hset(String key, String field, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String hget(String key, String field) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long hsetnx(String key, String field, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String hmset(String key, Map<String, String> hash) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hmset(key, hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hmget(key, fields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long hincrBy(String key, String field, long value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Double hincrByFloat(String key, String field, double value) {
        Double result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hincrByFloat(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean hexists(String key, String field) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hexists(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long hdel(String key, String... fields) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hdel(key, fields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long hlen(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hlen(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> hkeys(String key) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hkeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<String> hvals(String key) {
        List<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hvals(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long rpush(String key, String... strings) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.rpush(key, strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long lpush(String key, String... strings) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lpush(key, strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long llen(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.llen(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lrange(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String ltrim(String key, long start, long end) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.ltrim(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String lindex(String key, long index) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lindex(key, index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String lset(String key, long index, String value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lset(key, index, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long lrem(String key, long count, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lrem(key, count, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String lpop(String key) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String rpop(String key) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String rpoplpush(String srckey, String dstkey) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.rpoplpush(srckey, dstkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long sadd(String key, String... members) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.sadd(key, members);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> smembers(String key) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.smembers(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long srem(String key, String... members) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.srem(key, members);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String spop(String key) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.spop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> spop(String key, long count) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.spop(key, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long smove(String srckey, String dstkey, String member) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.smove(srckey, dstkey, member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long scard(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.scard(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean sismember(String key, String member) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.sismember(key, member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> sinter(String... keys) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.sinter(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long sinterstore(String dstkey, String... keys) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.sinterstore(dstkey, keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> sunion(String... keys) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.sunion(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        Set<Tuple> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zrevrangeByScoreWithScores(key, max, min);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zremrangeByRank(String key, long start, long end) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zremrangeByScore(String key, double start, double end) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zremrangeByScore(String key, String start, String end) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zunionstore(String dstkey, String... sets) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zunionstore(dstkey, sets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zunionstore(String dstkey, ZParams params, String... sets) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zunionstore(dstkey, params, sets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zinterstore(String dstkey, String... sets) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zinterstore(dstkey, sets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zinterstore(String dstkey, ZParams params, String... sets) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zinterstore(dstkey, params, sets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zlexcount(String key, String min, String max) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zlexcount(key, min, max);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> zrangeByLex(String key, String min, String max) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zrangeByLex(key, min, max);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zrangeByLex(key, min, max, offset, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> zrevrangeByLex(String key, String max, String min) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zrevrangeByLex(key, max, min);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        Set<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zrevrangeByLex(key, max, min, offset, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long zremrangeByLex(String key, String min, String max) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.zremrangeByLex(key, min, max);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long strlen(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.strlen(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long lpushx(String key, String... string) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.lpushx(key, string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long persist(String key) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.persist(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long rpushx(String key, String... string) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.rpushx(key, string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String echo(String string) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.echo(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String brpoplpush(String source, String destination, int timeout) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.brpoplpush(source, destination, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean setbit(String key, long offset, boolean value) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean setbit(String key, long offset, String value) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setbit(key, offset, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Boolean getbit(String key, long offset) {
        Boolean result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.getbit(key, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long setrange(String key, long offset, String value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setrange(key, offset, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String getrange(String key, long startOffset, long endOffset) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long bitpos(String key, boolean value) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.bitpos(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Long bitpos(String key, boolean value, BitPosParams params) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.bitpos(key, value, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<String> configGet(String pattern) {
        List<String> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.configGet(pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public String configSet(String parameter, String value) {
        String result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.configSet(parameter, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Object eval(String script, int keyCount, String... params) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.eval(script, keyCount, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Long publish(String channel, String message) {
        Long result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.publish(channel, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {
        try (Jedis jedis = jedisPool.getResource()) {
            psubscribe(jedisPubSub, patterns);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Object eval(String script, List<String> keys, List<String> args) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.eval(script, keys, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Object eval(String script) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.eval(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Object evalsha(String script) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.evalsha(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Object evalsha(String sha1, List<String> keys, List<String> args) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.evalsha(sha1, keys, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Object evalsha(String sha1, int keyCount, String... params) {
        Object result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.evalsha(sha1, keyCount, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        List<GeoRadiusResponse> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.georadiusByMember(key, member, radius, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        List<GeoRadiusResponse> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.georadiusByMember(key, member, radius, unit, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<byte[]> bitfield(byte[] key, byte[]... arguments) {
        List<byte[]> result = null;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.bitfield(key, arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public int hashCode() {
        int result = 0;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.hashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean equals(Object obj) {
        boolean result = false;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.equals(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
