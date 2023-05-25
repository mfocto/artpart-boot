package org.ict.artpart.minone.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @Slf4j
    @RestController
    @AllArgsConstructor
    @RequestMapping(value ="/minone" )      // "/localhost에서 접속 시 뭐로 구분할건지" > localhost:8080/test 이런 식으로 사용하게 됨
    public class MinoneController {

        private final MinoneService minoneService;


        //########################################################################
        //새 글 등록
        @PostMapping("/pageminoneform/newMin")
        public MinoneEntity create(@RequestBody MinoneDto minoneDto){
        log.info("Minone : " + minoneDto);
            return  minoneService.create(minoneDto); }
        //########################################################################


        //수정
//        @PatchMapping("/pageminoneform/sujung")
//        public MinoneEntity update(@RequestBody MinoneDto minoneDto){
//            return minoneService.update(minoneDto); }


        //########################################################################



        //전체리스트 조회
//        @PostMapping("/pageminoneform/all/list")
//        public List <MinoneDto> minoneList(@PathVariable Long memberidx) {
//            return minoneService.getMinoneList(); }

        //########################################################################


        //상세보기용(특정 게시글 조회)
//        @GetMapping("/pageminoneform/read/{memberidx}")
//        public MinoneDto getMinone(@PathVariable Long memberidx){
//            return minoneService.getMinone(memberidx); }

        //########################################################################


        //삭제
//        @DeleteMapping("/minone/remove/{id}")
//        public void delete(@PathVariable Long id) {
//            minoneService.delete(id); }




}// all close


