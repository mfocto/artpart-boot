package org.ict.artpart.seesul.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.seesul.entity.ScheckEntity;
import org.ict.artpart.seesul.entity.ScheckRepository;
import org.ict.artpart.seesul.entity.SeesulRepository;
import org.ict.artpart.seesul.entity.SeesulEntity;
import org.ict.artpart.seesul.model.dto.ScheckDto;
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
    public Header<List<ScheckDto>> getScheckList(Long id) {
        SeesulEntity sidx = seesulRepository.findBySidx(id);

        List<ScheckEntity> scheckEntities = scheckRepository.findAllBySidx(sidx);
        if (scheckEntities.isEmpty()) {
            throw new RuntimeException("글이 찾을 수 없습니다.");
        }
        List<ScheckDto> list = new ArrayList<>();
        for (ScheckEntity entity : scheckEntities) {
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
}
