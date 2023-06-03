package com.hackathon.org.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PostListResponseDto {
    private RoomResponseDto roomResponseDto;
    private UserResponseDto userResponseDto;
    private List<SinglePostResponseDto> posts;
}
