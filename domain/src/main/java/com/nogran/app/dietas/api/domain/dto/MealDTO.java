package com.nogran.app.dietas.api.domain.dto;

import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import com.nogran.app.dietas.api.domain.model.Food;
import java.util.List;
import lombok.Builder;

@Builder
public class MealDTO {

  private List<Food> foods;
  private MealEnum mealEnum;
  private MacrosDTO macrosDTO;

}
