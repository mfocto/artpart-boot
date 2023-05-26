package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.PaymentMemberEntity;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.ict.artpartM.account.model.service.PaymentMemberService;
import org.ict.artpartM.common.Header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PaymentMemberController {
    private final PaymentMemberService service;

    @PostMapping("/account/payment/member")
    public Header<PaymentMemberEntity> create(PaymentPublicDto dto){
        return Header.OK(service.create(dto));
    }
}
