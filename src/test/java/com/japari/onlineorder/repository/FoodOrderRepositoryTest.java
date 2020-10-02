package com.japari.onlineorder.repository;

import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.model.FoodOrder;
import com.japari.onlineorder.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodOrderRepositoryTest {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Test
    public void shouldHaveFoodOrder() {
        Food food = new Food();
        FoodOrder foodOrder = new FoodOrder();

        Money money = Money.parse("CNY 9999");
        food.setId(1L);
        food.setPrice(money);
        food.setName("MANHANQUANXI");

        List<Food> foods = List.of(food);


        foodOrder.setId(1L);
        foodOrder.setCustomer("Han Mei Mei");
        foodOrder.setItems(foods);
        foodOrder.setState(OrderState.COOKING);

        foodOrderRepository.save(foodOrder);


        log.info(String.valueOf(foodOrderRepository.findAll()));


    }
}
