package com.nogran.app.dietas.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private String name;
  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private String goal;
  private Metabolism metabolism;

}
