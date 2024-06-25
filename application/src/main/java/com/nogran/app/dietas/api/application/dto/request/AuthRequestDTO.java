package com.nogran.app.dietas.api.application.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequestDTO {

  @NotNull
  private String username;

  @NotNull
  private String password;

}
