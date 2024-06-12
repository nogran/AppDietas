package com.nogran.app.dietas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nogran.app.dietas.fixture.FoodFixture;
import com.nogran.app.dietas.mapper.FoodMapper;
import com.nogran.app.dietas.repository.FoodRepository;
import com.nogran.app.dietas.service.impl.FoodServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

  @Mock
  private FoodMapper mapper;

  @Mock
  private FoodRepository repository;

  @InjectMocks
  private FoodServiceImpl service;

  @Test
  void findAllReturnDataAsExpected() {
    var foods = List.of(FoodFixture.newFood());
    when(repository.findAll()).thenReturn(new ArrayList<>());
    var result = service.findAll();

    assertNotNull(result);
    assertEquals(new ArrayList<>(), result);
    verify(repository, times(1)).findAll();
  }

}
