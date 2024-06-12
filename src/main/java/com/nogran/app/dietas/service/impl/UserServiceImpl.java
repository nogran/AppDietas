package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.model.User;
import com.nogran.app.dietas.repository.UserRepository;
import com.nogran.app.dietas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public User login(String email, String password) {
    return repository.findByEmailAndPassword(email, password);
  }

  public User findByEmail(String email) {
    return repository.findByEmail(email);
  }

}
