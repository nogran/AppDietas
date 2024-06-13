package com.nogran.app.dietas.entity;

import com.nogran.app.dietas.enums.MacroEnum;
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
@Table(name = "meal", catalog = "meal")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class MealEntity {

  @Id
  @SequenceGenerator(name = "meal_seq", sequenceName = "meal_seq", allocationSize = 1)
  @GeneratedValue(generator = "meal_seq")
  private Long id;

  @Column(name = "name")
  @Enumerated(EnumType.STRING)
  private MacroEnum mealType;

  @Column(name = "reference_date")
  private LocalDate referenceDate;

  @Column(name = "food_id")
  private Long foodId;

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
