package org.ict.artpartM.seesul.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.seesul.entity.SeesulEntity;
import org.ict.artpartM.seesul.model.dto.SeesulDto;
import org.ict.artpartM.seesul.model.service.SeesulService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SeesulController {
    private final SeesulService seesulService;
    //목록 조회용
    @GetMapping("/seesul/list")
    public Header<List<SeesulDto>> seesulList(
            @PageableDefault(sort = {"sidx"}) Pageable pageable,
            SearchCondition searchCondition){
        return seesulService.getSeesulList(pageable, searchCondition);
    }

    // 상세보기용
    @GetMapping("/seesul/{id}")
    public SeesulDto getSeesul(@PathVariable Long id){ return seesulService.getSeesul(id); }
    //작성용
    @PostMapping("/seesul")
    public SeesulEntity create(@RequestBody SeesulDto seesulDto) { return seesulService.create(seesulDto); }
    //수정용
    @PatchMapping("/seesul")
    public SeesulEntity update(@RequestBody SeesulDto seesulDto) { return seesulService.update(seesulDto); }
}
