package com.hackathon.org.controller.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostListResponseDto {
    private RoomResponseDto roomResponseDto;
    private UserResponseDto userResponseDto;
    private List<SinglePostResponseDto> posts;
}
