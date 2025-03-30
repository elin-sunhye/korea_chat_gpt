package com.korit.mini_post.mapper;

import com.korit.mini_post.entity.PostLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostLikeMapper {
    int insert(PostLike postLike);
}
