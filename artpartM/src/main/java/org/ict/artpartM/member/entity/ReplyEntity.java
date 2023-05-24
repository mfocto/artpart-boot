package org.ict.artpartM.member.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="REPLY_COUNT")
@Entity
@IdClass(ReplyEntity.ReplyEntityId.class)
public class ReplyEntity implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_IDX")
    private MemberEntity memberidx;
    @Id
    @ManyToOne
    @JoinColumn(name = "VOTING_IDX")
    private VotingEntity votingidx;
    @NotNull
    @Column(name = "REPLY_ID")
    private long replyid;

    public static class ReplyEntityId implements Serializable{
        private MemberEntity memberidx;
        private VotingEntity votingidx;
    }

}

