package org.ict.artpart.paymentmember.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMemberDto {

    private long pmIdx;                 //개별관리비 번호
    private long memberNo;              //입주민 번호
    private Date pmDate;                //전월
    private Date lastpmDate;            //당월
    private BigDecimal pmHeat;          //난방비
    private BigDecimal lastpmHeat;      //당월난방비
    private BigDecimal pmOnsu;          //급탕비(온수)
    private BigDecimal lastpmOnsu;      //당월급탕비(온수)
    private BigDecimal pmGas;           //가스비
    private BigDecimal lastpmGas;       //당월가스비
    private BigDecimal pmElec;          //전기세
    private BigDecimal lastpmElec;      //당월전기세
    private BigDecimal pmWater;         //수도세
    private BigDecimal lastpmWater;     //당월수도세
    private BigDecimal pmSeptic;        //정화조오물수수료
    private BigDecimal lastpmSeptic;    //당월정화조오물수수료
    private BigDecimal pmWaste;         //생활폐기물수수료
    private BigDecimal lastpmWaste;     //당월생활폐기물수수료
    private BigDecimal pmOpercost;      //관리위원회운영비
    private BigDecimal lastpmOpercost;  //당월관리위원회운영비
    private BigDecimal pmInsure;        //건물보험료
    private BigDecimal lastpmInsure;    //당월건물보험료

}
