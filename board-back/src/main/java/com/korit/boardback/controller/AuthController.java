package com.korit.boardback.controller;

import com.korit.boardback.dto.request.ReqAuthEmailDto;
import com.korit.boardback.dto.request.ReqJoinDto;
import com.korit.boardback.dto.request.ReqLoginDto;
import com.korit.boardback.dto.response.RespTokenDto;
import com.korit.boardback.entity.User;
import com.korit.boardback.service.EmailService;
import com.korit.boardback.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public ResponseEntity<User> join(@RequestBody ReqJoinDto dto) {
        return ResponseEntity.ok().body(userService.join(dto));
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<RespTokenDto> login(@RequestBody ReqLoginDto dto) {
        return ResponseEntity.ok().body(userService.login(dto));
    }

    @Operation(summary = "이메일 인증 메일 보내기")
    @PostMapping("/email")
    public ResponseEntity<?> sendAuthMail(@RequestBody ReqAuthEmailDto dto) throws Exception {
        User foundUser = userService.getUserByUsername(dto.getUsername());
        emailService.sendAuthMail(foundUser.getEmail(), dto.getUsername());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이메일 인증하기")
    @GetMapping("/email")
    public ResponseEntity<String> setAuthMail(
            @RequestParam String username,
            @RequestParam String token
    ) {
//        인증 버튼 클릭 시 창이 열리는데 인증 절차 다 마치고나면 그 창 닫기
        String script = String.format("""
            <script>
                alert("%s");
                window.close();
            </script>
        """, emailService.auth(username, token));
        return ResponseEntity.ok().header("Content-Type", "text/html; charset=utf-8").body(script);
    }
}
