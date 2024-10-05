package com.example.togather.exception;

import com.example.togather.exception.errorcode.ErrorCode;


public class BadRequestException extends CustomException{
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BadRequestException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
