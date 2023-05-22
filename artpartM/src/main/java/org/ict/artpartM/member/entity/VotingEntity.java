package org.ict.artpartM.member.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Table(name="VOTING")
@Entity
public class VotingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOTING_IDX")
    @SequenceGenerator(name="VOTING_IDX", sequenceName = "VOTING_IDX" , allocationSize = 1)
    @Column(name="VOTING_IDX")
    private long votingidx;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "TITLE")
    private String title;
    @Column(name="CONTENT")
    private String content;
    @Column(name = "START_TIME")
    private LocalDate starttime;
    @Column(name = "END_TIME")
    private LocalDate endtime;
    @Column(name = "ANSWER1")
    private String answer1;
    @Column(name = "ANSWER2")
    private String answer2;
    @Column(name = "ANSWER3")
    private String answer3;
    @Column(name = "ANSWER4")
    private String answer4;
    @Column(name = "ANSWER5")
    private String answer5;
    @Column(name = "VOTING_WRITER")
    private String votingwriter;
    @Column(name = "VOTING_START", columnDefinition = "char default 'N'")
    private String votingstart;
}
