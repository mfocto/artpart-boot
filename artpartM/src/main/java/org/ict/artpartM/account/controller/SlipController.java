package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.SlipEntity;
import org.ict.artpartM.account.model.dto.SlipDto;
import org.ict.artpartM.account.model.service.SlipService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SlipController {
    private final SlipService slipService;

    @PostMapping("/account/slip/reg")
    public SlipEntity create(@RequestBody SlipDto slipDto){
        System.out.println("sentity : " + slipService.create(slipDto));
        return slipService.create(slipDto);
    }
}
