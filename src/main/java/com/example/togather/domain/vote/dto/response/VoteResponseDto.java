package com.example.togather.domain.vote.dto.response;

import com.example.togather.domain.vote.entity.Vote;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VoteResponseDto {
    private Long voteId;
    private String userName;
    private String placeName;

    public static VoteResponseDto from(Vote vote){
        return VoteResponseDto.builder()
                .voteId(vote.getVoteId())
                .userName(vote.getUser().getUserName())
                .placeName(vote.getPlace().getPlaceName())
                .build();
    }
}
