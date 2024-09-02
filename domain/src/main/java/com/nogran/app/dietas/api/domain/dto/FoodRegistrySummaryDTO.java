package com.nogran.app.dietas.api.domain.dto;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public class FoodRegistrySummaryDTO {

  private float totalCarbohydrate;
  private float totalProtein;
  private float totalFat;
  private float totalCalories;
  private float carbohydratePercentage;
  private float proteinPercentage;
  private float fatPercentage;
  private float totalCaloriesPercentage;
  private LocalDate referenceDate;
}
