package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.exception.FoodDuplicatedException;
import com.nogran.app.dietas.api.domain.exception.FoodNotFoundException;
import com.nogran.app.dietas.api.domain.model.Food;
import com.nogran.app.dietas.api.domain.persistence.FoodPersistence;
import com.nogran.app.dietas.api.domain.service.FoodService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

  private final FoodPersistence persistence;

  @Override
  public List<Food> findAll() {
    return persistence.findAll();
  }

  @Override
  public List<Food> findByNameStartsWithIgnoreCase(String name) {
    return persistence.findByNameStartsWithIgnoreCase(name);
  }

  @Override
  public Optional<Food> findByName(String name) {
    var optFood = persistence.findByName(name);
    if (!optFood.isPresent()) {
      throw new FoodNotFoundException(name);
    }
    return optFood;
  }

  @Override
  public Food create(Food food) {
    var optFood = persistence.findByName(food.getName());
    if (optFood.isPresent()) {
      throw new FoodDuplicatedException(food.getName());
    }
    return persistence.create(food);
  }

  @Override
  public void delete(String name) {
    var optFood = persistence.findByName(name);
    if (optFood.isEmpty()) {
      throw new FoodNotFoundException(name);
    }
    persistence.delete(optFood.get());
  }

  private float calculateCalories(float kcal, float quantidade) {
    return kcal * quantidade;
  }
}
