package org.ict.artpart.paymentmember.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.paymentmember.entity.PaymentMemberEntity;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepository;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepositoryCustom;
import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
//관리비 납부
public class PaymentMemberService {
    private final PaymentMemberRepository paymentMemberRepository;
    private final PaymentMemberRepositoryCustom paymentMemberRepositoryCustom;
    //이번년도 월별납부
    public Header<List<PaymentMemberDto>> getPmMonthList() {
        List<PaymentMemberDto> monthList = new ArrayList<>();
        List<PaymentMemberDto> yearList = new ArrayList<>();
        HashMap<PaymentMemberDto, Object> list = new HashMap<>();


        List<PaymentMemberEntity> month = paymentMemberRepositoryCustom.findAllByMonth();

        for(PaymentMemberEntity entity : month){
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmIdx(entity.getPmIdx())
                    .memberNo(entity.getMemberNo().getMemberIdx())
                    .pmDate(entity.getPmDate().format(DateTimeFormatter.ofPattern("MM")))
                    .pmHeat(entity.getPmHeat())
                    .pmOnsu(entity.getPmOnsu())
                    .pmGas(entity.getPmGas())
                    .pmElec(entity.getPmElec())
                    .pmWater(entity.getPmWater())
                    .pmSeptic(entity.getPmSeptic())
                    .pmOpercost(entity.getPmOpercost())
                    .pmWaste(entity.getPmWaste())
                    .pmInsure(entity.getPmInsure())
                    .build();
            monthList.add(dto);
        }

        return Header.OK(monthList);
    }
}
