package com.nogran.app.dietas.service;

import com.nogran.app.dietas.dto.AccessDTO;
import com.nogran.app.dietas.dto.UserDTO;

public interface AuthService {

  AccessDTO login(UserDTO userDTO);

}
