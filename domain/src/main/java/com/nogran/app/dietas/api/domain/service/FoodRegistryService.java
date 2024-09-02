package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.dto.CreateFoodRegistryDTO;
import com.nogran.app.dietas.api.domain.dto.FoodRegistrySummaryDTO;
import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FoodRegistryService {

  FoodRegistry create(CreateFoodRegistryDTO createFoodRegistryDTO);

  Optional<FoodRegistry> findById(Long id);

  List<FoodRegistry> findByReferenceDate(LocalDate referenceDate);

  void deleteById(Long id);

  FoodRegistrySummaryDTO summary(LocalDate referenceDate);
}
