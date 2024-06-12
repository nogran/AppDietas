package com.nogran.app.dietas.repository;

import com.nogran.app.dietas.model.User;
import com.nogran.app.dietas.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  User findByEmailAndPassword(String email, String password);

  User findByEmail(String email);

}
