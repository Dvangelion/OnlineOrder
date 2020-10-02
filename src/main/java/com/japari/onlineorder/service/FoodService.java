package com.japari.onlineorder.service;


import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Slf4j
@Service
@CacheConfig(cacheNames = "FoodCache")
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Cacheable
    public List<Food> getAllFood() {
        return foodRepository.findAll(Sort.by("id"));
    }

    public List<Food> getFoodByName(List<String> names) {
        return foodRepository.findByNameInOrderById(names);
    }

    public Optional<Food> findOneFood(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Food> food = foodRepository.findOne(
                Example.of(Food.builder().name(name).build(), matcher));

        log.info("Food Found: {}", food);
        return food;

    }
}
