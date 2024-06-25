package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.model.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

  private String name;
  private String username;
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(String name, String username, String password, String email,
      Collection<? extends GrantedAuthority> authorities) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.email = email;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(
        user.getName(),
        user.getLogin(),
        user.getPassword(),
        user.getEmail(),
        new ArrayList<>());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
