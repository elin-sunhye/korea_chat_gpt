package com.korit.korit_gpt_java_springboot.repository.post;

import com.korit.korit_gpt_java_springboot.entity.post.Post;
import com.korit.korit_gpt_java_springboot.mapper.post.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    @Autowired
    private PostMapper mapper;

//    추가
    public Optional<Post> save(Post post) {
        int successCount = mapper.insert(post);

        return successCount < 1 ? Optional.empty() : Optional.ofNullable(post);
    }

//    단건조회
    public Optional<Post> findById(int id) {
        Post post = mapper.selectById(id);
        return Optional.ofNullable(post);
    }

//    다건조회 - 검색
   public Optional<List<Post>> findAllByKeywordContaining(int startIdx, int limitCount, String keyword) {
        List<Post> posts = mapper.selectAllByKeywordContaining(startIdx, limitCount, keyword);
        return posts.isEmpty() ? Optional.empty() : Optional.ofNullable(posts);
    }

//    좋아요
//    좋아요 취소
}
