package com.hackathon.org.controller.dto;

import com.hackathon.org.common.status.ErrorStatus;
import com.hackathon.org.common.status.SuccessStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDTO<T> {
    private final int status;
    private final String message;
    private T data;

    public static <T> ApiResponseDTO<T> success(SuccessStatus successStatus, T data) {
        return new ApiResponseDTO<>(successStatus.getHttpStatus().value(), successStatus.getMessage(), data);
    }

    public static ApiResponseDTO error(ErrorStatus errorStatus) {
        return new ApiResponseDTO(errorStatus.getHttpStatus().value(), errorStatus.getMessage());
    }

    public static ApiResponseDTO error(HttpStatus errorStatus, String message) {
        return new ApiResponseDTO(errorStatus.value(), message);
    }
}
