package com.example.togather.domain.vote.service;

import com.example.togather.domain.meeting.entity.Meeting;
import com.example.togather.domain.meeting.repository.MeetingRepository;
import com.example.togather.domain.place.entity.Place;
import com.example.togather.domain.place.repository.PlaceRepository;
import com.example.togather.domain.user.User;
import com.example.togather.domain.user.repository.UserRepository;
import com.example.togather.domain.vote.entity.Vote;
import com.example.togather.domain.vote.repository.VoteRepository;
import com.example.togather.domain.vote.dto.request.VoteSelectDto;
import com.example.togather.domain.vote.dto.request.VoteSelectListDto;
import com.example.togather.domain.vote.dto.response.VoteResponseData;
import com.example.togather.exception.NotFoundException;
import com.example.togather.exception.errorcode.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final MeetingRepository meetingRepository;

    /**
     * 투표하기
     *
     **/
    public void voting(VoteSelectListDto voteSelectListDto) {

        for (VoteSelectDto voteSelectDto : voteSelectListDto.getVoteSelectDtoList()) {
            User user = userRepository.findByUserName(voteSelectDto.getUserName())
                    .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_USER));
            Place place = placeRepository.findByPlaceId(voteSelectDto.getPlaceId())
                    .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_PLACE));
            Meeting meeting = meetingRepository.findById(voteSelectDto.getMeetingId())
                    .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_MEETING));

            Vote vote = new Vote(user, place, meeting);
            voteRepository.save(vote);  // 투표 데이터 저장
        }
    }

    /**
     * 투표 결과 조회
     *
     **/
    public VoteResponseData getVoteResult(UUID meetingId){
        Meeting meeting = meetingRepository.findByMeetingId(meetingId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_MEETING));
        return VoteResponseData.from(meeting);
    }
}
