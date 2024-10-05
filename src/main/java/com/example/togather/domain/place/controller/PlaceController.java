package com.example.togather.domain.place.controller;

import com.example.togather.domain.place.dto.PlaceDto;
import com.example.togather.domain.place.service.PlaceService;
import com.example.togather.global.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/place")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Operation(summary="장소 투표정보 확인", description="미팅 장소 및 투표 현황을 불러옵니다.")
    @GetMapping("/get-place-info/{meeting_id}")
    public ResponseEntity<ResponseDto<List<PlaceDto>>> getPlaceInfo(@PathVariable("meeting_id") UUID uuid) {
        List<PlaceDto> placeDtos = placeService.getPlaceInfo(uuid);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "장소 정보 확인 완료", placeDtos), HttpStatus.OK);
    }

}
