package com.korit.korit_gpt_java_springboot.controller.post;

import com.korit.korit_gpt_java_springboot.aspect.annotation.TimerAop;
import com.korit.korit_gpt_java_springboot.dto.request.post.ReqAddPostDto;
import com.korit.korit_gpt_java_springboot.dto.response.common.SuccessResponseDto;
import com.korit.korit_gpt_java_springboot.entity.post.Post;
import com.korit.korit_gpt_java_springboot.service.post.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@Api(tags = "게시글 관리 컨트롤러")
@RestController
public class PostController {
    @Autowired
    private PostService service;

    @ApiOperation(value = "C-추가 API")
    @PostMapping("/api/post")
    public ResponseEntity<SuccessResponseDto<Post>> addPost(
            @RequestBody ReqAddPostDto reqAddPostDto
    ) {
        return ResponseEntity.created(URI.create("")).body(new SuccessResponseDto<>(service.addPost(reqAddPostDto))); // 201
//        return ResponseEntity.created(URI.create("http://localhost:8080/api/post" + ServiceId)).body(new SuccessResponseDto<>(null));
    }

//    AOP
    @TimerAop
    @ApiOperation(value = "R-단건조회 API")
    @GetMapping("/api/post/{postId}")
    public ResponseEntity<SuccessResponseDto<Post>> getPost(@PathVariable int postId
    ) throws Exception {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.getPostById(postId)));
    }

    @ApiOperation(value = "R-다건조회 - 검색 API")
    @GetMapping("/api/posts")
    public ResponseEntity<SuccessResponseDto<List<Post>>> getPosts(
            @Min(value = 1, message = "1이상의 정수입니다.")
            @RequestParam int page,
            @Min(value = 1, message = "1이상의 정수입니다.")
            @RequestParam int size,
            @RequestParam(required = false, defaultValue = "") String keyword
//            defaultValue = "" ; null로 들어왓을 때 빈문자열로 바꿔줌
    ) throws Exception {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.getAllByKeywordContaining(page, size, keyword)));
    }

    @ApiOperation(value = "C-좋아요 API")
    @PostMapping("/api/post/{postId}/like")
    public ResponseEntity<SuccessResponseDto<Boolean>> likePost(@PathVariable int postId) {
//        토큰 있다는 가정
        int userId = 2;
        return ResponseEntity.ok().body(new SuccessResponseDto<>(service.likePost(postId, userId)));
    }

    @ApiOperation(value = "D-좋아요 취소 API")
    @DeleteMapping("/api/post/{postId}/like")
    public ResponseEntity<SuccessResponseDto<Post>> disLikePost(@PathVariable int postId) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(null));
    }
}
