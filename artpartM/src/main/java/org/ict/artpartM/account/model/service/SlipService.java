package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.SlipEntity;
import org.ict.artpartM.account.entity.SlipRepository;
import org.ict.artpartM.account.model.dto.SlipDto;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlipService {

    private final SlipRepository slipRepository;

    public SlipEntity create(SlipDto slipDto) {
        SlipEntity entity = SlipEntity.builder()
                .slipIdx(slipDto.getSlipIdx())
                .slipNo(slipDto.getSlipNo())
                .slipType(slipDto.getSlipType())
                .slipComp(slipDto.getSlipComp())
                .slipNote(slipDto.getSlipNote())
                .slipItem(slipDto.getSlipItem())
                .slipCash(slipDto.getSlipCash())
                .build();
        return slipRepository.save(entity);
    }
}
