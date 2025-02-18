package com.korit.mini_post.mapper;

import com.korit.mini_post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    int insert(Post post);

    List<Post> selectAllPost();
    Post selectByPostId(int postId);
}
