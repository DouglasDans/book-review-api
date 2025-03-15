package dev.dans.bookreview.infra.security;

import dev.dans.bookreview.domain.enums.UserRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.List;

public class JWTBuilder {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String build(String prefix, String key, JWTObject jwt){

        String token = Jwts.builder()
                .setSubject(jwt.getSubject())
                .setIssuedAt(jwt.getIssuedAt())
                .setExpiration(jwt.getExpiration())
                .claim("role", jwt.getRoles())
                .signWith(SignatureAlgorithm.HS512, Keys.hmacShaKeyFor(SecurityConfig.KEY.getBytes()))
                .compact();
        return prefix + " " + token;
    }

    public static JWTObject parse(
            String token,
            String prefix,
            String key
    ) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        JWTObject object = new JWTObject();

        token = token.replace(prefix, "");
        token = token.replace(" ", "");

        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(SecurityConfig.KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();


        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());

        List<String> roles = claims.get("role", List.class);
        object.setRoles(roles);

        return object;
    }
}
