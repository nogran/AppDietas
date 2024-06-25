package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import java.util.Optional;

public interface UserVerificationPersistence {

  UserVerification save(UserVerification userVerification);

  Optional<UserVerification> findByLogin(String username);

}
