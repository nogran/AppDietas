package com.nogran.app.dietas.dto.request;

import com.nogran.app.dietas.enums.MacroEnum;
import com.nogran.app.dietas.model.Food;
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
