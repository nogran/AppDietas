package com.nogran.app.dietas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {

  @NotNull
  private String email;

  @NotNull
  private String password;

}
