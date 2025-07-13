package com.rafael0117.HotelApp.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long expirationMs;

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    public String generateToken(UserDetails user){
        Map<String, Object> claims = Map.of(
                "roles",user.getAuthorities().stream()
                        .map(a -> a.getAuthority())
                        .toList()
        );
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }
    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }
    public boolean validateToken(String token){
        try {
            return extractExpiration(token).after(new Date());

        }catch (Exception e){
            return false;
        }
    }
    public List<String> extractRoles(String token){
        Object rolesObject = extractAllClaims(token).get("roles");
        if(rolesObject instanceof List<?> rolesList){
            return rolesList.stream()
                    .map(Object::toString)
                    .toList();
        }
        return List.of();
    }

}
