package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.model.Food;
import java.util.List;
import java.util.Optional;

public interface FoodService {

  List<Food> findAll();

  Optional<Food> findByName(String name);

  List<Food> findByNameStartsWithIgnoreCase(String name);

  Food create(Food food);

  void delete(String name);
}
