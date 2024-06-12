package com.nogran.app.dietas.component;

import com.nogran.app.dietas.dto.MacrosDTO;
import com.nogran.app.dietas.model.Meal;
import java.util.List;

public class MacrosCalculatorComponent {

  private MacrosCalculatorComponent() {

  }

  public static MacrosDTO calculate(List<Meal> meals) {
    var totalCalories = CaloriesComponent.calculateDailyCalories(meals);
    var totalCarbohydrate = sum(meals.stream().map(i -> i.getFood().getCarbohydrate()).toList());
    var totalProtein = sum(meals.stream().map(i -> i.getFood().getProtein()).toList());
    var totalFat = sum(meals.stream().map(i -> i.getFood().getFat()).toList());

    return MacrosDTO.builder()
        .carbohydrate(totalCarbohydrate)
        .protein(totalProtein)
        .fat(totalFat)
        .totalCalories(totalCalories)
        .build();
  }

  private static float sum(List<Float> grams) {
    return grams.stream().reduce(0F, Float::sum);
  }

  public static float getPercentage(Float userTarget, Float totalCalories) {
    return (totalCalories / userTarget) * 100;
  }

}
