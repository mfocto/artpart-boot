package org.ict.artpartM.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.emp.entity.EmpEntity;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {
    private long noticeidx;
    private EmpEntity writer;
    private String title;
    private String content;
    private String noticedate;
}
