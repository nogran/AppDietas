package com.nogran.app.dietas.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationDTO {

  private String username;
  private String password;

}
