package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.SlipEntity;
import org.ict.artpartM.account.entity.SlipRepository;
import org.ict.artpartM.account.entity.SlipRepositoryCustom;
import org.ict.artpartM.account.model.dto.SlipDto;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlipService {

    private final SlipRepository slipRepository;
    private final SlipRepositoryCustom slipRepositoryCustom;

    public SlipEntity create(SlipDto slipDto) {
        SlipEntity entity = SlipEntity.builder()
                .slipIdx(slipDto.getSlipIdx())
                .slipNo(slipDto.getSlipNo())
                .slipBrif(slipDto.getSlipBrif())
                .slipWriter(slipDto.getSlipWriter())
                .slipType(slipDto.getSlipType())
                .slipComp(slipDto.getSlipComp())
                .slipNote(slipDto.getSlipNote())
                .slipItem(slipDto.getSlipItem())
                .slipCash(slipDto.getSlipCash())
                .build();
        return slipRepository.save(entity);
    }

    public List<SlipDto> getList(SearchCondition searchCondition) {
        List<SlipDto> dtos = new ArrayList<>();
        List<SlipEntity> entities = slipRepositoryCustom.findAllBySearchCondition(searchCondition);
        for (SlipEntity entity : entities) {
            SlipDto dto = SlipDto.builder()
                    .slipIdx(entity.getSlipIdx())
                    .slipNo(entity.getSlipNo())
                    .slipDate(entity.getSlipDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .slipWriter(entity.getSlipWriter())
                    .slipItem(entity.getSlipItem())
                    .slipComp(entity.getSlipComp())
                    .slipBrif(entity.getSlipBrif())
                    .slipCash(entity.getSlipCash())
                    .slipNote(entity.getSlipNote())
                    .slipType(entity.getSlipType())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    public SlipEntity update(SlipDto slipDto) {
        SlipEntity entity = slipRepository.findBySlipIdx(slipDto.getSlipIdx());
        entity.setSlipType(slipDto.getSlipType());
        entity.setSlipItem(slipDto.getSlipItem());
        entity.setSlipComp(slipDto.getSlipComp());
        entity.setSlipBrif(slipDto.getSlipBrif());
        entity.setSlipCash(slipDto.getSlipCash());
        entity.setSlipNote(slipDto.getSlipNote());
        return slipRepository.save(entity);
    }
}
