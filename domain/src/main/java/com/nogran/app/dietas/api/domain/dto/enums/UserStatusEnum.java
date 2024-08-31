package com.nogran.app.dietas.api.domain.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = Shape.OBJECT)
public enum UserStatusEnum {

  ACTIVE("A", "Ativo"),
  INACTIVE("I", "Inativo"),
  PENDING("P", "Pendente");

  private String code;
  private String description;

  UserStatusEnum(String code, String description) {
    this.code = code;
    this.description = description;
  }

  @JsonValue
  public String getCode() {
    return code;
  }

  @JsonCreator
  public static UserStatusEnum fromCode(String code) {
    if (code.equals("A")) {
      return ACTIVE;
    } else if (code.equals("I")) {
      return INACTIVE;
    } else if (code.equals("P")) {
      return PENDING;
    } else {
      return null;
    }
  }

}
