package com.nogran.app.dietas.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = Shape.OBJECT)
public enum UserStatus {

  ACTIVE("A", "Ativo"),
  INACTIVE("I", "Inativo"),
  PENDING("P", "Pendente");

  private String codigo;
  private String descricao;

  private UserStatus(String codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  @JsonValue
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @JsonCreator
  public static UserStatus fromCode(String code) {
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
