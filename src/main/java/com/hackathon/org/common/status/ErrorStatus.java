package com.hackathon.org.common.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러"),
    FAIL_TO_REGISTER(HttpStatus.INTERNAL_SERVER_ERROR, "등록 실패"),
    INVALID_DATE_DIFFERENCE(HttpStatus.INTERNAL_SERVER_ERROR, "잘못된 날짜 정보"),


    /**
     * 404
     */
    NOT_FOUND(HttpStatus.NOT_FOUND, "잘못된 요청"),
    INVALID_ID(HttpStatus.NOT_FOUND, "잘못된 id 정보"),


    ;

    private final HttpStatus httpStatus;
    private final String message;
}
