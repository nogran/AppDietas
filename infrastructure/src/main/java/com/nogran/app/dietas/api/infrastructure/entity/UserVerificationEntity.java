package com.nogran.app.dietas.api.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ngr_user_verification", catalog = "ngr_user_verification")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class UserVerificationEntity {

  @Id
  @SequenceGenerator(name = "ngr_user_verification_seq", sequenceName = "ngr_user_verification_seq", allocationSize = 1)
  @GeneratedValue(generator = "ngr_user_verification_seq")
  private Long id;

  @Column(name = "uuid", nullable = false)
  private UUID uuid;

  @CreatedBy
  @Column(name = "created_by", updatable = false)
  private String createdBy;

  @Column(name = "expiration_date", nullable = false)
  private Instant expirationDate;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @LastModifiedBy
  @Column(name = "updated_by")
  private String updatedBy;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
  private UserEntity user;
}
