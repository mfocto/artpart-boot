package org.ict.artpartM.member.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.ict.artpartM.emp.entity.EmpEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="CAPMEETING")
@Entity
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEETING_IDX")
    @SequenceGenerator(name="MEETING_IDX", sequenceName = "MEETING_IDX" , allocationSize = 1)
    @Column(name="MEETING_IDX")
    private long meetingidx;
    @Column(name = "MEETING_TIME", columnDefinition = "date default sysdate")
    private LocalDate meetingtime;
    @Column(name = "MEETING_TITLE")
    @NotNull
    private String meetingtitle;
    @Column(name = "MEETING_CONTENT")
    private String meetingcontent;
    @ManyToOne
    @JoinColumn(name = "MEETING_ID")
    private EmpEntity meetingid;
    @Column(name = "MEETING_OPEN", columnDefinition = "char default 'N'")
    @NotNull
    private String meetingopen;
}
