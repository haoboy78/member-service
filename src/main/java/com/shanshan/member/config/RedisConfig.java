package com.shanshan.member.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/5/6 09:02
 * @Version: 1.0
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    @Primary
    public RedissonClient getRedisson() {
        Config config = new Config();

        String address = "redis://" + redisProperties.getHost() +
                ":" +
                redisProperties.getPort();

        config.useSingleServer()
                .setAddress(address)
                .setPassword(redisProperties.getPassword())
                .setDatabase(redisProperties.getDatabase());

        return Redisson.create(config);
    }

}
