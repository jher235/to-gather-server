package com.example.togather.domain.vote.dto.response;

import com.example.togather.domain.meeting.entity.Meeting;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class VoteResponseData {
    private List<VoteResponseDto> voteResponseDtoList;

    public static VoteResponseData from(Meeting meeting){
        return VoteResponseData.builder()
                .voteResponseDtoList(meeting.getVotes().stream()
                        .map(VoteResponseDto::from)
                        .toList())
                .build();
    }
}
