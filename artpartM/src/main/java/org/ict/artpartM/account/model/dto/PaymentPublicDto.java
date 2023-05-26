package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentPublicDto {
    private long PPIdx;
    private String PPDate;
    private long PPFee;
}
