package com.japari.onlineorder.service;


import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.model.FoodCache;
import com.japari.onlineorder.repository.FoodCacheRepository;
import com.japari.onlineorder.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    private FoodCacheRepository foodCacheRepository;


    @Cacheable
    public List<Food> getAllFood() {
        return foodRepository.findAll(Sort.by("id"));
    }

    public List<Food> getFoodByName(List<String> names) {
        return foodRepository.findByNameInOrderById(names);
    }

    public Optional<Food> findOneFoodfromCache(String name) {
        Optional<FoodCache> cached = foodCacheRepository.findOneByName(name);
        if(cached.isPresent()) {
            FoodCache foodCache = cached.get();
            Food food = Food.builder()
                    .name(foodCache.getName())
                    .price(foodCache.getPrice())
                    .build();
            log.info("Found food from cache {}", food);

            return Optional.of(food);
        }   else {
            Optional<Food> newFood = findOneFood(name);
            newFood.ifPresent(
                    c -> {
                        FoodCache foodCache = FoodCache.builder()
                                .id(c.getId())
                                .name(c.getName())
                                .price(c.getPrice())
                                .build();
                        log.info("Saving new food to cache {}", newFood);
                        foodCacheRepository.save(foodCache);
                    }
            );
                return newFood;
            }

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
