package org.ict.artpart.minone.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @Slf4j
    @CrossOrigin
    @AllArgsConstructor
    @RestController
    //@RequestMapping(value ="/minone" )      // "/localhost에서 접속 시 뭐로 구분할건지" > localhost:8080/test 이런 식으로 사용하게 됨
    public class MinoneController {

        private final MinoneService minoneService;


        //########################################################################
        //새 글 등록
        @PostMapping("/newmin")
        public MinoneEntity create(@RequestBody MinoneDto minoneDto){
        log.info("Minone : " + minoneDto);
            return  minoneService.create(minoneDto); }


        //########################################################################
        //전체리스트 조회
        @GetMapping("/minone/alllist")
        public Header<List<MinoneDto>> minoneList(
                @PageableDefault(sort = {"minidx"}) Pageable pageable,
                SearchCondition searchCondition) {
            return minoneService.getMinoneList(pageable, searchCondition);
        }
        //########################################################################

        //글 상세정보 조회
        @GetMapping("/minone/{id}")
        public MinoneDto getMinone(@PathVariable Long id) {
            return minoneService.getMinone(id);
        }

        //########################################################################

        @PatchMapping("/minone")
        public MinoneEntity update(@RequestBody MinoneDto minoneDto) { return minoneService.update(minoneDto); }

        @DeleteMapping("/minone/{id}")
        public void delete(@PathVariable Long id) { minoneService.delete(id); }


    }// all close


