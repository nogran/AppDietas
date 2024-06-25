package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.domain.persistence.UserVerificationPersistence;
import com.nogran.app.dietas.api.domain.service.UserVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserVerificationServiceImpl implements UserVerificationService {

  private final UserVerificationPersistence persistence;

  @Override
  public UserVerification save(UserVerification userVerification) {
    return persistence.save(userVerification);
  }
}
