package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.SlipEntity;
import org.ict.artpartM.account.model.dto.SlipDto;
import org.ict.artpartM.account.model.service.SlipService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SlipController {
    private final SlipService slipService;

    @PostMapping("/account/slip/reg")
    public SlipEntity create(@RequestBody SlipDto slipDto) {
        log.info("slip : " + slipDto);
        return slipService.create(slipDto);
    }

    @GetMapping("/account/slip/list")
    public Header<List<SlipDto>> getList(SearchCondition searchCondition) {
        return Header.OK(slipService.getList(searchCondition));
    }

    @PatchMapping("/account/slip/list")
    public Header<SlipEntity> update(@RequestBody SlipDto slipDto) {
        log.info("slip 확인 : " + slipDto);
        return Header.OK(slipService.update(slipDto));

    }
}
