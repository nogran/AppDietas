package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import com.nogran.app.dietas.api.infrastructure.entity.FoodRegistryEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRegistryRepository extends JpaRepository<FoodRegistryEntity, Long> {

  Optional<FoodRegistryEntity> findById(Long id);

  @Query(value = "select r from FoodRegistryEntity r where r.food.name = ?1")
  Optional<FoodRegistryEntity> findByFoodName(String foodName);

  List<FoodRegistryEntity> findByReferenceDate(LocalDate reference);

  FoodRegistry save(FoodRegistry foodRegistry);

  void deleteById(Long id);
}
