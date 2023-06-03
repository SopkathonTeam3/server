package com.hackathon.org.common.status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    event
    */
    EVENT_SUCCESS(HttpStatus.OK, "이벤트 조회 성공"),

    READ_SUCCESS(HttpStatus.OK, "조회 성공"),

    CREATE_SUCCESS(HttpStatus.CREATED, "등록 성공"),

    ;


    private final HttpStatus httpStatus;
    private final String message;
}
