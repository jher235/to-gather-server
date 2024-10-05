package com.example.togather.domain.meeting.dto;

import com.example.togather.domain.time.dto.response.TimeResponse;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class MeetingDto {

    @NotBlank(message="필수 입력값입니다")
    private String meetingTitle;
    @NotBlank(message="필수 입력값입니다")
    private Date startDate;
    @NotBlank(message="필수 입력값입니다")
    private Date endDate;
    @NotBlank(message="필수 입력값입니다")
    private String startTime;
    @NotBlank(message="필수 입력값입니다")
    private String endTime;

    private List<String> places;

    private List<TimeResponse> times;


}
