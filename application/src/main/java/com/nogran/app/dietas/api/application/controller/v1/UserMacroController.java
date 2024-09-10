package com.nogran.app.dietas.api.application.controller.v1;

import com.nogran.app.dietas.api.application.dto.request.UserMacroRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.UserMacroResponseDTO;
import com.nogran.app.dietas.api.application.mapper.UserMacroMapper;
import com.nogran.app.dietas.api.domain.service.UserMacroService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = UserMacroController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserMacroController {

  private final UserMacroService service;
  private final UserMacroMapper mapper;

  public static final String PATH = "/v1/macros";

  @GetMapping
  public ResponseEntity<List<UserMacroResponseDTO>> findAll() {
    log.info("findAll user macros");
    return ResponseEntity.ok(mapper.toResponse(service.findAll()));
  }

  @PostMapping
  public ResponseEntity<UserMacroResponseDTO> create(
      @Valid @RequestBody UserMacroRequestDTO requestDTO) {
    log.info("create user macros[{}]", requestDTO);
    return ResponseEntity.ok(
        mapper.toResponse(service.save(mapper.createRequestToDomain(requestDTO))));
  }

  @PutMapping
  public ResponseEntity<UserMacroResponseDTO> update(
      @Valid @RequestBody UserMacroRequestDTO requestDTO) {
    log.info("update user macros[{}]", requestDTO);
    return ResponseEntity.ok(
        mapper.toResponse(service.update(mapper.createRequestToDomain(requestDTO))));
  }

  @DeleteMapping("/{name}")
  public ResponseEntity<Void> delete(@PathVariable LocalDate referenceDate) {
    log.info("delete user macros[{}]", referenceDate);
    service.delete(referenceDate);
    return ResponseEntity.noContent().build();
  }
}
