package com.lizard.common;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtils {

  private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  
  public static String generateToken(String subject) {
    return Jwts.builder()
        .setSubject(subject)
        .signWith(SECRET_KEY)
        .compact();
  }

  public static boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(SECRET_KEY)
          .build()
          .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      // 검증 실패
      return false;
    }
  }

  public static Claims getClaimsFromToken(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(SECRET_KEY)
        .build()
        .parseClaimsJws(token)
        .getBody();
  }
}
