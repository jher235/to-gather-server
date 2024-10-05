package com.example.togather.domain.time;

import com.example.togather.domain.meeting.Meeting;
import com.example.togather.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeId;
    private Long blockId;
    private boolean whether;
    private String memo;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
}

