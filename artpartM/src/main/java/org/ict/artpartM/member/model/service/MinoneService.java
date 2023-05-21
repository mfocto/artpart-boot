package org.ict.artpartM.member.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.member.entity.MinoneEntity;
import org.ict.artpartM.member.entity.MinoneRepository;
import org.ict.artpartM.member.entity.MinoneRepositoryCustom;
import org.ict.artpartM.member.model.dto.MinoneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MinoneService {
    private final MinoneRepository minoneRepository;
    private final MinoneRepositoryCustom minoneRepositoryCustom;

    public Header<List<MinoneDto>> getMinoneList(
            Pageable pageable, SearchCondition searchCondition){
        List<MinoneDto> dtos = new ArrayList<>();

        Page<MinoneEntity> minoneEntities = minoneRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(MinoneEntity entity : minoneEntities){
            MinoneDto dto = MinoneDto.builder()
                    .minidx(entity.getMinidx())
                    .memberidx(entity.getMemberidx())
                    .mintitle(entity.getMintitle())
                    .mintype(entity.getMintype())
                    .minstatus(entity.getMinstatus())
                    .minres(entity.getMinres())
                    .minfile(entity.getMinfile())
                    .minrename(entity.getMinrename())
                    .mincategory(entity.getMincategory())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) minoneEntities.getTotalElements()
                ,pageable.getPageNumber() + 1
                ,pageable.getPageSize()
                ,15
        );

        return Header.OK(dtos,pagination);
    }

    //입주민정보 가져오기
    public MinoneDto getMinone(Long id){
        MinoneEntity entity = minoneRepository.findById(id).orElseThrow(() -> new RuntimeException("민원정보가없습니다."));
        return MinoneDto.builder()
                .minidx(entity.getMinidx())
                .memberidx(entity.getMemberidx())
                .mintitle(entity.getMintitle())
                .mintype(entity.getMintype())
                .minstatus(entity.getMinstatus())
                .minres(entity.getMinres())
                .minfile(entity.getMinfile())
                .minrename(entity.getMinrename())
                .mincategory(entity.getMincategory())
                .build();
    }

    //등록
    public MinoneEntity create(MinoneDto minoneDto){
        MinoneEntity entity = MinoneEntity.builder()
                .minidx(minoneDto.getMinidx())
                .memberidx(minoneDto.getMemberidx())
                .mintitle(minoneDto.getMintitle())
                .mintype(minoneDto.getMintype())
                .minstatus(minoneDto.getMinstatus())
                .minres(minoneDto.getMinres())
                .minfile(minoneDto.getMinfile())
                .minrename(minoneDto.getMinrename())
                .mincategory(minoneDto.getMincategory())
                .build();
        return minoneRepository.save(entity);
    }

    //수정
    public MinoneEntity update(MinoneDto minoneDto){
        MinoneEntity entity = minoneRepository.findByMinidx(minoneDto.getMinidx());
        entity.setMinstatus(minoneDto.getMinstatus());
        entity.setMinres(minoneDto.getMinres());
        return minoneRepository.save(entity);
    }

    //삭제
    public void delete(Long id){
        MinoneEntity entity = minoneRepository.findById(id).orElseThrow(()-> new RuntimeException("민원을 찾을 수 없습니다."));
        minoneRepository.delete(entity);
    }
}
