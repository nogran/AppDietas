package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.model.User;

public interface UserService {

  User save(User user);

  User findByUsername(String username);

  void verify(String uuid);

}
