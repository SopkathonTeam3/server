package com.hackathon.org.common.error.model;

import com.hackathon.org.common.status.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException{
    private ErrorStatus status;
}
