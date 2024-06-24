package com.nogran.app.dietas.api.domain.dto;

import lombok.Data;

@Data
public class FoodDTO {

  private String name;

  private String company;

  private MacrosDTO macrosDTO;

  private float grams;

  private float totalCalories;

}
