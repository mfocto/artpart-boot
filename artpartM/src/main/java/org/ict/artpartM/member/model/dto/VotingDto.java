package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VotingDto {
    private long votingidx;
    private String category;
    private String title;
    private String content;
    private String starttime;
    private String endtime;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String votingwriter;
    private String votingstart;
    private long membercount;
}
