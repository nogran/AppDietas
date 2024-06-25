package com.nogran.app.dietas.api.application.mapper;

public interface CreateRequestMapper<D, C> {
  D createRequestToDomain(C addDto);
}
