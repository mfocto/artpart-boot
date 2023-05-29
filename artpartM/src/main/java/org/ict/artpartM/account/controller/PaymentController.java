package org.ict.artpartM.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpartM.account.entity.PaymentMemberEntity;
import org.ict.artpartM.account.entity.PaymentPublicEntity;
import org.ict.artpartM.account.model.dto.FeeListDto;
import org.ict.artpartM.account.model.dto.PaymentMemberDto;
import org.ict.artpartM.account.model.dto.PaymentPublicDto;
import org.ict.artpartM.account.model.service.PaymentService;
import org.ict.artpartM.common.Header;
import org.ict.artpartM.common.SearchCondition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PaymentController {
    private final PaymentService service;


    @PostMapping("/account/payment/public")
    public Header<PaymentPublicEntity> create(@RequestBody PaymentPublicDto dto){
        PaymentPublicEntity entity = service.create(dto);
        if(entity != null) {
            return Header.OK(entity);
        }
        return Header.ERROR("오류가 발생했습니다.");
    }


    @PostMapping("/account/payment/member")
    public Header<PaymentMemberEntity> create(@RequestBody PaymentMemberDto dto){
        PaymentMemberEntity entity = service.create(dto);
        if(entity != null) {
            return Header.OK(entity);
        }
        return Header.ERROR("오류가 발생했습니다.");
    }

    @GetMapping("/account/payment/list")
    public Header<List<FeeListDto>> getList(SearchCondition searchCondition){
        log.info(searchCondition.toString());
        List<FeeListDto> dto = service.getList(searchCondition);
        if(dto != null){
            return Header.OK(dto);
        }else {
            return Header.ERROR("리스트를 불러오지 못했습니다.");
        }
    }

    @PatchMapping("/account/payment")
    public Header<FeeListDto> update(@RequestBody FeeListDto dto){
       log.info("dto : "+dto.toString());
       return Header.OK(service.update(dto));
    }
}
