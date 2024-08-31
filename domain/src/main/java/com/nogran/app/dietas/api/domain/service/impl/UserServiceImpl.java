package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.dto.enums.UserStatusEnum;
import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.domain.persistence.UserPersistence;
import com.nogran.app.dietas.api.domain.service.EmailService;
import com.nogran.app.dietas.api.domain.service.UserService;
import com.nogran.app.dietas.api.domain.service.UserVerificationService;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserPersistence persistence;
  private final EmailService emailService;
  private final UserVerificationService userVerificationService;
  private final PasswordEncoder passwordEncoder;

  public User save(User user) {
    user.setStatus(UserStatusEnum.PENDING);
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

  public void verify(String uuid) {

    UserVerification userVerification =
        userVerificationService.findByUuid(UUID.fromString(uuid)).get();

    if (userVerification != null) {
      if (userVerification.getExpirationDate().compareTo(Instant.now()) >= 0) {

        var user = userVerification.getUser();
        user.setStatus(UserStatusEnum.ACTIVE);
        persistence.save(user);
        log.info("User verified");
      } else {
        userVerificationService.delete(userVerification);
        log.info("User verified");
      }
    } else {
      log.info("User not found");
    }

  }
}
