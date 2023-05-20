package com.hackathon.org.controller.dto;

import com.hackathon.org.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserResponseDto {
    private String name;
    private String backgroundColorCode;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder().name(user.getName())
                .backgroundColorCode(user.getBackgroundColor().getBackgroudColorCode()).build();
    }
}
