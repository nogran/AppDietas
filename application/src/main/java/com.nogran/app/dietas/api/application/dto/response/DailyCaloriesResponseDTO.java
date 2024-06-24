package com.nogran.app.dietas.api.application.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DailyCaloriesResponseDTO {

  private float carbohydratePercentage;
  private float proteinPercentage;
  private float fatPercentage;
  private float dailyCalories;
  private float targetCalories;
  private LocalDate referenceDate;

}
