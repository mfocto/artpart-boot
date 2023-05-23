package org.ict.artpartM.empSchedule.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpScheduleDto {
    private long sIdx;
    private String sEmpId;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
}
