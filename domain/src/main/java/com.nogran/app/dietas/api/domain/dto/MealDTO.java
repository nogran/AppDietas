package com.nogran.app.dietas.api.domain.dto;

import com.nogran.app.dietas.api.domain.dto.enums.MacroEnum;
import com.nogran.app.dietas.api.domain.model.Food;
import java.util.List;
import lombok.Builder;

@Builder
public class MealDTO {

  private List<Food> foods;
  private MacroEnum mealTypeEnum;
  private MacrosDTO macrosDTO;

}
