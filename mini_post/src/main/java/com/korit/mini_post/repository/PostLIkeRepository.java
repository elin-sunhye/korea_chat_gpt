package com.korit.mini_post.repository;

import com.korit.mini_post.entity.Post;
import com.korit.mini_post.entity.PostLike;
import com.korit.mini_post.mapper.PostLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PostLIkeRepository {
    @Autowired
    private PostLikeMapper postLikeMapper;

    public Optional<Boolean> savePostLike(PostLike postLike) {
        return postLikeMapper.insert(postLike) < 1 ? Optional.empty() : Optional.ofNullable(true);
    }
}
