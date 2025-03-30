package com.korit.korit_gpt_java_springboot.dto.request.post;

import com.korit.korit_gpt_java_springboot.entity.post.Post;
import lombok.Data;

@Data
public class ReqAddPostDto {
    private int userId;
    private String title;
    private String content;

    public Post toPost() {
        return Post.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .build();
    }
}
