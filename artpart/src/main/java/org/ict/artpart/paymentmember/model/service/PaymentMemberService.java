package org.ict.artpart.paymentmember.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.artpart.common.Header;
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
    public Header<HashMap<String,List<PaymentMemberDto>>> getPaymentMemberList(Long id) {
        List<PaymentMemberDto> monthList = new ArrayList<>();
        List<PaymentMemberDto> yearList = new ArrayList<>();
        List<PaymentMemberDto> sixMonthList = new ArrayList<>();
        List<PaymentMemberDto> recentlyMonth = new ArrayList<>();
        HashMap<String,List<PaymentMemberDto>> list = new HashMap<>();


        List<PaymentMemberEntity> month = paymentMemberRepositoryCustom.findAllByMonth(id);

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
        List<Object[]> resultsList = paymentMemberRepository.findByPmSixMonth(id);
        for(int i = 0; i < 6; i++){
            Object[] obj = resultsList.get(i);
            Date pmDate = (Date) obj[0];
            BigDecimal pmHeat = (BigDecimal) obj[1];
            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmDate(pmDate)
                    .pmHeat(pmHeat)
                    .build();
            sixMonthList.add(dto);
        }
        list.put("sixMonthList", sixMonthList);

        //최근 10년 년도별 리스트
        List<Object[]> year = paymentMemberRepository.findByPmSumByYear(id);
        for(int i = 10; i > 0; i--){
            Object[] obj = year.get(i);
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

            PaymentMemberDto dto = PaymentMemberDto.builder()
                    .pmDate(pmDate)
                    .pmHeat(pmHeat)
                    .pmOnsu(pmOnsu)
                    .pmGas(pmGas)
                    .pmElec(pmElec)
                    .pmWater(pmWater)
                    .pmSeptic(pmSeptic)
                    .pmOpercost(pmOpercost)
                    .pmWaste(pmWaste)
                    .pmInsure(pmInsure)
                    .build();
            yearList.add(dto);
        }
        list.put("yearList", yearList);

        //최근 관리비 전월 당월 비교
        List<Object[]> recently = paymentMemberRepository.findByPmMonth(id);
        for(int i = 0; i < 2; i++){
            //i가 0일때 최근
            if(i == 0) {
                Object[] obj1 = recently.get(i);
                Date lastpmDate = (Date) obj1[0];
                BigDecimal lastpmHeat = (BigDecimal) obj1[1];
                BigDecimal lastpmOnsu = (BigDecimal) obj1[2];
                BigDecimal lastpmGas = (BigDecimal) obj1[3];
                BigDecimal lastpmElec = (BigDecimal) obj1[4];
                BigDecimal lastpmWater = (BigDecimal) obj1[5];
                BigDecimal lastpmSeptic = (BigDecimal) obj1[6];
                BigDecimal lastpmWaste = (BigDecimal) obj1[7];
                BigDecimal lastpmOpercost = (BigDecimal) obj1[8];
                BigDecimal lastpmInsure = (BigDecimal) obj1[9];
            for(int  j = 0; j < 2; j++){
                //j가 1일때 전월
                if(j == 1) {
                    Object[] obj2 = recently.get(j);
                    Date pmDate = (Date) obj2[0];
                    BigDecimal pmHeat = (BigDecimal) obj2[1];
                    BigDecimal pmOnsu = (BigDecimal) obj2[2];
                    BigDecimal pmGas = (BigDecimal) obj2[3];
                    BigDecimal pmElec = (BigDecimal) obj2[4];
                    BigDecimal pmWater = (BigDecimal) obj2[5];
                    BigDecimal pmSeptic = (BigDecimal) obj2[6];
                    BigDecimal pmWaste = (BigDecimal) obj2[7];
                    BigDecimal pmOpercost = (BigDecimal) obj2[8];
                    BigDecimal pmInsure = (BigDecimal) obj2[9];
                    PaymentMemberDto dto = PaymentMemberDto.builder()
                            .lastpmDate(lastpmDate)
                            .lastpmHeat(lastpmHeat)
                            .lastpmOnsu(lastpmOnsu)
                            .lastpmGas(lastpmGas)
                            .lastpmElec(lastpmElec)
                            .lastpmWater(lastpmWater)
                            .lastpmSeptic(lastpmSeptic)
                            .lastpmWaste(lastpmWaste)
                            .lastpmOpercost(lastpmOpercost)
                            .lastpmInsure(lastpmInsure)
                            .pmDate(pmDate)
                            .pmHeat(pmHeat)
                            .pmOnsu(pmOnsu)
                            .pmGas(pmGas)
                            .pmElec(pmElec)
                            .pmWater(pmWater)
                            .pmSeptic(pmSeptic)
                            .pmWaste(pmWaste)
                            .pmOpercost(pmOpercost)
                            .pmInsure(pmInsure)
                            .build();
                    recentlyMonth.add(dto);
                }
                }
            }
        }
        list.put("recentlyMonth", recentlyMonth);
        return Header.OK(list);
    }

}
