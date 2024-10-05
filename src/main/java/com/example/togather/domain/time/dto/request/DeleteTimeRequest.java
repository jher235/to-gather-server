package com.example.togather.domain.time.dto.request;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteTimeRequest {
    private List<Long> deleteTimeIdList;
    private String userName;
}
