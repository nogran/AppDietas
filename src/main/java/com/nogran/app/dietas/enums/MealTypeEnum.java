package com.nogran.app.dietas.enums;

import com.nogran.app.dietas.exception.GoalNotFoundException;

public enum MealTypeEnum {
  BREAKFAST("Cafe da Manha"),
  LUNCH("Almoco"),
  SNACK("Lanche"),
  DINNER("Jantar"),
  SUPPER("Ceia");

  private final String type;

  MealTypeEnum(String type) {
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
