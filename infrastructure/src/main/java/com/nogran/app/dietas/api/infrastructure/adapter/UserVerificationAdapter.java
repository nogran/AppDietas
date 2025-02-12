package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.domain.persistence.UserVerificationPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.UserVerificationEntityMapper;
import com.nogran.app.dietas.api.infrastructure.repository.UserVerificationRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserVerificationAdapter implements UserVerificationPersistence {

  private final UserVerificationRepository repository;
  private final UserVerificationEntityMapper mapper;

  @Override
  public UserVerification save(UserVerification userVerification) {
    var entity = mapper.toEntity(userVerification);
    return mapper.toDomain(
        repository.save(entity));
  }

  @Override
  public Optional<UserVerification> findByUuid(UUID uuid) {
    var entity = repository.findByUuid(uuid);
    return Optional.ofNullable(mapper.toDomain(entity.get()));
  }

  @Override
  public void delete(UserVerification userVerification) {
    var entity = mapper.toEntity(userVerification);
    repository.delete(entity);
  }

}
