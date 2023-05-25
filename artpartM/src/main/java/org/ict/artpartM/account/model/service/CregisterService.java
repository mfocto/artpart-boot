package org.ict.artpartM.account.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.CregisterEntity;
import org.ict.artpartM.account.entity.CregisterRepository;
import org.ict.artpartM.account.entity.CregisterRepositoryCustom;
import org.ict.artpartM.account.model.dto.CregisterDto;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CregisterService {
    private final CregisterRepository cregisterRepository;
    private final CregisterRepositoryCustom cregisterRepositoryCustom;
    public List<CregisterDto> getList(SearchCondition searchCondition) {
        List<CregisterDto> dtos = new ArrayList<>();
        List<CregisterEntity> entities = cregisterRepositoryCustom.findAllBySearchCondition(searchCondition);
        for(CregisterEntity entity : entities){
           CregisterDto dto = CregisterDto.builder()
                   .crIdx(entity.getCrIdx())
                   .crDate(entity.getCrDate().toString())
                   .crIn(entity.getCrIn())
                   .crOut(entity.getCrOut())
                   .crCash(entity.getCrCash())
                   .crWriter(entity.getCrWriter())
                   .crNote(entity.getCrNote())
                   .crBrif(entity.getCrBrif())
                   .build();
           dtos.add(dto);
        }
        return dtos;
    }

    public CregisterEntity create(CregisterDto dto) {
        CregisterEntity entity = CregisterEntity.builder()
                .crIn(dto.getCrIn())
                .crOut(dto.getCrOut())
                .crCash(dto.getCrCash())
                .crWriter(dto.getCrWriter())
                .crNote(dto.getCrNote())
                .crBrif(dto.getCrBrif())
                .build();
        return cregisterRepository.save(entity);
    }

    public CregisterEntity update(CregisterDto dto) {
        CregisterEntity entity = cregisterRepository.findById(dto.getCrIdx()).orElseThrow(() -> new IllegalArgumentException("해당 데이터가 없습니다."));
        entity.setCrBrif(dto.getCrBrif());
        entity.setCrCash(dto.getCrCash());
        entity.setCrIn(dto.getCrIn());
        entity.setCrOut(dto.getCrOut());
        entity.setCrNote(dto.getCrNote());
        entity.setCrWriter(dto.getCrWriter());
        return cregisterRepository.save(entity);
    }
}
