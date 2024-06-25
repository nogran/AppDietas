package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.infrastructure.entity.UserVerificationEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerificationRepository extends JpaRepository<UserVerificationEntity, Long> {

  Optional<UserVerificationEntity> findByUserLogin(String login);
}
