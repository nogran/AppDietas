package com.nogran.app.dietas.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MealSummaryResponseDTO {

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
