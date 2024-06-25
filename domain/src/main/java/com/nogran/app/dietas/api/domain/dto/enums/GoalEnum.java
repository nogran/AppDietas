package com.nogran.app.dietas.api.domain.dto.enums;

import com.nogran.app.dietas.api.domain.exception.GoalNotFoundException;
import java.util.Arrays;

public enum GoalEnum {
  HIPERTROFIA("Hipertrofia"),
  DEFINICAO("Definicao"),
  MANTER_PESO("Manter Peso");

  private final String type;

  GoalEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void list() {
    Arrays.stream(GoalEnum.values()).toList().forEach(i -> System.out.println(i.getType()));
  }

  public static GoalEnum getType(String type) {
    for (GoalEnum objetivo : GoalEnum.values()) {
      if (objetivo.getType().equalsIgnoreCase(type)) {
        return objetivo;
      }
    }
    throw new GoalNotFoundException(type);
  }
}
