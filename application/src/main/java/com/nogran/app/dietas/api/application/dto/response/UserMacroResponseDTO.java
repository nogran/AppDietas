package com.nogran.app.dietas.api.application.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserMacroResponseDTO {

  private float carbohydrateTarget;
  private float proteinTarget;
  private float fatTarget;
  private float totalCaloriesTarget;
  private LocalDate referenceDate;
}
