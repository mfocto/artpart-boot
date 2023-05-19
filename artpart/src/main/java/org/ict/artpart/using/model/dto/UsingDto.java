package org.ict.artpart.using.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsingDto {
    private long detailIdx;         //관리비 번호
    private long memberIdx;         //입주민 번호
    private Date paymentDate;       //결제일자
    private Date paymentDedLine;    //납부 마감일
    private int paymentMoney;       //결제 금액
    private String paymentBank;     //금융사
    private String bankNumber;      //납부 계좌번호
    private String paymentStatus;   //진행 상태
}
