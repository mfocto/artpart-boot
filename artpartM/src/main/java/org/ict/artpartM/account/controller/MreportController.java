package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.MreportEntity;
import org.ict.artpartM.account.model.dto.MreportDto;
import org.ict.artpartM.account.model.service.MreportService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RestController
public class MreportController {

    private final MreportService mreportService;

    @GetMapping("/account/monthly-report")
    public Header<List<MreportDto>> dailyReportList(SearchCondition searchCondition) {
        System.out.println("반환값 : " + mreportService.monthlyReportList(searchCondition));
        return mreportService.monthlyReportList(searchCondition);
    }

    @PostMapping("/account/monthly-report")
    public MreportEntity create(@RequestBody MreportDto mreportDto) {
        return mreportService.create(mreportDto);
    }

    @PatchMapping("/account/monthly-report")
    public MreportEntity update(@RequestBody MreportDto mreportDto) {

        return mreportService.update(mreportDto);
    }
}
