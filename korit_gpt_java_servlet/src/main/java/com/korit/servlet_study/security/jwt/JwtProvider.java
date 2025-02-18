package com.korit.servlet_study.security.jwt;

import com.korit.servlet_study.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtProvider {
    private Key key;
    private static JwtProvider instance;

    private JwtProvider() {
//        https://jwtsecret.com/generate
//        원래는 파일 따로 만들어서 static으로 만들어서 gitignore 에 올려여함
        final String SECRET = "b17e40104e73070e134ecd8891c199b60928081322e877e1a1d05f97e8f6c8b2553de02638fd5886d7b18f58bb1b1432ca44b248d6523963a2985b1f52f18b4e79ca405a26b8469d058a6264dad63ad115f543c2971a1d1fecbb64d29f8823350383871ba8e9d70f06abc705b45505fd09cdb0401428317be8d74cbaad041490ba0affe35cace8885e2aa2866aae9468a0b23a757c0ddf43751162e12b867f342504ec8e6b206a391fb6e4bbb2da9a8450b622a2ca02939e922174c89f4d880f6792242f23860caf21f86bcaf609446814e0ee97466d27cb0241345618b593018d7fd123bf6dc432043d4c7cb44f7e523eedf65c89e741f1b6ba82f5b37d97b5";
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
    }

    public static JwtProvider getInstance() {
        if (instance == null) {
            instance = new JwtProvider();
        }
        return instance;
    }

    private Date getExpireDt() {
//        1000l * 60 : 1분
//        1000l * 60 * 60 : 1시간
//        1000l * 60 * 60 * 24 : 하루
//        1000l * 60 * 60 * 24 * 365 : 일년
        return new Date(new Date().getTime() + (1000l * 60 * 60 * 24 * 365));
    }

    //    로그인이 되어진 user
    public String generateToken(User user) {
        return Jwts.builder()
//                claim : 토큰에 들어가는 정보
                .claim("userId", user.getUserId())
//                토큰 만료 시간
                .setExpiration(getExpireDt())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims parseToken(String token) {
//        위조, 만료 등 예외
        Claims claims = null;
        try {
//            JwtParser jwtParser = Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build();
//
//            claims = jwtParser
//                    .parseClaimsJws(removeBearer(token))
//                    .getBody();
            
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(removeBearer(token))
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    private String removeBearer(String bearerToken) {
        String accessToken = null;
        final String BEARER_KEYWORD = "Bearer ";

        if (bearerToken.startsWith(BEARER_KEYWORD)) {
            accessToken = bearerToken.substring(BEARER_KEYWORD.length());
        }
        return accessToken;
    }
}
