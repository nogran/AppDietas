package com.nogran.app.dietas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Food {

    private String name;

    private String company;

    private float grams;

    private float carbohydrate;

    private float protein;

    private float fat;

    private float totalCalories;
}
