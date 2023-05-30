package org.ict.artpartM.empSchedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name="SCHEDULE")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_IDX")
    @SequenceGenerator(name = "EVENT_IDX", sequenceName = "EVENT_IDX", allocationSize = 1)
    @Column(name = "EVENT_IDX")
    private Long eventId;
    @Column(name = "EVENT_TITLE")
    private String title;
    @Column(name = "EVENT_DESCRIPTION")
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "EVENT_START_DATE")
    private LocalDateTime start;
    @Column(name = "EVENT_END_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime end;
    @Column(name = "EVENT_BACKGROUND_COLOR")
    private String backgroundColor;

}
