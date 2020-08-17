package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Service
public class RedisService {

    @Autowired(required = false)
    private JedisCluster jedisCluster;
    @Autowired(required = false)
    private JedisPool jedisPool;

    @Resource(name = "redisOne")
    private StringRedisTemplate template;



    public Long remove(String key) {
        if (jedisCluster != null) {
            return jedisCluster.del(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Long result = j.del(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String expire(String key,Integer expireSecond,String code) {
        if (jedisCluster != null) {
            return jedisCluster.setex(key, expireSecond, code);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.setex(key, expireSecond, code);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String get(String key) {
        if (jedisCluster != null) {
            return jedisCluster.get(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.get(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public Boolean exists(String key) {
        if (jedisCluster != null) {
            return jedisCluster.exists(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Boolean result = j.exists(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public Long lpush(String key, String dddh) {
        if (jedisCluster != null) {
            return jedisCluster.lpush(key, dddh);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Long result = j.lpush(key, dddh);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public Long del(String key) {
        if (jedisCluster != null) {
            return jedisCluster.del(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Long result = j.del(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String rpop(String key) {
        if (jedisCluster != null) {
            return jedisCluster.rpop(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.rpop(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public Long incr(String key) {
        if (jedisCluster != null) {
            return jedisCluster.incr(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Long result = j.incr(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String set(String key, String value) {
        if (jedisCluster != null) {
            return jedisCluster.set(key, value);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.set(key, value);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    /**
     *
     * @param key
     * @param value
     * @param time 秒
     * @return
     */
    public String setWithTime(final String key, final String value, final int time) {
        if (jedisCluster != null) {
            return jedisCluster.setex(key, time, value);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.setex(key, time, value);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }


    public Map<String,String> hgetAll(String key){
        if (jedisCluster != null) {
            return jedisCluster.hgetAll(key);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Map<String,String> result = j.hgetAll(key);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public void delByPattern(final String pattern) {
        if (jedisCluster != null) {
            TreeSet<String> keys = keys(jedisCluster, pattern);
            for (String key : keys) {
                jedisCluster.del(key);
            }
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                Set<String> ss = j.keys(pattern);
                for (String s : ss) {
                    j.del(s);
                }
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String setex(final String key, final int seconds, final String value) {
        if (jedisCluster != null) {
            return jedisCluster.setex(key,seconds,value);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                return j.setex(key, seconds, value);
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public String set(final String key, final String value, final String nxxx, final String expx, final long time) {
        if (jedisCluster != null) {
            return jedisCluster.set(key, value, nxxx, expx, time);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                return j.set(key, value, nxxx, expx, time);
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public boolean updateValue(String key,Object value,long minutes) {
        if (jedisCluster != null) {
            if(exists(key)) {
                // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
                long time = jedisCluster.ttl(key);
                jedisCluster.set(key, value.toString(), "XX", "EX", time);
            }else {
                jedisCluster.set(key, value.toString(), "NX", "EX", minutes*60);
            }
        } else if (jedisPool != null) {
            if(exists(key)) {
                Jedis j = jedisPool.getResource();
                try {
                    long time = j.ttl(key);
                    j.set(key, value.toString(), "XX", "EX", time);
                } finally {
                    j.close();
                }
            }else {
                Jedis j = jedisPool.getResource();
                try {
                    j.set(key, value.toString(), "NX", "EX", minutes*60);
                } finally {
                    j.close();
                }
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
        return true;
    }

    public String tryLock(String key,Object value,long minutes) {
        if (jedisCluster != null) {
            return jedisCluster.set(key, value.toString(), "NX", "EX", minutes*60);
        } else if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                return j.set(key, value.toString(), "NX", "EX", minutes*60);
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }

    public static TreeSet<String> keys(JedisCluster jedisCluster, String pattern) {
        TreeSet<String> keys = new TreeSet<>(); // 获取所有的节点
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes(); // 遍历节点 获取所有符合条件的KEY
        for (String k : clusterNodes.keySet()) {
            JedisPool jp = clusterNodes.get(k);
            Jedis connection = jp.getResource();
            try {
                keys.addAll(connection.keys(pattern));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
        }
        return keys;
    }

    public String rename(String oldKey, String newKey) {
        if (jedisPool != null) {
            Jedis j = jedisPool.getResource();
            try {
                String result = j.rename(oldKey, newKey);
                return result;
            } finally {
                j.close();
            }
        } else {
            throw new RuntimeException("未有Redis实例");
        }
    }
    public Set<String> getKeys(String pattern) {
        return template.keys(pattern);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

}
