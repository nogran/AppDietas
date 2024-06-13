package com.nogran.app.dietas.entity;

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
@Table(name = "user", catalog = "user")
@RequiredArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
@Data
public class UserLoginEntity {

  @Id
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
  @GeneratedValue(generator = "user_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

}
