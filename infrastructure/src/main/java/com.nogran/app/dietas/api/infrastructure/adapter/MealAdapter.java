package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.model.Meal;
import com.nogran.app.dietas.api.domain.persistence.MealPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.MealEntityMapper;
import com.nogran.app.dietas.api.infrastructure.repository.MealRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MealAdapter implements MealPersistence {

  private final MealRepository repository;
  private final MealEntityMapper mapper;

  @Override
  public List<Meal> findByReferenceDate(LocalDate referenceDate) {
    var entity = repository.findByReferenceDate(referenceDate);
    return mapper.toDomain(entity);
  }
}
