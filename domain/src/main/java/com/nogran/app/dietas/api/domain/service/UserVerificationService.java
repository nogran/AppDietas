package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import java.util.Optional;
import java.util.UUID;

public interface UserVerificationService {

  UserVerification save(UserVerification user);

  Optional<UserVerification> findByUuid(UUID uuid);

  void delete(UserVerification userVerification);

}
