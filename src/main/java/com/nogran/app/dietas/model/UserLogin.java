package com.nogran.app.dietas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLogin {

  private Long id;
  private String name;
  private String email;
  private String password;

}
