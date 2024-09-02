package com.nogran.app.dietas.api.domain.exception;

public class UsernameNotFoundException extends NotFoundException {

  public UsernameNotFoundException() {
    super(String.format("UsernameNotFound[404]"));
  }
}
