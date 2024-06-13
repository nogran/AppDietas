package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.mapper.UserLoginMapper;
import com.nogran.app.dietas.model.UserLogin;
import com.nogran.app.dietas.repository.UserLoginRepository;
import com.nogran.app.dietas.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserLoginRepository repository;

  private final UserLoginMapper mapper;

  public UserLogin save(UserLogin userLogin) {
    return mapper.entityToModel(
        repository.save(mapper.modelToEntity(userLogin)));
  }

  public UserLogin login(String email, String password) {
    return repository.findByEmailAndPassword(email, password);
  }

  public UserLogin findByEmail(String email) {
    return repository.findByEmail(email);
  }

}
