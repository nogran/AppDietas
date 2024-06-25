package com.nogran.app.dietas.api.domain.model;

import com.nogran.app.dietas.api.domain.dto.enums.UserStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private Long id;
  private String name;
  private String email;
  private String login;
  private String password;
  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private UserStatus status;

}
