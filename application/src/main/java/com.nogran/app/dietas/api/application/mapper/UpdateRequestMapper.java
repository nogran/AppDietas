package com.nogran.app.dietas.api.application.mapper;

public interface UpdateRequestMapper<D, U> {
  D updateRequestToDomain(U updateDto);

  U domainToUpdateRequest(D model);
}
