package com.hackathon.org.controller.dto;

import com.hackathon.org.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SinglePostResponseDto {
    private Long postId;
    private String firstAnswer;
    private String secondAnswer;

    public static SinglePostResponseDto of(Post post) {
        return SinglePostResponseDto.builder()
                .postId(post.getPostId())
                .firstAnswer(post.getFirstAnswer())
                .secondAnswer(post.getSecondAnswer())
                .build();
    }
}
