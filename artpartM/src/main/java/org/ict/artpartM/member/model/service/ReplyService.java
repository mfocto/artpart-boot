package org.ict.artpartM.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MeetingEntity;
import org.ict.artpartM.member.entity.ReplyEntity;
import org.ict.artpartM.member.entity.ReplyRepository;
import org.ict.artpartM.member.entity.ReplyRepositoryCustom;
import org.ict.artpartM.member.model.dto.MeetingDto;
import org.ict.artpartM.member.model.dto.ReplyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;




    //입주민정보 가져오기
    public ReplyDto getReply(Long id){
        ReplyEntity entity = replyRepository.findById(id).orElseThrow(() -> new RuntimeException("정보가없습니다."));
        return ReplyDto.builder()
                .memberidx(entity.getMemberidx())
                .votingidx(entity.getVotingidx())
                .replyid(entity.getReplyid())
                .build();
    }



}
