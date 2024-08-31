package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import java.util.Optional;
import java.util.UUID;

public interface UserVerificationPersistence {

  UserVerification save(UserVerification userVerification);

  Optional<UserVerification> findByUuid(UUID uuid);

  void delete(UserVerification userVerification);

}
