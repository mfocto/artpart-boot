package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.springframework.data.domain.Sort;
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




    //########################################################################
    //새 글 등록
    public MinoneEntity create(MinoneDto Dto) {
        MinoneEntity entity = MinoneEntity.builder()
                .minIdx(Dto.getMinIdx())
                .minTitle(Dto.getMinTitle())
                .minType(Dto.getMinType())
                .minStatus(Dto.getMinStatus())
                .minRename(Dto.getMinRename())
                .minCategory(Dto.getMinCategory())
                .build();

        return minoneRepository.save(entity);
    }//close

    //########################################################################
    //민원 글 수정
    public MinoneEntity update(MinoneDto minoneDto){
        MinoneEntity entity = minoneRepository.findByMinIdx(minoneDto.getMinIdx());
        entity.setMinTitle(minoneDto.getMinTitle());
        entity.setMinType(minoneDto.getMinType());
        entity.setMinStatus(minoneDto.getMinStatus());
        entity.setMinRes(minoneDto.getMinRes());
        entity.setMinFile(minoneDto.getMinFile());
        entity.setMinRename(minoneDto.getMinRename());
        entity.setMinCategory(entity.getMinCategory());
        return minoneRepository.save(entity);
    }//close




    //########################################################################


    public List<MinoneDto> getMinoneList() {

            List<MinoneEntity> minoneEntityList = minoneRepository.findAll();
            List<MinoneDto> list = new ArrayList<>();

            for (MinoneEntity entity : minoneEntityList) {
                MinoneDto dto = MinoneDto.builder()
                        .minIdx(entity.getMinIdx())
                        .memberIdx(entity.getMemberIdx())
                        .minTitle(entity.getMinTitle())
                        .minType(entity.getMinType())
                        .minStatus(entity.getMinStatus())
                        .minRename(entity.getMinRename())
                        .minCategory(entity.getMinCategory())
//                        .enrollDate(entity.getEnrollDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                        .lastModified(entity.getLastModified().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                        .build();
                list.add(dto);
            }//for
            return list;
        }//close





    //########################################################################
    //민원번호로 민원 전체리스트 조회
    public List<MinoneEntity> list() throws Exception {
        return minoneRepository.findAll(Sort.by(Sort.Direction.DESC, "minIdx"));
    }//close


    //########################################################################
    //상세보기(특정 게시글 조회)
    public MinoneDto getMinone(Long memberIdx) {
        MinoneEntity entity = minoneRepository.findById(memberIdx).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return MinoneDto.builder()
                .minIdx(entity.getMinIdx())
                .memberIdx(entity.getMemberIdx())
                .minTitle(entity.getMinTitle())
                .minType(entity.getMinType())
                .minStatus(entity.getMinStatus())
                .minRename(entity.getMinRename())
                .minCategory(entity.getMinCategory())
                .build();
    }//close


    //########################################################################
    //삭제
    public void delete(Long id) {
        MinoneEntity entity = minoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("민원을 찾을 수 없습니다."));
        minoneRepository.delete(entity);
    }//close

} //all close
