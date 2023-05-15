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
    private long detailIdx;
    private long memberIdx;
    private Date paymentDate;
    private Date paymentDadLine;
    private int paymentMoney;
    private String paymentBank;
    private String bankNumber;
    private String paymentStatus;
}
