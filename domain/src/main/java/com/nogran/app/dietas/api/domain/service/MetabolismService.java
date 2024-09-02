package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.dto.enums.GenderEnum;
import java.time.LocalDate;

public interface MetabolismService {

  Float harrisBenedictCalculator(
      LocalDate bornDate, GenderEnum genderEnum, float height, float weight);
}
