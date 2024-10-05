package com.example.togather.domain.user.service;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.user.dto.UserDto;
import com.example.togather.domain.user.entity.User;
import com.example.togather.domain.user.repository.UserRepository;
import com.example.togather.exception.BadRequestException;
import com.example.togather.exception.NotFoundException;
import com.example.togather.exception.errorcode.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

        Optional<Meeting> meeting = meetingRepository.findByMeetingId(uuid);
        if (meeting.isEmpty()) {
            throw new NotFoundException(ErrorCode.MEETING_NOT_FOUND);
        }
        List<User> users = meeting.get().getUsers();
        for(User u : users){
            if(u.getUserName().equals(userDto.getUserName())){
                throw new BadRequestException(ErrorCode.USER_DUPLICATION);
            }
        }
        users.add(user);
        meeting.get().setUsers(users);
        meetingRepository.save(meeting.get());

        return userRepository.save(user);
    }
}
