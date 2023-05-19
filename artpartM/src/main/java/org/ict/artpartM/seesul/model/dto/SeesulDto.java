package org.ict.artpartM.seesul.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.emp.entity.EmpEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeesulDto {
    private long sidx;
    private String scategory;
    private String sdate;
    private EmpEntity swiriter;
}
