package org.ict.artpart.paymentmember.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMemberDto {

    private long pmIdx;     //개별관리비 번호
    private long memberNo;  //입주민 번호
    private String pmDate;    //일자
    private int pmHeat;     //난방비
    private int pmOnsu;     //급탕비(온수)
    private int pmGas;      //가스사용
    private int pmElec;     //전기세
    private int pmWater;    //수도세
    private int pmSeptic;   //정화조오물수수료
    private int pmWaste;    //생활폐기물수수료
    private int pmOpercost; //관리위원회운영비
    private int pmInsure;   //건물보험료

}
