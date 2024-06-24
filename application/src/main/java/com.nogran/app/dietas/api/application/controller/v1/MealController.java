package com.nogran.app.dietas.api.application.controller.v1;

import com.nogran.app.dietas.api.application.dto.response.MealControlResponseDTO;
import com.nogran.app.dietas.api.application.dto.response.MealSummaryResponseDTO;
import com.nogran.app.dietas.api.application.mapper.MealMapper;
import com.nogran.app.dietas.api.application.mapper.MealSummaryDTOMapper;
import com.nogran.app.dietas.api.domain.service.MealService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = MealController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {

  private final MealService service;
  private final MealSummaryDTOMapper mealSummaryDTOMapper;
  private final MealMapper mapper;
  public static final String PATH = "/v1/meal";

  @GetMapping("/summary/{referenceDate}")
  public ResponseEntity<MealSummaryResponseDTO> summarize(
      @RequestParam LocalDate referenceDate) {
    log.info("summaryByReferenceDate[{}]", referenceDate);
    return ResponseEntity.ok(mealSummaryDTOMapper.toResponse(service.summarize(referenceDate)));
  }

  @GetMapping("/control/{referenceDate}")
  public ResponseEntity<MealControlResponseDTO> getMealControl(
      @RequestParam LocalDate referenceDate) {
    log.info("getMealsControl[{}]", referenceDate);
    return ResponseEntity.ok(mapper.toResponse(service.getMealControl(referenceDate)));
  }

//  @PostMapping("/{referenceDate}/{mealType}")
//  public ResponseEntity<MealSummaryResponseDTO> save(
//      @RequestBody CreateMealRequestDTO requestDTO) {
//    log.info("saveMeal | type[{}], referenceDate[{}], foods[{}]",
//        requestDTO.getMealType(), requestDTO.getReferenceDate(),
//        requestDTO.getFood().size());
//    return ResponseEntity.ok(mapper.toResponse(
//        service.save(mapper.createRequestToDomain(requestDTO))));
//  }

//  @DeleteMapping("/{foodName}/{mealTypeEnum}/{referenceDate")
//  public ResponseEntity<Void> delete(@RequestParam String foodName,
//      @RequestParam MealTypeEnum mealTypeEnum,
//      @RequestParam LocalDate referenceDate) {
//    log.info("delete | type[], foodName[{}], referenceDate[{}], ", mealTypeEnum, foodName,
//        referenceDate);
//    service.delete(name);
//    return ResponseEntity.noContent().build();
//  }
}
