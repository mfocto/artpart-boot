package org.ict.artpartM.seesul.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.seesul.entity.SeesulEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheckDto {
    private long scheckidx;
    private SeesulEntity sidx;
    private long scheck;
    private String sresult;
    private String sprocess;
}
