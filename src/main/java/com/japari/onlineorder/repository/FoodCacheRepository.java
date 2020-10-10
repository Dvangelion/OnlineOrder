package com.japari.onlineorder.repository;

import com.japari.onlineorder.model.FoodCache;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FoodCacheRepository extends CrudRepository<FoodCache, Long> {
    Optional<FoodCache> findOneByName(String name);
}
