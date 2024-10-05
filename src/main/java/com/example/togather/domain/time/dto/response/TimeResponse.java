package com.example.togather.domain.time.dto.response;


import com.example.togather.domain.time.entity.Time;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeResponse {
    private Long blockNum;
    private boolean whether;
    private String memo;
    private String userName;

    public static TimeResponse from(Time time){
        return new TimeResponse(time.getBlockId(), time.isWhether(), time.getMemo(), time.getUser().getUserName());
    }
}
