package com.example.togather.domain.meeting.controller;

import com.example.togather.domain.meeting.dto.MeetingDto;
import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.service.MeetingService;
import java.util.UUID;
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

    @PostMapping("/createMeeting")
    public Meeting createMeeting(@RequestBody MeetingDto meetingDto) {
        return meetingService.createMeeting(meetingDto);
    }

    @GetMapping("/checkMeeting/{id}")
    public Meeting checkMeeting(@PathVariable UUID id) {
        return meetingService.checkMeeting(id);
    }
}
