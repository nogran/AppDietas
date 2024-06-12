package com.nogran.app.dietas.service.impl;

import static com.nogran.app.dietas.component.MacrosCalculatorComponent.getPercentage;

import com.nogran.app.dietas.component.MacrosCalculatorComponent;
import com.nogran.app.dietas.dto.MealControlDTO;
import com.nogran.app.dietas.dto.MealDTO;
import com.nogran.app.dietas.dto.MealSummaryDTO;
import com.nogran.app.dietas.enums.MacroEnum;
import com.nogran.app.dietas.mapper.MealMapper;
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

    var macros = MacrosCalculatorComponent.calculate(meals);

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
    return buildMealControlDTO(meals, referenceDate);
  }

  private MealDTO buildMealDTO(List<Meal> meals, MacroEnum mealTypeEnum) {
    return MealDTO.builder()
        .foods(meals.stream().map(i -> i.getFood()).toList())
        .mealTypeEnum(mealTypeEnum)
        .macrosDTO(MacrosCalculatorComponent.calculate(meals))
        .build();
  }

  private List<MealDTO> buildMealDTOs(List<Meal> meals) {
    List<MealDTO> mealDTOs = new ArrayList<>();

    for (MacroEnum mealTypeEnum : MacroEnum.values()) {
      mealDTOs.add(buildMealDTO(meals, mealTypeEnum));
    }

    return mealDTOs;
  }

  private MealControlDTO buildMealControlDTO(List<Meal> meals, LocalDate referenceDate) {

    //user
    var userCarbohydrateTarget = 10F;
    var userProteinTarget = 30F;
    var userFatTarget = 20F;

    var carbohydrate = meals.stream()
        .map(i -> i.getFood().getCarbohydrate())
        .reduce(Float::sum);
    var protein = meals.stream()
        .map(i -> i.getFood().getProtein())
        .reduce(Float::sum);
    var fat = meals.stream()
        .map(i -> i.getFood().getFat())
        .reduce(Float::sum);

    return MealControlDTO.builder()
        .mealDTOs(buildMealDTOs(meals))
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
