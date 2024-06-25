package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.User;
import java.util.Optional;

public interface UserPersistence {

  User save(User user);

  Optional<User> findByLogin(String username);

}
