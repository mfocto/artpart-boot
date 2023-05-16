package org.ict.artpartM.notice.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.ict.artpartM.emp.entity.EmpEntity;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "NOTICE")
@Entity
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICEIDX")
    @SequenceGenerator(name="NOTICEIDX", sequenceName = "NOTICE_IDX", allocationSize=1)
    @Column(name = "NOTICEIDX")
    private long noticeidx;
    @ManyToOne
    @JoinColumn(name = "WRITER")
    private EmpEntity writer;
    @NotNull
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "NOTICEDATE", columnDefinition = "date default sysdate")
    private LocalDateTime noticedate;
}
