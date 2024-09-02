package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.component.MacrosCalculator;
import com.nogran.app.dietas.api.domain.dto.CreateFoodRegistryDTO;
import com.nogran.app.dietas.api.domain.dto.FoodRegistrySummaryDTO;
import com.nogran.app.dietas.api.domain.dto.MealControlDTO;
import com.nogran.app.dietas.api.domain.dto.MealDTO;
import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import com.nogran.app.dietas.api.domain.model.Food;
import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.domain.persistence.FoodRegistryPersistence;
import com.nogran.app.dietas.api.domain.service.FoodRegistryService;
import com.nogran.app.dietas.api.domain.service.FoodService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodRegistryServiceImpl implements FoodRegistryService {

  private final FoodRegistryPersistence persistence;
  private final FoodService foodService;

  @Override
  public List<FoodRegistry> findByReferenceDate(LocalDate referenceDate) {
    return persistence.findByReferenceDate(referenceDate);
  }

  @Override
  public FoodRegistry create(CreateFoodRegistryDTO createFoodRegistryDTO) {

    var food = foodService.findByName(createFoodRegistryDTO.getFoodName());

    var foodRegistry = FoodRegistry.builder()
        .food(food.get())
        .user(new User())
        .grams(createFoodRegistryDTO.getGrams())
        .mealEnum(createFoodRegistryDTO.getMealEnum())
        .referenceDate(createFoodRegistryDTO.getReferenceDate())
        .build();

    return persistence.create(foodRegistry);
  }

  @Override
  public Optional<FoodRegistry> findById(Long id) {
    return persistence.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    persistence.deleteById(id);
  }

  @Override
  public FoodRegistrySummaryDTO summary(LocalDate referenceDate) {
    List<FoodRegistry> foods = persistence.findByReferenceDate(referenceDate);

    var macros = MacrosCalculator.calculate(
        foods.stream()
            .map(i -> i.getFood())
            .toList());

    return FoodRegistrySummaryDTO.builder()
        .referenceDate(referenceDate)
        .totalCarbohydrate(macros.getCarbohydrate())
        .totalProtein(macros.getProtein())
        .totalFat(macros.getFat())
        .totalCalories(macros.getTotalCalories())
        .carbohydratePercentage(macros.getCarbohydrate() / 100)
        .proteinPercentage(macros.getProtein() / 100)
        .fatPercentage(macros.getFat() / 100)
        .totalCaloriesPercentage(macros.getTotalCalories() / 100)
        .build();
  }

  private MealDTO buildMealDTO(List<Food> foods, MealEnum mealEnum) {
    return MealDTO.builder()
        .foods(foods)
        .mealEnum(mealEnum)
        .macrosDTO(MacrosCalculator.calculate(foods))
        .build();
  }

  private List<MealDTO> buildMealDTOs(List<Food> foods) {
    List<MealDTO> mealDTOs = new ArrayList<>();

    for (MealEnum m : MealEnum.values()) {
      mealDTOs.add(buildMealDTO(foods, m));
    }

    return mealDTOs;
  }

  private MealControlDTO buildMealControlDTO(List<Food> foods, LocalDate referenceDate) {

    var userCarbohydrateTarget = 10F;
    var userProteinTarget = 30F;
    var userFatTarget = 20F;

    var carbohydrate = foods.stream()
        .map(i -> i.getCarbohydrate())
        .reduce(Float::sum);
    var protein = foods.stream()
        .map(i -> i.getProtein())
        .reduce(Float::sum);
    var fat = foods.stream()
        .map(i -> i.getFat())
        .reduce(Float::sum);

    return MealControlDTO.builder()
        .mealDTOs(buildMealDTOs(foods))
        .referenceDate(referenceDate)
        .carbohydratePercentage(
            MacrosCalculator.getPercentage(userCarbohydrateTarget,
                carbohydrate.isEmpty() ? carbohydrate.get() : 0F))
        .proteinPercentage(
            MacrosCalculator.getPercentage(userProteinTarget,
                protein.isEmpty() ? protein.get() : 0F))
        .fatPercentage(
            MacrosCalculator.getPercentage(userFatTarget, fat.isEmpty() ? fat.get() : 0F))
        .build();
  }

  private float calculateCalories(float kcal, float quantidade) {
    return kcal * quantidade;
  }
}
