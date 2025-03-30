package com.korit.korit_gpt_java_springboot.repository.post;

import com.korit.korit_gpt_java_springboot.entity.post.PostLike;
import com.korit.korit_gpt_java_springboot.mapper.post.PostLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PostLikeRepository {

    @Autowired
    private PostLikeMapper mapper;

    public Optional<Boolean> save(PostLike postLike) {
        return mapper.insert(postLike) < 1 ? Optional.empty() : Optional.ofNullable(true);
    }
}
