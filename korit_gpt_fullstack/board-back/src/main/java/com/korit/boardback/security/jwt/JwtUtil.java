package com.korit.boardback.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private Key key;
    private Long accessTokenExpired;
    private Long refreshTokenExpired;
    private Long emailTokenExpired;

//    JwtUtil 생성 시 토큰 및 리프레시 시간 셋팅
    public JwtUtil(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        accessTokenExpired = 1000l * 60 * 60;
        refreshTokenExpired = 1000l * 60 * 60 * 24 * 7;
        emailTokenExpired = 1000l * 60 * 5;
    }

//    토큰 생성
    public String generateToken (String userId, String username, Date expires) {
        return Jwts.builder()
                .setId(userId)
                .setSubject(username)
                .setExpiration(
                        expires
//                     new Date(System.currentTimeMillis() + (isRefreshToken ? refreshTokenExpired : emailTokenExpired))
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

//    프론트에 보낼 리턴 토큰 파싱
    public Claims parseToken(String token) {
        Claims claims = null;

        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
}
