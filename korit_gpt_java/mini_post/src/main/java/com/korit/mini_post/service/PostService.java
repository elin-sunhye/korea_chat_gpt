package com.korit.mini_post.service;

import com.korit.mini_post.dto.request.ReqAddPost;
import com.korit.mini_post.entity.Post;
import com.korit.mini_post.repository.PostRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Boolean savePost(int userId, ReqAddPost reqAddPost) {
        return postRepository.savePost(reqAddPost.toPost(userId))
                .orElseThrow(()->new DuplicateKeyException("동일한 제목이 있습니다."));
    }

    public Post findByPostId(int postId) throws NotFoundException {
        return postRepository.findByPostId(postId).orElseThrow(() -> new NotFoundException("해당 ID가 없습니다."));
    }
    public List<Post> findAllPost() throws NotFoundException {
        return postRepository.findAllPost().orElseThrow(() -> new NotFoundException("게시물이 없습니다."));
    }


}
