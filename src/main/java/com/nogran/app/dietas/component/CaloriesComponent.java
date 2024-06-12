package com.nogran.app.dietas.component;

import com.nogran.app.dietas.model.Meal;
import java.util.List;

public class CaloriesComponent {

  private CaloriesComponent() {

  }

  public static float calculateDailyCalories(List<Meal> meals) {
    float total = 0;
    for (Meal m : meals) {
      total = total + m.getFood().getTotalCalories();
    }
    return total;
  }

}
