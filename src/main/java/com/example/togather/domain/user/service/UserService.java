package com.example.togather.domain.user.service;

import com.example.togather.domain.meeting.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.user.dto.UserDto;
import com.example.togather.domain.user.entity.User;
import com.example.togather.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;

    public User createUser(UserDto userDto, UUID uuid) {
        User user = new User();
        user.setUserName(userDto.getUserName());

        Optional<Meeting> meeting  = meetingRepository.findByMeetingId(uuid);
        if(meeting.isEmpty()){
            throw new
        }
        
        return userRepository.save(user);
    }
}
