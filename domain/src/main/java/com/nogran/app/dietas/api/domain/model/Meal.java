package com.nogran.app.dietas.api.domain.model;

import com.nogran.app.dietas.api.domain.dto.enums.MacroEnum;
import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {

  private Food food;
  private MealEnum meal;
  private MacroEnum macro;
  private LocalDate referenceDate;

}
