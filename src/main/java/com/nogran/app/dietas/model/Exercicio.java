package com.nogran.app.dietas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exercicio {
  private Atividade atividade;
  private int tempo;
  private double caloria;
}
