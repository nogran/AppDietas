package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.infrastructure.entity.MealEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {

  List<MealEntity> findByReferenceDate(LocalDate referenceDate);

}
