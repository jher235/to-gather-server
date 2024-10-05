package com.example.togather.domain.place.repository;

import com.example.togather.domain.place.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByPlaceName(String placeName);
}
