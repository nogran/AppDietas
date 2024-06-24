package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

  private final UserPersistence persistence;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    var userLogin = persistence.findByLogin(username).get();
    return UserDetailsImpl.build(userLogin);
  }
}
