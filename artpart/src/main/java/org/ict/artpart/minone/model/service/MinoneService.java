package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;



    //########################################################################
    //민원번호로 민원 전체리스트 조회
    public List<MinoneEntity> list() throws Exception {
        return minoneRepository.findAll(Sort.by(Sort.Direction.DESC, "minIdx"));
    }



    //########################################################################
    //내 민원 삭제 요청처리용
    public void deleteMyMinone(Long minIdx)  {

    }//deleteMyMinone


    //########################################################################
    //민원등록
    public void register(MinoneEntity minone) {
        minoneRepository.save(minone);
    }//register



    //########################################################################
    //특정 게시글 번호에 해당하는 게시글정보 조회
    public MinoneEntity read(Long minIdx) throws Exception {
        return minoneRepository.getOne(minIdx);
    }



    //########################################################################



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
        }//getMinoneByMemberIdx

        return list;
    }








    //########################################################################
    //########################################################################
    //########################################################################








} //all close
