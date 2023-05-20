package com.hackathon.org.controller;

import com.hackathon.org.common.dto.ApiResponseDTO;
import com.hackathon.org.common.status.SuccessStatus;
import com.hackathon.org.controller.dto.PostUserRequestDTO;
import com.hackathon.org.controller.dto.PostUserResponseDTO;
import com.hackathon.org.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ApiResponseDTO<PostUserResponseDTO> registerUser(
            @RequestBody @Valid final PostUserRequestDTO request
    ) {

        return ApiResponseDTO.success(
                 SuccessStatus.POST_SUCCESS,
                 userService.registerUser(request.getName(), request.getBackgroundColorId()));
    }

}
