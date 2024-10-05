package com.example.togather.domain.user.repository;

import com.example.togather.domain.meeting.Meeting;
import com.example.togather.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUserByMeetingMeetingIdAndAndUserName(UUID meetingId, String userName );
}
