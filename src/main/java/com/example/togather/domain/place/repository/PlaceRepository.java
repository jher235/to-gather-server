package com.example.togather.domain.place.repository;

import com.example.togather.domain.place.entity.Place;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByPlaceId(Long placeId);

    Optional<List<Place>>findAllByMeetingMeetingId(UUID uuid);

}
