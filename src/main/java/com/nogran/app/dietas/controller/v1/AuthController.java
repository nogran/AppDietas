package com.nogran.app.dietas.controller.v1;

import com.nogran.app.dietas.dto.request.CreateUserLoginRequestDTO;
import com.nogran.app.dietas.dto.response.UserLoginResponseDTO;
import com.nogran.app.dietas.mapper.UserLoginMapper;
import com.nogran.app.dietas.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = AuthController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

  private final AuthService service;
  private final UserLoginMapper mapper;

  public static final String PATH = "/auth";

  @PostMapping("/signup")
  public ResponseEntity<UserLoginResponseDTO> create(
      @Valid @RequestBody CreateUserLoginRequestDTO requestDTO) {
    log.info("create user[{}]", requestDTO);
    return ResponseEntity.ok(
        mapper.toResponse(service.save(mapper.createRequestToDomain(requestDTO))));
  }

}
