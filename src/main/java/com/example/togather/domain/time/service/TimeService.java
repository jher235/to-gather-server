package com.example.togather.domain.time.service;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.time.dto.request.DeleteTimeRequest;
import com.example.togather.domain.time.dto.response.TimeResponse;
import com.example.togather.domain.time.entity.Time;
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
import java.util.List;
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

    public List<TimeResponse> getTimeList(UUID meetingId){
        Meeting meeting = findMeetingByMeetingId(meetingId);
        List<Time> timeList = timeJpaRepository.findAllByMeeting(meeting);

        return timeList.stream().map(TimeResponse::from).toList();
    }

    public void deleteTimeList(DeleteTimeRequest deleteTimeRequest, UUID meetingId){
        List<Long> timeId = deleteTimeRequest.getDeleteTimeIdList();
        timeId.forEach(timeJpaRepository::deleteById);
    }

    public List<TimeResponse> getUserTimeList(String userName, UUID meetingId){
        User user = findUserByMeetingIdAndUser(meetingId, userName);
        List<Time> timeList = timeJpaRepository.findAllByMeetingAndUser(findMeetingByMeetingId(meetingId), user);
        return timeList.stream().map(TimeResponse::from).toList();
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
