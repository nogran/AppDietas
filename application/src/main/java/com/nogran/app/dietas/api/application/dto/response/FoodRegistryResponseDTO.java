package com.nogran.app.dietas.api.application.dto.response;

import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import com.nogran.app.dietas.api.domain.model.Food;
import java.time.LocalDate;
import lombok.Data;

@Data
public class FoodRegistryResponseDTO {

  private Long id;
  private Food food;
  private float grams;
  private MealEnum mealEnum;
  private LocalDate referenceDate;
}
