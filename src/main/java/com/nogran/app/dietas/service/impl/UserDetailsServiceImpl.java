package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.entity.UserEntity;
import com.nogran.app.dietas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userLogin = userRepository.findByLogin(username).get();
    return UserDetailsImpl.build(userLogin);
  }
}
