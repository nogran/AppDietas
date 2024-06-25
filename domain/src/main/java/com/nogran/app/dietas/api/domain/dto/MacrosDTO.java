package com.nogran.app.dietas.api.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MacrosDTO {

  private float carbohydrate;
  private float protein;
  private float fat;
  private float totalCalories;

}
