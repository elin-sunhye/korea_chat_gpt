package com.korit.mini_post.controller;

import com.korit.mini_post.dto.request.ReqAddUser;
import com.korit.mini_post.dto.response.RespUserDto;
import com.korit.mini_post.dto.response.common.SuccessResponseDto;
import com.korit.mini_post.entity.User;
import com.korit.mini_post.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "사용자 관리 컨트롤러")
@RestController
public class UserController {
    @Autowired
    private UserService service;
    
    @ApiOperation("사용자 추가")
    @PostMapping("/api/user")
    public ResponseEntity<SuccessResponseDto<RespUserDto>> save (
            @ApiParam(value = "사용자dto")
            @RequestBody
            ReqAddUser reqAddUser) {
        System.out.println("controller" + reqAddUser);
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.saveUser(reqAddUser)));
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<SuccessResponseDto<User>> findByuserId(@PathVariable int userId) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.findByUserId(userId)));
    }
}
