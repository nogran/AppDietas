package com.nogran.app.dietas.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
  private String nome;
  private String email;
  private LocalDate dataNascimento;
  private float peso;
  private int altura;
  private String sexo;
  private String objetivo;
  private float metabolismoBasal;
  private List<DiarioExercicio> diarioExercicios;
  private List<Refeicao> refeicoes;
  private LocalDate dataCriacao;
}
