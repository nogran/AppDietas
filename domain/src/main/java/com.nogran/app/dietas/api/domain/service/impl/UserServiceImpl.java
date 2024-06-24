package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.dto.enums.UserStatus;
import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.domain.persistence.UserPersistence;
import com.nogran.app.dietas.api.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserPersistence persistence;
  private final PasswordEncoder passwordEncoder;

  public User save(User user) {
    user.setStatus(UserStatus.PENDING);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return persistence.save(user);
  }
}
