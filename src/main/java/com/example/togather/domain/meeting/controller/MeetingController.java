package com.example.togather.domain.meeting.controller;

import com.example.togather.domain.meeting.dto.MeetingDto;
import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.service.MeetingService;
import com.example.togather.domain.user.entity.User;
import com.example.togather.global.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @Operation(summary="미팅 생성", description="새로운 미팅을 생성합니다.")
    @PostMapping("/createMeeting")
    public ResponseEntity<ResponseDto<Meeting>> createMeeting(@RequestBody MeetingDto meetingDto) {
        Meeting meeting = meetingService.createMeeting(meetingDto);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "미팅 생성 완료", meeting), HttpStatus.OK);
    }

    @Operation(summary="미팅 확인", description="미팅 정보를 불러옵니다.")
    @GetMapping("/checkMeeting/{meeting_id}")
    public ResponseEntity<ResponseDto<MeetingDto>> checkMeeting(@PathVariable("meeting_id") UUID id) {
        MeetingDto meetingDto = meetingService.checkMeeting(id);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "미팅 확인 완료", meetingDto), HttpStatus.OK);
    }

    @Operation(summary="미팅에 대한 유저의 시간표", description="미팅에 대한 유저의 기존 시간 목록을 조회합니다.")
    @GetMapping("/check-meeting/{meeting_id}/user/{user_name}")
    public ResponseEntity<ResponseDto<MeetingDto>> getUserTime(@PathVariable("meeting_id")UUID meetingId, @PathVariable("user_name") String userName){
        MeetingDto meetingDto = meetingService.getUserMeetingInfo(meetingId, userName);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK,"유저의 시간 목록 조회", meetingDto), HttpStatus.OK);
    }
}
