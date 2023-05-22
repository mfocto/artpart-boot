package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.emp.entity.EmpEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingDto {
    private long meetingidx;
    private String meetingtime;
    private String meetingtitle;
    private String meetingcontent;
    private EmpEntity meetingid;
    private String meetingopen;
}
