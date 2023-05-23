package org.ict.artpartM.empSchedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="EMP_SCHEDULE")
@Entity
public class EmpScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="SCHEDULE_IDX", sequenceName = "SCHEDULE_IDX", allocationSize=1)
    @Column(name="SCHEDULE_IDX")
    private long sIdx;
    @Column(name="EMP_SID")
    private String empSid;
    @Column(name="EMP_STARTDATE")
    private LocalDate startDate;
    @Column(name="EMP_ENDDATE")
    private LocalDate endDate;
    @Column(name="EMP_STARTTIME")
    private LocalTime startTime;
    @Column(name="EMP_ENDTIME")
    private LocalTime endTime;
}
