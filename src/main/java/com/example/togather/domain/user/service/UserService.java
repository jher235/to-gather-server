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

        // 유저와 미팅 간의 관계 설정
        user.setMeeting(meeting.get());

        // 중복 유저 체크

        List<User> users = meeting.get().getUsers();
        for (User u : users) {
            if (u.getUserName().equals(userDto.getUserName())) {
                throw new BadRequestException(ErrorCode.USER_DUPLICATION);
            }
        }

        // 유저 생성 및 미팅과 연관관계 설정
        user.setMeeting(meeting.get());  // 유저에 미팅 설정

        // 유저를 미팅에 추가 (단일 방향으로만 추가)
        meeting.get().getUsers().add(user);

        // 유저 저장 (유저는 미팅과 연결되므로 별도의 meeting.setUsers() 불필요)
        userRepository.save(user);

        // 미팅을 저장할 필요 없음 (유저 저장 시 연관관계 자동 업데이트)

        return user;
    }
}
