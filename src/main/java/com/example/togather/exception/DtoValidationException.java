package com.example.togather.exception;

import com.example.togather.exception.errorcode.ErrorCode;

public class DtoValidationException extends CustomException{
    public DtoValidationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public DtoValidationException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
