package com.nogran.app.dietas.api.infrastructure.entity;

import com.nogran.app.dietas.api.domain.dto.enums.MealEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "ngr_food_registry", catalog = "ngr_food_registry")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class FoodRegistryEntity {

  @Id
  @SequenceGenerator(name = "ngr_food_registry_seq", sequenceName = "ngr_food_registry_seq", allocationSize = 1)
  @GeneratedValue(generator = "ngr_food_registry_seq")
  private Long id;

  @Column(name = "meal")
  private MealEnum mealEnum;

  @Column(name = "grams")
  private float grams;

  @Column(name = "reference_date", nullable = false)
  private LocalDate referenceDate;

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

  @JoinColumn(name = "user_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private UserEntity user;

  @JoinColumn(name = "food_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private FoodEntity food;
}
