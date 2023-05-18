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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
//관리비 납부
public class PaymentMemberService {
    private final PaymentMemberRepository paymentMemberRepository;
    private final PaymentMemberRepositoryCustom paymentMemberRepositoryCustom;
    //이번년도 월별납부
    public Header<List<PaymentMemberDto>> getPaymentMemberList() {
        List<PaymentMemberDto> Monthlist = new ArrayList<>();


        List<PaymentMemberEntity> paymentEntities = paymentMemberRepositoryCustom.findAllByMonth();

        for(PaymentMemberEntity entity : paymentEntities){
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmIdx(entity.getPmIdx())
                    .memberNo(entity.getMemberNo().getMemberIdx())
                    .pmDate(entity.getPmDate())
                    .pmHeat(entity.getPmHeat())
                    .pmOnsu(entity.getPmOnsu())
                    .pmGas(entity.getPmGas())
                    .pmElec(entity.getPmElec())
                    .pmWater(entity.getPmWater())
                    .pmSeptic(entity.getPmSeptic())
                    .pmWaste(entity.getPmWaste())
                    .pmInsure(entity.getPmInsure())
                    .build();
            Monthlist.add(dto);
        }
        return Header.OK(Monthlist);
    }
}
