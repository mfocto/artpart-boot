package org.ict.artpart.minone.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.entity.MinoneRepository;
import org.ict.artpart.notice.entity.NoticeEntity;
import org.ict.artpart.notice.entity.NoticeRepositoryCustom;
import org.ict.artpart.notice.model.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MinoneService {
    private final MinoneRepository minoneRepository;
    private final NoticeRepositoryCustom noticeRepositoryCustom;



    //########################################################################
    //새 글 등록 (**컬럼에 있는 값들은 내가 vue.js에서 사용하지 않더라도 모두 boot에 있어야 함)
    public MinoneEntity create(MinoneDto minoneDto) {       //entity안에 dto를 넣는 메소드임
        MinoneEntity entity = MinoneEntity.builder()
                .memberidx(minoneDto.getMemberidx())
                .mintitle(minoneDto.getMintitle())
                .mintype(minoneDto.getMintype())
                .minstatus(minoneDto.getMinstatus())
                .minres(minoneDto.getMinres())
                .mincategory(minoneDto.getMincategory())
                .build();                                               //빌드 하여라
        return minoneRepository.save(entity);           //되돌려 주어라  //민원 Repository안에 저장해서(민원entity안에 담은 후에)
    }//close

//    public Header<List<MinoneDto>> getMinoneList(
//            Pageable pageable, SearchCondition searchCondition) {
//        List<MinoneDto> dtos = new ArrayList<>(
//
//        Page<MinoneEntity> minoneEntities = minoneRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
//
//        for(MinoneEntity entity : minoneEntities){
//            MinoneDto dto = MinoneDto.builder()
//                    .memberidx(entity.getMemberidx())
//                    .mintitle(entity.getMintitle())
//                    .mintype(entity.getMintype())
//                    .minstatus(entity.getMinstatus())
//                    .minres(entity.getMinres())
//                    .mincategory(entity.getMincategory())
//                    .build();
//
//            dtos.add(dto);
//    }

    //########################################################################
    //민원 글 수정
//    public MinoneEntity update(MinoneDto minoneDto){
//        MinoneEntity entity = minoneRepository.findByMinidx(minoneDto.getMinidx());
//        entity.setMintitle(minoneDto.getMintitle());
//        entity.setMintype(minoneDto.getMintype());
//        entity.setMinstatus(minoneDto.getMinstatus());
//        entity.setMinres(minoneDto.getMinres());
//        entity.setMincategory(minoneDto.getMincategory());
//        return minoneRepository.save(entity);
//    }//close




    //########################################################################


//    public List<MinoneDto> getMinoneList() {
//
//            List<MinoneEntity> minoneEntityList = minoneRepository.findAll();
//            List<MinoneDto> list = new ArrayList<>();
//
//            for (MinoneEntity entity : minoneEntityList) {
//                MinoneDto dto = MinoneDto.builder()
//                        .minidx(entity.getMinidx())
//                        .memberidx(entity.getMemberidx())
//                        .mintitle(entity.getMintitle())
//                        .mintype(entity.getMintype())
//                        .minstatus(entity.getMinstatus())
//                        .mincategory(entity.getMincategory())
////                        .enrollDate(entity.getEnrollDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
////                        .lastModified(entity.getLastModified().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                        .build();
//                list.add(dto);
//            }//for
//            return list;
//        }//close

    //########################################################################
    //상세보기(특정 게시글 조회)
//    public MinoneDto getMinone(Long memberidx) {
//        minoneRepository.findById(memberidx);
//        List<MinoneEntity> minoneEntityList = minoneRepository.findAll();
//        List<MinoneDto> list = new ArrayList<>();
//
//        for (MinoneEntity entity : minoneEntityList) {
//                MinoneDto dto = MinoneDto.builder()
//                .minidx(entity.getMinidx())
//                .mintitle(entity.getMintitle())
//                .mintype(entity.getMintype())
//                .minstatus(entity.getMinstatus())
//                .mincategory(entity.getMincategory())
//                .build();
//            list.add(dto);
//        }//for
//        return (MinoneDto) list;
//    }//close



    //########################################################################
    //민원번호로 민원 전체리스트 조회
//    public List<MinoneEntity> list() throws Exception {
//        return minoneRepository.findAll(Sort.by(Sort.Direction.DESC, "minidx"));
//    }//close





    //########################################################################
    //삭제
//    public void delete(Long id) {
//        MinoneEntity entity = minoneRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("민원을 찾을 수 없습니다."));
//        minoneRepository.delete(entity);
//    }//close

} //all close
