package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.SlipEntity;
import org.ict.artpartM.account.entity.SlipRepository;
import org.ict.artpartM.account.model.dto.SlipDto;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlipService {

    private final SlipRepository slipRepository;

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

    public List<SlipDto> getList() {
        List<SlipDto> dtos = new ArrayList<>();

        List<SlipEntity> entities = slipRepository.findAll();
        for(SlipEntity entity: entities){
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
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
}
