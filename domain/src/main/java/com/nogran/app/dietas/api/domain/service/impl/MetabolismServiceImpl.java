package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.dto.enums.GenderEnum;
import com.nogran.app.dietas.api.domain.service.MetabolismService;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MetabolismServiceImpl implements MetabolismService {

  private static final int MALE_VALUE_HARRIS_BENEDICT = 5;
  private static final int FEMALE_VALUE_HARRIS_BENEDICT = -161;
  private static final int NOT_INFORMED_VALUE_HARRIS_BENEDICT = -80;

  public Float harrisBenedictCalculator(
      LocalDate bornDate, GenderEnum genderEnum, float height, float weight) {
    int age = getAge(bornDate);
    int coeficiente = 0;

    if (genderEnum.equals(GenderEnum.MALE)) {
      coeficiente = MALE_VALUE_HARRIS_BENEDICT;
    } else if (genderEnum.equals(GenderEnum.FEMALE)) {
      coeficiente = FEMALE_VALUE_HARRIS_BENEDICT;
    } else {
      coeficiente = NOT_INFORMED_VALUE_HARRIS_BENEDICT;
    }
    return (10 * weight) * (6.25F * height) - (5 * age) + coeficiente;
  }

  private static Integer getAge(LocalDate date) {
    Calendar cal = GregorianCalendar.getInstance();
    int currentYear = cal.get(Calendar.YEAR);
    int age = currentYear - date.getYear();
    int currentDay = cal.get(Calendar.DAY_OF_MONTH);
    int currentMonth = cal.get(Calendar.MONTH);

    if (date.getDayOfMonth() >= currentDay && date.getMonth().getValue() >= currentMonth) {
      age--;
    }
    return age;
  }

}
