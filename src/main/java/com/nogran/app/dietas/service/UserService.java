package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.User;

public interface UserService {

  User login(String email, String password);

}
