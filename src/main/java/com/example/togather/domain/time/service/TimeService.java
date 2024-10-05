package com.example.togather.domain.time.service;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.time.Time;
import com.example.togather.domain.time.dto.request.TimeRegister;
import com.example.togather.domain.time.dto.request.TimeRegisterList;
import com.example.togather.domain.time.repository.TimeJpaRepository;
import com.example.togather.domain.user.entity.User;
import com.example.togather.domain.user.repository.UserRepository;
import com.example.togather.exception.NotFoundException;
import com.example.togather.exception.errorcode.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimeService {
    private final TimeJpaRepository timeJpaRepository;
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;

    public void registerTime(TimeRegisterList timeRegisterList, UUID meetingId){

        Set<TimeRegister> timeRegisters = new HashSet(timeRegisterList.getTimeRegisterList());
        User user = findUserByMeetingIdAndUser(meetingId, timeRegisterList.getUserName());
        Meeting meeting = findMeetingByMeetingId(meetingId);

        timeRegisters.forEach(t ->
                register(new Time(t.getBlockNum(),t.isWhether(),t.getMemo(), user, meeting)));


    }


    private void register(Time t){
        timeJpaRepository.save(t);
    }

    private User findUserByMeetingIdAndUser(UUID meetingId, String name){
        return userRepository.findUserByMeetingMeetingIdAndAndUserName(meetingId, name).orElseThrow(()->
                new NotFoundException(ErrorCode.USER_NOT_FOUND));
    };

    private Meeting findMeetingByMeetingId(UUID meetingId){
        return meetingRepository.findByMeetingId(meetingId).orElseThrow(
                ()->new NotFoundException(ErrorCode.MEETING_NOT_FOUND));
    }


}
