package com.nogran.app.dietas.service;

import com.nogran.app.dietas.dto.MealControlDTO;
import com.nogran.app.dietas.dto.MealSummaryDTO;
import java.time.LocalDate;

public interface MealService {

  MealSummaryDTO summarize(LocalDate referenceDate);

  MealControlDTO getMealControl(LocalDate referenceDate);

}
