package com.example.togather.domain.place.entity;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.vote.entity.Vote;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;
    private String placeName;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vote> votes;
}
