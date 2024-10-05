package com.example.togather.domain.time.controller;

import com.example.togather.domain.time.dto.request.DeleteTimeRequest;
import com.example.togather.domain.time.dto.request.TimeRegisterList;
import com.example.togather.domain.time.dto.response.TimeResponse;
import com.example.togather.domain.time.service.TimeService;
import com.example.togather.global.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @PostMapping("/meeting/{meeting_id}/time")
    @Operation(summary="시간 리스트 등록", description="시간 목록을 등록합니다. 시간에 대한 정보는 30분 단위로 잘림.")
    public ResponseEntity<ResponseDto<Void>> registerTime(@RequestBody TimeRegisterList timeRegisterList,
                                                          @PathVariable("meeting_id")UUID meetingId){
        timeService.registerTime(timeRegisterList, meetingId);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "시간 목록 등록 성공"),HttpStatus.OK);
    }

    @Operation(summary="시간 리스트 삭제", description="기존 등록되어있던 시간 목록을 삭제합니다. 시간에 대한 정보는 30분 단위로 잘림.")
    @DeleteMapping("/meeting/{meeting_id}/time")
    public ResponseEntity<ResponseDto<Void>> deleteTime(@PathVariable("meeting_id")UUID meetingId,
                                                        @RequestBody DeleteTimeRequest deleteTimeRequest){
        timeService.deleteTimeList(deleteTimeRequest, meetingId);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK,"시간 목록 삭제 완료"), HttpStatus.OK);
    }

}
