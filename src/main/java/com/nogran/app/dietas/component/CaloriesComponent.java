package com.nogran.app.dietas.component;

import com.nogran.app.dietas.model.Food;
import java.util.List;

public class CaloriesComponent {

  private CaloriesComponent() {

  }

  public static float sumCalories(List<Food> foods) {
    return foods.stream()
        .map(i -> i.getTotalCalories())
        .reduce(Float::sum)
        .get();
  }
}
