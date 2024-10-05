package com.example.togather.exception;

import com.example.togather.exception.errorcode.ErrorCode;

public class ForbiddenException extends CustomException{
    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
