package org.ict.artpart.seesul.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.Pagination;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.seesul.entity.ScheckRepository;
import org.ict.artpart.seesul.entity.SeesulEntity;
import org.ict.artpart.seesul.entity.SeesulRepository;
import org.ict.artpart.seesul.entity.SeesulRepositoryCustom;
import org.ict.artpart.seesul.model.dto.SeesulDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SeesulService {
    private final SeesulRepository seesulRepository;
    private final SeesulRepositoryCustom seesulRepositoryCustom;

    //리스트 조회용
    public Header<List<SeesulDto>> getSeesulList(Pageable pageable, SearchCondition searchCondition) {
        List<SeesulDto> list = new ArrayList<>();

        Page<SeesulEntity> seesulEntities = seesulRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for(SeesulEntity entity : seesulEntities ){
            SeesulDto dto = SeesulDto.builder()
                    .sidx(entity.getSidx())
                    .scategory(entity.getScategory())
                    .sdate(entity.getSdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .swiriter(entity.getSwiriter())
                    .build();
            list.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) seesulEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 15
        );

        return Header.OK(list, pagination);
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
}
