package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import javassist.NotFoundException;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;

    //########################################################################
    //새 글 작성
    public MinoneDto post(MinoneDto minoneDto) {
        MinoneEntity minoneEntity = minoneDto.toEntity();
        MinoneEntity result = minoneRepository.save(minoneEntity);
        return result.toDto();
    }


    //########################################################################
    //민원번호로 민원 전체리스트 조회
    public List<MinoneEntity> list() throws Exception {
        return minoneRepository.findAll(Sort.by(Sort.Direction.DESC, "minIdx"));
    }

    //########################################################################
    //해당 입주민이 작성한 글 조회
    //minIdx에 해당하는 MinoneEntity를 조회하고, 이를 MinoneDto로 변환하여 리턴
    public MinoneDto view(Long minIdx) throws NotFoundException {
        Optional<MinoneEntity> minoneEntity = minoneRepository.findById(minIdx);

        if (minoneEntity.isPresent()) {
            return minoneEntity.get().toDto();
        } else {
            throw new NotFoundException("리소스를 찾을 수 없습니다.");
        }
    }

    //########################################################################
    //민원 글 수정
    public MinoneDto update(MinoneDto model, Long minIdx) throws Exception{
        MinoneDto minoneDto = view(minIdx);

        minoneDto.setMinTitle(model.getMinTitle());
        minoneDto.setMinType(model.getMinType());
        // Set other properties as needed

        MinoneEntity minoneEntity = minoneDto.toEntity();
        minoneEntity.setMinIdx(minIdx);
        MinoneEntity result = minoneRepository.save(minoneEntity);

        return new MinoneDto(result);
    }

    //########################################################################
    //글삭제
    public void delete(Long minIdx) throws Exception {
        this.view(minIdx);
        minoneRepository.deleteById(minIdx);
    }




} //all close
