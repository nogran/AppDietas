package com.nogran.app.dietas.api.domain.model;

import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodRegistry {

  private Long id;
  private Food food;
  private User user;
  private float grams;
  private MealEnum mealEnum;
  private LocalDate referenceDate;

}
