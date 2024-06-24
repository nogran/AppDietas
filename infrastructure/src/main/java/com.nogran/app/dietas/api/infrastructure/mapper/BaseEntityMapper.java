package com.nogran.app.dietas.api.infrastructure.mapper;

import java.util.List;

public interface BaseEntityMapper<D, E> {

  E toEntity(D model);

  List<E> toEntity(List<D> models);
}
