package com.example.togather.exception;

import com.example.togather.exception.errorcode.ErrorCode;

public class UnauthorizedException extends CustomException{
    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
