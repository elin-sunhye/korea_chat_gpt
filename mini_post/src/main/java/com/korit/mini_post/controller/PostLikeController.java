package com.korit.mini_post.controller;

import com.korit.mini_post.dto.request.ReqAddPostLike;
import com.korit.mini_post.dto.response.common.SuccessResponseDto;
import com.korit.mini_post.service.PostLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "post좋아요 관리")
@RestController
public class PostLikeController {
    @Autowired
    private PostLikeService postLikeService;

    @PostMapping("/api/post/{postId}/like/{userId}")
    @ApiOperation(value = "좋아요추가")
    public ResponseEntity<SuccessResponseDto<Boolean>> addPostLike(
            @ApiParam(value = "게시글 ID")
            @PathVariable int postId,
            @ApiParam(value = "사용자 ID")
            @PathVariable int userId)
            throws NotFoundException {
        return ResponseEntity.ok()
                .body(new SuccessResponseDto<>(postLikeService.savePostLike(postId, userId)));
    }
}
