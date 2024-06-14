package com.nogran.app.dietas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequestDTO {

  @NotNull
  private String name;

  @NotNull
  private String username;

  @NotNull
  private String email;

  @NotNull
  private String password;

}
