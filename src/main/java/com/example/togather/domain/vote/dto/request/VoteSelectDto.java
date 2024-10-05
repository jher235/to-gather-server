package com.example.togather.domain.vote.dto.request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class VoteSelectDto {
    private UUID meetingId;
    private Long placeId;
    private String userName;
}
