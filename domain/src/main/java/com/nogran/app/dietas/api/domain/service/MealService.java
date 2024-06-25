package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.dto.MealControlDTO;
import com.nogran.app.dietas.api.domain.dto.MealSummaryDTO;
import java.time.LocalDate;

public interface MealService {

  MealSummaryDTO summarize(LocalDate referenceDate);

  MealControlDTO getMealControl(LocalDate referenceDate);

}
