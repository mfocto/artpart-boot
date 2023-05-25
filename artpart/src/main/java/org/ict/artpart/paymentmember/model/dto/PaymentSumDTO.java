package org.ict.artpart.paymentmember.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentSumDTO {
    private int year;
    private int totalHeat;
    private int totalOnsu;
    private int totalGas;
    private int totalElec;
    private int totalWater;
    private int totalSeptic;
    private int totalWaste;
    private int totalOpercost;
    private int totalInsure;
}
