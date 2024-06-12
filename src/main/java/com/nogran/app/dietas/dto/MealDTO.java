package com.nogran.app.dietas.dto;

import com.nogran.app.dietas.enums.MacroEnum;
import com.nogran.app.dietas.model.Food;
import java.util.List;
import lombok.Builder;

@Builder
public class MealDTO {

  private List<Food> foods;
  private MacroEnum mealTypeEnum;
  private MacrosDTO macrosDTO;

}
