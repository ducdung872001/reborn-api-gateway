package vn.reborn.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${vertx.security.jwt.secret-key}")
    private String secret;

    public Claims validateToken(String token) throws ExpiredJwtException, MalformedJwtException {
        return null;
    }
}