package org.ict.artpartM.member.entity;

import com.sun.istack.NotNull;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEETINGIDX")
    @SequenceGenerator(name="MEETINGIDX", sequenceName = "MEETING_IDX" , allocationSize = 1)
    @Column(name="MEETINGIDX")
    private long meetingidx;
    @Column(name = "MEETINGTIME", columnDefinition = "date default sysdate")
    private LocalDate meetingtime;
    @Column(name = "MEETINGTITLE")
    @NotNull
    private String meetingtitle;
    @Column(name = "MEETINGCONTENT")
    @NotNull
    private String meetingcontent;
    @Column(name = "MEETINGID")
    private String meetingid;
    @Column(name = "MEETINGOPEN", columnDefinition = "char default 'N'")
    @NotNull
    private String meetingopen;
}
