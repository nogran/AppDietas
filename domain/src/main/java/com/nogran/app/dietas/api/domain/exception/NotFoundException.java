package com.nogran.app.dietas.api.domain.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(String.format("NotFound[404]: %s", message));
  }
}
