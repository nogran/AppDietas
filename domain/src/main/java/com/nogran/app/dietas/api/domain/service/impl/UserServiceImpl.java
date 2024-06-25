package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.dto.enums.UserStatus;
import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.domain.persistence.UserPersistence;
import com.nogran.app.dietas.api.domain.persistence.UserVerificationPersistence;
import com.nogran.app.dietas.api.domain.service.EmailService;
import com.nogran.app.dietas.api.domain.service.UserService;
import com.nogran.app.dietas.api.domain.service.UserVerificationService;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserPersistence persistence;
  private final EmailService emailService;
  private final UserVerificationService userVerificationService;
  private final PasswordEncoder passwordEncoder;

  public User save(User user) {
    user.setStatus(UserStatus.PENDING);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    var persistenceUser = persistence.save(user);

    UserVerification userVerification = new UserVerification();
    userVerification.setUuid(UUID.randomUUID());
    userVerification.setUser(persistenceUser);
    userVerification.setExpirationDate(Instant.now().plusMillis(900000));
    var newUserVerification = userVerificationService.save(userVerification);

    emailService.send(user.getEmail(),
        "Novo usuário cadastrado",
        "Você está recebendo um email de cadastro, o número para validação é "
            + newUserVerification.getUuid());

    return persistenceUser;
  }
}
