package com.nogran.app.dietas.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "login", catalog = "login")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class UserEntity {

  @Id
  @SequenceGenerator(name = "login_seq", sequenceName = "login_seq", allocationSize = 1)
  @GeneratedValue(generator = "login_seq")
  private Long id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

}
