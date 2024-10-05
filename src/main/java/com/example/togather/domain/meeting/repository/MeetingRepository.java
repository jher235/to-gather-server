package com.example.togather.domain.meeting.repository;

import com.example.togather.domain.meeting.entity.Meeting;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {

    Optional<Meeting> findByMeetingId(UUID id);
}
