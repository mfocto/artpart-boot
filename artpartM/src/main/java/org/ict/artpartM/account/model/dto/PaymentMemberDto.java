package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMemberDto {
    private long pmIdx;
    private MemberEntity memberNo;
    private String pmDate;
    private long pmHeat;
    private long pmOnsu;
    private long pmGas;
    private long pmElec;
    private long pmWater;
    private long pmSeptic;
    private long pmWaste;
    private long pmOpercost;
    private long pmInsure;
}
