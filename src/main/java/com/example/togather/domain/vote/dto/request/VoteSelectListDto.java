package com.example.togather.domain.vote.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class VoteSelectListDto {
    private List<VoteSelectDto> voteSelectDtoList;
}
