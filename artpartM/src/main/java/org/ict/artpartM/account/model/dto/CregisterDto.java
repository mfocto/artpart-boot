package org.ict.artpartM.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CregisterDto {
    private long crIdx;
    private String crDate;
    private long crOut;
    private long crIn;
    private long crCash;
    private String crNote;
    private String crWriter;

    private String crBrif;
}
