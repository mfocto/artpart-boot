package org.ict.artpartM.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MeetingEntity;
import org.ict.artpartM.member.entity.MeetingRepository;
import org.ict.artpartM.member.entity.MeetingRepositoryCustom;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.model.dto.MeetingDto;
import org.ict.artpartM.member.model.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final MeetingRepositoryCustom meetingRepositoryCustom;

    public Header<List<MeetingDto>> getMemberList(
            Pageable pageable, SearchCondition searchCondition){
        List<MeetingDto> dtos = new ArrayList<>();

        Page<MeetingEntity> meetingEntities = meetingRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(MeetingEntity entity : meetingEntities){
            MeetingDto dto = MeetingDto.builder()
                    .meetingidx(entity.getMeetingidx())
                    .meetingtime(entity.getMeetingtime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .meetingtitle(entity.getMeetingtitle())
                    .meetingcontent(entity.getMeetingcontent())
                    .meetingid(entity.getMeetingid())
                    .meetingopen(entity.getMeetingopen())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) meetingEntities.getTotalElements()
                ,pageable.getPageNumber() + 1
                ,pageable.getPageSize()
                ,15
        );

        return Header.OK(dtos,pagination);
    }

    //입주민정보 가져오기
    public MeetingDto getMeeting(Long id){
        MeetingEntity entity = meetingRepository.findById(id).orElseThrow(() -> new RuntimeException("회의정보가없습니다."));
        return MeetingDto.builder()
                .meetingidx(entity.getMeetingidx())
                .meetingtime(entity.getMeetingtime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .meetingtitle(entity.getMeetingtitle())
                .meetingcontent(entity.getMeetingcontent())
                .meetingid(entity.getMeetingid())
                .meetingopen(entity.getMeetingopen())
                .build();
    }

    //등록
    public MeetingEntity create(MeetingDto meetingDto){
        MeetingEntity entity = MeetingEntity.builder()
                .meetingidx(meetingDto.getMeetingidx())
                .meetingtime(LocalDate.now())
                .meetingtitle(meetingDto.getMeetingtitle())
                .meetingcontent(meetingDto.getMeetingcontent())
                .meetingid(meetingDto.getMeetingid())
                .meetingopen(meetingDto.getMeetingopen())
                .build();
        return meetingRepository.save(entity);
    }

    //수정
    public MeetingEntity update(MeetingDto meetingDto){
        MeetingEntity entity = meetingRepository.findByMeetingidx(meetingDto.getMeetingidx());
        entity.setMeetingtime(LocalDate.now());
        entity.setMeetingtitle(meetingDto.getMeetingtitle());
        entity.setMeetingcontent(meetingDto.getMeetingcontent());
        entity.setMeetingopen(meetingDto.getMeetingopen());
        return meetingRepository.save(entity);
    }

    //삭제
    public void delete(Long id){
        MeetingEntity entity = meetingRepository.findById(id).orElseThrow(()-> new RuntimeException("회의를 찾을 수 없습니다."));
        meetingRepository.delete(entity);
    }

}
