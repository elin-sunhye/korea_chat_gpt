package com.korit.korit_gpt_java_springboot.entity.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostLike {
    private int postLikeId;
    private int postId;
    private int userId;
    private LocalDateTime createdAt;

    private int likeCount;
}
