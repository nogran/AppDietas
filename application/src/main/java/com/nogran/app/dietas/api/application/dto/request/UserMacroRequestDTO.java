package com.nogran.app.dietas.api.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserMacroRequestDTO {

  @NotNull
  private float carbohydrateTarget;

  @NotNull
  private float proteinTarget;

  @NotNull
  private float fatTarget;

  @NotNull
  private float totalCaloriesTarget;
}
