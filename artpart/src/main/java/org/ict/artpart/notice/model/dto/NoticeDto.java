package org.ict.artpart.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpart.emp.entity.EmpEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {
    private long noticeIdx;     //공지글 번호
    private EmpEntity writer;   //직원 등록번호
    private String title;       //제목
    private String content;     //내용
    private LocalDateTime noticeDate;    //작성 일자

}
