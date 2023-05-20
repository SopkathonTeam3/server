package com.hackathon.org.common.error.model;

import com.hackathon.org.common.status.ErrorStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(ErrorStatus error) {
        super(error);
    }
}
