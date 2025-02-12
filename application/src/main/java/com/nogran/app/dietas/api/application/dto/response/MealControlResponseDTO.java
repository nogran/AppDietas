package com.nogran.app.dietas.api.application.dto.response;

import com.nogran.app.dietas.api.domain.dto.MealDTO;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class MealControlResponseDTO {

  private List<MealDTO> mealDTOs;
  private LocalDate referenceDate;
  private float carbohydratePercentage;
  private float proteinPercentage;
  private float fatPercentage;
}
