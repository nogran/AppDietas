package com.nogran.app.dietas.security.jwt;

import com.nogran.app.dietas.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthFilterToken extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      String jwt = getToken(request);
      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {

        String username = jwtUtils.getUsernameToken(jwt);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(auth);
      }

    } catch (Exception e) {
      System.out.println("invalid token process");
    }

    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest httpServletRequest) {
    String headerToken = httpServletRequest.getHeader("Authorization");
    if (StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")) {
      return headerToken.replace("Bearer: ", "");
    }
    return null;
  }
}
