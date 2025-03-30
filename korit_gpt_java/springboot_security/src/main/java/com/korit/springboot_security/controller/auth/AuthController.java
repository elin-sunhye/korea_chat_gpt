package com.korit.springboot_security.controller.auth;

import com.korit.springboot_security.dto.request.auth.ReqRefreshDto;
import com.korit.springboot_security.dto.request.auth.ReqSigninDto;
import com.korit.springboot_security.dto.response.auth.RespAuthDto;
import com.korit.springboot_security.service.RedisTokenService;
import com.korit.springboot_security.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup() {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/signin")
    public ResponseEntity<RespAuthDto> signin(@RequestBody ReqSigninDto reqSigninDto) {
        return ResponseEntity.ok().body(authService.login(reqSigninDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/token/refresh")
    public ResponseEntity<?> refresh(@RequestBody ReqRefreshDto reqRefreshDto) {
        return ResponseEntity.ok().body(authService.refresh(reqRefreshDto.getRefreshToken()));
    }
}
