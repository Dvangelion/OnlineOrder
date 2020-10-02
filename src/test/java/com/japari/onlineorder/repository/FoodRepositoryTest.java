package com.japari.onlineorder.repository;


import com.japari.onlineorder.model.Food;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Slf4j
public class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void shouldFindFood(){
        Food food = new Food();
        food.setCreateTime(new Date());
        food.setUpdateTime(new Date());
        food.setId(1L);
        Money money = Money.parse("CNY 20.44");
        food.setPrice(money);
        food.setName("Vanilla Icecream");


        foodRepository.save(food);

        log.info(String.valueOf(foodRepository.findAll()));

    }
}
