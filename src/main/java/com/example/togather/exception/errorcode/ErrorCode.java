package com.example.togather.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //400
    NOT_BLANK("4000", "필수값이 공백입니다."),
    PATTERN("4001","형식에 맞지 않습니다."),
    LENGTH("4002", "길이가 유효하지 않습니다."),
    NOT_NULL("4003", "필수값이 공백입니다."),
    USER_DUPLICATION("4004", "다른 이름을 사용해주세요."),
    //404
    MEETING_NOT_FOUND("4040", "요청하신 미팅을 찾을 수 없습니다."),

    USER_NOT_FOUND("4041", "존재하지 않는 유저입니다."),
    NOT_FOUND_PLACE("4042", "요청하신 장소를 찾을 수 없습니다.");

    private final String code;
    private final String message;

    public static ErrorCode resolveValidationErrorCode(String code){
        return switch (code){
            case "Pattern" -> PATTERN;
            case "NotBlank" -> NOT_BLANK;
            case "Length" -> LENGTH;
            case "NotNull" -> NOT_NULL;
            default -> throw new IllegalArgumentException("Unexpected value: "+ code);
        };
    }
}
