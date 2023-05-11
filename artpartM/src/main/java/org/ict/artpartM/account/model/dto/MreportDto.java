package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MreportDto {
    private long TMIdx;
    private String TMDate;
    private long TMDebitIn;
    private long TMDebitOut;
    private long TMDebitTotal;
    private long TMCreditIn;
    private long TMCreditOut;
    private long TMCreditTotal;
    private String TMAccount;
}
