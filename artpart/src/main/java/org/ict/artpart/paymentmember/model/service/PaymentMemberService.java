package org.ict.artpart.paymentmember.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.paymentmember.entity.PaymentMemberEntity;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepository;
import org.ict.artpart.paymentmember.entity.PaymentMemberRepositoryCustom;
import org.ict.artpart.paymentmember.model.dto.PaymentMemberDto;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
        List<PaymentMemberDto> yearList = new ArrayList<>();
        List<PaymentMemberDto> sixMonthList = new ArrayList<>();
        HashMap<String,List<PaymentMemberDto>> list = new HashMap<>();


        List<PaymentMemberEntity> month = paymentMemberRepositoryCustom.findAllByMonth();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");

        //월별 리스트 담기
        for(PaymentMemberEntity mentity : month){
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmIdx(mentity.getPmIdx())
                    .memberNo(mentity.getMemberNo().getMemberIdx())
                    .pmDate(mentity.getPmDate())
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

        //최근 6개월 차트넣기용
        List<Object[]> resultsList = paymentMemberRepository.getPmSixMonth();
        for(int i = 0; i < 6; i++){
            Object[] obj = resultsList.get(i);
            Date pmDate = (Date) obj[0];
            BigDecimal pmHeat = (BigDecimal) obj[1];
            PaymentMemberEntity payment = new PaymentMemberEntity(pmDate, pmHeat);
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmDate(payment.getPmDate())
                    .pmHeat(payment.getPmHeat())
                    .build();
            sixMonthList.add(dto);
        }
        list.put("sixMonthList", sixMonthList);

        //년도별 리스트 담기
        List<Object[]> year = paymentMemberRepository.getPmSumByYear();
        for (Object [] obj : year){
            BigDecimal pmDateDecimal = (BigDecimal) obj[0];
            int pmYear = pmDateDecimal.intValue(); // 연도 값으로 변환
            Date pmDate = new Date(pmYear - 1900, 0, 1); // Date 객체 생성 (연도는 1900을 빼주어야 정확한 값이 됩니다)
            BigDecimal pmHeat = (BigDecimal) obj[1];
            BigDecimal pmOnsu = (BigDecimal) obj[2];
            BigDecimal pmGas = (BigDecimal) obj[3];
            BigDecimal pmElec = (BigDecimal) obj[4];
            BigDecimal pmWater = (BigDecimal) obj[5];
            BigDecimal pmSeptic = (BigDecimal) obj[6];
            BigDecimal pmWaste = (BigDecimal) obj[7];
            BigDecimal pmOpercost = (BigDecimal) obj[8];
            BigDecimal pmInsure = (BigDecimal) obj[9];
            PaymentMemberEntity payment = new PaymentMemberEntity(pmDate, pmHeat, pmOnsu, pmGas, pmElec, pmWater, pmSeptic, pmWaste, pmOpercost, pmInsure);

            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmDate(payment.getPmDate())
                    .pmHeat(payment.getPmHeat())
                    .pmOnsu(payment.getPmOnsu())
                    .pmGas(payment.getPmGas())
                    .pmElec(payment.getPmElec())
                    .pmWater(payment.getPmWater())
                    .pmSeptic(payment.getPmSeptic())
                    .pmOpercost(payment.getPmOpercost())
                    .pmWaste(payment.getPmWaste())
                    .pmInsure(payment.getPmInsure())
                    .build();
            yearList.add(dto);
        }
        list.put("yearList", yearList);
        return list;
    }

}
