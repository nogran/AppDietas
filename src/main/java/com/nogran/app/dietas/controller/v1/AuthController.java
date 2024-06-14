package com.nogran.app.dietas.controller.v1;

import com.nogran.app.dietas.dto.request.AuthRequestDTO;
import com.nogran.app.dietas.dto.request.CreateUserRequestDTO;
import com.nogran.app.dietas.dto.response.UserResponseDTO;
import com.nogran.app.dietas.mapper.UserMapper;
import com.nogran.app.dietas.service.AuthService;
import com.nogran.app.dietas.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = AuthController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class AuthController {

  private final AuthService service;
  private final UserService userService;
  private final UserMapper mapper;

  public static final String PATH = "/auth";

  @PostMapping("/login")
  public ResponseEntity<UserResponseDTO> login(
      @Valid @RequestBody AuthRequestDTO requestDTO) {
    log.info("login[{}]", requestDTO.getUsername());
    return ResponseEntity.ok(mapper.toResponse(
        service.login(mapper.createRequestToDomain(requestDTO))));
  }

  @PostMapping("/signup")
  public ResponseEntity<UserResponseDTO> create(
      @Valid @RequestBody CreateUserRequestDTO requestDTO) {
    log.info("create user[{}]", requestDTO.getUsername());
    return ResponseEntity.ok(mapper.toResponse(
        userService.save(mapper.createRequestToDomain(requestDTO))));
  }

}
