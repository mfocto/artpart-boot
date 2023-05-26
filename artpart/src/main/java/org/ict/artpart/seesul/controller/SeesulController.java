package org.ict.artpart.seesul.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.SearchCondition;
import org.ict.artpart.seesul.model.dto.SeesulDto;
import org.ict.artpart.seesul.model.service.SeesulService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    //상세 보기용
    @GetMapping("/seesul/{id}")
    public SeesulDto getSeesul(@PathVariable Long id){
        return seesulService.getSeesul(id);
    }

}
