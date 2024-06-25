package com.nogran.app.dietas.api.infrastructure.mapper;

import org.mapstruct.MappingTarget;

public interface BaseUpdateMapper<D, E> {

  void update(@MappingTarget E entity, D model);
}
