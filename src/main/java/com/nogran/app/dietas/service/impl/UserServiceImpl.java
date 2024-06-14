package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.mapper.UserMapper;
import com.nogran.app.dietas.model.User;
import com.nogran.app.dietas.repository.UserRepository;
import com.nogran.app.dietas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;
  private final PasswordEncoder passwordEncoder;

  public User save(User user) {
    var entity = mapper.modelToEntity(user);
    entity.setPassword(passwordEncoder.encode(user.getPassword()));
    return mapper.entityToModel(
        repository.save(entity));
  }
}
