package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.infrastructure.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByLogin(String login);

  User findByEmail(String email);

}
