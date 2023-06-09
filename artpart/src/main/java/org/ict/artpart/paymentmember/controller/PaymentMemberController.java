package org.ict.artpart.paymentmember.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.ict.artpart.paymentmember.model.service.PaymentMemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class PaymentMemberController {

    private final PaymentMemberService paymentMemberService;

    // 이번달/월별/년도별  Map 메소드
    @GetMapping("payment/list/{id}")
    public Header<HashMap<String,List<PaymentMemberDto>>> paymentMemberList(@PathVariable Long id){
        return paymentMemberService.getPaymentMemberList(id);
    }

//    @GetMapping("payment/list")
//    public List<PaymentMemberDto> pmYearList(){
//        return paymentMemberService.getPmYearList();
//    }

}
