package com.nogran.app.dietas.component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetabolismCalculatorComponent {

  private MetabolismCalculatorComponent() {

  }

  public static float calculate(
      LocalDate dataNascimento, String gender, float height, float weight) {
    int age = getAge(dataNascimento);

    int coeficiente = 0;
    if (gender.equals('M')) {
      coeficiente = 5;
    } else if (gender.equals("F")) {
      coeficiente = -161;
    }
    return (10 * weight) * 6.25F * height - (5 * age) + coeficiente;
  }

  private static Integer getAge(LocalDate date) {
    Calendar cal = GregorianCalendar.getInstance();
    int currentYear = cal.get(Calendar.YEAR);
    int age = currentYear - date.getYear(); // Calcula a idade apenas com os anos
    int currentDay = cal.get(Calendar.DAY_OF_MONTH);
    int currentMonth = cal.get(Calendar.MONTH);

    if (date.getDayOfMonth() >= currentDay && date.getMonth().getValue() >= currentMonth) {
      age--;
    }
    return age;
  }

}
