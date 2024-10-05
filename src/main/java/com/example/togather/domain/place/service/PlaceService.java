package com.example.togather.domain.place.service;

import com.example.togather.domain.place.dto.PlaceDto;
import com.example.togather.domain.place.repository.PlaceRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
