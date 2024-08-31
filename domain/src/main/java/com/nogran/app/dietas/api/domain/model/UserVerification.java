package com.nogran.app.dietas.api.domain.model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVerification {

  private Long id;
  private UUID uuid;
  private User user;
  private Instant expirationDate;
  private OffsetDateTime createdAt;

}
