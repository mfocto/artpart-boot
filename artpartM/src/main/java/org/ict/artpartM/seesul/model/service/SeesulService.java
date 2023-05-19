package org.ict.artpartM.seesul.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.seesul.entity.SeesulEntity;
import org.ict.artpartM.seesul.entity.SeesulRepository;
import org.ict.artpartM.seesul.entity.SeesulRepositoryCustom;
import org.ict.artpartM.seesul.model.dto.SeesulDto;
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
public class SeesulService {
    private final SeesulRepository seesulRepository;
    private final SeesulRepositoryCustom seesulRepositoryCustom;
    public Header<List<SeesulDto>> getSeesulList(
            Pageable pageable, SearchCondition searchCondition) {
        List<SeesulDto> dtos = new ArrayList<>();

        Page<SeesulEntity> seesulEntities = seesulRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(SeesulEntity entity : seesulEntities){
            SeesulDto dto = SeesulDto.builder()
                    .sidx(entity.getSidx())
                    .scategory(entity.getScategory())
                    .sdate(entity.getSdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .swiriter(entity.getSwiriter())
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) seesulEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 15
        );

        return Header.OK(dtos, pagination);
    }

    //점검 상세보기
    public SeesulDto getSeesul(Long id) {
        SeesulEntity entity = seesulRepository.findById(id).orElseThrow(() -> new RuntimeException("글을 찾을 수 없습니다."));
        return SeesulDto.builder()
                .sidx(entity.getSidx())
                .scategory(entity.getScategory())
                .sdate(entity.getSdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .swiriter(entity.getSwiriter())
                .build();
    }

    //점검 등록
    public SeesulEntity create(SeesulDto seesulDto) {
        SeesulEntity entity = SeesulEntity.builder()
                .sidx(seesulDto.getSidx())
                .scategory(seesulDto.getScategory())
                .sdate(LocalDate.now())
                .swiriter(seesulDto.getSwiriter())
                .build();
        return seesulRepository.save(entity);
    }

    //점검 수정
    public SeesulEntity update(SeesulDto seesulDto) {
        SeesulEntity entity = seesulRepository.findBySidx(seesulDto.getSidx());
        entity.setSdate(LocalDate.now());
        entity.setSwiriter(seesulDto.getSwiriter());
        return seesulRepository.save(entity);
    }
}
