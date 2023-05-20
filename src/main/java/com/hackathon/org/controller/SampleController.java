package com.hackathon.org.controller;

import com.hackathon.org.common.status.SuccessStatus;
import com.hackathon.org.controller.dto.ApiResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public ApiResponseDTO success() {
        return ApiResponseDTO.success(SuccessStatus.EVENT_SUCCESS, "DATA");
    }
}
