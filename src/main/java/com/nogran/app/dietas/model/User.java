package com.nogran.app.dietas.model;

import com.nogran.app.dietas.entity.enums.UserStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private String name;
  private String username;
  private String email;
  private String password;
  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private UserStatus status;

}
