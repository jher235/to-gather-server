package com.example.togather.domain.vote.entity;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.place.entity.Place;
import com.example.togather.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Getter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    public Vote(User user, Place place, Meeting meeting){
        this.user = user;
        this.place = place;
        this.meeting = meeting;
    }
}
