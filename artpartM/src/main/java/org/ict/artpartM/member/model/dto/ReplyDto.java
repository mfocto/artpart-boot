package org.ict.artpartM.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ict.artpartM.member.entity.MemberEntity;
import org.ict.artpartM.member.entity.VotingEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDto {
    private MemberEntity memberidx;
    private VotingEntity votingidx;
    private long replyid;
}
