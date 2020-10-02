package com.japari.onlineorder.repository;

import com.japari.onlineorder.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByNameInOrderById(List<String> list);
}
