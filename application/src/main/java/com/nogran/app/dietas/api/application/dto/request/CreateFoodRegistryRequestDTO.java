package com.nogran.app.dietas.api.application.dto.request;

import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CreateFoodRegistryRequestDTO {

  @NotNull
  private String foodName;

  @NotNull
  private LocalDate referenceDate;

  @NotNull
  private float grams;

  @NotNull
  private MealEnum mealEnum;

}
