package com.korit.korit_gpt_java_springboot.mapper.post;

import com.korit.korit_gpt_java_springboot.entity.post.PostLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostLikeMapper {
    //    좋아요
    int insert(PostLike postLike);

    //    좋아요 취소
    int deleteByPostIdAndUserId(PostLike postLike);

//    좋아요 갯수 by postId
    int selectLikeCountByPostId(@Param("postId") int postId);

//    좋아요 갯수 전체 게시글
    List<PostLike> selectLikeCountAll();
}
