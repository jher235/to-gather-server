package com.example.togather.domain.place.service;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.place.dto.PlaceDto;
import com.example.togather.domain.place.entity.Place;
import com.example.togather.domain.place.repository.PlaceRepository;
import com.example.togather.domain.vote.repository.VoteRepository;
import com.example.togather.exception.NotFoundException;
import com.example.togather.exception.errorcode.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final MeetingRepository meetingRepository;

    public PlaceService(PlaceRepository placeRepository, MeetingRepository meetingRepository) {
        this.placeRepository = placeRepository;
        this.meetingRepository = meetingRepository;
    }

    public List<PlaceDto> getPlaceInfo(UUID uuid) {
        Optional<List<Place>> places = placeRepository.findAllByMeetingMeetingId(uuid);
        if (places.isEmpty()) {
            throw new NotFoundException(ErrorCode.NOT_FOUND_PLACE);
        }
        List<PlaceDto> placeDtos = new ArrayList<>();
        for(Place place : places.get()) {
            PlaceDto placeDto = new PlaceDto();
            placeDto.setName(place.getPlaceName());
            placeDto.setLikes(place.getVotes().size());
            placeDtos.add(placeDto);
        }
        return placeDtos;
    }
}
