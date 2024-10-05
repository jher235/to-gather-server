package com.example.togather.domain.meeting.entity;

import com.example.togather.domain.place.entity.Place;
import com.example.togather.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    private UUID meetingId;
    private String meetingTitle;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "meeting",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> users;

    @OneToMany(mappedBy = "meeting")
    @JsonManagedReference
    private List<Place> places;

}
