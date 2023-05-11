package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlipDto {
    private long slipIdx;
    private String slipDate;
    private String slipNo;
    private String slipType;
    private String slipItem;
    private String slipComp;
    private String slipBrif;
    private long slipCash;
    private String slipNote;
}
