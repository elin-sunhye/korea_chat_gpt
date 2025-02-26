package com.korit.boardback.controller;

import com.korit.boardback.security.principal.PrincipalUser;
import com.korit.boardback.service.FileService;
import com.korit.boardback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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
        if(principalUser.getUser().getProfileImg() == null) {
            principalUser.getUser().setProfileImg("default.png");
        }
        return ResponseEntity.ok().body(principalUser.getUser());
    }

    @PostMapping("/user/profile/img")
    public ResponseEntity<?> changeProfileImg(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestPart MultipartFile file
    ) {
        userService.updateProfileImg(principalUser.getUser(), file);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/profile/nickname")
    public ResponseEntity<?> changeNickname(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody Map<String, String> reqBody
    ) {
        String nickname = reqBody.get("nickname");
        userService.updateNickname(principalUser.getUser(), nickname);
        return ResponseEntity.ok().build();
    }
}
