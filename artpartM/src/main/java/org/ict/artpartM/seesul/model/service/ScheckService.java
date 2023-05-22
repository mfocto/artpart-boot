package org.ict.artpartM.seesul.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.seesul.entity.ScheckEntity;
import org.ict.artpartM.seesul.entity.ScheckRepository;
import org.ict.artpartM.seesul.entity.SeesulEntity;
import org.ict.artpartM.seesul.entity.SeesulRepository;
import org.ict.artpartM.seesul.model.dto.ScheckDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class ScheckService {
    private final ScheckRepository scheckRepository;
    private final SeesulRepository seesulRepository;

    //체크리스트 목록 조회
    public Header<List<ScheckDto>> getScheckList(long id) {
        SeesulEntity sidx = seesulRepository.findBySidx(id);

        List<ScheckEntity> scheckEntities = scheckRepository.findAllBySidx(sidx);
        if (scheckEntities.isEmpty()) {
            throw new RuntimeException("글을 찾을 수 없습니다.");
        }
        List<ScheckDto> list = new ArrayList<>();
        for(ScheckEntity entity : scheckEntities){
            ScheckDto dto = ScheckDto.builder()
                    .scheckidx(entity.getScheckidx())
                    .sidx(entity.getSidx())
                    .scheck(entity.getScheck())
                    .sresult(entity.getSresult())
                    .sprocess(entity.getSprocess())
                    .build();

            list.add(dto);
        }

        return Header.OK(list);
    }

    //체크리스트 등록
    public List<ScheckEntity> create(List<ScheckDto> scheckDtoList) {
        List<ScheckEntity> createdEntities = new ArrayList<>();
        for(ScheckDto scheckDto : scheckDtoList){
            ScheckEntity entity = ScheckEntity.builder()
                    .sidx(scheckDto.getSidx())
                    .scheck(scheckDto.getScheck())
                    .sresult(scheckDto.getSresult())
                    .sprocess(scheckDto.getSprocess())
                    .build();
            createdEntities.add(scheckRepository.save(entity));
        }

        return createdEntities;
    }

    //체크리스트 수정
    public List<ScheckEntity> update(List<ScheckDto> scheckDtoList) {
        List<ScheckEntity> updatedEntities = new ArrayList<>();

        for(ScheckDto scheckDto : scheckDtoList){
            ScheckEntity entity = scheckRepository.findByScheckidx(scheckDto.getScheckidx());
            entity.setSresult(scheckDto.getSresult());
            entity.setSprocess(scheckDto.getSprocess());
            updatedEntities.add(scheckRepository.save(entity));
        }

        return updatedEntities;
    }


}
