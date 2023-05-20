package com.hackathon.org.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PostUserResponseDTO {
    private final Long userId;
    private final Long roomId;

    public static PostUserResponseDTO from(Long userId, Long roomId) {
        return new PostUserResponseDTO(userId, roomId);
    }

}
