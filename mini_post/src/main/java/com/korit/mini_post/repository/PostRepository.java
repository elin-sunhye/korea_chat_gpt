package com.korit.mini_post.repository;

import com.korit.mini_post.entity.Post;
import com.korit.mini_post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    @Autowired
    private PostMapper postMapper;

    public Optional<Boolean> savePost(Post post) {
        return postMapper.insert(post) < 1  ? Optional.empty() : Optional.ofNullable(true);
    }

    public Optional<Post> findByPostId(int postId) {
        return Optional.ofNullable(postMapper.selectByPostId(postId)).isEmpty() ? Optional.empty() : Optional.ofNullable(postMapper.selectByPostId(postId));
    }

    public Optional<List<Post>> findAllPost() {
        System.out.println(postMapper.selectAllPost());
        return Optional.ofNullable(postMapper.selectAllPost()).isEmpty() ? Optional.empty() : Optional.ofNullable(postMapper.selectAllPost());
    }
}
