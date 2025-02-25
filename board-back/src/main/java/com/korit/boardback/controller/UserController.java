package com.korit.boardback.controller;

import com.korit.boardback.security.principal.PrincipalUser;
import com.korit.boardback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
//    두개 같은거임 가져오는 방법은 2가지
//    @AuthenticationPrincipal PrincipalUser principalUser
//    PrincipalUser principalUser2 = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    public ResponseEntity<?> getLoginUser(@AuthenticationPrincipal PrincipalUser principalUser) {
//        int userId = principalUser.getUser().getUserId();
        return ResponseEntity.ok().body(principalUser.getUser());
    }
}
