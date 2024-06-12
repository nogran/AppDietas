package com.nogran.app.dietas.model;

import com.nogran.app.dietas.enums.MacroEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {

  private Food food;
  private MacroEnum mealType;
  private LocalDate referenceDate;

}
