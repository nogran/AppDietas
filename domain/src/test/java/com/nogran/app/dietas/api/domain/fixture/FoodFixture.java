package com.nogran.app.dietas.api.domain.fixture;


import com.nogran.app.dietas.api.domain.model.Food;

public class FoodFixture {

  private FoodFixture() {

  }

  public static Food newFood() {
    return Food.builder()
        .name("Test Food")
        .company("Test Company")
        .grams(10)
        .carbohydrate(10)
        .protein(10)
        .fat(10)
        .totalCalories(100)
        .build();
  }

}
