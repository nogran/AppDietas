package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.infrastructure.entity.UserVerificationEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerificationRepository extends JpaRepository<UserVerificationEntity, Long> {

  Optional<UserVerificationEntity> findByUuid(UUID uuid);
}
