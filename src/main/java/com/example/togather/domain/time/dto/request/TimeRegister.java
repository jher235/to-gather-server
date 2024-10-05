package com.example.togather.domain.time.dto.request;


import lombok.*;



@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
public class TimeRegister {
    private Long blockNum;
    private boolean whether;
    private String memo;

}
