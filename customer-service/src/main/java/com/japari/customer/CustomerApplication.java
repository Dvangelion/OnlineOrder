package com.japari.customer;

import com.japari.customer.model.Food;
import com.japari.customer.service.FoodService;
import com.japari.customer.utils.BytestoMoneyConverter;
import com.japari.customer.utils.MoneytoBytesConverter;
import io.lettuce.core.ReadFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.Optional;

//@SpringBootApplication
//public class CustomerApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(CustomerApplication.class, args);
//    }
//
//}

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
@EnableRedisRepositories
public class CustomerApplication implements ApplicationRunner {
    @Autowired
    private FoodService foodService;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer() {
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(
                Arrays.asList(new MoneytoBytesConverter(), new BytestoMoneyConverter()));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Food> c = foodService.findOneFood("mocha");
        log.info("Coffee {}", c);

        for (int i = 0; i < 5; i++) {
            c = foodService.findOneFoodfromCache("mocha");
        }

        log.info("Value from Redis: {}", c);
    }
}
