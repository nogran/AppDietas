package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.model.UserMacro;
import java.time.LocalDate;
import java.util.List;

public interface UserMacroService {

  List<UserMacro> findAll();

  UserMacro save(UserMacro userMacro);

  UserMacro update(UserMacro userMacro);

  void delete(LocalDate localDate);

}
