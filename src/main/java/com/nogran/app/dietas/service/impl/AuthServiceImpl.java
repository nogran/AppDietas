package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.dto.AccessDTO;
import com.nogran.app.dietas.dto.UserDTO;
import com.nogran.app.dietas.security.jwt.JwtUtils;
import com.nogran.app.dietas.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;

  private final JwtUtils jwtUtils;

  public AccessDTO login(UserDTO userDTO) {

    try {
      UsernamePasswordAuthenticationToken userAuth =
          new UsernamePasswordAuthenticationToken(
              userDTO.getEmail(),
              userDTO.getPassword());

      Authentication authentication = authenticationManager.authenticate(userAuth);
      UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
      String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
      AccessDTO accessDTO = new AccessDTO(token);
      return accessDTO;
    } catch (BadCredentialsException e) {

    }
    return null;
  }

}
