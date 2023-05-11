package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.DreportRepositoryCustom;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.account.entity.DreportEntity;
import org.ict.artpartM.account.entity.DreportRepository;
import org.ict.artpartM.account.model.dto.DreportDto;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DreportService {
    private final DreportRepository dreportRepository;
    private final DreportRepositoryCustom dreportRepositoryCustom;

    public Header<List<DreportDto>> dailyReportList(SearchCondition searchCondition) {
        List<DreportDto> dtos = new ArrayList<>();
        List<DreportEntity> entities = dreportRepositoryCustom.findAllBySearchCondition(searchCondition);

        for (DreportEntity entity : entities) {
            DreportDto dto = DreportDto.builder()
                    .TDIdx(entity.getTDIdx())
                    .TDAccount(entity.getTDAccount())
                    .TDDate(entity.getTDDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .TDDebitIn(entity.getTDDebitIn())
                    .TDDebitOut(entity.getTDDebitOut())
                    .TDDebitTotal(entity.getTDDebitTotal())
                    .TDCreditIn(entity.getTDCreditIn())
                    .TDCreditOut(entity.getTDCreditOut())
                    .TDCreditTotal(entity.getTDCreditTotal())
                    .build();

            dtos.add(dto);
        }

        return Header.OK(dtos);
    }

    public DreportEntity create(DreportDto dreportDto) {
        DreportEntity entity = DreportEntity.builder()
                .TDAccount(dreportDto.getTDAccount())
                .TDDebitIn(dreportDto.getTDDebitIn())
                .TDDebitOut(dreportDto.getTDDebitOut())
                .TDDebitTotal(dreportDto.getTDDebitTotal())
                .TDCreditIn(dreportDto.getTDCreditIn())
                .TDCreditOut(dreportDto.getTDCreditOut())
                .TDCreditTotal(dreportDto.getTDCreditTotal())
                .build();

        return dreportRepository.save(entity);


    }

    public DreportEntity update(DreportDto dreportDto) {
        DreportEntity entity = dreportRepository.findByTDIdx(dreportDto.getTDIdx());
        entity.setTDDebitIn(dreportDto.getTDDebitIn());
        entity.setTDAccount(dreportDto.getTDAccount());
        entity.setTDDebitOut(dreportDto.getTDDebitOut());
        entity.setTDDebitTotal(dreportDto.getTDDebitTotal());
        entity.setTDCreditIn(dreportDto.getTDCreditIn());
        entity.setTDCreditOut(dreportDto.getTDCreditOut());
        entity.setTDCreditTotal(dreportDto.getTDCreditTotal());
        return dreportRepository.save(entity);
    }
}
