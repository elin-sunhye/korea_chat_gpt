package com.korit.korit_gpt_java_springboot.controller.user;

import com.korit.korit_gpt_java_springboot.dto.request.user.ReqAddUserDto;
import com.korit.korit_gpt_java_springboot.dto.request.user.ReqModifyUserDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.user.User;
import com.korit.korit_gpt_java_springboot.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Api(tags = "사용자 관리 Controller")
@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "username 중복 확인 API")
    @GetMapping("/api/user/username/duplication")
    public ResponseEntity<SuccessResponseDto<Boolean>> duplicateUsername(
            @RequestParam
            @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "4~16자의 영문자, 숫자, 밑줄(_)만 사용할 수 있으며, 공백은 포함할 수 없습니다.")
            String username
    ) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.duplicateUsername(username)));
    }

    @ApiOperation(value = "사용자 추가 API")
    @PostMapping("/api/user")
    public ResponseEntity<SuccessResponseDto<User>> addUser(@Valid
            @ApiParam(value = "추가 할 사용자 정보", required = true)
            @RequestBody ReqAddUserDto reqAddUserDto
    ) throws MethodArgumentNotValidException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.addUser(reqAddUserDto)));
    }

    @ApiOperation(value = "사용자 ID로 조회 API")
    @GetMapping("/api/user/{userId}")
    public ResponseEntity<SuccessResponseDto<User>> getUser(
            @Min(value = 1, message = "사용자 ID는 1이상의 정수입니다.")
            @ApiParam(value = "사용자 ID", example = "1", required = true)
            @PathVariable int userId
    ) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.getUserById(userId)));
    }

    @ApiOperation(value = "사용자 전체 조회")
    @GetMapping("/api/users")
    public ResponseEntity<SuccessResponseDto<List<User>>> getAllUsers() throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.getAllUsers()));
    }

    @ApiOperation(value = "사용자 수정 API")
    @PutMapping("/api/user/{userId}")
    public ResponseEntity<SuccessResponseDto<Boolean>> modifyUser(
            @Min(value = 1, message = "사용자 ID는 1이상의 정수입니다.")
            @ApiParam(value = "사용자 ID", example = "1", required = true)
            @PathVariable int userId,
            @Valid @RequestBody ReqModifyUserDto reqModifyUserDto
    ) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.modifyUser(userId, reqModifyUserDto)));
    }

    @ApiOperation(value = "사용자 삭제")
    @DeleteMapping("/api/user/{userId}")
    public ResponseEntity<SuccessResponseDto<?>> deleteUser(
            @Min(value = 1, message = "사용자 ID는 1이상의 정수입니다.")
            @ApiParam(value = "사용자 ID", example = "1", required = true)
            @PathVariable int userId
    ) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(userService.deleteUser(userId)));
    }
}
