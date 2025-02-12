package com.nogran.app.dietas.api.domain.exception;

public class FoodNotFoundException extends NotFoundException {
  public FoodNotFoundException(String name) {
    super(String.format("FoodNotFound[404]: [%s]", name));
  }
}
