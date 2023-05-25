package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.CregisterEntity;
import org.ict.artpartM.account.model.dto.CregisterDto;
import org.ict.artpartM.account.model.service.CregisterService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class CregisterController {
    private final CregisterService service;

    @GetMapping("/account/cash-journals")
    public Header<List<CregisterDto>> getList(SearchCondition searchCondition){
        return Header.OK(service.getList(searchCondition));
    }

    @PostMapping("/account/cash-journal")
    public Header<CregisterEntity> create(@RequestBody CregisterDto dto){
        return Header.OK(service.create(dto));
    }

    @PatchMapping("/account/cash-journal")
    public Header<CregisterEntity> update(@RequestBody CregisterDto dto){
        return Header.OK(service.update(dto));
    }
}
