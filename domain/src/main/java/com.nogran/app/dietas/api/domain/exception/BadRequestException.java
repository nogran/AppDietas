package com.nogran.app.dietas.api.domain.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(String.format("BadResquest[400]: %s", message));
  }
}
