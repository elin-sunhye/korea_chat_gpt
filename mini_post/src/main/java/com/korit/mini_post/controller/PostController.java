package com.korit.mini_post.controller;

import com.korit.mini_post.dto.request.ReqAddPost;
import com.korit.mini_post.dto.response.common.SuccessResponseDto;
import com.korit.mini_post.entity.Post;
import com.korit.mini_post.service.PostService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/api/post/{userId}")
    public ResponseEntity<SuccessResponseDto<Boolean>> addPost(
            @PathVariable int userId,
            @RequestBody
            ReqAddPost reqAddPost
    ) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.savePost(userId, reqAddPost)));
    }

    @GetMapping("/api/posts")
    public ResponseEntity<SuccessResponseDto<List<Post>>> allPosts() throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.findAllPost()));
    }

    @GetMapping("/api/post/{postId}")
    public ResponseEntity<SuccessResponseDto<Post>> foundByPostId(@PathVariable int postId) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.findByPostId(postId)));
    }
}
