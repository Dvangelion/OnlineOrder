package com.japari.customer.controller;

import com.japari.customer.controller.request.NewOrderRequest;
import com.japari.customer.model.Food;
import com.japari.customer.model.FoodOrder;
import com.japari.customer.service.FoodOrderService;
import com.japari.customer.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/foodorder")
@Slf4j

public class FoodOrderController {
    @Autowired
    private FoodOrderService foodOrderService;
    @Autowired
    private FoodService foodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Received new order {}", newOrder);

        Food[] foodList = foodService.getFoodByName(newOrder.getItems())
                .toArray(new Food[]{});

        log.info("food List {}", foodList);

        return foodOrderService.createOrder(newOrder.getCustomer(), foodList);
    }


}
