package com.nogran.app.dietas.api.application.controller.v1;

import com.nogran.app.dietas.api.application.dto.request.CreateFoodRegistryRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodRegistryResponseDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodRegistrySummaryResponseDTO;
import com.nogran.app.dietas.api.application.mapper.FoodRegistryMapper;
import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import com.nogran.app.dietas.api.domain.service.FoodRegistryService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = FoodRegistryController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class FoodRegistryController {

  private final FoodRegistryService service;
  private final FoodRegistryMapper mapper;

  public static final String PATH = "/v1/registry";

  @PostMapping
  public ResponseEntity<FoodRegistryResponseDTO> create(
      @Valid @RequestBody CreateFoodRegistryRequestDTO requestDTO) {
    log.info("create food registry[{}]", requestDTO);
    return ResponseEntity.ok(
        mapper.toResponse(service.create(mapper.createRequestToDomain(requestDTO))));
  }

  @GetMapping("/{referenceDate}")
  public ResponseEntity<List<FoodRegistryResponseDTO>> findByReferenceDate(
      @RequestParam LocalDate referenceDate) {
    log.info("findByReferenceDate[{}]", referenceDate);
    return ResponseEntity.ok(mapper.toResponse(service.findByReferenceDate(referenceDate)));
  }

  @GetMapping("/summary/{referenceDate}")
  public ResponseEntity<FoodRegistrySummaryResponseDTO> summary(
      @RequestParam LocalDate referenceDate) {
    log.info("summaryByReferenceDate[{}]", referenceDate);
    return ResponseEntity.ok(mapper.toResponse(service.summary(referenceDate)));
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(@RequestParam Long id) {
    Optional<FoodRegistry> foodOpt = service.findById(id);
    log.info("delete[{}]", foodOpt);
    if (foodOpt.isPresent()) {
      service.deleteById(foodOpt.get().getId());
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
