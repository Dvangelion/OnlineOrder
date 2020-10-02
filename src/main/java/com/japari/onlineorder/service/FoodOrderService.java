package com.japari.onlineorder.service;


import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.model.FoodOrder;
import com.japari.onlineorder.model.OrderState;
import com.japari.onlineorder.repository.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@Transactional
public class FoodOrderService {
    @Autowired
    private FoodOrderRepository orderRepository;

    public FoodOrder createOrder(String customer, Food...foods) {
        FoodOrder order = FoodOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(foods)))
                .state(OrderState.INIT)
                .build();

        FoodOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    }

    public boolean updateState(@NotNull FoodOrder order, @NotNull OrderState state) {

        if (state.compareTo(order.getState()) <= 0){
            log.warn("Wrong state order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }

}
