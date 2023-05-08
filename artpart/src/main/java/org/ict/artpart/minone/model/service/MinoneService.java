package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;



    //민원 전체리스트 조회
    public List<MinoneDto> selectMinoneList(){
        List<MinoneEntity> minoneEntityList = minoneRepository.findAll();
        List<MinoneDto> list = new ArrayList<>();

        for(MinoneEntity entity : minoneEntityList){
            MinoneDto minoneDto = MinoneDto.builder()
                    .min_idx(entity.getMin_idx())
                    .min_title(entity.getMin_title())
                    .min_type(entity.getMin_type())
                    .min_status(entity.getMin_status())
                    .min_res(entity.getMin_res())
                    .min_file(entity.getMin_file())
                    .min_rename(entity.getMin_rename())
                    .min_category(entity.getMin_category())
                    .member_idx(entity.getMember_idx())

                    .build();
            log.info(minoneDto.toString());

            list.add(minoneDto);
        }

        return list;
    }
}
