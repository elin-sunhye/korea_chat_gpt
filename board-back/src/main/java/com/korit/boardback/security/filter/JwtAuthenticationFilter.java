package com.korit.boardback.security.filter;

import com.korit.boardback.entity.User;
import com.korit.boardback.repository.UserRepository;
import com.korit.boardback.security.jwt.JwtUtil;
import com.korit.boardback.security.principal.PrincipalUser;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        jwtAuthentication(getAccessToken(request));

        filterChain.doFilter(servletRequest, servletResponse);
    }

//    claims
    private void jwtAuthentication(String accessToken) {
        if(accessToken == null) {
            return;
        }

        Claims claims = jwtUtil.parseToken(accessToken);

        int userId = Integer.parseInt(claims.getId());
        User user = userRepository.findByUserId(userId).get();

        PrincipalUser principalUser = PrincipalUser.builder()
                .user(user)
                .build();

        if (!principalUser.isEnabled()) {
            return;
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

//    headers에 authorization 여부 확인
    private String getAccessToken (HttpServletRequest request) {
        String accessToken = null;
        String authorization = request.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer ")) {
            accessToken = authorization.substring(7);
        }

        return accessToken;
    }
}
