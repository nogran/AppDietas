package com.nogran.app.dietas.api.domain.exception;

public class EmailDuplicatedException extends BadRequestException {

  public EmailDuplicatedException() {
    super(String.format("EmailDuplicated[400]"));
  }
}
