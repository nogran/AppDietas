package com.nogran.app.dietas.api.domain.component;

import com.nogran.app.dietas.api.domain.model.Food;
import java.util.List;

public class CaloriesCalculator {

  private CaloriesCalculator() {
  }

  public static float sum(List<Food> foods) {
    return foods.stream()
        .map(i -> i.getTotalCalories())
        .reduce(Float::sum)
        .get();
  }
}
