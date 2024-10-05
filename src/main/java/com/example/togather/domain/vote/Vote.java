package com.example.togather.domain.vote;

import com.example.togather.domain.place.Place;
import com.example.togather.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

    public Vote(User user, Place place){
        this.user = user;
        this.place = place;
    }
}
