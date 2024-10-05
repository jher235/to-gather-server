package com.example.togather.domain.time.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TimeRegisterList {
    private List<TimeRegister> timeRegisterList;
    private String userName;
}
