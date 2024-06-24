package com.nogran.app.dietas.api.application.mapper;

import java.util.List;

public interface ResponseMapper<D, R> {

  R toResponse(D model);

  List<R> toResponse(List<D> models);

}
