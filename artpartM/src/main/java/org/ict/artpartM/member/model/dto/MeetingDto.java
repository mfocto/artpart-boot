package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingDto {
    private long meetingidx;
    private String meetingtime;
    private String meetingtitle;
    private String meetingcontent;
    private String meetingid;
    private String meetingopen;
}
