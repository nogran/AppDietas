package com.nogran.app.dietas.api.domain.persistence;

import com.nogran.app.dietas.api.domain.model.UserMacro;
import java.time.LocalDate;
import java.util.List;

public interface UserMacroPersistence {

  List<UserMacro> findAll();

  UserMacro findByReferenceDate(LocalDate referenceDate);

  UserMacro save(UserMacro userMacro);

  void delete(UserMacro userMacro);
}
