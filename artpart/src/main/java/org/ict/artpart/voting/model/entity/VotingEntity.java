package org.ict.artpart.voting.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "VOTING")
@Entity
public class VotingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "VOTING_IDX")
    @SequenceGenerator(name = "VOTING_IDX", sequenceName = "VOTING_IDX", allocationSize = 1)
    @Column(name="voting_idx")
    private Long votingIdx;        //투표설문 번호

    @Column(name="member_idx")
    private Long memberIdx;     //입주민 번호

    @Column(name="category")
    private String category;        //카테고리

    @Column(name="title")
    private String title;               //제목

    @Column(name="start_time")
    private LocalDateTime startTime;      //투표설문 시작시간

    @Column(name="end_time")
    private LocalDateTime endTime;        //투표설문 종료시간

    @Column(name="answer1")
    private String answer1;         //답변1

    @Column(name="answer2")
    private String answer2;         //답변2

    @Column(name="answer3")
    private String answer3;         //답변3

    @Column(name="answer4")
    private String answer4;         //답변4

    @Column(name="answer5")
    private String answer5;         //답변5


}
