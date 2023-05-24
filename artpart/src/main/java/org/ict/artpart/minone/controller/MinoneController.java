package org.ict.artpart.minone.controller;

import lombok.AllArgsConstructor;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @AllArgsConstructor
    @RequestMapping(value ="/minone" , method = RequestMethod.GET)      // "/localhost에서 접속 시 뭐로 구분할건지" > localhost:8080/test 이런 식으로 사용하게 됨
    public class MinoneController {

        private final MinoneService minoneService;

        //########################################################################
        //새 글 등록
        @PostMapping("/pageminoneform/{minCategory}")
        public MinoneEntity create(@RequestBody MinoneDto minoneDto){ return  minoneService.create(minoneDto); }

        //########################################################################


        //수정
        @PatchMapping("/pageminoneform/{minCategory}")
        public MinoneEntity update(@RequestBody MinoneDto minoneDto){ return minoneService.update(minoneDto); }


        //########################################################################



        //전체리스트 조회
        @PostMapping("/pageminoneform/{minCategory}")
        public List <MinoneDto> minoneList(@PathVariable long memberIdx) {return minoneService.getMinoneList(); }

        //########################################################################


        //상세보기용(특정 게시글 조회)
        @GetMapping("/URL수정필요")
        public MinoneDto getMinone(@PathVariable Long memberIdx){ return minoneService.getMinone(memberIdx); }

        //########################################################################


        //삭제
        @DeleteMapping("/minone/{id}")
        public void delete(@PathVariable Long id) { minoneService.delete(id); }




}// all close


