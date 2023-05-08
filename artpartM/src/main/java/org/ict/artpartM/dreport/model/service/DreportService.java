package org.ict.artpartM.dreport.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.dreport.entity.DreportEntity;
import org.ict.artpartM.dreport.entity.DreportRepository;
import org.ict.artpartM.dreport.model.dto.DreportDto;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DreportService {
    private final DreportRepository dreportRepository;

    public Header<List<DreportDto>> dailyReportList() {
        List<DreportDto> dtos = new ArrayList<>();

        List<DreportEntity> entities = dreportRepository.findAll();
        for (DreportEntity entity : entities) {
            DreportDto dto = DreportDto.builder()
                    .trialDailyIdx(entity.getTrialDailyIdx())
                    .trialDailyAccount(entity.getTrialDailyAccount())
                    .trialDailyDate(entity.getTrialDailyDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .trialDailyDebitIn(entity.getTrialDailyDebitIn())
                    .trialDailyDebitOut(entity.getTrialDailyDebitOut())
                    .trialDailyDebitTotal(entity.getTrialDailyDebitTotal())
                    .trialDailyCreditIn(entity.getTrialDailyCreditIn())
                    .trialDailyCreditOut(entity.getTrialDailyCreditOut())
                    .trialDailyCreditTotal(entity.getTrialDailyCreditTotal())
                    .build();

            dtos.add(dto);
        }

        return Header.OK(dtos);
    }

    public DreportEntity create(DreportDto dreportDto) {
        DreportEntity entity = DreportEntity.builder()
                .trialDailyAccount(dreportDto.getTrialDailyAccount())
                .trialDailyDebitIn(dreportDto.getTrialDailyDebitIn())
                .trialDailyDebitOut(dreportDto.getTrialDailyDebitOut())
                .trialDailyDebitTotal(dreportDto.getTrialDailyDebitTotal())
                .trialDailyCreditIn(dreportDto.getTrialDailyCreditIn())
                .trialDailyCreditOut(dreportDto.getTrialDailyCreditOut())
                .trialDailyCreditTotal(dreportDto.getTrialDailyCreditTotal())
                .build();

        return dreportRepository.save(entity);


    }
}
