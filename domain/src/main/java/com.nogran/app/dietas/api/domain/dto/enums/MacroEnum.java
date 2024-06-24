package com.nogran.app.dietas.api.domain.dto.enums;

import com.nogran.app.dietas.api.domain.exception.GoalNotFoundException;

public enum MacroEnum {
  PROTEIN("Proteina"),
  FAT("Gordura"),
  CARBOHYDRATE("Carboidrato");

  private final String type;

  MacroEnum(String type) {
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
