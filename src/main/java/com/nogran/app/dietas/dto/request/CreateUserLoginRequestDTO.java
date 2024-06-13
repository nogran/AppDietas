package com.nogran.app.dietas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserLoginRequestDTO {

  private String name;
  private String email;
  private String password;

}
