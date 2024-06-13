package com.nogran.app.dietas.security.jwt;

import com.nogran.app.dietas.service.impl.UserDetailsImpl;
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
  private String jwtExpirationMs;

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
      Jwts.parser().setSigningKey(getSignKey()).build().parseSignedClaims(authToken);
      return true;

    } catch (MalformedJwtException e) {
      System.out.printf("error: " + e);
    } catch (ExpiredJwtException e) {
      System.out.printf("error: " + e);
    } catch (UnsupportedJwtException e) {
      System.out.printf("error: " + e);
    } catch (IllegalArgumentException e) {
      System.out.printf("error: " + e);
    }
    return false;
  }
}
