package org.ict.artpart.using.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.using.model.dto.UsingDto;
import org.ict.artpart.using.model.service.UsingService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class UsingController {
    private final UsingService usingService;

    @GetMapping("/using/list")
    public Header<List<UsingDto>> usingList(
            @PageableDefault(sort = {"usingIdx"}) Pageable pageable){
        return usingService.getUsingList(pageable);
    }
}
