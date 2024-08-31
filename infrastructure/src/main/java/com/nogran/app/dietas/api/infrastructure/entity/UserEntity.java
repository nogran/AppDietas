package com.nogran.app.dietas.api.infrastructure.entity;

import com.nogran.app.dietas.api.domain.dto.enums.UserStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ngr_user", catalog = "ngr_user")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class UserEntity {

  @Id
  @SequenceGenerator(name = "ngr_user_seq", sequenceName = "ngr_user_seq", allocationSize = 1)
  @GeneratedValue(generator = "ngr_user_seq")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "login", nullable = false, unique = true)
  private String login;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "weight")
  private float weight;

  @Column(name = "height")
  private int height;

  @Column(name = "gender")
  private String gender;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_status", nullable = false)
  private UserStatusEnum userStatusEnum;

//  @Column(name = "goal")
//  private String goal;

  @CreatedBy
  @Column(name = "created_by", nullable = false)
  private String createdBy;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @LastModifiedBy
  @Column(name = "updated_by")
  private String updatedBy;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;

}
