package com.hackathon.org.controller;

import com.hackathon.org.common.dto.ApiResponseDTO;
import com.hackathon.org.common.status.SuccessStatus;
import com.hackathon.org.controller.dto.PostListResponseDto;
import com.hackathon.org.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/{userId}/{roomId}")
    public ApiResponseDTO<PostListResponseDto> getPosts(@PathVariable final Long roomId,
                                                        @PathVariable final Long userId) {

        return ApiResponseDTO.success(SuccessStatus.READ_SUCCESS, postService.getPosts(userId, roomId));
    }
}
