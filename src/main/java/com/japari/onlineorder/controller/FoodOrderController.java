package com.japari.onlineorder.controller;


import com.japari.onlineorder.controller.request.NewOrderRequest;
import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.model.FoodOrder;
import com.japari.onlineorder.service.FoodOrderService;
import com.japari.onlineorder.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodorder")
@Slf4j

public class FoodOrderController {
    @Autowired
    private FoodOrderService foodOrderService;
    @Autowired
    private FoodService foodService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Received new order {}", newOrder);

        Food [] foodList = foodService.getFoodByName(newOrder.getItems())
                .toArray(new Food[]{});

        return foodOrderService.createOrder(newOrder.getCustomer(), foodList);
    }


}
