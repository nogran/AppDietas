package com.nogran.app.dietas.exception;

public class MealDuplicatedException extends BadRequestException {
  public MealDuplicatedException(String meal) {
    super(String.format("Refeicao duplicada: [%s]", meal));
  }
}
