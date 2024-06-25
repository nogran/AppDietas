package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.Meal;
import java.time.LocalDate;
import java.util.List;

public interface MealPersistence {

  List<Meal> findByReferenceDate(LocalDate referenceDate);
}
