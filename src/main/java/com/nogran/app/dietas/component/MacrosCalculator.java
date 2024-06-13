package com.nogran.app.dietas.component;

import com.nogran.app.dietas.dto.MacrosDTO;
import com.nogran.app.dietas.model.Food;
import java.util.List;

public class MacrosCalculator {

  private MacrosCalculator() {

  }

  public static MacrosDTO calculate(List<Food> foods) {
    var totalCalories = CaloriesComponent.sumCalories(foods);
    var totalCarbohydrate = sum(foods.stream().map(i -> i.getCarbohydrate()).toList());
    var totalProtein = sum(foods.stream().map(i -> i.getProtein()).toList());
    var totalFat = sum(foods.stream().map(i -> i.getFat()).toList());

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
