package com.nogran.app.dietas.api.domain.dto;

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
public class CreateFoodRegistryDTO {

  private String username;
  private String foodName;
  private float grams;
  private MealEnum mealEnum;
  private LocalDate referenceDate;

}
