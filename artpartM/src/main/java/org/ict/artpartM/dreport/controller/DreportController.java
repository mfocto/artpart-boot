package org.ict.artpartM.dreport.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.dreport.entity.DreportEntity;
import org.ict.artpartM.dreport.model.dto.DreportDto;
import org.ict.artpartM.dreport.model.service.DreportService;
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
    public Header<List<DreportDto>> dailyReportList() {
        return dreportService.dailyReportList();
    }

    @PostMapping(value = "/account/daily-report", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DreportEntity create(@RequestBody DreportDto dreportDto) {
        System.out.println(HttpServletRequest.class.getName());
        System.out.println("dreport : " + dreportDto);
        return dreportService.create(dreportDto);
    }
}
