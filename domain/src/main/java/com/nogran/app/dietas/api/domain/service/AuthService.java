package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.dto.AccessDTO;
import com.nogran.app.dietas.api.domain.dto.AuthenticationDTO;

public interface AuthService {

  AccessDTO login(AuthenticationDTO authDTO);

}
