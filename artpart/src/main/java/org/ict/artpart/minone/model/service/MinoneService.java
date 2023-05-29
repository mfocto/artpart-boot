package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.Pagination;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.ict.artpart.minone.model.entity.MinoneRepositoryCustom;
import org.ict.artpart.notice.entity.NoticeEntity;
import org.ict.artpart.notice.entity.NoticeRepositoryCustom;
import org.ict.artpart.notice.model.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;
    private final MinoneRepositoryCustom minoneRepositoryCustom;




    //새 글 등록 (**컬럼에 있는 값들은 내가 vue.js에서 사용하지 않더라도 모두 boot에 있어야 함)
    public MinoneEntity create(MinoneDto minoneDto) {       //entity안에 dto를 넣는 메소드임
        MinoneEntity entity = MinoneEntity.builder()
                .memberidx(minoneDto.getMemberidx())
                .mintitle(minoneDto.getMintitle())
                .mintype(minoneDto.getMintype())
                .minstatus(minoneDto.getMinstatus())
                .minres(minoneDto.getMinres())
                .mincategory(minoneDto.getMincategory())
                .build();                                               //빌드 하여라
        return minoneRepository.save(entity);           //되돌려 주어라  //민원 Repository안에 저장해서(민원entity안에 담은 후에)
    }//close



    public Header<List<MinoneDto>> getMinoneList(
            Pageable pageable, SearchCondition searchCondition) {
        List<MinoneDto> dtos = new ArrayList<>();

        Page<MinoneEntity> minoneEntities = minoneRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (MinoneEntity entity : minoneEntities) {
            MinoneDto dto = MinoneDto.builder()
                .minidx(entity.getMinidx())
                .memberidx(entity.getMemberidx())
                .mintitle(entity.getMintitle())
                .mintype(entity.getMintype())
                .minstatus(entity.getMinstatus())
                .minres(entity.getMinres())
                .mincategory(entity.getMincategory())
                .build();

            dtos.add(dto);
        }//for

        Pagination pagination = new Pagination(
            (int) minoneEntities.getTotalElements()
            , pageable.getPageNumber() + 1
            , pageable.getPageSize()
            , 15
        );

        return Header.OK(dtos, pagination);
    }//close


    //글 상세정보 조회
    public MinoneDto getMinone(Long id) {
        MinoneEntity entity = minoneRepository.findById(id).orElseThrow(() -> new RuntimeException("민원정보가없습니다."));
        return MinoneDto.builder()
            .minidx(entity.getMinidx())
            .memberidx(entity.getMemberidx())
            .mintitle(entity.getMintitle())
            .mintype(entity.getMintype())
            .minstatus(entity.getMinstatus())
            .minres(entity.getMinres())
            .mincategory(entity.getMincategory())
            .build();
    }//close


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



} //all close

