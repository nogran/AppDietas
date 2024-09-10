package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.model.UserMacro;
import com.nogran.app.dietas.api.domain.persistence.UserMacroPersistence;
import com.nogran.app.dietas.api.domain.service.UserMacroService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMacroImpl implements UserMacroService {

  private final UserMacroPersistence persistence;

  public List<UserMacro> findAll() {
    return persistence.findAll();
  }

  public UserMacro save(UserMacro userMacro) {
    return persistence.save(userMacro);
  }

  public UserMacro update(UserMacro userMacro) {
    return persistence.save(userMacro);
  }

  public void delete(LocalDate referenceDate) {
    var entity = persistence.findByReferenceDate(referenceDate);
    persistence.delete(entity);
  }

}
