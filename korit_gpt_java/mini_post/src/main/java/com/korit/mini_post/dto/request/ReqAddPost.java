package com.korit.mini_post.dto.request;

import com.korit.mini_post.entity.Post;
import lombok.Data;

@Data
public class ReqAddPost {
//    private int userId;
    private String title;
    private long content;

    public Post toPost(int userId) {
        return Post.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .build();
    }
}
