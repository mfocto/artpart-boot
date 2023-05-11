package org.ict.artpart.minone.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.minone.model.dto.MinoneDto;
import org.ict.artpart.minone.model.service.MinoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MinoneController {
    private final MinoneService minoneService;


    @GetMapping("minone/pagemyminone")
    //민원 정보 전체리스트 조회
    public List<MinoneDto> minoneList() { return minoneService.getMinoneList(); }

    @GetMapping("/minone/pagemyminoneform/{MEMBERIDX}")
    //1명이 작성한 게시글 모두 조회 =>getBoardsByMember 메서드에 매핑
    public List<MinoneDto> getMinoneByMember(@PathVariable Long memberIdx) {
        return minoneService.getMinoneByMemberIdx(memberIdx);
    }



}
