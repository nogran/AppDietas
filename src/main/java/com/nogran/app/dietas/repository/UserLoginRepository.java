package com.nogran.app.dietas.repository;

import com.nogran.app.dietas.entity.UserLoginEntity;
import com.nogran.app.dietas.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long> {

  UserLogin findByEmailAndPassword(String email, String password);

  UserLogin findByEmail(String email);

}
