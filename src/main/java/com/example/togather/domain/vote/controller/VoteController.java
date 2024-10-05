package com.example.togather.domain.vote.controller;

import com.example.togather.domain.vote.dto.request.VoteSelectDto;
import com.example.togather.domain.vote.dto.response.VoteResponseData;
import com.example.togather.domain.vote.service.VoteService;
import com.example.togather.global.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    /**
     * 투표하기
     *
     **/
    @PostMapping
    public ResponseEntity<ResponseDto<Void>> voting(@RequestBody @Valid VoteSelectDto voteSelectDto) {
        voteService.voting(voteSelectDto);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "투표 완료"), HttpStatus.CREATED);
    }

    /**
     * 투표 결과 조회
     *
     **/
    @GetMapping("/{meetingId}")
    public ResponseEntity<ResponseDto<VoteResponseData>> getVoteResult(@PathVariable UUID meetingId) {
        VoteResponseData voteResponseData = voteService.getVoteResult(meetingId);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "투표 결과 조회 완료", voteResponseData), HttpStatus.OK);
    }
}
