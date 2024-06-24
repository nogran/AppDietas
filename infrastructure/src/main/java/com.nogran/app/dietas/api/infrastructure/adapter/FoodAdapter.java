package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.model.Food;
import com.nogran.app.dietas.api.domain.persistence.FoodPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.FoodEntityMapper;
import com.nogran.app.dietas.api.infrastructure.repository.FoodRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodAdapter implements FoodPersistence {

  private final FoodRepository repository;
  private final FoodEntityMapper mapper;

  @Override
  public List<Food> findAll() {
    var entity = repository.findAll();
    return mapper.toDomain(entity);
  }

  @Override
  public Optional<Food> findByName(String name) {
    var entity = repository.findByName(name);
    return Optional.ofNullable(mapper.toDomain(entity));
  }

  @Override
  public List<Food> findByNameStartsWithIgnoreCase(String name) {
    var entities = repository.findByNameStartsWithIgnoreCase(name);
    return mapper.toDomain(entities);
  }

  @Override
  public Food create(Food food) {
    var entity = mapper.toEntity(food);
    return mapper.toDomain(
        repository.save(entity));
  }

  @Override
  public void delete(Food food) {
    repository.delete(mapper.toEntity(food));
  }
}
