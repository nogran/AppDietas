package com.nogran.app.dietas.api.domain.exception;

public class UsernameDuplicatedException extends BadRequestException {

  public UsernameDuplicatedException() {
    super(String.format("UsernameDuplicated[400]"));
  }
}
