package com.nogran.app.dietas.api.application.dto.request;

import com.nogran.app.dietas.api.domain.dto.enums.MacroEnum;
import com.nogran.app.dietas.api.domain.model.Food;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class CreateMealRequestDTO {

  @NotNull
  private List<Food> food;

  @NotNull
  private MacroEnum mealType;

  @NotNull
  private LocalDate referenceDate;

}
