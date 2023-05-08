package org.ict.artpartM.dreport.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DreportDto {
    private long trialDailyIdx;
    private String trialDailyDate;
    private long trialDailyDebitIn;
    private long trialDailyDebitOut;
    private long trialDailyDebitTotal;
    private long trialDailyCreditIn;
    private long trialDailyCreditOut;
    private long trialDailyCreditTotal;
    private String trialDailyAccount;
}
