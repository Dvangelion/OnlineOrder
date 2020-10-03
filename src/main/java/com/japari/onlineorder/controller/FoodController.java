package com.japari.onlineorder.controller;


import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    @ResponseBody
    public List<Food> getAll(){
        return foodService.getAllFood();
    }
}
