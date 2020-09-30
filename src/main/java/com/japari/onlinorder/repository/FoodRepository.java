package com.japari.onlinorder.repository;

import com.japari.onlinorder.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
