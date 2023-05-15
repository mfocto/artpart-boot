package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.MreportEntity;
import org.ict.artpartM.account.entity.MreportRepository;
import org.ict.artpartM.account.entity.MreportRepositoryCustom;
import org.ict.artpartM.account.model.dto.MreportDto;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MreportService {
    private final MreportRepository mreportRepository;
    private final MreportRepositoryCustom mreportRepositoryCustom;

    public Header<List<MreportDto>> monthlyReportList(SearchCondition searchCondition) {
        List<MreportDto> dtos = new ArrayList<>();

        List<MreportEntity> entities = mreportRepositoryCustom.findAllBySearchCondition(searchCondition);

        for (MreportEntity entity : entities) {
            MreportDto dto = MreportDto.builder()
                    .TMIdx(entity.getTMIdx())
                    .TMAccount(entity.getTMAccount())
                    .TMDate(entity.getTMDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                    .TMDebitIn(entity.getTMDebitIn())
                    .TMDebitOut(entity.getTMDebitOut())
                    .TMDebitTotal(entity.getTMDebitTotal())
                    .TMCreditIn(entity.getTMCreditIn())
                    .TMCreditOut(entity.getTMCreditOut())
                    .TMCreditTotal(entity.getTMCreditTotal())
                    .build();

            dtos.add(dto);
        }

        return Header.OK(dtos);
    }

    public MreportEntity create(MreportDto mreportDto) {
        MreportEntity entity = MreportEntity.builder()
                .TMAccount(mreportDto.getTMAccount())
                .TMDebitIn(mreportDto.getTMDebitIn())
                .TMDebitOut(mreportDto.getTMDebitOut())
                .TMDebitTotal(mreportDto.getTMDebitTotal())
                .TMCreditIn(mreportDto.getTMCreditIn())
                .TMCreditOut(mreportDto.getTMCreditOut())
                .TMCreditTotal(mreportDto.getTMCreditTotal())
                .build();

        return mreportRepository.save(entity);
    }

    public MreportEntity update(MreportDto mreportDto) {
        MreportEntity entity = mreportRepository.findByTMIdx(mreportDto.getTMIdx());
        entity.setTMAccount(mreportDto.getTMAccount());
        entity.setTMDebitIn(mreportDto.getTMDebitIn());
        entity.setTMDebitOut(mreportDto.getTMDebitOut());
        entity.setTMDebitTotal(mreportDto.getTMDebitTotal());
        entity.setTMCreditIn(mreportDto.getTMCreditIn());
        entity.setTMCreditOut(mreportDto.getTMCreditOut());
        entity.setTMCreditTotal(mreportDto.getTMCreditTotal());
        return mreportRepository.save(entity);
    }
}
