package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.UserLogin;

public interface AuthService {

  UserLogin save(UserLogin userLogin);

  UserLogin login(String email, String password);

  UserLogin findByEmail(String email);

}
