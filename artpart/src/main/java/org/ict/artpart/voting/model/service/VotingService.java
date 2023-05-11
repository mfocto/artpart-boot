package org.ict.artpart.voting.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.voting.model.dto.VotingDto;
import org.ict.artpart.voting.model.entity.VotingEntity;
import org.ict.artpart.voting.model.entity.VotingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class VotingService {
    private final VotingRepository votingRepository;


    //투표설문 전체리스트 조회
    public List<VotingDto> selectVotingList(){
        List<VotingEntity> votingEntityList = votingRepository.findAll();
        List<VotingDto> list = new ArrayList<>();

        for(VotingEntity entity : votingEntityList){
            VotingDto votingDto = VotingDto.builder()
                    .votingIdx(entity.getVotingIdx())
                    .memberIdx(entity.getMemberIdx())
                    .category(entity.getCategory())
                    .title(entity.getTitle())
                    .startTime(entity.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .endTime(entity.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .answer1(entity.getAnswer1())
                    .answer2(entity.getAnswer2())
                    .answer3(entity.getAnswer3())
                    .answer4(entity.getAnswer4())
                    .answer5(entity.getAnswer5())

                    .build();
            log.info(votingDto.toString());

            list.add(votingDto);
        }

        return list;
    }

}
