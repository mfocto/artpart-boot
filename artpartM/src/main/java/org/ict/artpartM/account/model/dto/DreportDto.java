package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DreportDto {
    private long TDIdx;
    private String TDDate;
    private long TDDebitIn;
    private long TDDebitOut;
    private long TDDebitTotal;
    private long TDCreditIn;
    private long TDCreditOut;
    private long TDCreditTotal;
    private String TDAccount;
}
