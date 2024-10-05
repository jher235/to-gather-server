package com.example.togather.domain.user.repository;

import com.example.togather.domain.meeting.Meeting;
import com.example.togather.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
