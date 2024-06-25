package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.service.AuthService;
import com.nogran.app.dietas.api.domain.dto.AccessDTO;
import com.nogran.app.dietas.api.domain.dto.AuthenticationDTO;
import com.nogran.app.dietas.api.domain.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtils jwtUtils;

  public AccessDTO login(AuthenticationDTO authDTO) {
    try {
      UsernamePasswordAuthenticationToken userAuth =
          new UsernamePasswordAuthenticationToken(
              authDTO.getUsername(),
              authDTO.getPassword());

      Authentication authentication = authenticationManager.authenticate(userAuth);
      UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
      String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
      AccessDTO accessDTO = new AccessDTO(token);
      return accessDTO;

    } catch (BadCredentialsException e) {
      log.debug("BadCredentialsException: ", e);
    }
    return new AccessDTO("Denied");
  }

}
