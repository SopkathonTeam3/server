package com.hackathon.org.controller;

import com.hackathon.org.common.dto.ApiResponseDTO;
import com.hackathon.org.common.status.SuccessStatus;
import com.hackathon.org.controller.dto.ReadBackgroundColorDTO;
import com.hackathon.org.service.BackgroundColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final BackgroundColorService backgroundColorService;

    @GetMapping("/home")
    public ApiResponseDTO<List<ReadBackgroundColorDTO>> getHome() {
        return ApiResponseDTO.success(SuccessStatus.READ_SUCCESS, backgroundColorService.getBackgroundColors());
    }

}
