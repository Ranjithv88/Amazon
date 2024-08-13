package com.SpringBoot.Amazon.Redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory () {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost,redisPort) ;
        return new LettuceConnectionFactory(configuration);
    }

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory () {
//        return new JedisConnectionFactory( new RedisStandaloneConfiguration(redisHost,redisPort));
//    }

    public RedisCacheManager redisCacheManager (RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.create(redisConnectionFactory);
    }

}

