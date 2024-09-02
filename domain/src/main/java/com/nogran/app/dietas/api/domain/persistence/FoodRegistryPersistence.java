package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FoodRegistryPersistence {

  FoodRegistry create(FoodRegistry foodRegistry);

  Optional<FoodRegistry> findById(Long id);

  List<FoodRegistry> findByReferenceDate(LocalDate referenceDate);

  void deleteById(Long id);

}
