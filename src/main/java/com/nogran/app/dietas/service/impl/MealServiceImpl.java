package com.nogran.app.dietas.service.impl;

import static com.nogran.app.dietas.component.MacrosCalculator.getPercentage;

import com.nogran.app.dietas.component.MacrosCalculator;
import com.nogran.app.dietas.dto.MealControlDTO;
import com.nogran.app.dietas.dto.MealDTO;
import com.nogran.app.dietas.dto.MealSummaryDTO;
import com.nogran.app.dietas.enums.MacroEnum;
import com.nogran.app.dietas.mapper.MealMapper;
import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.model.Meal;
import com.nogran.app.dietas.repository.MealRepository;
import com.nogran.app.dietas.service.MealService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

  private final MealRepository mealRepository;
  private final MealMapper mealMapper;

  @Override
  public MealSummaryDTO summarize(LocalDate referenceDate) {
    List<Meal> meals = mealMapper.entityToModel(
        mealRepository.findByReferenceDate(referenceDate));

    var macros = MacrosCalculator.calculate(
        meals.stream().map(i -> i.getFood())
            .toList());

    return MealSummaryDTO.builder()
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

  @Override
  public MealControlDTO getMealControl(LocalDate referenceDate) {
    List<Meal> meals = mealMapper.entityToModel(
        mealRepository.findByReferenceDate(referenceDate));
    var foods = meals.stream().map(i -> i.getFood()).toList();
    return buildMealControlDTO(foods, referenceDate);
  }

  private MealDTO buildMealDTO(List<Food> foods, MacroEnum mealTypeEnum) {
    return MealDTO.builder()
        .foods(foods)
        .mealTypeEnum(mealTypeEnum)
        .macrosDTO(MacrosCalculator.calculate(foods))
        .build();
  }

  private List<MealDTO> buildMealDTOs(List<Food> foods) {
    List<MealDTO> mealDTOs = new ArrayList<>();

    for (MacroEnum mealTypeEnum : MacroEnum.values()) {
      mealDTOs.add(buildMealDTO(foods, mealTypeEnum));
    }

    return mealDTOs;
  }

  private MealControlDTO buildMealControlDTO(List<Food> foods, LocalDate referenceDate) {

    //user
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
            getPercentage(userCarbohydrateTarget, carbohydrate.isEmpty() ? carbohydrate.get() : 0F))
        .proteinPercentage(
            getPercentage(userProteinTarget, protein.isEmpty() ? protein.get() : 0F))
        .fatPercentage(
            getPercentage(userFatTarget, fat.isEmpty() ? fat.get() : 0F))
        .build();
  }

}
