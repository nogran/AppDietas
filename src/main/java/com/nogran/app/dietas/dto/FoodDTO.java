package com.nogran.app.dietas.dto;

import lombok.Data;

@Data
public class FoodDTO {

  private String name;

  private String company;

  private MacrosDTO macrosDTO;

  private float grams;

  private float totalCalories;

}
