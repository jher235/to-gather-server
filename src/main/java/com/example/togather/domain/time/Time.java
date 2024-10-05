package com.example.togather.domain.time;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeId;

    @Column(nullable = false)
    private Long blockId;

    @Column(nullable = false)
    private boolean whether;

    @Column(length = 1000)
    private String memo;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    public Time(final Long blockId,
                final boolean whether,
                final String memo,
                final User user,
                final Meeting meeting){
        this.blockId = blockId;
        this.whether = whether;
        this.memo = memo;
        this.user = user;
        this.meeting = meeting;
    }

    public Time(final Long blockId,
                final boolean whether,
                final User user,
                final Meeting meeting){
        this.blockId = blockId;
        this.whether = whether;
        this.memo = null;
        this.user = user;
        this.meeting = meeting;
    }

}

