package com.nogran.app.dietas.api.application.controller.v1;

import com.nogran.app.dietas.api.application.dto.request.AuthRequestDTO;
import com.nogran.app.dietas.api.application.dto.request.CreateUserRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.AccessResponseDTO;
import com.nogran.app.dietas.api.application.dto.response.UserResponseDTO;
import com.nogran.app.dietas.api.application.mapper.AuthMapper;
import com.nogran.app.dietas.api.application.mapper.UserMapper;
import com.nogran.app.dietas.api.domain.service.AuthService;
import com.nogran.app.dietas.api.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  private final AuthMapper authMapper;

  public static final String PATH = "/auth";

  @GetMapping(value = "/verification/{uuid}")
  public ResponseEntity userVerify(@PathVariable("uuid") String uuid) {
    userService.verify(uuid);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/login")
  public ResponseEntity<AccessResponseDTO> login(
      @Valid @RequestBody AuthRequestDTO requestDTO) {
    log.info("login[{}]", requestDTO.getUsername());
    return ResponseEntity.ok(authMapper.toResponse(
        service.login(
            authMapper.createRequestToDomain(requestDTO))));
  }

  @PostMapping("/signup")
  public ResponseEntity<UserResponseDTO> create(
      @Valid @RequestBody CreateUserRequestDTO requestDTO) {
    log.info("create user[{}]", requestDTO.getUsername());
    return ResponseEntity.ok(mapper.toResponse(
        userService.save(mapper.createRequestToDomain(requestDTO))));
  }

}
