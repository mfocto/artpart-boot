package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.PaymentPublicEntity;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.ict.artpartM.account.model.service.PaymentPublicService;
import org.ict.artpartM.common.Header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PaymentPublicController {
    private final PaymentPublicService service;

    @PostMapping("/account/payment/public")
    public Header<PaymentPublicEntity> create(@RequestBody PaymentPublicDto dto, @RequestBody String dong, @RequestBody String ho){
        log.info("값 확인, dto : " + dto + ", dong : " + dong + ", ho : " + ho);
        return Header.OK(service.create(dto));
    }
}
