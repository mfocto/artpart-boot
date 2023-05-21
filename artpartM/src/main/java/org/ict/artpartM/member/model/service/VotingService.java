package org.ict.artpartM.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.*;
import org.ict.artpartM.member.model.dto.MeetingDto;
import org.ict.artpartM.member.model.dto.VotingDto;
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
public class VotingService {
    private final VotingRepository votingRepository;
    private final VotingRepositoryCustom votingRepositoryCustom;
    private final MemberRepositoryCustom memberRepositoryCustom;

    public Header<List<VotingDto>> getVotingList(
            Pageable pageable, SearchCondition searchCondition){
        List<VotingDto> dtos = new ArrayList<>();

        Page<VotingEntity> votingEntities = votingRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(VotingEntity entity : votingEntities){
            VotingDto dto = VotingDto.builder()
                    .votingidx(entity.getVotingidx())
                    .category(entity.getCategory())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .starttime(entity.getStarttime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .endtime(entity.getEndtime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .answer1(entity.getAnswer1())
                    .answer2(entity.getAnswer2())
                    .answer3(entity.getAnswer3())
                    .answer4(entity.getAnswer4())
                    .answer5(entity.getAnswer5())
                    .votingwriter(entity.getVotingwriter())
                    .votingstart(entity.getVotingstart())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) votingEntities.getTotalElements()
                ,pageable.getPageNumber() + 1
                ,pageable.getPageSize()
                ,15
        );

        return Header.OK(dtos,pagination);
    }

    //입주민정보 가져오기
    public VotingDto getVoting(Long id){
        VotingEntity entity = votingRepository.findById(id).orElseThrow(() -> new RuntimeException("투표정보가없습니다."));
        long ab = memberRepositoryCustom.membercount();
        return VotingDto.builder()
                .votingidx(entity.getVotingidx())
                .category(entity.getCategory())
                .title(entity.getTitle())
                .content(entity.getContent())
                .starttime(entity.getStarttime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .endtime(entity.getEndtime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .answer1(entity.getAnswer1())
                .answer2(entity.getAnswer2())
                .answer3(entity.getAnswer3())
                .answer4(entity.getAnswer4())
                .answer5(entity.getAnswer5())
                .votingwriter(entity.getVotingwriter())
                .votingstart(entity.getVotingstart())
                .membercount(ab)
                .build();
    }

    //등록
    public VotingEntity create(VotingDto votingDto){
        VotingEntity entity = VotingEntity.builder()
                .votingidx(votingDto.getVotingidx())
                .category(votingDto.getCategory())
                .title(votingDto.getTitle())
                .content(votingDto.getContent())
                .starttime(LocalDate.parse(votingDto.getStarttime()))
                .endtime(LocalDate.parse(votingDto.getEndtime()))
                .answer1(votingDto.getAnswer1())
                .answer2(votingDto.getAnswer2())
                .answer3(votingDto.getAnswer3())
                .answer4(votingDto.getAnswer4())
                .answer5(votingDto.getAnswer5())
                .votingwriter(votingDto.getVotingwriter())
                .votingstart(votingDto.getVotingstart())
                .build();
        return votingRepository.save(entity);
    }

    //수정
    public VotingEntity update(VotingDto votingDto){
        VotingEntity entity = votingRepository.findByVotingidx(votingDto.getVotingidx());
        entity.setCategory(votingDto.getCategory());
        entity.setTitle(votingDto.getTitle());
        entity.setContent(votingDto.getContent());
        entity.setStarttime(LocalDate.parse(votingDto.getStarttime()));
        entity.setEndtime(LocalDate.parse(votingDto.getEndtime()));
        entity.setAnswer1(votingDto.getAnswer1());
        entity.setAnswer2(votingDto.getAnswer2());
        entity.setAnswer3(votingDto.getAnswer3());
        entity.setAnswer4(votingDto.getAnswer4());
        entity.setAnswer5(votingDto.getAnswer5());
        entity.setVotingwriter(votingDto.getVotingwriter());
        entity.setVotingstart(votingDto.getVotingstart());
        return votingRepository.save(entity);
    }

    //삭제
    public void delete(Long id){
        VotingEntity entity = votingRepository.findById(id).orElseThrow(()-> new RuntimeException("투표를 찾을 수 없습니다."));
        votingRepository.delete(entity);
    }
}
