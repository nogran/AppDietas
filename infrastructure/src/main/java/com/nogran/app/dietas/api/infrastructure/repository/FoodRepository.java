package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.infrastructure.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

    FoodEntity findByName(String name);

    List<FoodEntity> findByNameStartsWithIgnoreCase(String name);
}
