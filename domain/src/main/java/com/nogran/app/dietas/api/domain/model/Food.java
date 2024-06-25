package com.nogran.app.dietas.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private String name;

    private String company;

    private float grams;

    private float carbohydrate;

    private float protein;

    private float fat;

    private float totalCalories;
}
