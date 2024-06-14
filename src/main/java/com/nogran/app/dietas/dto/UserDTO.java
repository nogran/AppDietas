package com.nogran.app.dietas.dto;

import com.nogran.app.dietas.model.Metabolism;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

  private String name;
  private String email;
  private String username;
  private String password;

  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private String goal;
  private Metabolism metabolism;

}
