package com.japari.onlineorder.service;

import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;



import java.util.Date;

import static org.mockito.Mockito.*;


@Slf4j
public class FoodServiceTest {

    @InjectMocks
    private FoodService foodService;

    @Mock
    private FoodRepository foodRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindFood(){
        Food food = new Food();
        Money price = Money.of(CurrencyUnit.of("CNY"), 25);

        food.setId((long) 1);
        food.setName("Hongshaorou");
        food.setPrice(price);
        food.setCreateTime(new Date());
        food.setUpdateTime(new Date());

        log.info("food: {}", food);

        when(foodRepository.save(any(Food.class))).thenReturn(new Food());
        log.info("id=1: {}",foodRepository.findById(1L));



        log.info("All Food: {}", foodRepository.findAll());
        foodService.findOneFood("Hongshaorou");

    }
}
