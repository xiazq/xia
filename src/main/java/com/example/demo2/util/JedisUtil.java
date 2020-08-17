package com.example.demo2.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisUtil {


    //    1.定义一个连接池对象
    private static final JedisPool POOL;

    /**
     *  静态代码块初始化连接池对象:
     *     静态代码特点: 随着类的加载而执行，而且只执行一次,它仅能初始化类变量，即static修饰的数据成员。
     * */
    static {
//        1.设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
//        2.设置池中最大连接数[可选]
        config.setMaxTotal(30000);
//        3.设置空闲时间池中的连接数[可选]
        config.setMaxIdle(10000);
//        4. 设置连接池对象
        POOL = new JedisPool(config, "192.168.8.167", 6379);
    }

    /**
     * 从连接池获取连接方法
     */
    @Bean
    public static Jedis getJedis() {
        return POOL.getResource();
    }
}

