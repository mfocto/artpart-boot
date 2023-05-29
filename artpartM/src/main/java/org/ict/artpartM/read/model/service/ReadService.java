package org.ict.artpartM.read.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.Pagination;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.read.entity.ReadEntity;
import org.ict.artpartM.read.entity.ReadRepository;
import org.ict.artpartM.read.entity.ReadRepositoryCustom;
import org.ict.artpartM.read.model.dto.ReadDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class ReadService {
    private final ReadRepository readRepository;
    private final ReadRepositoryCustom readRepositoryCustom;

    //검침 조회
    public Header<List<ReadDto>> getReadList(
            Pageable pageable, SearchCondition searchCondition) {
            List<ReadDto> dtos = new ArrayList<>();

            Page<ReadEntity> readEntities = readRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
            for(ReadEntity entity : readEntities){
                LocalDateTime lastMonth = entity.getReaddate().minusMonths(1);
                ReadEntity lastMonthEntity = readRepositoryCustom.findByMemberidxAndReaddate(entity.getMemberidx(), lastMonth);
                ReadDto dto = ReadDto.builder()
                        .readidx(entity.getReadidx())
                        .memberidx(entity.getMemberidx())
                        .lastelectric(lastMonthEntity != null ? lastMonthEntity.getElectric() : 0)
                        .electric(entity.getElectric())
                        .lasthotwater(lastMonthEntity != null ? lastMonthEntity.getHotwater() : 0)
                        .hotwater(entity.getHotwater())
                        .lastwater(lastMonthEntity != null ? lastMonthEntity.getWater() : 0)
                        .water(entity.getWater())
                        .lastheat(lastMonthEntity != null ? lastMonthEntity.getHeat() : 0)
                        .heat(entity.getHeat())
                        .readdate(entity.getReaddate().format(DateTimeFormatter.ofPattern("yyyy-MM")))
                        .build();
                dtos.add(dto);
            }

        Pagination pagination = new Pagination(
                (int) readEntities.getTotalElements()
                , pageable.getPageNumber() +1
                , pageable.getPageSize()
                , 15
        );

            return Header.OK(dtos, pagination);
    }
}
