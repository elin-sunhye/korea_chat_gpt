package com.korit.mini_post.dto.request;

import com.korit.mini_post.entity.PostLike;
import lombok.Data;

@Data
public class ReqAddPostLike {

    private int postId;
    private int userId;

    public PostLike toPostLike(int postId, int userId) {
        return PostLike.builder()
                .postId(postId)
                .userId(userId)
                .build();
    }
}
