package org.ict.artpart.paymentmember.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
import org.ict.artpart.common.SumByYear;
import org.ict.artpart.paymentmember.entity.PaymentMemberEntity;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepository;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepositoryCustom;
import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.ict.artpart.paymentmember.model.dto.PaymentSumDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.core.convert.converter.Converter;

@Service
@RequiredArgsConstructor
@Slf4j
//관리비 납부
public class PaymentMemberService {
    private final PaymentMemberRepository paymentMemberRepository;
    private final PaymentMemberRepositoryCustom paymentMemberRepositoryCustom;
    //이번년도 월별납부
    public HashMap<String,List<PaymentMemberDto>> getPmMonthList() {
        List<PaymentMemberDto> monthList = new ArrayList<>();
        HashMap<String,List<PaymentMemberDto>> list = new HashMap<>();


        List<PaymentMemberEntity> month = paymentMemberRepositoryCustom.findAllByMonth();

        for(PaymentMemberEntity mentity : month){
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmIdx(mentity.getPmIdx())
                    .memberNo(mentity.getMemberNo().getMemberIdx())
                    .pmDate(mentity.getPmDate().format(DateTimeFormatter.ofPattern("MM")))
                    .pmHeat(mentity.getPmHeat())
                    .pmOnsu(mentity.getPmOnsu())
                    .pmGas(mentity.getPmGas())
                    .pmElec(mentity.getPmElec())
                    .pmWater(mentity.getPmWater())
                    .pmSeptic(mentity.getPmSeptic())
                    .pmOpercost(mentity.getPmOpercost())
                    .pmWaste(mentity.getPmWaste())
                    .pmInsure(mentity.getPmInsure())
                    .build();
            monthList.add(dto);
        }
        list.put("monthList", monthList);

        List<PaymentMemberDto> yearList = new ArrayList<>();
//        List<PaymentMemberEntity> year = paymentMemberRepository.getSumByYear();

//        log.info("asdasd");
//        log.info(year.toString());


//        for (PaymentMemberEntity yentity : year){
//            PaymentMemberDto dto = PaymentMemberDto.builder()
//                    .pmDate(yentity.getPmDate().format(DateTimeFormatter.ofPattern("YYYY")))
//                    .pmHeat(yentity.getPmHeat())
//                    .pmOnsu(yentity.getPmOnsu())
//                    .pmGas(yentity.getPmGas())
//                    .pmElec(yentity.getPmElec())
//                    .pmWater(yentity.getPmWater())
//                    .pmSeptic(yentity.getPmSeptic())
//                    .pmOpercost(yentity.getPmOpercost())
//                    .pmWaste(yentity.getPmWaste())
//                    .pmInsure(yentity.getPmInsure())
//                    .build();
//            yearList.add(dto);
//        }
//        List<PaymentSumDTO> yearList = new ArrayList<>();
//
//        List<PaymentSumDTO> year = paymentMemberRepository.getSumByYear();
//
//        for (PaymentSumDTO yentity : year) {
//            PaymentSumDTO dto = PaymentSumDTO.builder()
//                    .year(yentity.getYear())
//                    .totalHeat(yentity.getTotalHeat())
//                    .totalOnsu(yentity.getTotalOnsu())
//                    .totalElec(yentity.getTotalElec())
//                    .totalWater(yentity.getTotalWater())
//                    .totalSeptic(yentity.getTotalSeptic())
//                    .totalOpercost(yentity.getTotalOpercost())
//                    .totalInsure(yentity.getTotalInsure())
//                    .build();
//            yearList.add(dto);
//        }
//        list.put("yearList", yearList);

        return list;
    }

}
