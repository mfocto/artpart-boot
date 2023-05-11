package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;



    //########################################################################
    //민원 정보 전체리스트 조회 => findAll은 Repository 코드가 따로 필요치 않음
    public List<MinoneDto> getMinoneList(){
        List<MinoneEntity> minoneEntityList = minoneRepository.findAll();
        List<MinoneDto> list = new ArrayList<>();

        for(MinoneEntity entity : minoneEntityList){
            MinoneDto minoneDto = MinoneDto.builder()
                    .minIdx(entity.getMinIdx())
                    .memberIdx(entity.getMemberIdx())
                    .minTitle(entity.getMinTitle())
                    .minType(entity.getMinType())
                    .minStatus(entity.getMinStatus())
                    .minRes(entity.getMinRes())
                    .minFile(entity.getMinFile())
                    .minRename(entity.getMinRename())
                    .minCategory(entity.getMinCategory())

                    .build();
            log.info(minoneDto.toString()); //확인

            list.add(minoneDto);
        }

        return list;
    }



    //########################################################################
    //1명이 작성한 게시글 모두 조회
    public List<MinoneDto> getMinoneByMemberIdx(Long memberIdx) {
        List<MinoneEntity> minoneEntityList = minoneRepository.findByMemberIdx(memberIdx);
        List<MinoneDto> list = new ArrayList<>();

        for (MinoneEntity entity : minoneEntityList) {
            MinoneDto minoneDto = MinoneDto.builder()
                    .minIdx(entity.getMinIdx())
                    .memberIdx(entity.getMemberIdx())
                    .minTitle(entity.getMinTitle())
                    .minType(entity.getMinType())
                    .minStatus(entity.getMinStatus())
                    .minRes(entity.getMinRes())
                    .minFile(entity.getMinFile())
                    .minRename(entity.getMinRename())
                    .minCategory(entity.getMinCategory())

                    .build();
            log.info(minoneDto.toString()); //확인

            list.add(minoneDto);
        }

        return list;
    }



}
