package com.nogran.app.dietas.api.infrastructure.adapter;

import com.nogran.app.dietas.api.domain.model.UserMacro;
import com.nogran.app.dietas.api.domain.persistence.UserMacroPersistence;
import com.nogran.app.dietas.api.infrastructure.mapper.UserMacroEntityMapper;
import com.nogran.app.dietas.api.infrastructure.repository.UserMacroRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMacroAdapter implements UserMacroPersistence {

  private final UserMacroRepository repository;
  private final UserMacroEntityMapper mapper;

  @Override
  public List<UserMacro> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  public UserMacro findByReferenceDate(LocalDate referenceDate) {
    return mapper.toDomain(repository.findByReferenceDate(referenceDate));
  }

  @Override
  public UserMacro save(UserMacro userMacro) {
    var entity = mapper.toEntity(userMacro);
    return mapper.toDomain(repository.save(entity));
  }

  @Override
  public void delete(UserMacro userMacro) {
    var entity = mapper.toEntity(userMacro);
    repository.delete(entity);
  }

}
