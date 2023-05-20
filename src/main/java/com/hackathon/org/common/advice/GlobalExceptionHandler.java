package com.hackathon.org.common.advice;

import com.hackathon.org.common.error.BaseException;
import com.hackathon.org.common.status.ErrorStatus;
import com.hackathon.org.common.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
public class GlobalExceptionHandler {

    /*
        커스텀 에러 핸들러
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ BaseException.class })
    protected ApiResponseDTO handleCustomException(BaseException exception) {
        return ApiResponseDTO.error(exception.getStatus());
    }

    /*
        bad request 핸들러
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MissingServletRequestParameterException.class,
            MissingRequestHeaderException.class,
            IllegalStateException.class,
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            MultipartException.class,
            NoHandlerFoundException.class,
    })
    ApiResponseDTO serverErrorHandler(Exception exception) {
        return ApiResponseDTO.error(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    /*
        validation error 핸들러
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDTO validException(MethodArgumentNotValidException exception) {
        String message = "유효성 검사 실패: " + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ApiResponseDTO.error(HttpStatus.BAD_REQUEST, message);
    }

    /*
        all exception 핸들러
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    protected ApiResponseDTO handleServerException(Exception exception) {
        return ApiResponseDTO.error(ErrorStatus.INTERNAL_SERVER_ERROR);
    }


}
