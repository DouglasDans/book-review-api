package dev.dans.bookreview.infra.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JWTBuilder {
    public static String build(String prefix, String key, JWTObject jwt){
        String token = Jwts.builder()
                .setSubject(jwt.getSubject())
                .setIssuedAt(jwt.getIssuedAt())
                .setExpiration(jwt.getExpiration())
                .claim("role", jwt.getRoles())
                .signWith(SignatureAlgorithm.HS512, getSignInKey(key))
                .compact();
        return prefix + " " + token;
    }

    private static Key getSignInKey(String key) {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
