package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.account.entity.DreportEntity;
import org.ict.artpartM.account.model.dto.DreportDto;
import org.ict.artpartM.account.model.service.DreportService;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class DreportController {
    private final DreportService dreportService;

    @GetMapping("/account/daily-report")
    public Header<List<DreportDto>> dailyReportList(SearchCondition searchCondition) {
        return dreportService.dailyReportList(searchCondition);
    }

    @PostMapping("/account/daily-report")
    public DreportEntity create(@RequestBody DreportDto dreportDto) {
        return dreportService.create(dreportDto);
    }

    @PatchMapping("/account/daily-report")
    public DreportEntity update(@RequestBody DreportDto dreportDto) {
        return dreportService.update(dreportDto);
    }
}
