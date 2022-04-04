package com.home.aircraft;

import com.home.aircraft.Models.Aircraft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class AircraftApplication {

    @Bean
    public RedisOperations<String, Aircraft> redisOperations(RedisConnectionFactory factory) {
        // Create a serializer to be used when converting between objects and JSON records
        Jackson2JsonRedisSerializer<Aircraft> serializer = new Jackson2JsonRedisSerializer<>(Aircraft.class);

        // Create a RedisTemplate that accepts keys of type String and values of type Aircraft to accommodate the inbound Aircraft with String IDs.
        RedisTemplate<String, Aircraft> template = new RedisTemplate<>();

        // plug the RedisConnectionFactory bean that was autowired into this bean-creation method’s sole parameter—RedisConnectionFactory factory—
        // into the template object, so it can create and retrieve a connection to the Redis database.
        template.setConnectionFactory(factory);

        // Set the default serializer
        template.setDefaultSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());

        // Return the created and configured RedisTemplate as the bean to use when some implementation of a RedisOperations bean is requested within the application
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(AircraftApplication.class, args);
    }

}
