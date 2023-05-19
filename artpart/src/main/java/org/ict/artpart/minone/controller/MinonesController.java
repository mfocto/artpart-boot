package org.ict.artpart.minone.controller;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.entity.MinoneEntity;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @AllArgsConstructor
    @RequestMapping(value ="/minone" , method = RequestMethod.GET)      // "/localhost에서 접속 시 뭐로 구분할건지" > localhost:8080/test 이런 식으로 사용하게 됨
    public class MinonesController {

        private final MinoneService service;


        //create() => POST
        @PostMapping("/pageminoneform/{minCategory}")
        public ResponseEntity<?> create(@RequestBody final MinoneDto minoneDto) {

            try {
                return new ResponseEntity<MinoneDto>(service.post(minoneDto), HttpStatus.CREATED);
            } catch (final Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }


        //전체민원리스트조회 => getAll() => GET 요청 /pagemyminone 대한 처리를 담당 (service따로없음)
        // MinoneService.list()를 호출하여 모든 게시글을 가져온 후, ApiResult 객체에 결과를 담아 반환
        @GetMapping("pagemyminone")
        public ApiResult<List<MinoneEntity>> getAll() throws Exception {
            List<MinoneEntity> list = service.list();

            return ApiResult.<List<MinoneEntity>>builder()
                    .data(list)
                    .build();
        }


        //해당 입주민이 작성한 글 조회
        //getBoardById(): GET
        //MinoneService.view(min_idx)를 호출하여 해당 min_idx의 게시글을 가져온 후, ResponseEntity 객체에 결과를 담아 반환
        @GetMapping("pagemyminoneform/{min_idx}")
        public ResponseEntity<?> getMinoneById(@PathVariable("min_idx") Long min_idx) {
            ResponseEntity<?> entity = null;

            try {
                MinoneDto minoneDto = service.view(min_idx);
                entity = new ResponseEntity<MinoneDto>(minoneDto, HttpStatus.OK);
            } catch (NotFoundException e) {
                entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return entity;
        }



        //민원 글 수정 (vue 미구현)
        @PutMapping("/update/{minIdx}")
        public ResponseEntity<?> update(@PathVariable("minIdx") Long minIdx, @RequestBody MinoneDto minoneDto) {
            try {
                return new ResponseEntity<MinoneDto>(service.update(minoneDto, minIdx), HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        }



        //민원 글 삭제
        @DeleteMapping("/delete/{minIdx}")
        public ResponseEntity<?> delete(@PathVariable("minIdx") Long minIdx) {

            ResponseEntity<?> entity = null;

            try {
                service.delete(minIdx);
                entity = new ResponseEntity<>(HttpStatus.OK);
            } catch (NotFoundException e) {
                entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return entity;
        }


}// class close


