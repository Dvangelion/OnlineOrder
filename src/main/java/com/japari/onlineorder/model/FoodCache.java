package com.japari.onlineorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@RedisHash(value = "onlineorder-food", timeToLive = 60)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FoodCache {
    @Id
    private Long id;
    @Indexed
    private String name;
    private Money price;
}
