package org.ict.artpartM.read.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.ict.artpartM.read.entity.ReadEntity;
import org.ict.artpartM.read.model.dto.ReadDto;
import org.ict.artpartM.read.model.service.ReadService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ReadController {
    private final ReadService readService;

    @GetMapping("/read/list")
    public Header<List<ReadDto>> readList(
            @PageableDefault(sort = {"memberidx.memberdong", "memberidx.memberho"})Pageable pageable,
            SearchCondition searchCondition) {
        return readService.getReadList(pageable, searchCondition);
    }


}
