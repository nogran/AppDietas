package com.nogran.app.dietas.api.domain.dto.enums;

import com.nogran.app.dietas.api.domain.exception.GoalNotFoundException;

public enum MealEnum {
  BREAKFAST("Cafe da Manha"),
  LUNCH("Almoco"),
  SNACK("Lanche"),
  DINNER("Jantar"),
  SUPPER("Ceia");

  private final String type;

  MealEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static MacroEnum getType(String type) {
    for (MacroEnum meal : MacroEnum.values()) {
      if (meal.getType().equalsIgnoreCase(type)) {
        return meal;
      }
    }
    throw new GoalNotFoundException(type);
  }
}
