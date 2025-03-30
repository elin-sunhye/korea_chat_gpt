package com.korit.korit_gpt_java_springboot.controller.authentication;

import com.korit.korit_gpt_java_springboot.aspect.annotation.PrintParamsAop;
import com.korit.korit_gpt_java_springboot.dto.request.authentication.ReqSigninDto;
import com.korit.korit_gpt_java_springboot.dto.request.authentication.ReqSignupDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.user.User;
import com.korit.korit_gpt_java_springboot.service.authentication.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "계정 API")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PrintParamsAop
    @PostMapping("/api/auth/signup")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<SuccessResponseDto<User>> signup(@Valid @RequestBody ReqSignupDto reqSignupDto) throws MethodArgumentNotValidException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(authenticationService.signup(reqSignupDto)));
    }

    @PostMapping("/api/auth/signin")
    @ApiOperation(value = "로그인")
    public ResponseEntity<SuccessResponseDto<String>> signin(@Valid @RequestBody ReqSigninDto reqSigninDto) throws MethodArgumentNotValidException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(authenticationService.signin(reqSigninDto)));
    }

    @PostMapping("/api/auth/logout")
    @ApiOperation(value = "로그아웃")
    public ResponseEntity<SuccessResponseDto<?>> logout() {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(null));
    }
}








