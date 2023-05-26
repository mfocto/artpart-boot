package org.ict.artpart.notice.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.ict.artpart.emp.entity.EmpEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="NOTICE")
@NoArgsConstructor (force = true)
@AllArgsConstructor
@Builder
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICEIDX")
    @SequenceGenerator(name = "NOTICEIDX", sequenceName = "NOTICEIDX", allocationSize = 1)
    @Column(name = "NOTICEIDX")
    @Comment("공지글 번호")
    private long noticeidx;

    @ManyToOne
    @JoinColumn(name = "WRITER")
    @Comment("직원등록 번호")
    private EmpEntity writer;

    @NotNull
    @Column(name = "TITLE")
    @Comment("제목")
    private String title;

    @Column(name = "CONTENT")
    @Comment("내용")
    private String content;

    @Column(name = "NOTICEDATE", columnDefinition = "date default sysdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("작성 일자")
    private LocalDateTime noticeDate;

}
