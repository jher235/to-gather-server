package com.example.togather.global.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto<T> {
    private final String statusCode;
    private final String message;
    private final  T data;

    public static <T> ResponseDto<T> res(final HttpStatusCode statusCode, final String message){
        return new ResponseDto<>(String.valueOf(statusCode),message, null);
    }

    public static <T> ResponseDto<T> res(final HttpStatusCode statusCode, final String message,final T data){
        return new ResponseDto<>(String.valueOf(statusCode),message, data);
    }
}
