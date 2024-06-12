package com.nogran.app.dietas.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder
public class MealControlDTO {

  private List<MealDTO> mealDTOs;
  private LocalDate referenceDate;
  private float carbohydratePercentage;
  private float proteinPercentage;
  private float fatPercentage;

}
