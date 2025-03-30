package com.korit.mini_post.service;

import com.korit.mini_post.dto.request.ReqAddPostLike;
import com.korit.mini_post.entity.PostLike;
import com.korit.mini_post.repository.PostLIkeRepository;
import io.swagger.annotations.Api;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostLikeService {
    @Autowired
    private PostLIkeRepository postLIkeRepository;

    public Boolean savePostLike(int postId, int userId) throws NotFoundException {
        return postLIkeRepository.savePostLike(PostLike.builder()
                        .postId(postId)
                        .userId(userId)
                .build()).orElseThrow(() -> new NotFoundException("해당 게시물이 없습니다."));
    }
}
