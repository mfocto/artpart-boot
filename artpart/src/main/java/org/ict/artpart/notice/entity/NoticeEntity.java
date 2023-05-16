package org.ict.artpart.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.ict.artpart.emp.entity.EmpEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name ="NOTICE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICEIDX")
    @SequenceGenerator(name = "NOTICEIDX", sequenceName = "NOTICEIDX", allocationSize = 1)
    @Column(name = "NOTICEIDX")
    @Comment("공지글 번호")
    private long noticeIdx;

    @ManyToOne
    @JoinColumn(name = "WRITER")
    @Comment("직원등록 번호")
    private EmpEntity writer;

    @Column(name = "TITLE")
    @Comment("제목")
    private String title;

    @Column(name = "CONTENT")
    @Comment("내용")
    private String content;

    @Column(name = "NOTICEDATE")
    @Comment("작성 일자")
    private Date noticeDate;

}
