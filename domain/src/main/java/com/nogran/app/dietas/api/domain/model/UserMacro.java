package com.nogran.app.dietas.api.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserMacro {

  private Long id;
  private Float carbohydrateTarget;
  private Float proteinTarget;
  private Float fatTarget;
  private Float targetCalories;
  private LocalDate referenceDate;

}
