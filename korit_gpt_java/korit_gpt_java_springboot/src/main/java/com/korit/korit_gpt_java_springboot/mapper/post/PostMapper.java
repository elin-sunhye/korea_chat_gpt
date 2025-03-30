package com.korit.korit_gpt_java_springboot.mapper.post;

import com.korit.korit_gpt_java_springboot.entity.post.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
//    추가
    int insert(Post post);

//    단건조회
    Post selectById(@Param("postId") int postId);

//    다건조회 - 검색
    List<Post> selectAllByKeywordContaining(
            @Param("startIdx") int startIdx,
            @Param("limitCount") int limitCount,
            @Param("keyword") String keyword
    );
}
