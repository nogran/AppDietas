package com.nogran.app.dietas.api.infrastructure.mapper;

import java.util.List;

public interface BaseDomainMapper<D, E> {

  D toDomain(E entity);

  List<D> toDomain(List<E> entities);

}
