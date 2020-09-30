package com.japari.onlinorder.service;


import com.japari.onlinorder.model.Food;
import com.japari.onlinorder.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
@Slf4j
@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public Optional<Food> findOneFood(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Food> food = foodRepository.findOne(
                Example.of(Food.builder().name(name).build(), matcher));

        log.info("Food Found: {}", food);
        return food;

    }
}
