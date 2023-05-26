package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeListDto {
    private String dong;
    private String ho;
    private String date;
    private long gen;
    private long heat;
    private long onsu;
    private long gas;
    private long elec;
    private long water;
    private long etc;
    private long sum;
}
