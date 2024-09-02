package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import com.nogran.app.dietas.api.domain.persistence.FoodRegistryPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.FoodRegistryEntityMapper;
import com.nogran.app.dietas.api.infrastructure.repository.FoodRegistryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodRegistryAdapter implements FoodRegistryPersistence {

  private final FoodRegistryRepository repository;
  private final FoodRegistryEntityMapper mapper;

  @Override
  public Optional<FoodRegistry> findById(Long id) {
    var entity = repository.findById(id);
    return entity.map(mapper::toDomain);
  }

  @Override
  public List<FoodRegistry> findByReferenceDate(LocalDate referenceDate) {
    var entities = repository.findByReferenceDate(referenceDate);
    return mapper.toDomain(entities);
  }

  @Override
  public FoodRegistry create(FoodRegistry foodRegistry) {
    var entity = mapper.toEntity(foodRegistry);
    return mapper.toDomain(
        repository.save(entity));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
