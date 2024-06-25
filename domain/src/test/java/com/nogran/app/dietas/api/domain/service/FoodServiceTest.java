package com.nogran.app.dietas.api.domain.service;

import com.nogran.app.dietas.api.domain.persistence.FoodPersistence;
import com.nogran.app.dietas.api.domain.service.impl.FoodServiceImpl;
import com.nogran.app.dietas.api.domain.fixture.FoodFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

  @Mock
  private FoodPersistence persistence;

  @InjectMocks
  private FoodServiceImpl service;

  @Test
  void findAllReturnDataAsExpected() {
    var foods = List.of(FoodFixture.newFood());
    Mockito.when(persistence.findAll()).thenReturn(new ArrayList<>());
    var result = service.findAll();

    Assertions.assertNotNull(result);
    Assertions.assertEquals(new ArrayList<>(), result);
    Mockito.verify(persistence, Mockito.times(1)).findAll();
  }

}
