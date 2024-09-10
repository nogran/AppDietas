package com.nogran.app.dietas.api.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@Table(name = "ngr_user_macro", catalog = "ngr_user_macro")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class UserMacroEntity {

  @Id
  @SequenceGenerator(name = "ngr_user_macro_seq", sequenceName = "ngr_user_macro_seq", allocationSize = 1)
  @GeneratedValue(generator = "ngr_user_macro_seq")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "carbohydrate_target", nullable = false)
  private Float carbohydrateTarget;

  @Column(name = "protein_target", nullable = false)
  private Float proteinTarget;

  @Column(name = "fat_target", nullable = false)
  private Float fatTarget;

  @Column(name = "calories_target", nullable = false)
  private Float caloriesTarget;

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

}
