package com.nogran.app.dietas.api.domain.security.jwt;

import com.nogran.app.dietas.api.domain.service.impl.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

  @Value("${app-dietas.jwtSecret}")
  private String jwtSecret;

  @Value("${app-dietas.jwtExpirationMs}")
  private int jwtExpirationMs;

  public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetails) {
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
        .signWith(getSignKey(), SignatureAlgorithm.HS512).compact();
  }

  public Key getSignKey() {
    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    return key;
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
      return true;
    } catch (MalformedJwtException e) {
      System.out.println("Token inválido " + e.getMessage());
    } catch (ExpiredJwtException e) {
      System.out.println("Token expirado " + e.getMessage());
    } catch (UnsupportedJwtException e) {
      System.out.println("Token não suportado " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("Token Argumento inválido " + e.getMessage());
    }

    return false;
  }

  public String getUsernameToken(String token) {
    return Jwts.parser().setSigningKey(getSigninKey()).build()
        .parseClaimsJws(token).getBody().getSubject();
  }

  public Key getSigninKey() {
    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    return key;
  }
}
