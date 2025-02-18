package com.korit.korit_gpt_java_springboot.service.post;

import com.korit.korit_gpt_java_springboot.aspect.annotation.PrintParamsAop;
import com.korit.korit_gpt_java_springboot.dto.request.post.ReqAddPostDto;
import com.korit.korit_gpt_java_springboot.entity.post.Post;
import com.korit.korit_gpt_java_springboot.entity.post.PostLike;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.repository.post.PostLikeRepository;
import com.korit.korit_gpt_java_springboot.repository.post.PostRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostLikeRepository postLikeRepository;

//    추가
    @Transactional(rollbackFor = Exception.class) // CUD는 필수
    public Post addPost(ReqAddPostDto reqDto) {
        return postRepository.save(reqDto.toPost()).get();
    }

//    단건 조회
//        AOP
    @PrintParamsAop
    public Post getPostById(int id) throws Exception {
        Post post = postRepository.findById(id)
                .orElseThrow(() ->  new NotFoundException("해당 postId의 게시글이 존재하지 않습니다."));
        return post;
    }

//    다건조회 - 검색
//        AOP
@PrintParamsAop
    public List<Post> getAllByKeywordContaining(int page, int size, String keyword) throws Exception {
        int startIdx = (page - 1) * size;
        List<Post> posts = postRepository.findAllByKeywordContaining(startIdx, size, keyword)
                .orElseThrow(() -> new NotFoundException("검색된 정보가 없습니다."));
        return posts;
    }

//    좋아요
    public Boolean likePost(int postId, int userId) {
        PostLike postLike = PostLike.builder()
                .postId(postId)
                .userId(userId)
                .build();
        return postLikeRepository.save(postLike).orElseThrow(() -> new CustomDuplicateKeyException("", Map.of("message","해당 게시글을 이미 like 처리 하셨습니다.")));
    }

//    좋아요 취소
}
