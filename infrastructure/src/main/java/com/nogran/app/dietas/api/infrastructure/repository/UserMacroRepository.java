package com.nogran.app.dietas.api.infrastructure.repository;

import com.nogran.app.dietas.api.infrastructure.entity.UserMacroEntity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMacroRepository extends JpaRepository<UserMacroEntity, Long> {

  UserMacroEntity save(UserMacroEntity userMacroEntity);

  UserMacroEntity findByReferenceDate(LocalDate referencceDate);

}
