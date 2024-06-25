package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.persistence.UserPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.UserEntityMapper;
import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.infrastructure.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPersistence {

  private final UserRepository repository;
  private final UserEntityMapper mapper;

  @Override
  public User save(User user) {
    var entity = mapper.toEntity(user);
    return mapper.toDomain(
        repository.save(entity));
  }

  @Override
  public Optional<User> findByLogin(String login) {
    var entity = repository.findByLogin(login);
    return Optional.ofNullable(mapper.toDomain(entity.get()));
  }

}
