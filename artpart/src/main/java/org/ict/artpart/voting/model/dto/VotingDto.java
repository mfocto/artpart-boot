package org.ict.artpart.voting.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotingDto {

    private Long voting_idx;        //투표설문 번호
    private Long member_idx;     //입주민 번호
    private String category;        //카테고리
    private String title;               //제목
    private String start_time;      //투표설문 시작시간
    private String end_time;        //투표설문 종료시간
    private String answer1;         //답변1
    private String answer2;         //답변2
    private String answer3;         //답변3
    private String answer4;         //답변4
    private String answer5;         //답변5



}
