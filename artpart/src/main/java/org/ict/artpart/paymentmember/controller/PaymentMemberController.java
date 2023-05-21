package org.ict.artpart.paymentmember.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.ict.artpart.paymentmember.model.service.PaymentMemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class PaymentMemberController {

    private final PaymentMemberService paymentMemberService;

    @GetMapping("payment/list")
    public Header<List<PaymentMemberDto>> paymentMemberList(){

        return paymentMemberService.getPmMonthList();
    }

}
