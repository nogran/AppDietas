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

  private UUID uuid;
  private Instant expirationDate;
  private User user;
  private String createdBy;
  private OffsetDateTime createdAt;

}
