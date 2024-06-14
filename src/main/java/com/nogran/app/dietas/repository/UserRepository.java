package com.nogran.app.dietas.repository;

import com.nogran.app.dietas.entity.UserEntity;
import com.nogran.app.dietas.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//  Optional<UserLoginEntity> findByEmailAndPassword(String email, String password);

  Optional<UserEntity> findByLogin(String username);

  User findByEmail(String email);

}
