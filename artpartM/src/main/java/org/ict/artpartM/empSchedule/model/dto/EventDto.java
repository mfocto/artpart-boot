package org.ict.artpartM.empSchedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    private Long eventId;
    private String title;
    private String description;
    private String start;
    private String end;
    private String backgroundColor;


}
